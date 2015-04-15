package pl.weztegre.services;

import pl.weztegre.exceptions.EmailExistsException;
import pl.weztegre.exceptions.NickExistsException;
import pl.weztegre.formObjects.UserForm;
import pl.weztegre.models.Registration;
import pl.weztegre.models.Role;
import pl.weztegre.models.User;

public interface RoleService {
        Role findRole(final String role);
        void createRole(final String role);
}
