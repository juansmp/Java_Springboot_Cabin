package co.edu.usergioarboleda.cabin.cabin.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.cabin.cabin.app.repository.ReservationRepository;
import co.edu.usergioarboleda.cabin.cabin.app.models.Reservation;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAll() {
        return repository.findAll();
    }

    public Optional<Reservation> getById(Integer id) {
        return repository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return repository.save(reservation);
        } else {
            if (repository.findById(reservation.getIdReservation()) == null) {
                return repository.save(reservation);
            } else {
                // throw new RuntimeException("Reservation not found");
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> optionalReservation = repository.findById(reservation.getIdReservation());
            if (optionalReservation.isPresent()) {
                if (reservation.getStartDate() != null) {
                    optionalReservation.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    optionalReservation.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                return repository.save(optionalReservation.get());
            } else {
                // throw new RuntimeException("Reservation not found");
                return reservation;
            }
        } else {
            // throw new RuntimeException("Reservation not found");
            return reservation;
        }
    }

    public void delete(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> optionalReservation = repository.findById(reservation.getIdReservation());
            if (optionalReservation.isPresent()) {
                repository.delete(reservation);
            } else {
                // throw new RuntimeException("Reservation not found");
            }
        } else {
            // throw new RuntimeException("Reservation not found");
        }

    }

}