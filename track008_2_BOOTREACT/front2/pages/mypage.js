// pages/mypage.js
//1. require / import
import {
  Card, Avatar, Spin, Descriptions, Form, Input, Button, Upload, List, Tabs, message, } from "antd";
import { UploadOutlined } from "@ant-design/icons";  

// store : useSelector(전역), useDispatch(스토어 이벤트 알림)
// 감지 : useEffect(이벤트 변경 감지), useState(변수) 
// 경로 : useRouter
import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useRouter } from "next/router";
import { updateNicknameRequest, updateProfileImageRequest } from "../reducers/authReducer";

//2. function
function MyPage(){
    //Redux에서 회원가입시 저장된 사용자 정보 반영하기 - user
    const dispatch = useDispatch();
    const router = useRouter();
    const { user } = useSelector((state) => state.auth);
    const [fileList, setFileList] = useState([]);

    const onFinishUpdateNickname = (value)=>{
        dispatch( updateNicknameRequest( {userId: user.id, nickname: value.nickname}) );
    };

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
                {/* 닉네임 수정 */}
                <Form layout="inline" style={{ margin: "20px 0" }}
                    onFinish={onFinishUpdateNickname} >
                    <Form.Item name="nickname" >
                        <Input placeholder="새 닉네임" />
                    </Form.Item>
                    <Button type="primary" htmlType="submit">닉네임 변경</Button>
                </Form>
                {/* 프로필 이미지 수정 */}
                <Form layout="inline" style={{ margin: "20px 0" }} >
                    <Form.Item name="nickname" >
                        <Upload
                            beforeUpload={()=>false}
                            fileList={ fileList }
                            onChange={ ( {fileList} )=>{ setFileList(fileList) } }
                            action="https://660d2bd96ddfa2943b33731c.mockapi.io/api/upload"
                            listType="picture"
                            maxCount={1}
                        >
                            <Button icon={<UploadOutlined />}> 이미지 선택 </Button>
                        </Upload>
                    </Form.Item>
                    <Button 
                    type="primary" 
                    onClick={()=>{ if(!user || fileList.length === 0){
                            message.warning('변경할 이미지를 선택해주세요.'); return;
                        } 
                        const file = fileList[0]?.originFileObj;
                        dispatch( updateProfileImageRequest({userId:user.id, file}) );
                        setFileList([]); // 전송 후 파일 선택 목록 초기화
                    }}
                    htmlType="submit">프로필 이미지 변경</Button>
                </Form>
            </Card>
        </div>
    );
}

//3. export 
export default MyPage;

//npm run dev