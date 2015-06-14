package pl.weztegre.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.weztegre.models.Message;
import pl.weztegre.models.User;
import pl.weztegre.repositories.MessageRepository;

import java.util.List;


@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    private final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message findOne(Integer id) {
        return messageRepository.findOne(id);
    }

    @Override
    public List<Message> findByIdOrderByDateDescTimeDesc(User sender) {
        return messageRepository.findBySenderOrderByDateDescTimeDesc(sender);
    }


}
