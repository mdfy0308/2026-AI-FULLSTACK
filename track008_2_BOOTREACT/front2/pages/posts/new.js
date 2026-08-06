// pages/posts/new.js
//1. require / import
import { Row, Col, Form, Button, Upload, Spin, message, Input, Card, Descriptions } from "antd";

// store : useSelector(전역), useDispatch(스토어 이벤트 알림)
// 감지 : useEffect(이벤트 변경 감지), useState(변수) 
// 경로 : useRouter
import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux"; // 전역정보, 이벤트 발생
import { useRouter } from "next/router"; // 화면 이동
import { createPostRequest, resetPostState } from "../../reducers/postReducer"; // 액션


function newPostPage(){
    //1. 글 정보(state.post) 유저 정보(state.auth) 가져오기(useSelector : 전역정보)
    const dispatch = useDispatch();
    const router = useRouter();

    const { error, success, loading  } = useSelector((state) => state.post); // 글정보
    const { user } = useSelector((state) => state.auth); //유저 정보

    //2. 게시글 작성(dispatch)
    const onFinish = (values)=>{
            const dto = {
                content: values.content,
                userId: 82 // user.id (있는 번호, 어떤 유저)
            }
        dispatch( createPostRequest(dto) );
        message.success("게시글 작성 요청 완료");
        router.push("/");
    }

    ////////////////////////////////
    return (
        <div style={ {maxWidth: 600, margin: "40px auto"} }>
            <Card title="게시글 작성">
                <Form layout="vertical" onFinish={onFinish}>
                    <Form.Item
                    label="내용"
                    name="content"
                    rules={[ {required: true, message: '내용을 입력하세요.'} ]}> 
                    <Input.TextArea rows={5} placeholder="내용을 입력하세요."/>
                    </Form.Item>
                    <Button type="primary" htmlType="submit" loading={loading}>
                        게시글 작성
                    </Button>
                    { error && <p style={{color: "red"}}> {error} </p> }
                </Form>
            </Card>
        </div>
    );
}

//3. export
export default newPostPage;