package ca.uqac.API.service;

import ca.uqac.API.entity.Annonces;
import ca.uqac.API.entity.Avis;
import ca.uqac.API.entity.Disponibilites;
import ca.uqac.API.entity.Habitations;
import ca.uqac.API.repository.AnnoncesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class AnnoncesService {

    @Autowired
    private AnnoncesRepository annoncesRepository;

    public void saveAnnonce(Annonces annonces){
        annoncesRepository.save(annonces);
    }

    public Set<Avis> getAllAvisWithIdAnnounce(int idAnnounce) throws Exception {
        Optional<Annonces> find = annoncesRepository.findById(idAnnounce);
        if (find.isEmpty()) {
            throw new Exception();
        }
        Annonces found = find.get();
        return found.getIdHabitation().getAvis();
    }

    public List<Annonces> search(String ville) {
        return  StreamSupport
                .stream(annoncesRepository.findAll().spliterator(), false)
                .filter(a -> a.getIdHabitation().getVille().equals(ville))
                .toList();
    }
}
