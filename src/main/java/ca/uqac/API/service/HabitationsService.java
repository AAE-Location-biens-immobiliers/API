package ca.uqac.API.service;

import ca.uqac.API.entity.Annonces;
import ca.uqac.API.entity.Avis;
import ca.uqac.API.entity.Habitations;
import ca.uqac.API.repository.HabitationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class HabitationsService {

    @Autowired
    private HabitationsRepository habitationsRepository;

    public void saveHabitation(Habitations habitation){
        habitationsRepository.save(habitation);
    }

    public List<Habitations> getAllWithUserId(int userId) {
        return StreamSupport
                .stream(habitationsRepository.findAll().spliterator(), false)
                .filter(e -> e.getIdPersonne().getId() == userId)
                .toList();
    }

    public List<Annonces> getAllAnnoncesWithIdHabitation(int idHabitations) throws Exception {
        Optional<Habitations> habitation = habitationsRepository.findById(idHabitations);
        if (habitation.isEmpty()){
            throw new Exception();
        }
        return habitation.get().getAnnonces().stream().toList();
    }
}
