package ca.uqac.API.service;

import ca.uqac.API.entity.Annonces;
import ca.uqac.API.entity.Comptes;
import ca.uqac.API.entity.Habitations;
import ca.uqac.API.repository.HabitationsRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

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

    public void modifierHabitation(@NotNull Habitations h) throws Exception {
        final Optional<Habitations> find = habitationsRepository.findById(h.getIdHabitation());
        if (find.isEmpty())
            throw new Exception();
        final Habitations found = find.get();
        h.setIdPersonne(found.getIdPersonne());
        h.setAnnonces(found.getAnnonces());
        h.setAvis(found.getAvis());
        habitationsRepository.save(h);
    }

    public void deleteById(int id) {
        habitationsRepository.deleteById(id);
    }

    public Habitations ajouterHabitation(Habitations habitation, int idPersonne) {
        final Comptes personne = new Comptes();
        personne.setId(idPersonne);
        habitation.setIdPersonne(personne);
        return habitationsRepository.save(habitation);
    }

    public List<Annonces> getAllAnnoncesWithIdHabitation(int idHabitations) throws Exception {
        Optional<Habitations> habitation = habitationsRepository.findById(idHabitations);
        if (habitation.isEmpty()){
            throw new Exception();
        }
        return habitation.get().getAnnonces().stream().toList();
    }
}
