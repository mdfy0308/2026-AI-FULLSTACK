// sagas/postSaga.js
import { all, call, put, takeLatest } from 'redux-saga/effects';
import axios from 'axios';
import {
    fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
    fetchPostDetailRequest, fetchPostDetailSuccess, fetchPostDetailFailure,
    createPostRequest, createPostSuccess, createPostFailure,
    updatePostRequest, updatePostSuccess, updatePostFailure,
    deletePostRequest, deletePostSuccess, deletePostFailure,
    resetPostState,
} from '../reducers/postReducer';

const POST_API_BASE = 'http://localhoset:8080/api/posts';

//////////////////////////////////////////////////////////////////////////////
// watchFetchPosts  - GET /api/posts 전체 게시글 조회 ---
//////////////////////////////////////////////////////////////////////////////

export const fetchPostsApi = ()=> axios.get(POST_API_BASE);

export function* fetchPosts(){
    try{
        const result = yield call(fetchPostsApi);
        yield put(fetchPostsSuccess(result.data));
    } catch(err) {
        yield put(fetchPostsFailure(err.response?.data?.message || err.message));
    }
}

function* watchFetchPosts(){ yield takeLatest( fetchPostsRequest.type, fetchPosts ); }

//////////////////////////////////////////////////////////////////////////////
// watchPostDetail  - GET       /api/posts/{id}         게시글 단건 조회 
//////////////////////////////////////////////////////////////////////////////
 
export const fetchPostDetailApi = (id)=> axios.get(`${POST_API_BASE}/${id}`);

export function* fetchPostDetail(action){
    try{
        const result = yield call(fetchPostDetailApi, action.payload);
        yield put(fetchPostDetailSuccess(result.data));
    } catch(err) {
        yield put(fetchPostDetailFailure(err.response?.data?.message || err.message));
    }
}

function* watchPostDetail(){ yield takeLatest( fetchPostDetailRequest.type, fetchPostDetail ); }

//////////////////////////////////////////////////////////////////////////////
// watchCreatePost  - POST      /api/posts              게시글 작성
//////////////////////////////////////////////////////////////////////////////

export const createPostApi = (postData)=> axios.post(POST_API_BASE, postData);
export function* createPost(action){
    try{
        const result = yield call(createPostApi, action.payload); // 사용자가 넘겨준 값
        yield put(createPostSuccess(result.data));
    }catch(err){
        yield put(createPostFailure(err.response?.data?.message || err.message));
    }
}

function* watchCreatePost(){ yield takeLatest( createPostRequest.type, createPost ); }

//////////////////////////////////////////////////////////////////////////////
// watchUpdatePost  - PUT       /api/posts/{id}         게시글 수정
//////////////////////////////////////////////////////////////////////////////

export const updatePostApi = ({postId, dto})=> axios.put(`${POST_API_BASE}/${postId}`, dto);

export function* updatePost(action){
    try{
        const result = yield call(updatePostApi, action.payload); // 사용자가 넘겨준 값
        yield put(updatePostSuccess(result.data));
    }catch(err){
        yield put(updatePostFailure(err.response?.data?.message || err.message));
    }
}

function* watchUpdatePost(){ yield takeLatest( updatePostRequest.type, updatePost ); }

//////////////////////////////////////////////////////////////////////////////
// watchDeletePost  - DELETE    /api/posts/{id}         게시글 삭제
//////////////////////////////////////////////////////////////////////////////

export const deletePostApi = (id)=> axios.delete(`${POST_API_BASE}/${id}`);

export function* deletePost(action){
    try{
        yield call(deletePostApi, action.payload); // 사용자가 넘겨준 값
        yield put(deletePostSuccess(action.payload));
    }catch(err){
        yield put(deletePostFailure(err.response?.data?.message || err.message));
    }
}

function* watchDeletePost(){ yield takeLatest( deletePostRequest.type, deletePost ); }



//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////

export default function * postSaga(){
    yield all([
        call(watchFetchPosts),
        call(watchPostDetail),
        call(watchCreatePost),
        call(watchUpdatePost),
        call(watchDeletePost),
    ]);
}