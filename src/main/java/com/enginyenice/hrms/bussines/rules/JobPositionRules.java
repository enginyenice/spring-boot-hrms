package com.enginyenice.hrms.bussines.rules;

import com.enginyenice.hrms.core.utilities.results.ErrorResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;
import com.enginyenice.hrms.dataAccess.abstracts.JobPositionRepository;
import org.springframework.stereotype.Component;

@Component
public class JobPositionRules {

    private final JobPositionRepository jobPositionRepository;

    public JobPositionRules(JobPositionRepository jobPositionRepository) {
        this.jobPositionRepository = jobPositionRepository;
    }

    public Result isExistPositionName(String positionName){
        if(this.jobPositionRepository.findByName(positionName) != null)
        {
            return new ErrorResult("Position name is exist");
        }
        return new SuccessResult();
    }
}
