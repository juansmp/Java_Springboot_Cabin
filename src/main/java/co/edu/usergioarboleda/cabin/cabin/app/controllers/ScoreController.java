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

import co.edu.usergioarboleda.cabin.cabin.app.models.Score;
import co.edu.usergioarboleda.cabin.cabin.app.services.ScoreService;

@RestController
@RequestMapping("/Score")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ScoreController {
    @Autowired
    private ScoreService service;

    @GetMapping("/all")
    public ResponseEntity<List<Score>> getAll() {
        List<Score> listScores = service.getAll();
        if (listScores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(listScores);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(listScores);
        }
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Score save(@RequestBody Score score) {
        return service.save(score);
    }

    @GetMapping("/{id}")
    public Score getById(@PathVariable Integer id) {
        return service.getById(id).orElse(null);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Score update(@RequestBody Score score) {
        return service.update(score);
    }

    @DeleteMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteAll(@RequestBody Score score) {
        service.deleteAll(score);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

}
