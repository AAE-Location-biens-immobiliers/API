package ca.uqac.API.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.time.DateTimeException;

@Entity
public class Reservations {
    @Id
    private Integer idReservation;
    private Integer idAnnonce;
    private Integer idLocataire;
    private Date dateReservationDebut;
    private Date dateReservationFin;


}
