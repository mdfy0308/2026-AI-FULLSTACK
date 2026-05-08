package com.the703.basic016_ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;

public class JavaIOEx001 {
	public static void main(String[] args) {
		
		//#1.경로
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss"); // 포맷 설정
		long millis = System.currentTimeMillis(); // 시스템 시간 가져오기
		String folder_rel = "src/com/the703/basic016_ex/"; // 상대경로 - 현재작업 폴더 기준
		String file_path = sdf.format(millis) + "_app.log";

		File folder = new File(folder_rel);
		File file   = new File(folder_rel + file_path);	
		
		//#2.폴더+파일 만들기
		try {
			if(!folder.exists()) { folder.mkdirs(); }
			if(!file.exists()) { file.createNewFile(); }
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("폴더/파일 준비완료");
		
		//#3. Char 단위로 파일 쓰기
		//sdf.format(millis) + "로그파일입니다."
		
		Writer wLog;
		try {
			wLog = new FileWriter(file);
			wLog.write(sdf.format(millis) + " 로그 파일입니다.");
			wLog.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//#4. Char 단위로 파일 읽기
		Reader rLog;
		try {
			rLog = new FileReader(file);
			int cnt = 0;
			while( (cnt = rLog.read()) != -1 ) { System.out.print((char)cnt); }
			rLog.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}//
}//
