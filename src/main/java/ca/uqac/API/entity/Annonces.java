package ca.uqac.API.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Annonces {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idAnnonce;
    private String description;
    private Date disponibilite;
    private float prix;


    @OneToMany(mappedBy = "idAnnonce")
    private Set<Reservations> reservations;

    @OneToMany(mappedBy = "idAnnonce")
    private Set<Disponibilites> disponibilites;

    @ManyToOne
    @JoinColumn(name = "idhabitation")
    private Habitations idHabitation;

    public Habitations getIdHabitation() {
        return idHabitation;
    }

    public void setIdHabitation(Habitations idHabitation) {
        this.idHabitation = idHabitation;
    }

    public Integer getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Integer idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Date disponibilite) {
        this.disponibilite = disponibilite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Set<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservations> reservations) {
        this.reservations = reservations;
    }

    public Set<Disponibilites> getDisponibilites() {
        return disponibilites;
    }

    public void setDisponibilites(Set<Disponibilites> disponibilites) {
        this.disponibilites = disponibilites;
    }
}
