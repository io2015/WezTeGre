package pl.weztegre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.weztegre.models.Registration;

/**
* Interfejs RegistrationRepository.
*/
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
	/**
	* Metoda znajduje odpowiednią instancję klasy Registration po tokenie
	* @param token Token
	* @return Instancja rejestracji
	*/
    Registration findByToken(String token);
}
