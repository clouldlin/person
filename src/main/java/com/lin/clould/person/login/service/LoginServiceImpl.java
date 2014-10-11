package com.lin.clould.person.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lin.clould.person.login.dao.LoginDao;
import com.lin.clould.person.login.dao.vo.LoginVO;
import com.lin.clould.util.Util;
import com.lin.clould.web.command.CommandResult;
import com.lin.clould.web.command.impl.CommandServiceImpl;

public class LoginServiceImpl extends CommandServiceImpl {
	
	private static Logger logger = Logger.getLogger(LoginServiceImpl.class);
	
	private LoginDao dao = LoginDao.getInstance();
	
	public CommandResult login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String forword = "";
		
		try {
			if(Util.sessionCheck(request) ){
				forword = "main.do";
				return new CommandResult(forword, true);
			}else{
				String id = Util.nvl(request.getParameter("id"));
				String pw = Util.nvl(request.getParameter("pw"));
				
				LoginVO loginVO = dao.selectUserById(id);
				
				// 인증이 성공하면..
				if (loginVO.getId().equals(id) && loginVO.getPw().equals(pw)) {
					
					logger.info(loginVO.toString());
					
					HttpSession session = request.getSession();
					session.setAttribute("person.sessionInfo", loginVO);
					forword = "main.do";
					return new CommandResult(forword, true);
				}else{
					System.out.println("인증 실패");
					throw new Exception("아이디 또는 비밀번호가 일치하지 않습니다. \\n다시 확인 후 입력해 주시기 바랍니다.");
				}
			}
		} catch (Exception e) {
			forword = "login/login";
			request.setAttribute("message", e.getMessage());
		}
		
		return new CommandResult(forword);
		
	}
	
	public CommandResult logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		session.invalidate();
		//request.setAttribute("message", "로그아웃 되었습니다.");
		//return new CommandResult("login/login");
		return new CommandResult("main.do", true);
	}
}