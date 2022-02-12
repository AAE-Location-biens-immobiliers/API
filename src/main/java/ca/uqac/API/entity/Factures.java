package ca.uqac.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"idCompteUtilisateur", "idReservation"})
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
