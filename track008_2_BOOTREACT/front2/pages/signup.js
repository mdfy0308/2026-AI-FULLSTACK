// pages/signup.js
import { Row, Col, Form, Input, Button, Spin, message, Upload } from "antd";
import { UploadOutlined } from '@ant-design/icons';

import React, { useEffect, useState, useRef } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useRouter } from "next/router";
import axios from "axios";
import { signupRequest, resetUserState } from "../reducers/authReducer";


//////////////////////////////////////////////////////////////////////////


function SignupPage(){
    const dispatch = useDispatch();
    const router = useRouter();
    const {user, error, success, loading} = useSelector((state) => state.auth);

    const [fileList, setFileList] = useState([]);
    const isSubmittedRef = useRef(false);

    // 데이터 받아서 회원가입 전송 - 네트워크가 느리면 0.5초 2~3회 연속으로 클릭(요청 중복)
    const onFinish = (values) => {
        if(isSubmittedRef.current){ return; } // ##
        isSubmittedRef.current = true; // ##

        const formData = new FormData();
        formData.append("email", values.email);
        formData.append("password", values.password);
        formData.append("nickname", values.nickname);

        if(fileList.length > 0){
            formData.append("ufile", fileList[0].originFileObj);
        }

        dispatch(signupRequest(formData));
    };
    
    useEffect(() => {
        if (success) {
            message.success("회원가입이 성공적으로 완료되었습니다.");
            router.push(`login`);
            dispatch(resetUserState());
        }
        return ()=>{
            isSubmittedRef.current = false;
        };
    }, [success, router, dispatch]);
    
    //////////////////////////////////////////////////////////////////

    return (
        <Row justify="center">
            <Col xs={24} sm={16} md={8}>
                {loading && <Spin />}
                {error && <p style={{ color: "red" }}>{error}</p>}
                {!success && (
                    <Form layout="vertical" onFinish={onFinish}>
                        {/* 이메일 입력 + 중복검사 */}
                        <Form.Item 
                            label="이메일"
                            name="email"
                            hasFeedback
                            rules={[ 
                                { required: true, message: '이메일을 입력하세요.' },
                                { validator: async (_, value) => {
                                        if (!value) return Promise.resolve();

                                        try {
                                            const res = await axios.get(`http://localhost:8080/auth/check-email?email=${encodeURIComponent(value)}`);
                                            if (res?.data === true) {
                                                return Promise.reject(new Error("이미 사용중인 이메일입니다."));
                                            }
                                            return Promise.resolve();
                                        } catch (err) {
                                            console.log('이메일 중복검사 오류', err);
                                            return Promise.reject(new Error("중복 검사 실패"));
                                        }
                                    }
                                },
                            ]}>
                            <Input placeholder="example@email.com" />
                        </Form.Item>

                        <Form.Item 
                            label="비밀번호"
                            name="password"
                            rules={[{ required: true, message: '비밀번호를 입력하세요.' }]}> 
                            <Input.Password />
                        </Form.Item>

                        <Form.Item 
                            label="닉네임"
                            name="nickname"
                            hasFeedback
                            rules={[{ required: true, message: '닉네임을 입력하세요.' },
                                { validator: async (_, value) => {
                                        if (!value) return Promise.resolve();

                                        try {
                                            const res = await axios.get(`http://localhost:8080/auth/check-nickname?nickname=${encodeURIComponent(value)}`);
                                            if (res?.data === true) {
                                                return Promise.reject(new Error("이미 사용중인 닉네임입니다."));
                                            }
                                            return Promise.resolve();
                                        } catch (err) {
                                            console.log('닉네임 중복검사 오류', err);
                                            return Promise.reject(new Error("중복 검사 실패"));
                                        }
                                    }
                                },
                            ]}> 
                            <Input />
                        </Form.Item>

                        <Form.Item name="profileImage" label="프로필 이미지">
                                <Upload
                                    beforeUpload={()=>false}
                                    fileList={ fileList }
                                    onChange={ ( {fileList} )=>{ setFileList(fileList)} }
                                    action="https://660d2bd96ddfa2943b33731c.mockapi.io/api/upload"
                                    listType="picture"
                                    maxCount={1}
                                >
                                    <Button icon={<UploadOutlined />}>Upload (Max: 1)</Button>
                                </Upload>
                        </Form.Item>

                        <Button type="primary" htmlType="submit" loading={loading} block>
                            회원가입
                        </Button>
                    </Form>
                )}
            </Col>
        </Row>
    );
}

export default SignupPage;