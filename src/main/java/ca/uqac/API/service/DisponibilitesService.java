package ca.uqac.API.service;

import ca.uqac.API.entity.Annonces;
import ca.uqac.API.entity.Disponibilites;
import ca.uqac.API.repository.DisponibilitesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class DisponibilitesService {

    @Autowired
    private DisponibilitesRepository disponibilitesRepository;

    public void saveDisponibilites(Disponibilites disponibilites){
        disponibilitesRepository.save(disponibilites);
    }


    public List<Annonces> getAllAnnounceWithDisponibility (Disponibilites disponibility){
        return (List<Annonces>) StreamSupport
                .stream(disponibilitesRepository.findAll().spliterator(), false)
                .filter(e -> e.getDebut().equals(disponibility.getDebut()) && e.getFin().equals(disponibility.getFin()))
                .map(e -> e.getIdAnnonce())
                .toList();
    }
}
