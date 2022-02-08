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

    public Integer getIdDisponibilite() {
        return idDisponibilite;
    }

    public void setIdDisponibilite(Integer idDisponibilite) {
        this.idDisponibilite = idDisponibilite;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Annonces getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Annonces idAnnonce) {
        this.idAnnonce = idAnnonce;
    }
}
