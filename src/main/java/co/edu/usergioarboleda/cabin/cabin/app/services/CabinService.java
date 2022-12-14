package co.edu.usergioarboleda.cabin.cabin.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.cabin.cabin.app.repository.CabinRepository;
import co.edu.usergioarboleda.cabin.cabin.app.models.Cabin;

import java.util.List;
import java.util.Optional;

@Service
public class CabinService {
    @Autowired
    private CabinRepository repository;

    public List<Cabin> getAll() {
        return repository.findAll();
    }

    public Optional<Cabin> getById(Integer id) {
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
            Optional<Cabin> optionalCabin = repository.findById(cabin.getId());
            if (optionalCabin.isPresent()) {
                if (cabin.getName() != null) {
                    optionalCabin.get().setName(cabin.getName());
                }
                if (cabin.getDescription() != null) {
                    optionalCabin.get().setDescription(cabin.getDescription());
                }
                if (cabin.getCategory() != null) {
                    optionalCabin.get().setCategory(cabin.getCategory());
                }
                if (cabin.getRooms() != null) {
                    optionalCabin.get().setRooms(cabin.getRooms());
                }
                if (cabin.getBrand() != null) {
                    optionalCabin.get().setBrand(cabin.getBrand());
                }
                return repository.save(optionalCabin.get());
            } else {
                // throw new RuntimeException("Cabin not found");
                return cabin;
            }
        } else {
            // throw new RuntimeException("Cabin not found");
            return cabin;
        }
    }

    public void deleteAll(Cabin cabin) {
        if (cabin.getId() != null) {
            Optional<Cabin> optionalCabin = repository.findById(cabin.getId());
            if (optionalCabin.isPresent()) {
                repository.delete(cabin);
            } else {
                // throw new RuntimeException("Cabin not found");
            }
        } else {
            // throw new RuntimeException("Cabin not found");
        }

    }

    public void deleteById(Integer id) {
        Optional<Cabin> optionalCabin = repository.findById(id);
        if (optionalCabin.isPresent()) {
            repository.delete(optionalCabin.get());
        } else {
            // throw new RuntimeException("Cabin not found");
        }
    }

}