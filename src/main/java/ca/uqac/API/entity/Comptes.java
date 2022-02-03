package ca.uqac.API.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Comptes {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String identifiant;
    @Column(unique = true, nullable = false)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getLocataire() {
        return locataire;
    }

    public void setLocataire(Boolean locataire) {
        this.locataire = locataire;
    }

    public Set<Avis> getAvis() {
        return avis;
    }

    public void setAvis(Set<Avis> avis) {
        this.avis = avis;
    }

    public Set<Avis> getAviswritten() {
        return aviswritten;
    }

    public void setAviswritten(Set<Avis> aviswritten) {
        this.aviswritten = aviswritten;
    }

    public Set<Habitations> getHabitations() {
        return habitations;
    }

    public void setHabitations(Set<Habitations> habitations) {
        this.habitations = habitations;
    }

    public Set<Factures> getFactures() {
        return factures;
    }

    public void setFactures(Set<Factures> factures) {
        this.factures = factures;
    }

    public Set<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservations> reservations) {
        this.reservations = reservations;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
}
