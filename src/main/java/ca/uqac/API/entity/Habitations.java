package ca.uqac.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"idPersonne", "annonces", "avis"})
public class Habitations {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idHabitation;
    private String description;
    private double longitude;
    private double latitude;
    private String pays;
    private Integer numero;
    private Integer code;
    private String rue;
    private String ville;
    @Lob
    @Column(columnDefinition="MEDIUMBLOB", length = 2000000)
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

    @OneToMany(mappedBy = "idHabitation", cascade = CascadeType.ALL)
    private Set<Annonces> annonces;

    @OneToMany(mappedBy = "idLogement")
    private Set<Avis> avis;
}
