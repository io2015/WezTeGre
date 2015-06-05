package pl.weztegre.services;

import pl.weztegre.models.Language;
import pl.weztegre.models.Platform;

import java.util.List;

public interface LanguageService {
        List<Language> findAll();
        Language findByLanguage(String language);
        void createLanguage(String language);
}
