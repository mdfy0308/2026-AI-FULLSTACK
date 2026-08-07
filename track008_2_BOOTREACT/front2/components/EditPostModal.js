// components/EditPostModal
import React, { useState, useEffect } from "react"; // 변수/이벤트 알림
import { useSelector, useDispatch } from "react-redux"; // 전역정보, 이벤트 발생
import { useRouter } from "next/router"; // 화면 이동
import { updatePostRequest, resetPostState } from "../reducers/postReducer"; // 액션
import { Modal, Form, Input, Button, Select, Upload } from "antd"; 
import { UploadOutlined } from '@ant-design/icons';

export default function EditPostModal({
    visible, onCancel, editPost, onSubmit, uploadFiles, setUploadFiles // ##
}){ 
    const { error, success, loading  } = useSelector((state) => state.post); // 글정보
    const { user } = useSelector((state) => state.auth); //유저 정보
    const [fileList, setFileList] = useState([]); 
    //////////////////////////////
    return (
        <Modal title="글 수정" open={visible} onCancel={onCancel} footer={null}>
            <Form 
                initialValues={{
                    content: editPost?.content,
                    hashtags: editPost?.hashtags
                }} 
                onFinish={onSubmit}
                layout="vertical"
            >
                <Form.Item name="content" label="내용">
                    <Input.TextArea rows={4} />
                </Form.Item>

                {/* 해시태그 입력 */}
                <Form.Item label="해시태그" name="hashtags"> 
                    <Select mode="tags" style={{width: "100%"}} placeholder="해시태그 입력 후 Enter"></Select>
                </Form.Item>

                {/* 이미지 업로드 / 파일 변경시 변경되는 값추가 */}
                <Form.Item label="이미지 업로드"> 
                    <Upload 
                        multiple
                        beforeUpload={()=>false}
                        fileList={fileList} 
                        onChange={ ({fileList})=>
                            setUploadFiles(fileList.map((f) => f.originFileObj))
                        }
                        listType="picture-card"
                    >
                        <Button icon={<UploadOutlined />}></Button>
                    </Upload>
                </Form.Item>
                <div style={{textAlign: "right"}}>
                    <Button type="primary" htmlType="submit">
                        수정완료
                    </Button>
                </div>
            </Form>
        </Modal>
    );
}