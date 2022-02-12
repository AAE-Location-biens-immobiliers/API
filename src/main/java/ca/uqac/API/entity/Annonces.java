package ca.uqac.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"reservations", "disponibilites", "idHabitation"})
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
}
