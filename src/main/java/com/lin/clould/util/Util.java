package com.lin.clould.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.lin.clould.person.login.dao.vo.LoginVO;


public class Util
{
	public Util()	{}
	
	/**
	 * 
	 * 세션 체크
	 * 
	 * @param request
	 * @param response
	 * @return boolean
	 */
	public static boolean sessionCheck(HttpServletRequest request){
		
		boolean chk = false;
		
		/*
		 *  HttpSession session = request.getSession(); // 세션 생성
   			request.getSession(false);
			  - (true)   세션이 없으면 새로 생성한다
		                   세션이 있으면 기존 세션을 리턴한다.
		      - (false) 세션이 없으면 null을 리턴한다.
		                   세션이 있으면 기존 세션을 리턴한다.
				
		   session.setMaxInactiveInterval()  -- 세션 유효시간 설정
		   session.setAttribute(arg0, arg1)  -- 세션에 값을 셋팅한다.
		   session.getAttribute(arg0)        -- 세션에 값을 가져온다.
		   session.removeAttribute(arg0)     -- 세션 값 제거
		   session.invalidate()              -- 세션을 무효화 시킨다.(로그아웃 처리)
		 * 
		 */
		
		HttpSession session = request.getSession(false); // false 를 주었으므로 셰션이 없을 경우 null을 반환한다.
		
		if(session == null){
			chk = false;
		}else{
			if( session.getAttribute("person.sessionInfo") != null){
				chk = true;
			}else{
				chk = false;
			}
		}
		return chk;
	}
	
	
	/**
	 * 문자열(String)의 값이 null또는 비었는지("")의 여부를 체크.
	 * 
	 * @param str 체크할 문자열
	 * @return 문자열에 값이 존재하면 false, null이거나 비었으면("") true를 반환한다.
	 */
	public static boolean isEmpty(String str){
	      return str == null || str.trim().length() == 0 || "null".equals(str);    
	}
	
	/**
	 * 
	 * @param str 체크할 문자열
	 * @return 문자열에 값이 존재하면 문자열 반환, null이거나 비었으면 "" 를 반환한다.
	 */
	public static String nvl(String str){
	    if(str == null || str.trim().length() == 0 || "null".equals(str)){
	    	return "";
	    }else{
	    	return str;
	    }
	      
	}

	public static Object getSessionInfo(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return session.getAttribute("person.sessionInfo");
	}
	
}