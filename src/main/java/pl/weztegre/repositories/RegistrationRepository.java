package pl.weztegre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.weztegre.models.Registration;

/**
* Interfejs RegistrationRepository.
*/
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
    Registration findByToken(String token);
}
