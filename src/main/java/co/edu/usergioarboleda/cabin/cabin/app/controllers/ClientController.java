package co.edu.usergioarboleda.cabin.cabin.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usergioarboleda.cabin.cabin.app.models.Client;
import co.edu.usergioarboleda.cabin.cabin.app.services.ClientService;

@RestController
@RequestMapping("/Client")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAll() {
        List<Client> listClients = service.getAll();
        if (listClients.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listClients);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(listClients);
        }
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return service.save(client);
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Integer id) {
        return service.getById(id).orElse(null);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Client update(@RequestBody Client client) {
        return service.update(client);
    }

    @DeleteMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteAll(@RequestBody Client client) {
        service.deleteAll(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

}
