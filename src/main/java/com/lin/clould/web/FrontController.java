package com.lin.clould.web;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lin.clould.web.command.Command;
import com.lin.clould.web.command.CommandConstant;
import com.lin.clould.web.command.CommandFactory;
import com.lin.clould.web.command.CommandResult;

public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 5168367048977636503L;

	private static Logger logger = Logger.getLogger(FrontController.class);
	private static String defaultViewPath = null;
	
	private CommandFactory commandFactory;
	
    public FrontController() {
        super(); 
    }
	
	public void init(ServletConfig config) throws ServletException {
		commandFactory = new CommandFactory();
		try {
			commandFactory.init();
			defaultViewPath = commandFactory.getDefaultViewPath();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			process(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 1) 호출한 경로가 index.do라면 ---> IndexCommand 객체를 생성해서 index.jsp로 포워드 해보자.0
		
		// String requestURI = request.getRequestURI(); // /JSP_MVC.2.1.1/aaa.do

		//확장자가 없는 경로일때는 getPathInfo() -- web.xml에서 uri-pattern 수정 /*
		String path = request.getPathInfo();
		
		//확장가 있는 경우라면 getServletPath() 
		if(path == null){
			path = request.getServletPath(); // /aaa.do
		}
		
		String callPath = getPath(path);
		
		logger.info("RequestURI :" + callPath );
		
		Map<String, Object> command = commandFactory.lookup(callPath);
		
		CommandResult result = ((Command)command.get("class")).execute(request, response, command);
		
		if(result.isRedirect() == true){
			response.sendRedirect(result.getNextPage());
			return;
		}
		
		System.out.println(result.getNextPage());
		
		System.out.println("viewPath : " + defaultViewPath + result.getNextPage() + ".jsp");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(defaultViewPath + result.getNextPage() + ".jsp");
		
		dispatcher.forward(request, response);
		
	}
	
	private String getPath(String path) {
		String result = null; 
		
		//확장자가 있는 경우 
		if(path.indexOf(".") >= 0){
			result = path.substring(0, path.indexOf("."));
		}else{
			result = path;
		}
		
		return result;
	}
}
