package co.edu.usergioarboleda.cabin.cabin.app.repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usergioarboleda.cabin.cabin.app.models.Client;
import co.edu.usergioarboleda.cabin.cabin.app.models.Reservation;
import co.edu.usergioarboleda.cabin.cabin.app.models.custom.CountClient;
import co.edu.usergioarboleda.cabin.cabin.app.repository.crud.ClientCrudRepository;
import co.edu.usergioarboleda.cabin.cabin.app.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository repository;

    @Autowired
    private ClientCrudRepository clientRepository;

    public List<Reservation> findAll() {
        return (List<Reservation>) repository.findAll();
    }

    public Optional<Reservation> findById(Integer id) {
        return repository.findById(id);
    }
    /* Another implementation for findByid would be the following */
    /*
     * public Reservation findById(Integer id) {
     * return repository.findById(id).orElse(null);
     * }
     */

    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }

    public void delete(Reservation reservation) {
        repository.delete(reservation);
    }

    public List<Reservation> findAllByDates(Date startDate, Date devolutionDate) {
        return repository.findAllByStartDateAfterAndDevolutionDateBefore(startDate, devolutionDate);
    }

    /**
     * Método que devuelve el top de clientes que más reservas han hecho.
     * 
     * @return List<CountClient> respuesta;
     */

    public List<CountClient> findTopClients() {
        List<CountClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = repository.countTotalReservationByClient();
        for (Object[] object : reporte) {
            Client client = new Client();
            client = clientRepository.findById((Integer) object[0]).get();
            respuesta.add(new CountClient((long) ((BigInteger) object[1]).longValue(),
                    client));
        }
        return respuesta;
    }

    /**
     * Método que devuelve el top de cabinas que más reservas han hecho.
     * 
     * @return List<CountClient> respuesta;
     */
    public List<Reservation> findReservationsByStatus(String status) {
        return repository.findAllByStatus(status);
    }

}
