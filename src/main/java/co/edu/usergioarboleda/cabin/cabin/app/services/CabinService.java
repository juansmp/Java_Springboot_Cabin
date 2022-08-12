package co.edu.usergioarboleda.cabin.cabin.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.cabin.cabin.app.repository.CabinRepository;
import co.edu.usergioarboleda.cabin.cabin.app.models.Cabin;

import java.util.List;

//TODO completar validaciones.
//TODO completar updates con validaciones respectivas usando optional y verificar si algunos campos vienen o no vienen. .

@Service
public class CabinService {
    @Autowired
    private CabinRepository repository;

    public List<Cabin> getAll() {
        return repository.findAll();
    }

    public Cabin getById(Integer id) {
        return repository.findById(id);
    }

    public Cabin save(Cabin cabin) {
        if (cabin.getId() == null) {
            return repository.save(cabin);
        } else {
            if (repository.findById(cabin.getId()) == null) {
                return repository.save(cabin);
            } else {
                // throw new RuntimeException("Cabin not found");
                return cabin;
            }
        }
    }

    public Cabin update(Cabin cabin) {
        if (cabin.getId() != null) {
            if (repository.findById(cabin.getId()) != null) {
                return repository.save(cabin);
            } else {
                // throw new RuntimeException("Cabin not found");
                return cabin;
            }
        } else {
            // throw new RuntimeException("Cabin not found");
            return cabin;
        }
    }

    /*
     * 
     * public void delete(Integer id) {
     * repository.deleteById(id);
     * }
     * 
     * public List<Cabin> getByName(String name) {
     * return repository.findByName(name);
     * }
     * 
     * public List<Cabin> getByCategory(String category) {
     * return repository.findByCategory(category);
     * }
     * 
     * public List<Cabin> getByPrice(Double price) {
     * return repository.findByPrice(price);
     * }
     * 
     */

}