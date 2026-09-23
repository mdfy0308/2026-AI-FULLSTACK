import { StatusBar } from 'expo-status-bar';
// 상태표시줄  - 리액트 네이티브에서 임포트하지 않음. 서드파티 패키지
import { StyleSheet, Text, View } from 'react-native';

export default function App() {
  return ( // return에 포함된 컴포넌트들이 렌더링 된다!
    <View style={styles.container}>
      {/* 1. View는 Container 역할을 한다. div 대신 사용하고 항상 import할 것. */}

      <Text style={styles.text}>~React Native를 배워보자~</Text>
      {/* 2. react native의 Text는 항상 text component에 들어가야 한다. 
        만약 View 안에 Text를 넣은 경우 > 오류 발생. #이건 브라우저가 아니다! */}

      <Text style={{
        color: 'green', // 안에 직접 작성하는 것도 가능
      }}>오늘은 스타일 시트와 스테이터스 바에 대해서 알아보기!!</Text>

      <StatusBar style="auto" />
      {/* 상태표시줄 스타일 = "auto" 
        시계, 배터리, Wi-Fi 등의 스타일을 자동 변경함
        light/dart/auto 선택 가능 */}
    </View>
  );
}

const styles = StyleSheet.create({ 
  // StyleSheet.create - styles object 생성
  // 스타일 컴포넌트를 정리하는데 유용하지만 반드시 필요한 것은 아님.
  // 다만 StyleSheet.create를 사용하면 자동 완성 기능을 제공한다.
  container: { // CSS의 class 이름처럼 자유롭게 작성 가능하다.
    flex: 1,
    backgroundColor: '#f6ffde',
    alignItems: 'center',
    justifyContent: 'center',
  }, 
  // 사용할 수 있는 css 요소들이 있지만 표기에 주의, 사용 불가한 것도 있음. 
  // 위와 관련한 예시를 한번쯤 읽어보면 좋을 듯(예: border)
  text: {
    fontSize: 24,
    fontWeight: 'bold',
  }
});
