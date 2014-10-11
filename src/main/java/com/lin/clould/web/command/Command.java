package com.lin.clould.web.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response, Map<String, Object> command) throws Exception;
		
}
