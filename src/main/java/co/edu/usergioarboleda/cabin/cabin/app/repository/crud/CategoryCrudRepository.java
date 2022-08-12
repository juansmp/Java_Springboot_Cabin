package co.edu.usergioarboleda.cabin.cabin.app.repository.crud;

import org.springframework.data.repository.CrudRepository;
import co.edu.usergioarboleda.cabin.cabin.app.models.Category;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}