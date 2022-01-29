package ca.uqac.API.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Disponibilites {
    @Id
    private Integer idDisponibilite;
    private Integer idAnnonce;
    private Date debut;
    private Date fin;


}
