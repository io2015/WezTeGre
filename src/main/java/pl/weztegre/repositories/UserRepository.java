package pl.weztegre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.weztegre.models.User;

/**
* Interfejs UserRepository
*/
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
