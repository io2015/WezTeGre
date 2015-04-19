package pl.weztegre.services;

import pl.weztegre.exceptions.EmailExistsException;
import pl.weztegre.exceptions.NickExistsException;
import pl.weztegre.formObjects.UserForm;
import pl.weztegre.models.Registration;
import pl.weztegre.models.User;

import java.util.List;

public interface RegistrationService {
        Registration createUserAndRegistration(final UserForm userForm);
        Registration getRegistrationToken(final String token);
        Registration updateUserAndRegistration(final Registration registration);
        User saveUserAndDeleteRegistration(final Registration registration);
}
