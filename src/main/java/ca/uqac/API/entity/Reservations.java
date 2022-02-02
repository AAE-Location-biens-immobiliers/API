package ca.uqac.API.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.DateTimeException;
import java.util.Set;

@Entity
public class Reservations {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idReservation;
    private Date dateReservationDebut;
    private Date dateReservationFin;

    @OneToMany(mappedBy = "idReservation")
    private Set<Factures> factures;


    @ManyToOne
    @JoinColumn(name = "idlocataire")
    private Comptes idLocataire;

    @ManyToOne
    @JoinColumn(name = "idannonce")
    private Annonces idAnnonce;

    public Annonces getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Annonces idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public Comptes getIdLocataire() {
        return idLocataire;
    }

    public void setIdLocataire(Comptes idLocataire) {
        this.idLocataire = idLocataire;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getDateReservationDebut() {
        return dateReservationDebut;
    }

    public void setDateReservationDebut(Date dateReservationDebut) {
        this.dateReservationDebut = dateReservationDebut;
    }

    public Date getDateReservationFin() {
        return dateReservationFin;
    }

    public void setDateReservationFin(Date dateReservationFin) {
        this.dateReservationFin = dateReservationFin;
    }

    public Set<Factures> getFactures() {
        return factures;
    }

    public void setFactures(Set<Factures> factures) {
        this.factures = factures;
    }
}
