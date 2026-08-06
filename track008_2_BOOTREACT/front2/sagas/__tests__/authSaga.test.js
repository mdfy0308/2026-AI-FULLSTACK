// sagas/__test__/authSaga.test.js
// call - 동기 - 제너레이터 함수 function* 일시중단 후 결과물 받기 / fork - 비동기
// put - redux 액션처리
import { call, put } from 'redux-saga/effects';
import axios from 'axios';

import { 
    signupRequest, signupSuccess, signupFailure,
    loginRequest, loginSuccess, loginFailure,
    logoutRequest, logoutSuccess, logoutFailure,
    updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
    updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,
    resetUserState
} from '../../reducers/authReducer'

import { signup, login, logout, updateNickname, updateProfileImage } from '../authSaga';

jest.mock('axios');

describe('auth saga', ()=>{
    afterEach(()=> { jest.clearAllMocks() }); // 각각의 테스트 종료 후 clear

    // --- 회원가입 ---
    it('signup success', ()=>{
        const userData = { email: '1@1', password: '1234' } // ##1
        const action = signupRequest(userData); //##2
        const generator = signup(action);

        //1. api 호출(call)
        const callstep = generator.next().value;
        expect(callstep.type).toBe('CALL');

        //2. api 성공시 결과 값을 전달
        const mockResponse = { data: { id:1, email: '1@1'}  }; //##3
        const putStep = generator.next( mockResponse ).value;

        //3. 성공 액션 디스패치
        expect(putStep).toEqual(put(signupSuccess(mockResponse.data)));
        expect(generator.next().done).toBe(true);

    });

    // --- 로그인 ---
    it('login success', ()=>{
        const userData = { email: '1@1', password: '1234' };
        const action = loginRequest(userData);
        const generator = login(action);

        //1. api 호출(call)
        const callstep = generator.next().value;
        expect(callstep.type).toBe('CALL');

        //2. api 성공시 결과 값을 전달
        const mockResponse = { data: { id:1, email: '1@1', nickname: 'first'}  }; //##3
        const putStep = generator.next( mockResponse ).value;

        //3. 성공 액션 디스패치
        expect(putStep).toEqual(put(loginSuccess(mockResponse.data)));
        expect(generator.next().done).toBe(true);
    });

    // --- 로그아웃 ---
    it('logout success', ()=>{
        const action = logoutRequest();
        const generator = logout(action);

        //1. api 호출(call)
        const callstep = generator.next().value;
        expect(callstep.type).toBe('CALL');

        //2. api 성공시 결과 값을 전달
        const putStep = generator.next().value;

        //3. 성공 액션 디스패치
        expect(putStep).toEqual(put(logoutSuccess()));
        expect(generator.next().done).toBe(true);
        
    });

    // --- 닉네임 수정 ---
    it('updateNickname success', ()=>{
        const payload = { userId:1, nickname: 'new' };
        const action = updateNicknameRequest(payload);
        const generator = updateNickname(action);

        //1. api 호출(call)
        const callstep = generator.next().value;
        expect(callstep.type).toBe('CALL');

        //2. api 성공시 결과 값을 전달
        const mockResponse = { data: { id:1, nickname: 'new'}  }; //##3
        const putStep = generator.next( mockResponse ).value;

        //3. 성공 액션 디스패치
        expect(putStep).toEqual(put(updateNicknameSuccess(mockResponse.data)));
        expect(generator.next().done).toBe(true);
    });

    // --- 프로필 이미지 수정 ---
    it('updateProfileImage success', ()=>{
        const payload = { userId: 1, file: new Blob(['test']) };
        const action = updateProfileImageRequest(payload);
        const generator = updateProfileImage(action);

        //1. api 호출(call)
        const callstep = generator.next().value;
        expect(callstep.type).toBe('CALL');

        //2. api 성공시 결과 값을 전달
        const mockResponse = { data: { id:1, ufile:'profile.png' }  }; //##3
        const putStep = generator.next( mockResponse ).value;

        //3. 성공 액션 디스패치
        expect(putStep).toEqual(put(updateProfileImageSuccess(mockResponse.data)));
        expect(generator.next().done).toBe(true);

    });

});

// npm test authSaga.test.js