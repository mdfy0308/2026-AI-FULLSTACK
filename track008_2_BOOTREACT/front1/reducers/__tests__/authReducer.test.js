//__test__/authReducer.test.js
//import { loadPlugin } from 'immer/dist/internal.js';
import userReducer, { signupRequest, signupSuccess, signupFailure,
    fetchUserRequest, fetchUserSuccess, fetchUserFailure,
    resetUserState } from '../authReducer';

describe('user slice reducer', ()=>{
    const initialState={
        user: null,         // 단건 조회된 사용자 정보
        loading: false,     // 로딩 상태
        error: null,        // 에러 메시지
        success: false,     // 성공 여부
    };
    it('signupRequest', ()=>{
        const state = userReducer(initialState, signupRequest);
        expect(state.loading).toBe(true);
        expect(state.success).toBe(false);
        expect(state.error).toBeNull();
    });

    it('signupSuccess', ()=>{ 
        const userData = {id:1, email:'1@1'};
        const state = userReducer(initialState, signupSuccess(userData));
        // 1. signupSuccess(userData) - {id:1, email:'1@1'}
        // 2. 리듀서 툴킷에서 {type:signupSuccess, payload:userData} 객체 만들기
        // 3. 리듀서의 signupSuccess: (state, action)=>{} 액션 받아서 처리
        // acion = {type:signupSuccess, payload:userData}
        expect(state.loading).toBe(false);      // state.loading = false
        expect(state.user).toEqual(userData);   // state.user    = action.payload
        expect(state.success).toBe(true);       // state.success = true
    });

    it('signupFailure', ()=>{
        const state = userReducer(initialState, signupFailure('회원가입 실패'));
        // 1. signupFailure('회원가입 실패') 실행하면
        // 2. 리듀서툴킷에서 {type:signupFailure, payload:'회원가입 실패'} 객체 만들기
        // 3. 리듀서의 signupFailure: (state, action)=>{} 액션 받아서 처리
        // action = {type:signupFailure, payload:'회원가입 실패'}
        expect(state.loading).toBe(false);
        expect(state.error).toBe('회원가입 실패');
    });

    ///////////////////////////////////////////////////////////
    // it('fetchUserRequest', ()=>{ });

    it('fetchUserSuccess', ()=>{
        const userData = {id:1, email:'1@1'}
        const state = userReducer(initialState, fetchUserSuccess(userData));
        // 1. fetchUserSuccess(userData) - {id:1, email:'1@1'} 전달
        // 2. 리듀서 툴킷에서 {type:fetchUserSuccess, payload:userData} 객체 만들기
        // 3. 리듀서의 fetchUserSuccess: (state, action)=>{} 액션 받아서 처리
        // action = {type: fetchUserSuccess, payload:userData}
        expect(state.loading).toBe(false);
        expect(state.user).toEqual(userData); // state.user = actiom.payload
        expect(state.success).toBe(true);     
    });

    // it('fetchUserFailure', ()=>{ });

    ///////////////////////////////////////////////////////////
    it('resetUserState', ()=>{
        const prev = {user: {id:1}, loading: true, error:'err', success: true}; // 상태꼬임
        const state = userReducer(prev, resetUserState());
        // 1. resetUserState() 실행 - 인자 없음
        // 2. 리듀서 툴킷에서 { type:resetUserState, payload:undefined } 객체 만들기
        // 3. 리듀서의 resetUserState : (state, action) => 액션 받아서 처리-상태 초기화
        // action = { type:resetUserState, payload:undefined }
        expect(state.loading).toBe(false);
        expect(state.error).toBeNull();
        expect(state.success).toBe(false);
    });
});

//npm test authReducer