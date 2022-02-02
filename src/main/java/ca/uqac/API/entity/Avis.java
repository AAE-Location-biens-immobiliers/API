package ca.uqac.API.entity;

import javax.persistence.*;

@Entity
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

    public Habitations getIdLogement() {
        return idLogement;
    }

    public void setIdLogement(Habitations idLogement) {
        this.idLogement = idLogement;
    }

    public Comptes getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Comptes idCompte) {
        this.idCompte = idCompte;
    }

    public Integer getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(Integer idAvis) {
        this.idAvis = idAvis;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Integer getEtoile() {
        return etoile;
    }

    public void setEtoile(Integer etoile) {
        this.etoile = etoile;
    }

    public Comptes getIdWriter() {
        return idWriter;
    }

    public void setIdWriter(Comptes idWriter) {
        this.idWriter = idWriter;
    }
}
