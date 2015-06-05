package pl.weztegre.services;

import pl.weztegre.exceptions.EmailExistsException;
import pl.weztegre.exceptions.NickExistsException;
import pl.weztegre.formObjects.UserForm;
import pl.weztegre.models.Registration;
import pl.weztegre.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User save(User user);
    User findByEmail(String email);
    User findOne(Integer id);
}
