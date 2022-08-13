package co.edu.usergioarboleda.cabin.cabin.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usergioarboleda.cabin.cabin.app.models.Score;
import co.edu.usergioarboleda.cabin.cabin.app.services.ScoreService;

@RestController
@RequestMapping("/Score")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ScoreController {
    @Autowired
    private ScoreService service;

    @GetMapping("/all")
    public List<Score> getAll() {
        return service.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Score save(@RequestBody Score score) {
        return service.save(score);
    }

    @GetMapping("/{id}")
    public Score getById(@RequestBody Integer id) {
        return service.getById(id).orElse(null);
    }

    /*
     * @PutMapping("/update")
     * 
     * @ResponseStatus(code = HttpStatus.CREATED)
     * public Score update(@RequestBody Score score) {
     * return service.update(score);
     * }
     */

    @PutMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@RequestBody Score score) {
        service.delete(score);
    }

}
