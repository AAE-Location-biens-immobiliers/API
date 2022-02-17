package ca.uqac.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private float prix;
    private int nombrePlace;

    @OneToMany(mappedBy = "idAnnonce",cascade = CascadeType.ALL)
    private Set<Reservations> reservations;

    @OneToMany(mappedBy = "idAnnonce", cascade = CascadeType.ALL)
    private Set<Disponibilites> disponibilites;

    @ManyToOne
    @JoinColumn(name = "idhabitation")
    private Habitations idHabitation;
}
