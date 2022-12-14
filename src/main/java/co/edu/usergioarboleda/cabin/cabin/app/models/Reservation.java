package co.edu.usergioarboleda.cabin.cabin.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 45:20 // 10:50
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    private static final long serialVersionUID = 5L;

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";

    @ManyToOne
    @JoinColumn(name = "cabinId")
    @JsonIgnoreProperties("reservations")
    private Cabin cabin;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({ "reservations", "messages" })
    private Client client;

    private String score;

    /*
     * @ManyToOne
     * 
     * @JoinColumn(name = "categoryId")
     * 
     * @JsonIgnoreProperties("cabins")
     * private Category category;
     * private Integer rooms;
     * private String brand;
     */
}