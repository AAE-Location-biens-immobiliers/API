package ca.uqac.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"avis", "avisWritten", "habitations", "factures", "reservations"})
public class Comptes {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String password;
    private String nom;
    private String prenom;
    private String tel;
    @Column(unique = true, nullable = false)
    private String email;
    private Boolean locataire;
    @Lob
    @Column(columnDefinition="MEDIUMBLOB", length = 2000000)
    private byte[] photo;

    @OneToMany(mappedBy = "idCompte")
    private Set<Avis> avis;

    @OneToMany(mappedBy = "idWriter")
    private Set<Avis> avisWritten;

    @OneToMany(mappedBy = "idPersonne")
    private Set<Habitations> habitations;

    @OneToMany(mappedBy = "idCompteUtilisateur")
    private Set<Factures> factures;

    @OneToMany(mappedBy = "idLocataire")
    private Set<Reservations> reservations;
}
