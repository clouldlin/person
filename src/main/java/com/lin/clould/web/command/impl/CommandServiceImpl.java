package com.lin.clould.web.command.impl;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import com.lin.clould.util.Util;
import com.lin.clould.web.command.Command;
import com.lin.clould.web.command.CommandConstant;
import com.lin.clould.web.command.CommandResult;
import com.lin.clould.web.command.annotation.SessionCertification;

public abstract class CommandServiceImpl implements Command {
	
	// 상속되어 실 구현체에서 실행된다는 점을 감안하자. 
	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response,  Map<String, Object> command) throws Exception {
		
		String methodName  = (Util.isEmpty(request.getParameter("method")))  ? (String) command.get(CommandConstant.TAG_DEFAULT_METHOD) : request.getParameter("method") ;
		
		System.out.println("methodName :" + methodName);
		
		Class<? extends CommandServiceImpl> clazz = this.getClass();
		
		// 메소드명이 methodName이고,  전달 되는 파라미터 타입이 HttpServletRequest.class,  HttpServletResponse.class인 메소드
		//Method targetMethod = clazz.getDeclaredMethod(methodName, HttpServletRequest.class,  HttpServletResponse.class);
		//Method[] targetMethod = clazz.getMethods(); 
		
		Method targetMethod = null;
		Method[] methods = clazz.getMethods();
		
		for (Method method : methods) {
			if(method.getName().equals(methodName)){
				targetMethod =  method;
				break;
			}
		}
		
		// SessionCertification.clsss check
		if(targetMethod.isAnnotationPresent(SessionCertification.class)){ 
			if(!Util.sessionCheck(request) ){
				SessionCertification sessionCertificationAnno = targetMethod.getAnnotation(SessionCertification.class);
				request.setAttribute("message", sessionCertificationAnno.message());
				
				return new CommandResult("login.do", true);
			}
		}
		
		return (CommandResult)targetMethod.invoke(this, request, response);
	}

}