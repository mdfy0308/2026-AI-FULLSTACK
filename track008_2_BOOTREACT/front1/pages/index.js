// pages/index.js
import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useRouter } from "next/router";
import { fetchPostsRequest } from '../reducers/postReducer';
import { Row, Col, Form, Button, Upload, Spin, Input, Card, Descriptions } from "antd";

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

    ////////////////////////
    return (
        <div>
            {/* 게시판 리스트 */}
            <h3> 게시글 : {posts.length} </h3>
            { posts.map((post, index)=>(
                <Card key={post.id || index} style={{ marginBottom: "10px"}}>
                    <p>{post.content}</p>
                </Card>
            )) }            
        </div>
        
    );
}

// npm run dev