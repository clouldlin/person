package com.lin.clould.person.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.lin.clould.person.login.dao.vo.LoginVO;
import com.lin.clould.repository.SqlMapSessionFactory;

public class LoginDao {

	SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	private LoginDao() {
		
	}

	private static LoginDao dao;

	public static LoginDao getInstance() {
		if (dao == null) {
			dao = new LoginDao();
		}
		return dao;
	}

	public LoginVO selectUserById(String id) {
		
		SqlSession session = sqlSessionFactory.openSession();
		
		LoginVO loginVO = null; 
		try{
			loginVO = session.selectOne("query.person.login.LoginSqlMapper.selectUserById", id);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
		    session.close();
		}
		
		return loginVO;
	}

}