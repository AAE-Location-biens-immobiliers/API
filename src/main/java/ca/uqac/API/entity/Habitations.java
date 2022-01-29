package ca.uqac.API.entity;


import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Habitations {
    @Id
    private Integer idHabitation;
    private Integer idPersonne;
    private String description;
    private float longitude;
    private float latitude;
    private String pays;
    private Integer numero;
    private Integer code;
    private String rue;
    private String ville;
    @Type(type="imageBlob")
    private Image photo;
    private Boolean wifi;
    private Boolean lave_linge;
    private Boolean seche_linge;
    private Boolean climatisation;
    private Boolean parking;
    private Boolean tv;
    private Boolean cuisine;

}
