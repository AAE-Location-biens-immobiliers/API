package ca.uqac.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"factures", "idLocataire", "idAnnonce"})
public class Reservations {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idReservation;
    private Date dateReservationDebut;
    private Date dateReservationFin;

    @OneToMany(mappedBy = "idReservation")
    private Set<Factures> factures;

    @ManyToOne
    @JoinColumn(name = "idlocataire")
    private Comptes idLocataire;

    @ManyToOne
    @JoinColumn(name = "idannonce")
    private Annonces idAnnonce;
}
