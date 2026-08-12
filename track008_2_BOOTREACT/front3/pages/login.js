// pages/login.js

//1. import / require
import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux"; // 스토어 알림, 전역상태
import { Row, Col, Form, Input, Button, Spin, message } from "antd";  
import { useRouter } from "next/router"; // 경로
import { loginRequest, resetUserState } from "../reducers/authReducer";


// 2+3 부품+export
export default function LoginPage() { 
    //Q1. useDispatch, useRouter 초기화
    const dispatch = useDispatch();
    const router = useRouter();

    //Q2. useSelector 이용해서 user 상태 가져오기
    const { user, loading, error, accessToken } = useSelector((state) => state.auth);

    //Q3. 로그인 버튼을 누르고 나면 - 스토어알림(ditpatch) 이용해서 login Request 처리
    const onFinish = (values) => {
        dispatch(loginRequest({...values, provider:'local'}));
    };

    //Q4. 로그인 성공시 OO님 환영합니다 메시지 띄우고(message), 마이페이지로 이동
    // useSelect, useDispatch, useRouter, useEffect
    useEffect(()=>{
        if(user && user.email){
            message.success(`${user.nickname}님 환영합니다.`);
            router.push('/mypage');
        }
    }, [ user, router ]);

    const handleSocialLogin=(provider)=>{ 
        window.location.href = `http://localhost:8080/oauth2/authorization/${provider}`;
    };

    return (
        // Q5. justify 이용해서 중앙으로 배치, 위쪽에 여백주기
        <Row justify="center" style={ {marginTop: "40px"} }>
            {/* Q6. 반응형 처리 xs 24칸, sm 16칸, md 8칸 */}
            <Col xs={24} sm={16} md={8}>
                { loading && <Spin /> }
                { error && <p style={ {color: "red"} }> {error} </p> }
               <Form  layout="vertical" onFinish={onFinish}> 
                    <Form.Item 
                        label="이메일"
                        name="email"
                        rules={[ { required:true, message: "이메일을 입력하세요." } ]}
                    >
                        <Input placeholder="example@email.com" />
                    </Form.Item>
                    <Form.Item 
                        label="비밀번호"
                        name="password" 
                        rules={[ { required:true, message: "비밀번호를 입력하세요." } ]}
                    >
                        <Input.Password placeholder="******"  />
                    </Form.Item>
                    <div style={{ textAlign: 'center', marginTop: 20 }}>
                        <Button 
                            type="primary" 
                            htmlType="submit"   
                            style={{ width: '200px', height: '50px' }}
                        >
                            로그인
                        </Button>
                    </div>
                </Form> 

                {/*   소셜  로그인 이미지 버튼 */}
                <div style={{ marginTop: 20, textAlign: "center" }}>
                    <img
                        src="/images/google.png"       alt="Google Login"
                        style={{ cursor: "pointer", width: "200px", marginBottom: "10px" }}
                        onClick={()=> handleSocialLogin("google")}
                    />
                </div> 
                <div style={{ marginTop: 20, textAlign: "center" }}>
                    <img
                        src="/images/kakao.png"      alt="Kakao Login"
                        style={{ cursor: "pointer", width: "200px", marginBottom: "10px" }}
                        onClick={()=> handleSocialLogin("kakao")}
                    />
                </div>
                <div style={{ marginTop: 20, textAlign: "center" }}>
                    <img
                        src="/images/naver.png"      alt="Naver Login"
                        style={{ cursor: "pointer", width: "200px", marginBottom: "10px" }}
                        onClick={()=> handleSocialLogin("naver")}
                    />
                </div>
            </Col>
        </Row>
    );
}

// SSR 단순 렌더링 : 서버에서 데이터 가져오거나 가공하지 않고 페이지 컴포넌트를 서버에 그려서 내어주기
export async function getServerSideProps() {
  return { props: {} };
}
