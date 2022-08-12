package co.edu.usergioarboleda.cabin.cabin.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usergioarboleda.cabin.cabin.app.models.Category;
import co.edu.usergioarboleda.cabin.cabin.app.repository.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository repository;

    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    public Category findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Category save(Category Category) {
        return repository.save(Category);
    }

    public void delete(Category Category) {
        repository.delete(Category);
    }

}
