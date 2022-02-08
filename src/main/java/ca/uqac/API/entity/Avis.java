package ca.uqac.API.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Avis {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idAvis;
    private String commentaire;
    private Integer etoile;

    @ManyToOne
    @JoinColumn(name = "idWriter")
    private Comptes idWriter;


    @ManyToOne
    @JoinColumn(name = "idcompte")
    private Comptes idCompte;

    @ManyToOne
    @JoinColumn(name = "idlogement")
    private Habitations idLogement;
}
