package ca.uqac.API.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Factures {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idFactures;
    private Integer idPaiement;

    @ManyToOne
    @JoinColumn(name = "idcompteutilisateur")
    private Comptes idCompteUtilisateur;

    @ManyToOne
    @JoinColumn(name = "idreservation")
    private Reservations idReservation;
}
