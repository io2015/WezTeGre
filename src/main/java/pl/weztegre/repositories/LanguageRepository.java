package pl.weztegre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.weztegre.models.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
    Language findByLanguage(String language);
}
