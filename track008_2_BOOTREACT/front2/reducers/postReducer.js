// reducers/postReducer.js
import { createSlice } from "@reduxjs/toolkit";

//1. 초기화 상태(공용)
const initialState={
    posts: [],          // 전체 게시글 목록
    currentPost: null,  // 단건 조회된 상세 게시글
    loading: false,     // 로딩 상태
    error: null,        // 에러 메시지
    success: false,     // 성공 여부
};

//2. 상태 변화
const postReducer=createSlice({
    name: "post",
    initialState,
    reducers: {

        // --- 상태 초기화 ---
        resetPostState : (state)=>{
            state.loading = false;
            state.error   = null;
            state.success = false;
        },
        
        // --- 게시글 전체 목록 조회 ---
        fetchPostsRequest: (state)=>{
            state.loading = true;
            state.error = null;
        },
        fetchPostsSuccess: (state, action)=>{
            state.loading = false;
            state.posts = action.payload;
        },
        fetchPostsFailure: (state, action)=>{
            state.loading = false;
            state.error = action.payload;
        },
        
        // --- 게시글 단건 조회 ---
        fetchPostDetailRequest: (state)=>{
            state.loading = true;
            state.error = null;
        },
        fetchPostDetailSuccess: (state, action)=>{
            state.loading = false;
            state.currentPost = action.payload;
        },
        fetchPostDetailFailure: (state, action)=>{
            state.loading = false;
            state.error = action.payload;
        },

        // --- 게시글 작성 ---
        createPostRequest: (state)=>{
            state.loading = true;
            state.error = null;
            state.success = false;
        },
        createPostSuccess: (state, action)=>{
            state.loading = false;
            // state.posts = [action.payload, ...state.posts]; // 새 글을 목록 상단에 추가 → 덮어쓰기
            state.posts.unshift(action.payload); // 위와 결과물은 동일함
            // action.payload - 새로 작성된 게시글 / unshift 배열의 맨 앞에 새 요소추가(직접 배열 수정)
            state.success = true;
        },
        createPostFailure: (state, action)=>{
            state.loading = false;
            state.error = action.payload;
        },

        // --- 게시글 수정 ---
        updatePostRequest: (state)=>{
            state.loading = true;
            state.error = null;
        },
        updatePostSuccess: (state, action)=>{
            state.loading = false;
            state.posts = state.posts.map(post=> 
                post.id === action.payload.id? action.payload : post);
            // post의 id와 action의 id가 같은 값일때 : 수정된 값으로 교체 or 아닐시 기존 값 유지
            state.currentPost = action.payload;
        },
        updatePostFailure: (state, action)=>{
            state.loading = false;
            state.error = action.payload;
        },

        // --- 게시글 삭제 ---
        deletePostRequest: (state)=>{
            state.loading = true;
            state.error   = null;
        },
        deletePostSuccess: (state, action)=>{
            state.loading = false;
            // 삭제된 게시글의 아이디를 받아서 목록에서 제외
            state.posts   = state.posts.filter(post => post.id !== action.payload)
        },
        deletePostFailure: (state, action)=>{
            state.loading = false;
            state.error   = action.payload;
        },
    }
});

//3. action
export const {
    fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
    fetchPostDetailRequest, fetchPostDetailSuccess, fetchPostDetailFailure,
    createPostRequest, createPostSuccess, createPostFailure,
    updatePostRequest, updatePostSuccess, updatePostFailure,
    deletePostRequest, deletePostSuccess, deletePostFailure,
    resetPostState
} = postReducer.actions;

//4. export
export default postReducer.reducer;