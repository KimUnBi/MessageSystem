package com.smhrd.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class DAO {

	// 1) ����,����,������ ���� sqlSessionManager�� �����Ѵ�!
	// static�̸� ������ �������� �ʾƵ� �ٷ� ��밡���ϴ�!
	// static�̶�? ����, ��𿡼��� ȣ�� �����ϴ�.
	// -��ü ����, �������� ���� �� �ʿ���� Ư���� �ּҿ� �ڸ� ����.
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	private SqlSession sqlSession;
	
	
	
	public int join(MemberVO vo) {
		
		sqlSession = sqlSessionFactory.openSession(true);
		int cnt = 0;
		try {
			cnt = sqlSession.insert("insert", vo);
		} catch (Exception e) {
			
		}finally {
			sqlSession.close();
		}
		return cnt;
	}

	public MemberVO login(MemberVO vo) {
		
		sqlSession = sqlSessionFactory.openSession(true);
		MemberVO result = null;
		try {
			result = sqlSession.selectOne("login", vo);
		} catch (Exception e) {
			
		}finally {
			sqlSession.close();
		}
		return result;
	}

	public List<MessageVO> send(MessageVO vo) {
		
		sqlSession = sqlSessionFactory.openSession(true);
		List<MessageVO> result = null;
		try {
			sqlSession.insert("send", vo);
			result = selectMsg(vo);
		} catch (Exception e) {
			
		}finally {
			sqlSession.close();
		}
		return result;
	}
	
	public List<MessageVO> selectMsg(MessageVO vo){
		sqlSession = sqlSessionFactory.openSession(true);
		List<MessageVO> result = null;
		try {
			result = sqlSession.selectList("select", vo);
		} catch (Exception e) {
			
		}finally {
			sqlSession.close();
		}
		return result;
	}

	public String check(MessageVO vo) {
		sqlSession = sqlSessionFactory.openSession(true);
		System.out.println("DAO >> "+vo.getReceive_email());
		String email= null;
		try {
			email = sqlSession.selectOne("check", vo);
			System.out.println(email);
			
		} catch (Exception e) {
			
		}finally {
			sqlSession.close();
		}
		return email;
	}

	public int update(MemberVO vo) {
		sqlSession = sqlSessionFactory.openSession(true);
		int cnt = 0;
		try {
			cnt = sqlSession.update("update",vo);
		} catch (Exception e) {
			
		}finally {
			sqlSession.close();
		}
		return cnt;
	}

	public List<MemberVO> selectAll() {
		sqlSession = sqlSessionFactory.openSession(true);
		List<MemberVO> list = null;
		try {
			list = sqlSession.selectList("selectAll");
		} catch (Exception e) {
			
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	

	

}
