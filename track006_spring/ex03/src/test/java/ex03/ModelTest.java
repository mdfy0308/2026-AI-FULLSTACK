package ex03;

import java.net.UnknownHostException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.BoardMapper;
import com.the703.dao.TestMapper;
import com.the703.dto.BoardDto;
import com.the703.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)  //1. spring �����׽�Ʈ
@ContextConfiguration(locations = "classpath:config/root-context.xml")  //2. ����
public class ModelTest { 
	@Autowired  ApplicationContext context;  //3. Bean ( �������� �����ϴ� ��ü) ����~�Ҹ�
	@Autowired  DataSource  dataSource;
	@Autowired  SqlSession  sqlSession; 
	@Autowired  TestMapper  testMapper;  
	
	@Autowired  BoardMapper  boardMapper;  
	@Autowired  BoardService  service;
	
	
	@Test public void test6() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("start", 0);
		map.put("end", 10);
		System.out.println("boardMapper.select10(map)");
		
		//1. 전체갯수
		System.out.println( boardMapper.selectCnt() );
 	}
	
	@Ignore @Test
	public void test5() {
		//����
//		BoardDto dto = new BoardDto();   dto.setBno(4);
//		System.out.println(  service.delete(dto) );
		//����
		//		BoardDto dto = new BoardDto();
		//		dto.setBname("first");        dto.setBpass("1111"); dto.setBno(4);
		//		dto.setBtitle("NEW-service-ù��° �۾���");  dto.setBcontent("NEW-service-����");
		//		System.out.println(  service.edit(dto) ); 
		
		//�˻�
//		System.out.println(service.detail(4)); 
		//����  -  4
		//		BoardDto dto = new BoardDto();
		//		dto.setBname("first");        dto.setBpass("1111");
		//		dto.setBtitle("service-ù��° �۾���");  dto.setBcontent("service-����");
		//		System.out.println(  service.insert(dto) );
		
		//��ü����Ʈ
		//System.out.println(service.selectAll());
	}
	
	
	@Ignore @Test
	public void test4() throws UnknownHostException {
//		//����
//		System.out.println(boardMapper.delete(1));
//		//����
//		BoardDto dto2 = new BoardDto();
//		dto2.setBname("first");        dto2.setBno(2);
//		dto2.setBtitle("ù��° �۾���-new");  dto2.setBcontent("����-new"); 
//		System.out.println(boardMapper.update(dto2)); //������ �ټ�1
//		
//		//�˻�
//		System.out.println(boardMapper.select(1));
//		//����
//		BoardDto dto = new BoardDto();
//		dto.setBname("first");        dto.setBpass("1111");
//		dto.setBtitle("ù��° �۾���");  dto.setBcontent("����");
//		dto.setBip(InetAddress.getLocalHost().getHostAddress()); //#1
//		System.out.println(boardMapper.insert(dto)); //������ �ټ�1
		//��ü�˻�
//		System.out.println(boardMapper.selectAll());
	}
	
	
	
//	@Ignore @Test public void  test3() { System.out.println(testMapper.now());    }         
//	@Ignore @Test public void  test1() { System.out.println(context);    } 
//	@Ignore @Test public void  test2() { System.out.println(sqlSession); } 
}
