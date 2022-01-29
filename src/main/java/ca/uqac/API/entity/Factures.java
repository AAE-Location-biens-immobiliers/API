package ca.uqac.API.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Factures {
    @Id
    private Integer idFactures;
    private Integer idPaiement;
    private Integer idReservation;
    private Integer idCompteUtilisateur;


}
