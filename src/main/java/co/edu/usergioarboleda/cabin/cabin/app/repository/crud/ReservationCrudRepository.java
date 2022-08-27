package co.edu.usergioarboleda.cabin.cabin.app.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import co.edu.usergioarboleda.cabin.cabin.app.models.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    // SELECT * FROM reservation WHERE startDate > ? and endDate < ?
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date startDate, Date devolutionDate);
    // public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date //
    // startDate, Date endDate);

    @Query(value = "SELECT c.client_id, count(c.client_id) as total FROM reservation c GROUP BY c.client_id ORDER BY total DESC", nativeQuery = true)
    public List<Object[]> countTotalReservationByClient();

    public List<Reservation> findAllByStatus(String status);

    @Query(value = "SELECT c.cabin_id, count(c.cabin_id) as total FROM reservation c GROUP BY c.cabin_id ORDER BY total DESC", nativeQuery = true)
    public List<Object[]> countTotalReservationByCabin();
}
