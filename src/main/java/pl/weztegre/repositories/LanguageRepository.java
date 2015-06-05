package pl.weztegre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.weztegre.models.Language;
import pl.weztegre.models.Platform;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
    Language findByLanguage(String language);
}
