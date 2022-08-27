package co.edu.usergioarboleda.cabin.cabin.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.cabin.cabin.app.repository.ReservationRepository;
import co.edu.usergioarboleda.cabin.cabin.app.models.Reservation;
import co.edu.usergioarboleda.cabin.cabin.app.models.custom.CountClient;
import co.edu.usergioarboleda.cabin.cabin.app.models.custom.StatusAmount;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public void deleteAll(Reservation reservation) {
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

    public void deleteById(Integer id) {
        Optional<Reservation> optionalReservation = repository.findById(id);
        if (optionalReservation.isPresent()) {
            repository.delete(optionalReservation.get());
        } else {
            // throw new RuntimeException("Reservation not found");
        }
    }

    public List<Reservation> getReportDates(String fechaInicial, String fechaFinal) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicialDate = new Date();
        Date fechaFinalDate = new Date();
        try {
            fechaInicialDate = formatter.parse(fechaInicial);
            fechaFinalDate = formatter.parse(fechaFinal);
            if (fechaInicialDate.before(fechaFinalDate)) {
                return repository.findAllByDates(fechaInicialDate, fechaFinalDate);
            } else {
                return new ArrayList<Reservation>();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<Reservation>();
        }
    }

    /**
     * Metodo que devuelve el top de clientes que mas reservaron
     * 
     * @return List<CountClient> respuesta
     */
    public List<CountClient> getTopClients() {
        return repository.findTopClients();
    }

    public StatusAmount getReservationStatusReport() {
        List<Reservation> completed = repository.findReservationsByStatus("completed");
        List<Reservation> cancelled = repository.findReservationsByStatus("cancelled");

        return new StatusAmount(completed.size(), cancelled.size());
    }

}