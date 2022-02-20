package ca.uqac.API.service;

import ca.uqac.API.entity.Disponibilites;
import ca.uqac.API.repository.DisponibilitesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class DisponibilitesService {
    @Autowired
    private DisponibilitesRepository disponibilitesRepository;

    public void saveDisponibilites(Disponibilites disponibilites) {
        List<Disponibilites> all = StreamSupport
                .stream(disponibilitesRepository.findAll().spliterator(), false)
                .filter(d -> Objects.equals(d.getIdAnnonce().getIdAnnonce(), disponibilites.getIdAnnonce().getIdAnnonce()))
                .toList();
        Disponibilites dispo;
        if(all.size() == 1) {
            dispo = all.get(0);
        } else {
            Optional<Disponibilites> optional = all
                    .stream()
                    .filter(d -> d.getDebut().compareTo(disponibilites.getDebut()) <= 0 && d.getFin().compareTo(disponibilites.getFin()) >= 0)
                    .findFirst();
            if(optional.isPresent()) dispo = optional.get();
            else throw new Error();
        }
        Date fin = dispo.getFin();
        dispo.setFin(disponibilites.getDebut());
        disponibilitesRepository.save(disponibilites);
        disponibilites.setDebut(disponibilites.getFin());
        disponibilites.setFin(fin);
        disponibilitesRepository.save(disponibilites);
    }

}
