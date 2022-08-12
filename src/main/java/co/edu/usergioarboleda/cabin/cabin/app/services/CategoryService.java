package co.edu.usergioarboleda.cabin.cabin.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.cabin.cabin.app.repository.CategoryRepository;
import co.edu.usergioarboleda.cabin.cabin.app.models.Category;

import java.util.List;

//ToDo: agregar métodos y completar validaciones.

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Category getById(Integer id) {
        return repository.findById(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return repository.save(category);
        } else {
            if (repository.findById(category.getId()) == null) {
                return repository.save(category);
            } else {
                // throw new RuntimeException("Category not found");
                return category;
            }
        }
    }

    public Category update(Category category) {
        if (category.getId() != null) {
            if (repository.findById(category.getId()) != null) {
                return repository.save(category);
            } else {
                // throw new RuntimeException("Category not found");
                return category;
            }
        } else {
            // throw new RuntimeException("Category not found");
            return category;
        }
    }

    /*
     * 
     * public void delete(Integer id) {
     * repository.deleteById(id);
     * }
     * 
     * public List<Category> getByName(String name) {
     * return repository.findByName(name);
     * }
     * 
     * public List<Category> getByCategory(String category) {
     * return repository.findByCategory(category);
     * }
     * 
     * public List<Category> getByPrice(Double price) {
     * return repository.findByPrice(price);
     * }
     * 
     */

}