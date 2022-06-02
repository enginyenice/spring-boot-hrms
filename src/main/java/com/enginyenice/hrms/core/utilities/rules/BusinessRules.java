package com.enginyenice.hrms.core.utilities.rules;

import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;

public class BusinessRules {
	public static Result Run(Result... locigs) {
		
		for( Result locig : locigs ) {
			   if(!locig.getSuccess())
			   {
				   return locig;
			   }
			}
		return new SuccessResult();
	}
}
