package co.edu.usergioarboleda.cabin.cabin.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.usergioarboleda.cabin.cabin.app.repository.CabinRepository;

@Service
public class CabinService {
    @Autowired
    private CabinRepository repository;
}
