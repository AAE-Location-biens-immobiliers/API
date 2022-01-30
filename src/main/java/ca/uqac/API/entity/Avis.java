package ca.uqac.API.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avis {
    @Id
    private Integer idAvis;
    private Integer idLogement;
    private String commentaire;
    private Integer etoile;
    private Integer idCompte; // rendu inutile par ce qui est écrit en dessous
    private Integer idWriter;


    @ManyToOne
    @JoinColumn(name = "comptes_id",nullable = false)
    private Comptes comptes;

    public Comptes getComptes() { //auto generated
        return comptes;
    }

    public void setComptes(Comptes comptes) { // auto generated
        this.comptes = comptes;
    }
}
