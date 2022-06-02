package com.enginyenice.hrms.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult() {
		super(null,true);
	}
	
	public SuccessDataResult(T data) {
		super(data, true);
	}
	
	public SuccessDataResult(String message) {
		super(null,message,true);
	}
	
	public SuccessDataResult(T data, String message)
	{
		super(data,message,true);
	}
	

}
