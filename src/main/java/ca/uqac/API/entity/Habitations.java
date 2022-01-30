package ca.uqac.API.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@Entity
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
    @JoinColumn(name = "idpersonne")
    private Comptes idPersonne;

    @OneToMany(mappedBy = "idHabitation")
    private Set<Annonces> annonces;

    @OneToMany(mappedBy = "idLogement")
    private Set<Avis> avis;

    public Comptes getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Comptes idPersonne) {
        this.idPersonne = idPersonne;
    }
}
