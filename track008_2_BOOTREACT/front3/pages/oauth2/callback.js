//1. import, require [ ]
import { useEffect, useRef } from "react";
import { useRouter } from "next/router";
import { useDispatch } from "react-redux";
import { loginSuccess } from "../../reducers/authReducer";
import axios from "axios";

// String targetUrl = redirectUrl + "?accessToken=" + access; // 쿼리스트링

//2. 부품 + export
export default function Oauth2CallbackPage(){

    const router = useRouter(); // 경로 이동
    const dispatch = useDispatch(); // 스토어 알림

    useEffect(()=>{
        if(!router.isReady) return;
        const {accessToken} = router.query;
        if(accessToken){
            try{
                localStorage.setItem("accessToken" , accessToken); // 토큰 저장 
                fetchUser(accessToken); // 사용자 정보 요청
            }catch(err){
                console.error( "OAuth2 callback error:", err);
                router.push("/login");
            }
        }
    }, [ router.isReady, router.query ]);

    const fetchUser = async(accessToken)=>{
        try{
            const res = await axios.get("http://localhost:8080/auth/me", {
                headers: { Authorization: `Bearer ${accessToken}` },
                withCredentials: true,  //쿠키 전송용
            });
            const user = res.data;
            dispatch(loginSuccess({user, accessToken}));
            router.push("/mypage");
        }catch(err){
            console.error("User fetch error:", err);
            router.push("/login");
        }
    };

    return (
        <p> 소셜 로그인 처리중입니다. </p>
    );
}