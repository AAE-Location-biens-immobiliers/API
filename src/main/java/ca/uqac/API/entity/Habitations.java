package ca.uqac.API.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Habitations {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idHabitation;
    private String description;
    private float longitude;
    private float latitude;
    private String pays;
    private Integer numero;
    private Integer code;
    private String rue;
    private String ville;
    private byte[] photo;
    private Boolean wifi;
    private Boolean lave_linge;
    private Boolean seche_linge;
    private Boolean climatisation;
    private Boolean parking;
    private Boolean tv;
    private Boolean cuisine;

    @ManyToOne()
    @JoinColumn(name = "idpersonne")
    private Comptes idPersonne;

    @OneToMany(mappedBy = "idHabitation")
    private Set<Annonces> annonces;

    @OneToMany(mappedBy = "idLogement")
    private Set<Avis> avis;

    /*public Comptes getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Comptes idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Integer getIdHabitation() {
        return idHabitation;
    }

    public void setIdHabitation(Integer idHabitation) {
        this.idHabitation = idHabitation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getLave_linge() {
        return lave_linge;
    }

    public void setLave_linge(Boolean lave_linge) {
        this.lave_linge = lave_linge;
    }

    public Boolean getSeche_linge() {
        return seche_linge;
    }

    public void setSeche_linge(Boolean seche_linge) {
        this.seche_linge = seche_linge;
    }

    public Boolean getClimatisation() {
        return climatisation;
    }

    public void setClimatisation(Boolean climatisation) {
        this.climatisation = climatisation;
    }

    public Boolean getParking() {
        return parking;
    }

    public void setParking(Boolean parking) {
        this.parking = parking;
    }

    public Boolean getTv() {
        return tv;
    }

    public void setTv(Boolean tv) {
        this.tv = tv;
    }

    public Boolean getCuisine() {
        return cuisine;
    }

    public void setCuisine(Boolean cuisine) {
        this.cuisine = cuisine;
    }

    public Set<Annonces> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(Set<Annonces> annonces) {
        this.annonces = annonces;
    }

    public Set<Avis> getAvis() {
        return avis;
    }

    public void setAvis(Set<Avis> avis) {
        this.avis = avis;
    }*/
}
