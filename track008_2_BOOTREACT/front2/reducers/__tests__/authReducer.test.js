//__test__/authReducer.test.js
//import { loadPlugin } from 'immer/dist/internal.js';
import userReducer, { 
    signupRequest, signupSuccess, signupFailure,
    loginRequest, loginSuccess, loginFailure,
    logoutRequest, logoutSuccess, logoutFailure,
    updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
    updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,
    resetUserState
} from '../authReducer';

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

    /////////////////////////////////////////////////////////// 로그인

    it('loginSuccess', ()=>{
        const payload = { id:1, email: '1@1'};
        const state = userReducer(initialState, loginSuccess(payload));
        expect(state.loading).toBe(false);
        expect(state.user).toEqual(payload);
    });


    /////////////////////////////////////////////////////////// 로그아웃
    
    it('logoutSuccess', ()=>{
        const prev = { ...initialState, user:{ id:1 }};
        const state = userReducer(prev, logoutSuccess());
        expect(state.loading).toBe(false);
        expect(state.user).toBeNull();
        expect(state.error).toBeNull();
    });


    /////////////////////////////////////////////////////////// 닉네임 변경

    it('updateNicknameSuccess', ()=>{
        const payload = { id:1, nickname: 'new'};
        const state = userReducer(initialState, updateNicknameSuccess(payload));
        expect(state.loading).toBe(false);
        expect(state.user.nickname).toEqual('new');
    });


    /////////////////////////////////////////////////////////// 프로필 이미지 변경
    it('updateProfileImageSuccess', ()=>{
        const payload = { id:1, ufile: '1.png'};
        const state = userReducer(initialState, updateProfileImageSuccess(payload));
        expect(state.loading).toBe(false);
        expect(state.user).toEqual(payload);
    });

});

//npm test authReducer