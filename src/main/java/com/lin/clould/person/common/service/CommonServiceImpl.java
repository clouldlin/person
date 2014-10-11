package com.lin.clould.person.common.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lin.clould.person.common.dao.CommonDao;
import com.lin.clould.web.command.CommandResult;
import com.lin.clould.web.command.impl.CommandServiceImpl;

public class CommonServiceImpl extends CommandServiceImpl {
	
	private static Logger logger = Logger.getLogger(CommonServiceImpl.class);
	
	private CommonDao dao = new CommonDao();

	public CommandResult page(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String page = request.getParameter("page");
		
		return new CommandResult(page);
	}
	
}