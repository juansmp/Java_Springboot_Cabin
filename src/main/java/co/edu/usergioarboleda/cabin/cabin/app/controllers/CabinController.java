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

import co.edu.usergioarboleda.cabin.cabin.app.models.Cabin;
import co.edu.usergioarboleda.cabin.cabin.app.services.CabinService;

@RestController
@RequestMapping("/Cabin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CabinController {
    @Autowired
    private CabinService service;

    @GetMapping("/all")
    public List<Cabin> getAll() {
        return service.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin cabin) {
        return service.save(cabin);
    }

    @GetMapping("/{id}")
    public Cabin getById(@PathVariable Integer id) {
        return service.getById(id).orElse(null);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cabin update(@RequestBody Cabin cabin) {
        return service.update(cabin);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@RequestBody Cabin cabin) {
        service.delete(cabin);
    }

}
