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
}
