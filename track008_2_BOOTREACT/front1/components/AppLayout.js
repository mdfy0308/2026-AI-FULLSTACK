// components/AppLayout.js      # 재사용 가능한 UI 컴포넌트 폴더
// 1. require
import { Layout, Menu, Input, Row, Col, Drawer, Button, Grid } from "antd";  
import { MenuOutlined, SearchOutlined } from "@ant-design/icons";

import { useSelector, useDispatch } from 'react-redux'; // 전역상태, 액션
import { useRouter }                from 'next/router'; // 이동
import { useEffect, useState }      from 'react';       // 이벤트 변경 감지, 변수
import Link                         from 'next/link';   // 

const { Header, Footer, Sider, Content } = Layout; // <Layout.Header> → <Header>
const { useBreakpoint } = Grid;

// 2. 부품
// Header / Drawer
function AppLayout( { children, initialUser } ){ //★ children 각각의 부품 대체, initialUser 초기값

    // 변수, 세팅함수
    const [drawerOpen, setDrawerOpen] = useState(false);

    const menuItems = [
        { key: "new",     label: <Link href="/posts/new">✏️ NEW POST ✏️</Link> },
        { key: "profile", label: <Link href="/mypage">👤 MY PAGE 👤</Link> },
        { key: "home",    label: <Link href="/signup">🏠 JOIN 🏠</Link> },
    ];
    /////////////////////////////////// #1) Row(줄) - Col(칸) / Col
    /////////////////////////////////// #2) 반응형 속성(xs, sm, 태블릿: md, PC: lg) - 24칸
    // display: "flex" 자식요소의 배치를 알아서
    // justify="space-between" 양쪽에 콘텐츠 배치
    return (
        <Layout>
            {/* Header */}
            <Header style={{display: "flex"}}>
                <Row align="middle" justify="space-between" style={{width: "100%"}}>
                    <Col flex="none">
                        <Link href="/">
                            <a style={{color: "#fff", fontWeight: "bold", fontSize: "24px"}}>
                                THEJOA703(POST VER)
                            </a>
                        </Link>
                    </Col>
                    {/* xs, sm(모바일): 0 숨김 처리, md(태블릿): 16, lg(PC): 18 */}
                    <Col flex="auto" xs={0} sm={0} md={16} lg={18}>
                        <Menu theme="dark" mode="horizontal" items={menuItems} />
                    </Col>
                    {/* button 종류: primary, default, text */}
                    <Col flex="none" xs={2} sm={2} md={0} lg={0}>
                        <Button style={{ color: "#fff"}} 
                        type="text" icon={<MenuOutlined />} 
                        onClick={()=> setDrawerOpen(true)}></Button>
                    </Col>
                </Row>
            </Header>
            <Drawer
                title="Menu"
                placement="right"
                onClose={()=> setDrawerOpen(false)}
                open={drawerOpen}
            >
                <Menu 
                mode="vertical"
                items={menuItems}
                />
            </Drawer>
            <Layout>
                <Content style={{ padding: "40px" }}> {children} </Content>
            </Layout>
            <Footer>Footer</Footer>
        </Layout>
    );
}

// 3. export
export default AppLayout;

// Layout:  https://ant.design/components/layout 
// Menu:    https://ant.design/components/menu 
// Input:   https://ant.design/components/input 
// Drawer:  https://ant.design/components/drawer 
// Grid:    https://ant.design/components/grid 
// Button:  https://ant.design/components/button