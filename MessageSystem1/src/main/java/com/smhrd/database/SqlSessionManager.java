package com.smhrd.database;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	
	public static SqlSessionFactory sqlSession;
	
	//��ü ������ ����Ǵ� �κ�
	//������ : �ν��Ͻ�(�ڷ����� �Ȱ����� ������ ���� �ٸ� ������! ���� �ٸ� �ּҿ� ����� -->) ������ �ʱ�ȭ�ϴ� �޼ҵ�
	//� �ν��Ͻ��̴��� �Ȱ��� �۵���Ű�� ���� �� ����ϴ� ��!
	static {
		//���� ���� ���(db����-url���� / mapper.xml ���) �а� ����� ��
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
	
	
	
	
	//db����, ����, ���� ���� ����
	public static SqlSessionFactory getSqlSession() {
		return sqlSession;
	}
	
	

}
