package com.lin.clould.web.command;

public class CommandResult {
	
	private String nextPage;
	private boolean redirect;
	
	public CommandResult(String nextPage){
		this(nextPage, false);
	}

	public CommandResult(String nextPage, boolean redirect){
		this.nextPage = nextPage;
		this.redirect = redirect;
	}
	
	public String getNextPage() {
		return nextPage;
	}
	public boolean isRedirect() {
		return redirect;
	}

}
