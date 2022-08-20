package co.edu.usergioarboleda.cabin.cabin.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.cabin.cabin.app.repository.AdminRepository;
import co.edu.usergioarboleda.cabin.cabin.app.models.Admin;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;

    public List<Admin> getAll() {
        return repository.findAll();
    }

    public Optional<Admin> getById(Integer id) {
        return repository.findById(id);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return repository.save(admin);
        } else {
            if (repository.findById(admin.getIdAdmin()) == null) {
                return repository.save(admin);
            } else {
                // throw new RuntimeException("Admin not found");
                return admin;
            }
        }
    }

    /*
     * public Admin update(Admin admin) {
     * if (admin.getIdAdmin() != null) {
     * Optional<Admin> optionalAdmin = repository.findById(admin.getIdAdmin());
     * if (optionalAdmin.isPresent()) {
     * if (admin.getName() != null) {
     * optionalAdmin.get().setName(admin.getName());
     * }
     * if (admin.getDescription() != null) {
     * optionalAdmin.get().setDescription(admin.getDescription());
     * }
     * return repository.save(optionalAdmin.get());
     * } else {
     * // throw new RuntimeException("Admin not found");
     * return admin;
     * }
     * } else {
     * // throw new RuntimeException("Admin not found");
     * return admin;
     * }
     * }
     */
    public void delete(Admin admin) {
        if (admin.getIdAdmin() != null) {
            Optional<Admin> optionalAdmin = repository.findById(admin.getIdAdmin());
            if (optionalAdmin.isPresent()) {
                repository.delete(admin);
            } else {
                // throw new RuntimeException("Admin not found");
            }
        } else {
            // throw new RuntimeException("Admin not found");
        }

    }

    /*
     * 
     * public void delete(Integer id) {
     * repository.deleteById(id);
     * }
     * 
     * public List<Admin> getByName(String name) {
     * return repository.findByName(name);
     * }
     * 
     * public List<Admin> getByAdmin(String admin) {
     * return repository.findByAdmin(admin);
     * }
     * 
     * public List<Admin> getByPrice(Double price) {
     * return repository.findByPrice(price);
     * }
     * 
     */

}