package pl.weztegre.services;

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
    User findOne(Integer id);
}
