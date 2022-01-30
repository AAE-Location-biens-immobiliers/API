package ca.uqac.API.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Comptes {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String password;
    private String nom;
    private String prenom;
    private String tel;
    private String email;
    private Boolean locataire;

    @OneToMany(mappedBy = "idCompte")
    private Set<Avis> avis;

    @OneToMany(mappedBy = "idWriter")
    private Set<Avis> aviswritten;

    @OneToMany(mappedBy = "idPersonne")
    private Set<Habitations> habitations;

    @OneToMany(mappedBy = "idCompteUtilisateur")
    private Set<Factures> factures;

    @OneToMany(mappedBy = "idLocataire")
    private Set<Reservations> reservations;


}
