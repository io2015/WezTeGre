package pl.weztegre.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.weztegre.models.Language;
import pl.weztegre.repositories.LanguageRepository;

import java.util.List;


@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {
    private final Logger LOGGER = LoggerFactory.getLogger(LanguageServiceImpl.class);

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language findByLanguage(String language) {
        return languageRepository.findByLanguage(language);
    }

    @Override
    public void createLanguage(String language) {
        languageRepository.save(new Language(language));
    }
}
