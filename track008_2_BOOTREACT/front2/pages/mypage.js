// pages/mypage.js
//1. require / import
import { Button, Card, Descriptions, Avatar } from "antd";    
import { UploadOutlined } from "@ant-design/icons";  

// store : useSelector(전역), useDispatch(스토어 이벤트 알림)
// 감지 : useEffect(이벤트 변경 감지), useState(변수) 
// 경로 : useRouter
import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useRouter } from "next/router";
import { fetchUserRequest, resetUserState } from "../reducers/authReducer";

//2. function
function MyPage(){
    //Redux에서 회원가입시 저장된 사용자 정보 반영하기 - user
    const { user } = useSelector((state) => state.auth);
    const router = useRouter();

    if(!user){
        return (
            <div style={ {maxWidth: 600, margin: "40px auto", textAlign: "center"} }>
                <p> 로그인된 사용자가 없습니다.</p>
                <Button type="primary" onClick={()=> router.push("/signup")}>
                    회원가입 하러가기
                </Button>
            </div>
        );
    }
    ///////////////////////
    return (
        <div style={ {maxWidth: 600, margin: "40px auto"} }>
            <Card title="마이페이지(회원 정보)">
                <div style={ { display:"flex", flexDirection: "column", gap:"20px"} }>
                    <Avatar src={`http://localhost:8080/${user.ufile}`} size={64}>{user.nickname?.[0]}</Avatar>
                    <Descriptions style={ {width: "100%" } } title="User Info" bordered column={1}>
                        <Descriptions.Item label="회원번호">{user.id}</Descriptions.Item>
                        <Descriptions.Item label="이메일">{user.email}</Descriptions.Item>
                        <Descriptions.Item label="닉네임">{user.nickname}</Descriptions.Item>
                    </Descriptions>
                </div>
            </Card>
        </div>
    );
}

//3. export 
export default MyPage;

//npm run dev