//__test__/postReducer.test.js
//import { loadPlugin } from 'immer/dist/internal.js';

import postReducer, { 
    fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
    fetchPostDetailRequest, fetchPostDetailSuccess, fetchPostDetailFailure,
    createPostRequest, createPostSuccess, createPostFailure,
    updatePostRequest, updatePostSuccess, updatePostFailure,
    deletePostRequest, deletePostSuccess, deletePostFailure,
    resetPostState } from '../postReducer';



describe('post', ()=>{
    const initialState={
        posts: [],          // 전체 게시글 목록
        currentPost: null,  // 단건 조회된 상세 게시글
        loading: false,     // 로딩 상태
        error: null,        // 에러 메시지
        success: false,     // 성공 여부
    };

    it('fetchPostsRequest & fetchPostsSuccess', ()=>{
        let state = postReducer( initialState, fetchPostsRequest() );
        // 1. fetchPostsRequest() 실행 - 인자 없음
        // 2. 리듀서툴킷 - { type:fetchPostsRequest, payload: undefined } 객체 만들기
        // 3. 리듀서 fetchPostsRequest:(state, action)=>{} 액션 받아서 처리
        // 4. fetchPostsRequest
        expect(state.loading).toBe(true);

        const posts = [{id:1, content: '첫 번째 글'}, {id:2, content: '두 번째 글'}];
        state = postReducer( initialState, fetchPostsSuccess(posts) );
        expect(state.loading).toBe(false);
        expect(state.posts).toEqual(posts);
        expect(state.success).toBe(true);
    });

    it('fetchPostDetailSuccess', ()=>{
        const post = {id:1, content: '첫 번째 글'};
        const state = postReducer( initialState, fetchPostDetailSuccess(post) );
        expect(state.loading).toBe(false);
        expect(state.currentPost).toEqual(post);
        expect(state.success).toBe(true);
    });


    it('createPostSuccess', ()=>{
        const newPost = {id:3, content:'새 글'};
        const state = postReducer(initialState, createPostSuccess(newPost));
        expect(state.posts[0]).toEqual(newPost);
        expect(state.success).toBe(true);

    });

    it('updatePostSuccess', ()=>{
        const prev = { ...initialState, posts: [{id:3, content:'새 글'}] };
        const updated = { id:3, content: '수정 후' }; // 서버에서 받아온 값

        const state = postReducer(prev, updatePostSuccess(updated));
        expect(state.posts[0].content).toBe('수정 후');
        expect(state.currentPost).toEqual(updated);
        expect(state.success).toBe(true);
    });

    it('deletePostSuccess', ()=>{
        const prev = { ...initialState, posts: [ {id:1, content:'새 글'} ]};
        const state = postReducer(prev, deletePostSuccess(1));

        expect(state.posts).toHaveLength(0);
        expect(state.posts.length).toBe(0);
        expect(state.success).toBe(true);
    });

    it('resetPostState', ()=>{
        const prev = {user: {id:1}, loading: true, error:'error', success: true}; // 상태꼬임
        const state = postReducer(prev, resetPostState());
        expect(state.loading).toBe(false);
        expect(state.error).toBeNull();
        expect(state.success).toBe(false);
    });

});

// npm test postReducer