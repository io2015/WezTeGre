package pl.weztegre.services;

import pl.weztegre.models.Message;
import pl.weztegre.models.User;

import java.util.List;

public interface MessageService {
        Message save(Message message);
        List<Message> findAll();
        Message findOne(Integer id);
        List<Message> findByIdOrderByDateDescTimeDesc(User sender);
}
