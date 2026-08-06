// sagas/authSaga.js
import { all, call, put, takeLatest } from 'redux-saga/effects';
import axios from 'axios';
import {
    signupRequest, signupSuccess, signupFailure,
    loginRequest, loginSuccess, loginFailure,
    logoutRequest, logoutSuccess, logoutFailure,
    updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
    updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,
    resetUserState
} from '../reducers/authReducer';

const USER_API_BASE = 'http://localhost:8080/auth';

// --- 회원가입 POST ---
// POST : http://localhost:8080/auth/signup
export  const signupApi = ( formData )=> axios.post(`${USER_API_BASE}/signup`, formData, {
    headers: { "Content-Type" : "multipart/form-data" },
} );

// ■2. signup(action) - action.payload 사용자가 입력한 값(회원정보)
export function* signup(action){
    // acion = { type: auth/signupRequest, payload: { email:'1@1', password: '1'} }
    try{
        const result = yield call(signupApi, action.payload);
        yield put(signupSuccess(result.data)); // 처리결과 put
    } catch(err) {
        yield put(signupFailure(err.response?.data?.message || err.message));
    }
}

//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
// --- 로그인 POST : /auth/login ---
export const loginApi = ( payload )=> axios.post(`${USER_API_BASE}/login`, payload);

export function* login(action){
    // { email: '1@1', password: '1', provider: 'local' }
    // acion = { type: auth/login, payload: 1 }
    try{
        const result = yield call(loginApi, action.payload); // 3.
        yield put(loginSuccess(result.data)); // 처리결과 put
    } catch(err) {
        yield put(loginFailure(err.response?.data?.message || err.message));
    }
}

//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
// --- 로그아웃 POST : /auth/logout 넘겨줄 데이터 없음---
export const logoutApi = ()=> axios.post(`${USER_API_BASE}/logout`);

export function* logout(){
    // acion = { type: signupSuccess, payload: userData }
    try{
        const result = yield call(logoutApi);
        yield put(logoutSuccess());
    } catch(err) {
        yield put(logoutFailure(err.response?.data?.message || err.message));
    }
}

//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
// --- 닉네임 변경 PATCH : /auth/{userId}/nickname ---
export const updateNicknameApi = ( {userId, nickname} )=> axios.patch(`${USER_API_BASE}/${userId}/nickname`, null, {params:{nickname}} );

export function* updateNickname(action){
    // acion = { type: signupSuccess, payload: userData }
    try{
        const result = yield call(updateNicknameApi, action.payload); // 3.
        yield put(updateNicknameSuccess(result.data)); // 처리결과 put
    } catch(err) {
        yield put(updateNicknameFailure(err.response?.data?.message || err.message));
    }
}

//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
// --- 프로필 이미지 변경 PATCH : /auth/{userId}/profile-image, formData ---
export function updateProfileImageApi( {userId, file} ){ 
    const formData = new formData();
    formData.append("ufile", file);
    return axios.patch(`${USER_API_BASE}/${userId}/profile-image`, formData, 
        { headers: { "Content-Type" : "multipart/form-data" }
    });
}
export function* updateProfileImage(action){
    try{
        const result = yield call(updateProfileImageApi, action.payload);
        yield put(updateProfileImageSuccess(result.data));
    } catch(err) {
        yield put(updateProfileImageFailure(err.response?.data?.message || err.message));
    }
}

//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////

// ■1. takeLatest( signupRequest.type, signup )
// takeLatest : 요청이 여러번 발생해도, 가장 마지막에 발생한 요청만 처리
function* watchSignup(){ yield takeLatest( signupRequest.type, signup ); }
function* watchLogin(){ yield takeLatest( loginRequest.type, login ); }
function* watchLogout(){ yield takeLatest( logoutRequest.type, logout ); }
function* watchUpdateNickname(){ yield takeLatest( updateNicknameRequest.type, updateNickname ); }
function* watchUpdateProfileImage(){ yield takeLatest( updateProfileImageRequest.type, updateProfileImage ); }

//1. UserApi - 사용자 관련 API
// POST - /api/users
// GET -  /api/users/{id}
export default function * authSaga(){
    yield all([
        call(watchSignup),
        call(watchLogin),
        call(watchLogout),
        call(watchUpdateNickname),
        call(watchUpdateProfileImage),
    ]);
}