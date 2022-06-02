package com.enginyenice.hrms.core.utilities.results;

public class Result {
	private String message;
	private boolean success;
	
	public Result(boolean success)
	{
		this.success = success;
	}
	
	public Result(String message,boolean success)
	{
		this(success);
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}
	
	public boolean getSuccess() {
		return this.success;
	}
	

}
