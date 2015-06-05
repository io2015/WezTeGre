package pl.weztegre.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import pl.weztegre.exceptions.EmailExistsException;
import pl.weztegre.exceptions.NickExistsException;
import pl.weztegre.formObjects.UserForm;
import pl.weztegre.models.Registration;
import pl.weztegre.models.User;
import pl.weztegre.repositories.RegistrationRepository;
import pl.weztegre.repositories.RoleRepository;
import pl.weztegre.repositories.UserRepository;

import java.util.List;

/**
* Interfejs RegistrationService
*/
public interface RegistrationService {
		/**
		* Metoda tworząca nowego użytkownika
		*/
        Registration createUserAndRegistration(final UserForm userForm);
		/**
		* Metoda zwraca token
		*/
        Registration getRegistrationToken(final String token);
		/**
		* Metoda aktualizuje użytkownika
		*/
        Registration updateUserAndRegistration(final Registration registration);
		/**
		* Metoda zapisująca zmiany użytkownika
		*/
        User saveUserAndDeleteRegistration(final Registration registration);

		/**
		* Metoda pozwala na ustawienie repozytorium rejestracji
		*/
        void setRegistrationRepository(RegistrationRepository registrationRepository);
		/**
		* Metoda pozwala na ustawienie repozytorium użytkownika
		*/
        void setUserRepository(UserRepository userRepository);
		/**
		* Metoda pozwala na ustawienie repozytorium ról
		*/
        void setRoleRepository(RoleRepository roleRepository);
		/**
		* Metoda pozwala na ustawienie enkodera haseł
		*/
        void setPasswordEncoder(PasswordEncoder passwordEncoder);        //niewidzepowodudlaczegotumialobytubyc
}
