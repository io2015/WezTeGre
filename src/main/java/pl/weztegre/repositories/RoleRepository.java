package pl.weztegre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.weztegre.models.Role;

/**
* Interfejs RoleRepository.
*/
public interface RoleRepository extends JpaRepository<Role, Integer> {
	/**
	* Metoda znajduje rolę po nazwie
	* @param role Nazwa roli
	* @return Rola o podanej nazwie
	*/
    Role findByRole(String role);
}
