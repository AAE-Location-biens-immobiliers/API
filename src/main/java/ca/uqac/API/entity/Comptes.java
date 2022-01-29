package ca.uqac.API.entity;

import javax.persistence.*;

@Entity
public class Comptes {
    @Id
    @Column(unique = true, nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String password;
    private String nom;
    private String prenom;
    private String tel;
    private String email;
    private Boolean locataire;


}
