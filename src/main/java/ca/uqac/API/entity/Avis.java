package ca.uqac.API.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Avis {
    @Id
    private Integer idAvis;
    private Integer idLogement;
    private String commentaire;
    private Integer etoile;
    private Integer idCompte;
    private Integer idWriter;


}
