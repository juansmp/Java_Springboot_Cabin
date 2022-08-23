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

import co.edu.usergioarboleda.cabin.cabin.app.models.Admin;
import co.edu.usergioarboleda.cabin.cabin.app.services.AdminService;

@RestController
@RequestMapping("/Admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
    @Autowired
    private AdminService service;

    @GetMapping("/all")
    public List<Admin> getAll() {
        return service.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin) {
        return service.save(admin);
    }

    @GetMapping("/{id}")
    public Admin getById(@PathVariable Integer id) {
        return service.getById(id).orElse(null);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin) {
        return service.update(admin);
    }

    @DeleteMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteAll(@RequestBody Admin admin) {
        service.deleteAll(admin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

}
