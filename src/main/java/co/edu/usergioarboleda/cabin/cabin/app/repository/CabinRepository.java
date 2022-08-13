package co.edu.usergioarboleda.cabin.cabin.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usergioarboleda.cabin.cabin.app.models.Cabin;
import co.edu.usergioarboleda.cabin.cabin.app.repository.crud.CabinCrudRepository;

@Repository
public class CabinRepository {

    @Autowired
    private CabinCrudRepository repository;

    public List<Cabin> findAll() {
        return (List<Cabin>) repository.findAll();
    }

    public Optional<Cabin> findById(Integer id) {
        return repository.findById(id);
    }
    /* Another implementation for findByid would be the following */
    /*
     * public Cabin findById(Integer id) {
     * return repository.findById(id).orElse(null);
     * }
     */

    public Cabin save(Cabin cabin) {
        return repository.save(cabin);
    }

    public void delete(Cabin cabin) {
        repository.delete(cabin);
    }

}
