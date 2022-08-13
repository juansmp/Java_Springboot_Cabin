package co.edu.usergioarboleda.cabin.cabin.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usergioarboleda.cabin.cabin.app.models.Admin;
import co.edu.usergioarboleda.cabin.cabin.app.repository.crud.AdminCrudRepository;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository repository;

    public List<Admin> findAll() {
        return (List<Admin>) repository.findAll();
    }

    public Optional<Admin> findById(Integer id) {
        return repository.findById(id);
    }
    /* Another implementation for findByid would be the following */
    /*
     * public Admin findById(Integer id) {
     * return repository.findById(id).orElse(null);
     * }
     */

    public Admin save(Admin admin) {
        return repository.save(admin);
    }

    public void delete(Admin admin) {
        repository.delete(admin);
    }

}
