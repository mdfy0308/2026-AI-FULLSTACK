// pages/login.js

//1. import / require
import React, { useEffect, useState, useRef } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useRouter } from "next/router";
import axios from "axios";
import { loginRequest, resetUserState } from "../reducers/authReducer";


// 2+3 부품+export

export default function LoginPage(){

    return "login";

}


/*

Q1. 로그인한 상태 : 글쓰기 / 마이페이지 / 로그아웃
Q2. 로그인 안 한 상태 : 로그인 / 회원가입 / 

*/