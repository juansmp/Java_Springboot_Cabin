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

    public Admin update(Admin admin) {
        if (admin.getIdAdmin() != null) {
            Optional<Admin> optionalAdmin = repository.findById(admin.getIdAdmin());
            if (optionalAdmin.isPresent()) {
                if (admin.getName() != null) {
                    optionalAdmin.get().setName(admin.getName());
                }
                if (admin.getEmail() != null) {
                    optionalAdmin.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null) {
                    optionalAdmin.get().setPassword(admin.getPassword());
                }
                return repository.save(optionalAdmin.get());
            } else {
                // throw new RuntimeException("Admin not found");
                return admin;
            }
        } else {
            // throw new RuntimeException("Admin not found");
            return admin;
        }
    }

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

}