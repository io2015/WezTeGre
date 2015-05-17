package pl.weztegre.services;

import pl.weztegre.exceptions.EmailExistsException;
import pl.weztegre.exceptions.NickExistsException;
import pl.weztegre.formObjects.UserForm;
import pl.weztegre.models.Registration;
import pl.weztegre.models.User;

import java.util.List;

/**
* Interfejs UserService
*/
public interface UserService {
    /**
	* Metoda znajduje wszystkich użytkowników
	*/
	List<User> findAll();
	/**
	* Metoda zapisuje użytkownika
	*/
    User save(User user);
	/**
	* Metoda znajduje użytkownika po adresie email
	*/
    User findByEmail(String email);
}
