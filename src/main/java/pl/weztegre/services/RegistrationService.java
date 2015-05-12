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

public interface RegistrationService {
        Registration createUserAndRegistration(final UserForm userForm);
        Registration getRegistrationToken(final String token);
        Registration updateUserAndRegistration(final Registration registration);
        User saveUserAndDeleteRegistration(final Registration registration);

        void setRegistrationRepository(RegistrationRepository registrationRepository);

        void setUserRepository(UserRepository userRepository);

        void setRoleRepository(RoleRepository roleRepository);

        void setPasswordEncoder(PasswordEncoder passwordEncoder);        //niewidzepowodudlaczegotumialobytubyc
}
