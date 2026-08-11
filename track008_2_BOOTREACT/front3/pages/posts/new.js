// pages/posts/new.js
//1. require / import
import React, { useState, useEffect } from "react"; // 변수/이벤트 알림
import { Form, Button, Upload, Input, Card, Select, message } from "antd";
import { UploadOutlined } from '@ant-design/icons';
import { useSelector, useDispatch } from "react-redux"; // 전역정보, 이벤트 발생
import { useRouter } from "next/router"; // 화면 이동
import { createPostRequest, resetPostState } from "../../reducers/postReducer"; // 액션

function NewPostPage(){
    //1. 글 정보(state.post) 유저 정보(state.auth) 가져오기(useSelector : 전역정보)
    const dispatch = useDispatch();
    const router = useRouter();

    const { error, success, loading  } = useSelector((state) => state.post); // 글정보
    const { user } = useSelector((state) => state.auth); //유저 정보

    const [fileList, setFileList] = useState([]); 

    //2. 게시글 작성(dispatch)
    // { userId, dto(content, hashtag), files }
    const onFinish = (values)=>{
        if (!user || !user.id) {
            message.error("로그인이 필요합니다.");
            return;
        }
        const dto = {
            content: values.content,
            hashtags: values.hashtags? values.hashtags.join(",") : "",
        };
        const files = fileList.map( (f)=> f.originFileObj );
        dispatch( createPostRequest({ userId: user.id, dto, files }) );
    }

    // userSelect(전역) / useDispatch(알림) / useState(변수) / useEffect(이벤트 알림)
    useEffect(()=>{
        if(success){ 
            message.success("게시글이 성공적으로 작성되었습니다.");
            setFileList([]);
            dispatch(resetPostState());
            router.push("/");
        }
        return ()=> { 
            if(success){ dispatch(resetPostState()); } 
        };
    }, [success, router, dispatch]);
    
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

                    <Form.Item label="해시태그" name="hashtags"> 
                        <Select mode="tags" style={{width: "100%"}} placeholder="해시태그 입력 후 Enter"></Select>
                    </Form.Item>

                    <Form.Item label="이미지 업로드"> 
                        <Upload multiple
                            beforeUpload={()=>false}
                            fileList={fileList} 
                            onChange={ ({fileList})=>{setFileList(fileList)} }
                            listType="picture-card"
                            maxCount={5}>
                                <Button icon={<UploadOutlined />}></Button>
                        </Upload>
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
export default NewPostPage;