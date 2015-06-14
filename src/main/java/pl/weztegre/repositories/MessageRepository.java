package pl.weztegre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.weztegre.models.Message;
import pl.weztegre.models.User;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    //@Query("SELECT m FROM Message m ORDER BY m.date DESC")
    List<Message> findBySenderOrderByDateDescTimeDesc(User sender);
}
