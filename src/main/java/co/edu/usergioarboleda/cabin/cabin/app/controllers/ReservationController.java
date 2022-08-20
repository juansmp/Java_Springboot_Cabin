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

import co.edu.usergioarboleda.cabin.cabin.app.models.Reservation;
import co.edu.usergioarboleda.cabin.cabin.app.services.ReservationService;

@RestController
@RequestMapping("/Reservation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReservationController {
    @Autowired
    private ReservationService service;

    @GetMapping("/all")
    public List<Reservation> getAll() {
        return service.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return service.save(reservation);
    }

    @GetMapping("/{id}")
    public Reservation getById(@PathVariable Integer id) {
        return service.getById(id).orElse(null);
    }

    /*
     * @PutMapping("/update")
     * 
     * @ResponseStatus(code = HttpStatus.CREATED)
     * public Reservation update(@RequestBody Reservation reservation) {
     * return service.update(reservation);
     * }
     */

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@RequestBody Reservation reservation) {
        service.delete(reservation);
    }

}
