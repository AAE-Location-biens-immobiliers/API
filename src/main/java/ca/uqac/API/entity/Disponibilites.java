package ca.uqac.API.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Disponibilites {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idDisponibilite;
    private Date debut;
    private Date fin;


    @ManyToOne
    @JoinColumn(name = "idannonce")
    private Annonces idAnnonce;

    public Annonces getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Annonces idAnnonce) {
        this.idAnnonce = idAnnonce;
    }
}
