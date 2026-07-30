// sagas/__test__/authSaga.test.js
// call - 동기 - 제너레이터 함수 function* 일시중단 후 결과물 받기 / fork - 비동기
// put - redux 액션처리
import { call, put } from 'redux-saga/effects';
import axios from 'axios';

import { signupRequest , signupSuccess , signupFailure,
    fetchUserRequest,  fetchUserSuccess ,  fetchUserFailure,  
    resetUserState, } from '../../reducers/authReducer'

import { signup, fetchUser } from '../authSaga';

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
        const mockupResponse = { data: { id:1, email: '1@1'}  }; //##3
        const putStep = generator.next( mockupResponse ).value;

        //3. 성공 액션 디스패치
        expect(putStep).toEqual(put(signupSuccess(mockupResponse.data)));
        expect(generator.next().done).toBe(true);

    });

    // --- 단건조회 ---
    it('fetchUser success', ()=>{
        const action = fetchUserRequest(1);
        const generator = fetchUser(action);    // action = { type:fetchUserRequest , payload: {1} }

        //1. api 호출(call)
        expect(generator.next().value.type).toBe('CALL');

        //2. api 성공시 결과 값을 전달
        const mockUser = { data: { id:1, email: '1@1'}  }; //##3 서버에서 전달된 값
        const putStep = generator.next( mockUser ).value;

        //3. 성공 액션 디스패치
        expect(putStep).toEqual(put(fetchUserSuccess(mockUser.data)));
    });


});

// npm test authSaga.test.js