package com.enginyenice.hrms.bussines.concretes;

import com.enginyenice.hrms.bussines.abstracts.LanguageService;
import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessDataResult;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;
import com.enginyenice.hrms.dataAccess.abstracts.LanguageRepository;
import com.enginyenice.hrms.entities.concretes.Language;
import com.enginyenice.hrms.entities.dtos.languages.GetAllLanguageDto;
import com.enginyenice.hrms.entities.dtos.languages.LanguageDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private final LanguageRepository languageRepository;
    private ModelMapper modelMapper;

    public LanguageManager(LanguageRepository languageRepository, ModelMapper modelMapper) {
        this.languageRepository = languageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result create(LanguageDto languageDto) {
        Language language = this.modelMapper.map(languageDto,Language.class);
        language.setId(0);

        this.languageRepository.save(language);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<GetAllLanguageDto>> getByCandidateId(int candidateId) {

        List<GetAllLanguageDto> languageDtos = this.modelMapper.map(
                this.languageRepository.getByCandidate_Id(candidateId),
                new TypeToken<List<GetAllLanguageDto>>() {}.getType()
        );
        return new SuccessDataResult<>(languageDtos);
    }
}
