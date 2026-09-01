// sagas/postSaga.js
import { all, call, put, takeLatest } from 'redux-saga/effects';
import api from '../api/axios';
import {
    fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
    fetchPostDetailRequest, fetchPostDetailSuccess, fetchPostDetailFailure,
    createPostRequest, createPostSuccess, createPostFailure,
    updatePostRequest, updatePostSuccess, updatePostFailure,
    deletePostRequest, deletePostSuccess, deletePostFailure,
    resetPostState
} from '../reducers/postReducer';

const POST_API_BASE = 'http://localhost:8080/api/posts';

//////////////////////////////////////////////////////////////////////////////
// watchFetchPosts  - GET /api/posts 전체 게시글 조회 ---
//////////////////////////////////////////////////////////////////////////////

export const fetchPostsApi = ()=> api.get(POST_API_BASE);

export function* fetchPosts(){
    try{
        const result = yield call(fetchPostsApi);
        yield put(fetchPostsSuccess(result.data));
    } catch(err) {
        yield put(fetchPostsFailure(err.response?.data?.message || err.message));
    }
}

//////////////////////////////////////////////////////////////////////////////
// watchPostDetail  - GET       /api/posts/{id}         게시글 단건 조회 
//////////////////////////////////////////////////////////////////////////////
 
export const fetchPostDetailApi = (id)=> api.get(`${POST_API_BASE}/${id}`);

export function* fetchPostDetail(action){
    try{
        const result = yield call(fetchPostDetailApi, action.payload);
        yield put(fetchPostDetailSuccess(result.data));
    } catch(err) {
        yield put(fetchPostDetailFailure(err.response?.data?.message || err.message));
    }
}

//////////////////////////////////////////////////////////////////////////////
// watchCreatePost  - POST      /api/posts              게시글 작성
//////////////////////////////////////////////////////////////////////////////

export function createPostApi(payload) {
    const { userId, dto, files } = payload; // 1. Springboot의 PostController와 이름 동일하게 세팅함
    const formData = new FormData();    // 2. form 만들기
    Object.entries(dto || {}).forEach(([k, v]) => { // 3. dto - content/hashtag
      if (v !== undefined && v !== null) {
        formData.append(k, v);
      }
    });
    if (files && files.length > 0) {    // 4. 이미지 파일들
      files.forEach((f) => formData.append('files', f));
    }
    //http://localhost:8080/api/posts?userId=${userId}
    return api.post( `${POST_API_BASE}?userId=${userId}`, formData, { 
        headers: { "Content-Type" : "multipart/form-data" },
    }); 
}

export function* createPost(action){
    try{
        const result = yield call(createPostApi, action.payload); // 사용자가 넘겨준 값
        yield put(createPostSuccess(result.data));
    }catch(err){
        yield put(createPostFailure(err.response?.data?.message || err.message));
    }
}

//////////////////////////////////////////////////////////////////////////////
// watchUpdatePost  - PUT       /api/posts/{id}         게시글 수정
//////////////////////////////////////////////////////////////////////////////

export function updatePostApi(payload){ 
    const { userId, postId, dto, files } = payload;
    const formData = new FormData();    // 2. form 만들기
    Object.entries(dto || {}).forEach(([k, v]) => { // 3. dto - content/hashtag
      if (v !== undefined && v !== null) {
        formData.append(k, v);
      }
    });
    if (files && files.length > 0) {    // 4. 이미지 파일들
      files.forEach((f) => formData.append('files', f));
    }
    //http://localhost:8080/api/posts/${postId}?userId=${userId}
    return api.patch(`${POST_API_BASE}/${postId}?userId=${userId}`, formData, {
        headers: { "Content-Type" : "multipart/form-data" }
    }); 
}

export function* updatePost(action){
    try{
        const result = yield call(updatePostApi, action.payload); // 사용자가 넘겨준 값
        yield put(updatePostSuccess(result.data));
    }catch(err){
        yield put(updatePostFailure(err.response?.data?.message || err.message));
    }
}

//////////////////////////////////////////////////////////////////////////////
// watchDeletePost  - DELETE    /api/posts/{id}         게시글 삭제
//////////////////////////////////////////////////////////////////////////////

export const deletePostApi = (id)=> api.delete(`${POST_API_BASE}/${id}`);

export function* deletePost(action){
    try{
        yield call(deletePostApi, action.payload); // 사용자가 넘겨준 값
        yield put(deletePostSuccess(action.payload));
    }catch(err){
        yield put(deletePostFailure(err.response?.data?.message || err.message));
    }
}

//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////

function* watchFetchPosts(){ yield takeLatest( fetchPostsRequest.type, fetchPosts ); }
function* watchPostDetail(){ yield takeLatest( fetchPostDetailRequest.type, fetchPostDetail ); }
function* watchCreatePost(){ yield takeLatest( createPostRequest.type, createPost ); }
function* watchUpdatePost(){ yield takeLatest( updatePostRequest.type, updatePost ); }
function* watchDeletePost(){ yield takeLatest( deletePostRequest.type, deletePost ); }


export default function* postSaga(){
    yield all([
        call(watchFetchPosts),
        call(watchPostDetail),
        call(watchCreatePost),
        call(watchUpdatePost),
        call(watchDeletePost),
    ]);
}