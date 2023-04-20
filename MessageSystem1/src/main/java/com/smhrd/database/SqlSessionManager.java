package com.smhrd.database;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	
	public static SqlSessionFactory sqlSession;
	
	//객체 생성시 실행되는 부분
	//생성자 : 인스턴스(자료형은 똑같지만 엄연히 서로 다른 데이터! 서로 다른 주소에 저장됨 -->) 생성시 초기화하는 메소드
	//어떤 인스턴스이던지 똑같이 작동시키고 싶을 때 사용하는 것!
	static {
		//설정 파일 경로(db관련-url계정 / mapper.xml 경로) 읽게 만들어 줌
		String resource = "com/smhrd/database/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSession = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	//db연결, 종료, 실행 세션 관리
	public static SqlSessionFactory getSqlSession() {
		return sqlSession;
	}
	
	

}
