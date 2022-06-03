package com.enginyenice.hrms.bussines.concretes;

import com.enginyenice.hrms.bussines.abstracts.TalentService;
import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessDataResult;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;
import com.enginyenice.hrms.dataAccess.abstracts.TalentRepository;
import com.enginyenice.hrms.entities.concretes.Talent;
import com.enginyenice.hrms.entities.dtos.talents.GetAllTalentDto;
import com.enginyenice.hrms.entities.dtos.talents.TalentDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentManager implements TalentService {
    private final TalentRepository talentRepository;
    private ModelMapper modelMapper;

    public TalentManager(TalentRepository talentRepository, ModelMapper modelMapper) {
        this.talentRepository = talentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result create(TalentDto talentDto) {
        Talent talent = this.modelMapper.map(talentDto,Talent.class);
        talent.setId(0);
        this.talentRepository.save(talent);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<GetAllTalentDto>> getByCandidateId(int candidateId) {
        List<GetAllTalentDto> talentDtos = this.modelMapper.map(
          this.talentRepository.getByCandidate_Id(candidateId),
                new TypeToken<List<GetAllTalentDto>>() {}.getType()
        );
        return new SuccessDataResult<>(talentDtos);
    }
}
