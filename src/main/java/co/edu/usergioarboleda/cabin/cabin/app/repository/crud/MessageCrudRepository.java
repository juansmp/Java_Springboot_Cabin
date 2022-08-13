package co.edu.usergioarboleda.cabin.cabin.app.repository.crud;

import org.springframework.data.repository.CrudRepository;
import co.edu.usergioarboleda.cabin.cabin.app.models.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {

}
