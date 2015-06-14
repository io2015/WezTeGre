package pl.weztegre.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.weztegre.models.Role;
import pl.weztegre.repositories.RoleRepository;

/**
* Klasa implementuje interfejs RoleService
*/
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleRepository roleRepository;

	/**
	* Metoda znajduje rolę po nazwie
	* @param role Nazwa roli
	* @return Rola
	*/
    @Override
    public Role findRole(String role) {
        return roleRepository.findByRole(role);
    }

	/**
	* Metoda tworzy rolę o pddanej nazwie
	* @param role Nazwa roli
	*/
    @Override
    public void createRole(String role) {
        roleRepository.save(new Role(role));
    }
}
