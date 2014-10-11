package com.lin.clould.person.bbs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.lin.clould.repository.SqlMapSessionFactory;

public class BbsDao {
	
	SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	private BbsDao() {
		
	}

	private static BbsDao dao;

	public static BbsDao getInstance() {
		if (dao == null) {
			dao = new BbsDao();
		}
		return dao;
	}

	public List<?> selectBBSListByMenuId(String menuId) {
		
		SqlSession session = sqlSessionFactory.openSession();
		
		List<?> bbsList = null;
		try{
			bbsList = session.selectList("query.person.bbs.BbsSqlMapper.selectBBSListByMenuId", menuId);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
		    session.close();
		}
		
		return bbsList;
	}
}