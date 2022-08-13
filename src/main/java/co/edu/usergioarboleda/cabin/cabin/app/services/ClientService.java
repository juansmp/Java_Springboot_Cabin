package co.edu.usergioarboleda.cabin.cabin.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.cabin.cabin.app.repository.ClientRepository;
import co.edu.usergioarboleda.cabin.cabin.app.models.Client;

import java.util.List;
import java.util.Optional;

//ToDo: agregar métodos y completar validaciones.

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public List<Client> getAll() {
        return repository.findAll();
    }

    public Optional<Client> getById(Integer id) {
        return repository.findById(id);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return repository.save(client);
        } else {
            if (repository.findById(client.getIdClient()) == null) {
                return repository.save(client);
            } else {
                // throw new RuntimeException("Client not found");
                return client;
            }
        }
    }
    /*
     * public Client update(Client client) {
     * if (client.getIdClient() != null) {
     * Optional<Client> optionalClient = repository.findById(client.getIdClient());
     * if (optionalClient.isPresent()) {
     * if (client.getName() != null) {
     * optionalClient.get().setName(client.getName());
     * }
     * if (client.getDescription() != null) {
     * optionalClient.get().setDescription(client.getDescription());
     * }
     * return repository.save(optionalClient.get());
     * } else {
     * // throw new RuntimeException("Client not found");
     * return client;
     * }
     * } else {
     * // throw new RuntimeException("Client not found");
     * return client;
     * }
     * }
     */

    public void delete(Client client) {
        repository.delete(client);
    }

    /*
     * 
     * public void delete(Integer id) {
     * repository.deleteById(id);
     * }
     * 
     * public List<Client> getByName(String name) {
     * return repository.findByName(name);
     * }
     * 
     * public List<Client> getByClient(String client) {
     * return repository.findByClient(client);
     * }
     * 
     * public List<Client> getByPrice(Double price) {
     * return repository.findByPrice(price);
     * }
     * 
     */

}