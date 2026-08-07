// pages/index.js
import React, { useState, useEffect } from "react"; // 이벤트 변경 감지, 변수 변경
import { useSelector, useDispatch } from "react-redux"; // 전역상태, 스토어 알림
import { useRouter } from "next/router"; // 경로 변경
import { Spin } from "antd"; // 디자인

import { deletePostRequest, fetchPostsRequest, updatePostRequest } from '../reducers/postReducer';
import PostList from "../components/PostList";
import EditPostModal from "../components/EditPostModal";

export default function Home(){

    const dispatch = useDispatch();
    const router = useRouter();

    //1. state.user 정보 가져오기
    const { user } = useSelector((state)=> state.auth);

    //2. 게시글 정보 가져오기
    const { posts, loading, error } = useSelector((state)=> state.post);

    useEffect( ()=>{
        dispatch(fetchPostsRequest());
    }, [dispatch]);

    ////////////////////////////////////////////////////////// 수정
    // isEditModalVisible, setIsEditModalVisible - 수정 모달
    const [isEditModalVisible, setIsEditModalVisible] = useState(false); 
    
    // editPost, setEditPost - 수정할 글
    const [editPost, setEditPost] = useState(null);

    // 수정할 이미지 파일
    const [uploadFiles, setUploadFiles] = useState([]); // ##1.

    // handleEditSubmit - 수정 기능
    const handleEdit = (post)=>{
        setEditPost(post); // 수정 글 세팅
        setIsEditModalVisible(true); // 수정화면 보이기
        setUploadFiles([]); // ##
    };

    // saga에 넘기는 데이터 확인 { userId, postId, dto(content+hashtag), files }
    const handleEditSubmit = (values)=>{
        dispatch(
            updatePostRequest({
                userId: user?.id, // 옵셔널 체이닝
                postId: editPost.id,
                dto:{
                    content: values.content,
                    hashtags: values.hashtags? values.hashtags.join(",") 
                    : values.hashtags},
                files: uploadFiles
            }) ); // 수정 기능 후
        setIsEditModalVisible(false); // 화면 안 보이게
        setEditPost(null);
    };

    ////////////////////////////////////////////////////////// 삭제
    // handleDelete
    const handleDelete = (postId)=>{
        dispatch(deletePostRequest( postId )); // 해당 글 번호
    }

    //////////////////////////////////////////////////////////
    return (
        <>
            <PostList 
                posts={posts}
                handleEdit={handleEdit}
                handleDelete={handleDelete}
            />
            <EditPostModal
                visible={isEditModalVisible}
                onCancel={()=> setIsEditModalVisible(false)}
                editPost={editPost}
                onSubmit={handleEditSubmit}
                uploadFiles={uploadFiles}
                setUploadFiles={setUploadFiles}
            />
        </>
    );
}
