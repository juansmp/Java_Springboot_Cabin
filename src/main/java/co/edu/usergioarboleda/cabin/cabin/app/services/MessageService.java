package co.edu.usergioarboleda.cabin.cabin.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.cabin.cabin.app.repository.MessageRepository;
import co.edu.usergioarboleda.cabin.cabin.app.models.Message;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;

    public List<Message> getAll() {
        return repository.findAll();
    }

    public Optional<Message> getById(Integer id) {
        return repository.findById(id);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return repository.save(message);
        } else {
            if (repository.findById(message.getIdMessage()) == null) {
                return repository.save(message);
            } else {
                // throw new RuntimeException("Message not found");
                return message;
            }
        }
    }

    /*
     * public Message update(Message message) {
     * if (message.getIdMessage() != null) {
     * Optional<Message> optionalMessage =
     * repository.findById(message.getIdMessage());
     * if (optionalMessage.isPresent()) {
     * if (message.getName() != null) {
     * optionalMessage.get().setName(message.getName());
     * }
     * if (message.getDescription() != null) {
     * optionalMessage.get().setDescription(message.getDescription());
     * }
     * return repository.save(optionalMessage.get());
     * } else {
     * // throw new RuntimeException("Message not found");
     * return message;
     * }
     * } else {
     * // throw new RuntimeException("Message not found");
     * return message;
     * }
     * }
     */
    public void delete(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> optionalMessage = repository.findById(message.getIdMessage());
            if (optionalMessage.isPresent()) {
                repository.delete(message);
            } else {
                // throw new RuntimeException("Message not found");
            }
        } else {
            // throw new RuntimeException("Message not found");
        }

    }

    /*
     * 
     * public void delete(Integer id) {
     * repository.deleteById(id);
     * }
     * 
     * public List<Message> getByName(String name) {
     * return repository.findByName(name);
     * }
     * 
     * public List<Message> getByMessage(String message) {
     * return repository.findByMessage(message);
     * }
     * 
     * public List<Message> getByPrice(Double price) {
     * return repository.findByPrice(price);
     * }
     * 
     */

}