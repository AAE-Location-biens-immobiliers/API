package ca.uqac.API.entity;

import javax.persistence.*;

@Entity
public class Factures {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idFactures;
    private Integer idPaiement;

    public Integer getIdFactures() {
        return idFactures;
    }

    public void setIdFactures(Integer idFactures) {
        this.idFactures = idFactures;
    }

    public Integer getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(Integer idPaiement) {
        this.idPaiement = idPaiement;
    }

    @ManyToOne
    @JoinColumn(name = "idcompteutilisateur")
    private Comptes idCompteUtilisateur;

    @ManyToOne
    @JoinColumn(name = "idreservation")
    private Reservations idReservation;

    public Reservations getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Reservations idReservation) {
        this.idReservation = idReservation;
    }

    public Comptes getIdCompteUtilisateur() {
        return idCompteUtilisateur;
    }

    public void setIdCompteUtilisateur(Comptes idCompteUtilisateur) {
        this.idCompteUtilisateur = idCompteUtilisateur;
    }


}
