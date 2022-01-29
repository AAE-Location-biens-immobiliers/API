package ca.uqac.API.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Annonces {
    @Id
    private Integer idAnnonce;
    private Integer idHabitation;
    private String description;
    private Date disponibilite;
    private float prix;
}
