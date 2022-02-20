package ca.uqac.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@JsonIgnoreProperties("idAnnonce")
public class Disponibilites {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idDisponibilite;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date debut;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fin;

    @ManyToOne
    @JoinColumn(name = "idannonce")
    private Annonces idAnnonce;
}
