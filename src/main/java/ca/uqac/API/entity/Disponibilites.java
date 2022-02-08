package ca.uqac.API.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
public class Disponibilites {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idDisponibilite;
    private Date debut;
    private Date fin;

    @ManyToOne
    @JoinColumn(name = "idannonce")
    private Annonces idAnnonce;
}
