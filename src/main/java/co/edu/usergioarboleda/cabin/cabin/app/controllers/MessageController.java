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

import co.edu.usergioarboleda.cabin.cabin.app.models.Message;
import co.edu.usergioarboleda.cabin.cabin.app.services.MessageService;

@RestController
@RequestMapping("/Message")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MessageController {
    @Autowired
    private MessageService service;

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAll() {
        List<Message> listMessages = service.getAll();
        if (listMessages.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listMessages);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(listMessages);
        }
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {
        return service.save(message);
    }

    @GetMapping("/{id}")
    public Message getById(@PathVariable Integer id) {
        return service.getById(id).orElse(null);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Message update(@RequestBody Message message) {
        return service.update(message);
    }

    @DeleteMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteAll(@RequestBody Message message) {
        service.deleteAll(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

}
