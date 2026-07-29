//pages/_app.js #전체 앱의 공통 설정(Redux Provider, 글로벌 스타일 등)
//import, require
import React from 'react'; //React 불러오기
import { wrapper } from '../store/configureStore'; //전역 상태 + 서버 연동
import AppLayout from '../components/AppLayout';   //공통 레이아웃
import 'antd/dist/antd.css';        //ant 디자인
import '../styles/global.css';      //전역 css
// bootstrap을 추가해서 사용할 수 있다.
// 다만 3차 프로젝트에서 새로운 디자인은 antd를 활용해볼것

//부품
function MyApp({ Component, pageProps }) {  //부품, 초기 설정값
    return (
        <AppLayout initialUser={pageProps.user}>
            <Component {...pageProps} />
        </AppLayout>
    );
}

//export
export default wrapper.withRedux(MyApp); // 스토어 전역사용