package com.enginyenice.hrms.core.utilities.results;

public class SuccessResult extends Result {

	public SuccessResult() {
		super(true);
	}
	public SuccessResult(String message)
	{
		super(message,true);
	}

}
