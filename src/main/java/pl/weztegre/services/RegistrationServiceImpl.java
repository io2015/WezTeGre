package pl.weztegre.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.weztegre.formObjects.UserForm;
import pl.weztegre.models.Registration;
import pl.weztegre.models.Role;
import pl.weztegre.models.User;
import pl.weztegre.repositories.RegistrationRepository;
import pl.weztegre.repositories.RoleRepository;
import pl.weztegre.repositories.UserRepository;

import java.util.UUID;


/**
* Klasa  RegistrationSer implementuje interfejs RegistrationService
*/
@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    private final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
	/**
	* Metoda tworząca nowego użytkownika
	*/
    public Registration createUserAndRegistration(UserForm userForm) {
        final User user = new User(userForm.getEmail(),
                userForm.getName(),
                userForm.getSurname(),
                passwordEncoder.encode(userForm.getPassword()));

        final Role userRole = roleRepository.findByRole("ROLE_USER");
        user.addRole(userRole);

        final Registration registration = new Registration(user, UUID.randomUUID().toString());

        return registrationRepository.save(registration);
    }
	/**
	* Metoda aktualizuje użytkownika
	*/
    public Registration updateUserAndRegistration(Registration registration) {
        registration.setNewExpiryDate();
        registration.setToken(UUID.randomUUID().toString());

        return registrationRepository.save(registration);
    }
	/**
	* Metoda zapisująca zmiany użytkownika
	*/
    @Override
    public User saveUserAndDeleteRegistration(Registration registration) {
        final User user = userRepository.save(registration.getUser());
        registrationRepository.delete(registration);

        return user;
    }
	/**
	* Metoda zwraca token
	*/
    @Override
    public Registration getRegistrationToken(String token) {
        return registrationRepository.findByToken(token);
    }

	/**
	* Metoda pozwala na ustawienie repozytorium rejestracji
	*/
    public void setRegistrationRepository(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }
	/**
	* Metoda zwraca repozytorium użytkownika
	*/
    public UserRepository getUserRepository() {
        return userRepository;
    }

	/**
	* Metoda pozwala na ustawienie repozytorium użytkownika
	*/
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	/**
	* Metoda pozwala na uzyskanie repozytorium ról
	*/
    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

	/**
	* Metoda pozwala na ustawienie repozytorium ról
	*/
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
	/**
	* Metoda pozwala pobranie
	*/
    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
	/**
	* Metoda pozwala na ustawienie enkodera haseł
	*/
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
