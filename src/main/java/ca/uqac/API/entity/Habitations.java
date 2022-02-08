package ca.uqac.API.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Habitations {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idHabitation;
    private String description;
    private float longitude;
    private float latitude;
    private String pays;
    private Integer numero;
    private Integer code;
    private String rue;
    private String ville;
    private byte[] photo;
    private Boolean wifi;
    private Boolean lave_linge;
    private Boolean seche_linge;
    private Boolean climatisation;
    private Boolean parking;
    private Boolean tv;
    private Boolean cuisine;

    @ManyToOne
    @JoinColumn(name = "id_personne")
    private Comptes idPersonne;

    @OneToMany(mappedBy = "idHabitation")
    private Set<Annonces> annonces;

    @OneToMany(mappedBy = "idLogement")
    private Set<Avis> avis;
}
