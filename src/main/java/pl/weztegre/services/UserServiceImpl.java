package pl.weztegre.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.weztegre.models.User;
import pl.weztegre.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
* Klasa UserService implementuje interfejs UserService
*/
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

	/**
	* Implementacja metody znajdywania wszystkich użytkowników
	* @return Lista użytkowników
	*/
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

	/**
	* Implementacja metody zapisywania zmian dot. konta użytkownika
	* @param user Dane użytkownika
	* @return Status zapisywania
	*/
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

	/**
	* Metoda znajduje użytkownika po emailu
	* @param email Email użytkownika
	* @return Użytkownik
	*/
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findOne(Integer id) {
        return userRepository.findOne(id);
    }
}
