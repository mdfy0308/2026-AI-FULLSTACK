import React, { useState, useEffect } from "react"; // 변수/이벤트 알림
import { Card, Button, Popconfirm, Carousel, Image } from "antd";
import Link from 'next/link';

export default function PostList({posts, handleEdit, handleDelete}){
    
    /////////////////////////////////
    return (
        <div>
            {/* 게시판 리스트 */}
            <h3> 게시글 : {posts.length} </h3>
            { posts.map((post, index)=>(
                <Card key={post.id || index} 
                style={{ marginBottom: "10px"}}
                actions={[
                    <Button type="link" onClick={()=>{handleEdit(post)}}>수정</Button>,
                    <Popconfirm 
                        title="정말 삭제하시겠습니까?"
                        onConfirm={()=> handleDelete(post.id)}
                        okText="예"
                        cancelText="아니오"
                    >
                        <Button type="link">
                            삭제
                        </Button>
                    </Popconfirm>
                ]}
                >
                    {/* 게시글 이미지들 - imageUrls */}
                    {post?.imageUrls && post.imageUrls.length>0 &&
                        <Carousel dots draggable style={{ textAlign: "center", marginBottom: "15px" }}> 
                            {post.imageUrls.map((v, idx)=>(
                                <div key={idx} style={{ background: "#f0f2f5" }}>
                                    <Image
                                        src={`http://localhost:8080/${v}`}
                                        alt={`post image ${idx}`}
                                        style={{ maxHeight: "300px", objectFit: "cover", borderRadius: "8px" }}
                                    />
                                </div> 
                            ))}
                        </Carousel>
                    }

                    {/* 게시글 텍스트 내용 */}
                    <p>{post?.content}</p>

                    {/* 게시글 해시태그 - hashyags */}
                    { (post?.hashtags ?? []).length>0 && (
                        <div>
                            { post.hashtags.map((tag, idx)=>(
                                <span style={{ color: "#AAA", marginRight:"8px" }}> #{tag} </span>
                            ))}
                        </div>
                    )}
                </Card>
            )) }
        </div>
    );

}