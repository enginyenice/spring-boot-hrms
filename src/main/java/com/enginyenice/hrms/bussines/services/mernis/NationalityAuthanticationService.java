package com.enginyenice.hrms.bussines.services.mernis;

import org.springframework.stereotype.Service;

public interface NationalityAuthanticationService {
	boolean verify(String nationalityNumber, String firstName, String lastName, int yearOfBirth);
}
