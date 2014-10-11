package com.lin.clould.person.mypage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lin.clould.person.login.dao.vo.LoginVO;
import com.lin.clould.person.mypage.dao.MyPageDao;
import com.lin.clould.util.Util;
import com.lin.clould.web.command.CommandResult;
import com.lin.clould.web.command.annotation.SessionCertification;
import com.lin.clould.web.command.impl.CommandServiceImpl;

public class MyPageServiceImpl extends CommandServiceImpl {

	private MyPageDao dao = new MyPageDao();
	
	@SessionCertification(message ="사용자 정보가 존재하지 않습니다. 로그인을 해주세요")
	public CommandResult mypage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		LoginVO loginVO = (LoginVO)Util.getSessionInfo(request);
		
		System.out.println(loginVO);
		
		return new CommandResult("mypage/mypage");
	}
	
}