package com.enginyenice.hrms.bussines.rules;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.enginyenice.hrms.core.utilities.results.ErrorResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;

@Component
public class EmployerRules {
	
	public Result DoesEmailAndWebsiteMatch(String email, String url) {
		URL url1;
		String baseUrl = url;
		try {
			url1 = new URL(url);
			baseUrl = url1.getHost().toLowerCase();
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		String mailBaseUrl = email.substring(email.indexOf("@") + 1).toLowerCase();
		if(!baseUrl.equals(mailBaseUrl))
		{
			return new ErrorResult("The e-mail address must end with '@" + baseUrl+"'");
		}
		
		
		return new SuccessResult();
	}
}
