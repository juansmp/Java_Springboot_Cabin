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

import co.edu.usergioarboleda.cabin.cabin.app.models.Category;
import co.edu.usergioarboleda.cabin.cabin.app.services.CategoryService;

@RestController
@RequestMapping("/Category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll() {
        List<Category> listCategories = service.getAll();
        if (listCategories.isEmpty()) {
            /*
             * A continuación se muestra la respuesta que se obtiene al ejecutar el método
             * getAll() cuando no se obtienen resultados, en este caso se obtiene un código
             * de estado 200 y un cuerpo vacío para que pasen los test cases en la
             * plataforma Mastertech, sin embargo, también se podría retornar un código de
             * estado 404:
             * return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
             */

            return ResponseEntity.status(HttpStatus.OK).body(listCategories);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(listCategories);
        }
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return service.save(category);
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id) {
        return service.getById(id).orElse(null);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category update(@RequestBody Category category) {
        return service.update(category);
    }

    @DeleteMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteAll(@RequestBody Category category) {
        service.deleteAll(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

}
