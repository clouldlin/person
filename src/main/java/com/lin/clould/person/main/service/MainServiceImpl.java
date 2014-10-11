package com.lin.clould.person.main.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lin.clould.person.main.dao.MainDao;
import com.lin.clould.util.Util;
import com.lin.clould.web.command.CommandResult;
import com.lin.clould.web.command.annotation.SessionCertification;
import com.lin.clould.web.command.impl.CommandServiceImpl;

public class MainServiceImpl extends CommandServiceImpl {

	private MainDao dao = new MainDao();
	
	//@SessionCertification(message ="사용자 정보가 존재하지 않습니다. 로그인을 해주세요")
	public CommandResult main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new CommandResult("main/main");
	}
	
}