package co.edu.usergioarboleda.cabin.cabin.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usergioarboleda.cabin.cabin.app.models.Client;
import co.edu.usergioarboleda.cabin.cabin.app.repository.crud.ClientCrudRepository;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository repository;

    public List<Client> findAll() {
        return (List<Client>) repository.findAll();
    }

    public Optional<Client> findById(Integer id) {
        return repository.findById(id);
    }
    /* Another implementation for findByid would be the following */
    /*
     * public Client findById(Integer id) {
     * return repository.findById(id).orElse(null);
     * }
     */

    public Client save(Client client) {
        return repository.save(client);
    }

    public void delete(Client client) {
        repository.delete(client);
    }

}
