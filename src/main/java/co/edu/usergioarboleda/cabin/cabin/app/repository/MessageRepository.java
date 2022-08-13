package co.edu.usergioarboleda.cabin.cabin.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usergioarboleda.cabin.cabin.app.models.Message;
import co.edu.usergioarboleda.cabin.cabin.app.repository.crud.MessageCrudRepository;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository repository;

    public List<Message> findAll() {
        return (List<Message>) repository.findAll();
    }

    public Optional<Message> findById(Integer id) {
        return repository.findById(id);
    }
    /* Another implementation for findByid would be the following */
    /*
     * public Message findById(Integer id) {
     * return repository.findById(id).orElse(null);
     * }
     */

    public Message save(Message message) {
        return repository.save(message);
    }

    public void delete(Message message) {
        repository.delete(message);
    }

}
