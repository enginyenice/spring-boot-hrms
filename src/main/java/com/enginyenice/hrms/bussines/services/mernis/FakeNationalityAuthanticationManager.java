package com.enginyenice.hrms.bussines.services.mernis;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fakeService")
public class FakeNationalityAuthanticationManager implements NationalityAuthanticationService {
	@Autowired
	public FakeNationalityAuthanticationManager() {

	}

	@Override
	public boolean verify(String nationalityNumber, String firstName, String lastName, int yearOfBirth) {
		if(firstName.toUpperCase().equals("Ahmet"))
		{
			return false;
		}
		return true;
	}

}
