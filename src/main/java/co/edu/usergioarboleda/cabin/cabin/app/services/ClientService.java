package co.edu.usergioarboleda.cabin.cabin.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.cabin.cabin.app.repository.ClientRepository;
import co.edu.usergioarboleda.cabin.cabin.app.models.Client;

import java.util.List;
import java.util.Optional;

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

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> optionalClient = repository.findById(client.getIdClient());
            if (optionalClient.isPresent()) {
                if (client.getName() != null) {
                    optionalClient.get().setName(client.getName());
                }
                if (client.getEmail() != null) {
                    optionalClient.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    optionalClient.get().setPassword(client.getPassword());
                }
                if (client.getAge() != null) {
                    optionalClient.get().setAge(client.getAge());
                }
                return repository.save(optionalClient.get());
            } else {
                // throw new RuntimeException("Client not found");
                return client;
            }
        } else {
            // throw new RuntimeException("Client not found");
            return client;
        }
    }

    public void deleteAll(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> optionalClient = repository.findById(client.getIdClient());
            if (optionalClient.isPresent()) {
                repository.delete(client);
            } else {
                // throw new RuntimeException("Client not found");
            }
        } else {
            // throw new RuntimeException("Client not found");
        }

    }

    public void deleteById(Integer id) {
        Optional<Client> optionalClient = repository.findById(id);
        if (optionalClient.isPresent()) {
            repository.delete(optionalClient.get());
        } else {
            // throw new RuntimeException("Client not found");
        }
    }

}