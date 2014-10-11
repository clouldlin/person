package com.lin.clould.person.bbs.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lin.clould.person.bbs.dao.BbsDao;
import com.lin.clould.web.command.CommandResult;
import com.lin.clould.web.command.impl.CommandServiceImpl;

public class BbsServiceImpl extends CommandServiceImpl {

	private BbsDao dao = BbsDao.getInstance();
	
	public CommandResult bbsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<HashMap<String, String>> bbsList = (List<HashMap<String, String>>) dao.selectBBSListByMenuId(request.getParameter("menuId"));
		System.out.println(bbsList.toString());
		
		return new CommandResult("bbs/bbs");
	}
	
}