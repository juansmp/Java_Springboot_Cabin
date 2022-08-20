package co.edu.usergioarboleda.cabin.cabin.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<Message> getAll() {
        return service.getAll();
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

    /*
     * @PutMapping("/update")
     * 
     * @ResponseStatus(code = HttpStatus.CREATED)
     * public Message update(@RequestBody Message message) {
     * return service.update(message);
     * }
     */

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@RequestBody Message message) {
        service.delete(message);
    }

}
