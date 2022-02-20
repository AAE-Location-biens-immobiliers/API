package ca.uqac.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"idCompte", "idLogement"})
public class Avis {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idAvis;
    private String commentaire;
    private Integer etoile;

    @ManyToOne
    @JoinColumn(name = "idWriter", nullable = false)
    private Comptes idWriter;

    @ManyToOne
    @JoinColumn(name = "idcompte", nullable = true)
    private Comptes idCompte;

    @ManyToOne
    @JoinColumn(name = "idlogement", nullable = true)
    private Habitations idLogement;

}
