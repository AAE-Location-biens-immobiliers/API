package ca.uqac.API.service;

import ca.uqac.API.entity.Avis;
import ca.uqac.API.entity.Comptes;
import ca.uqac.API.entity.Habitations;
import ca.uqac.API.repository.AvisRepository;
import ca.uqac.API.repository.CompteRepository;
import ca.uqac.API.repository.HabitationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AvisService {
    @Autowired
    private AvisRepository avisRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private HabitationsRepository habitationsRepository;

    public void saveAvis(Avis avis, int idCompte, int idWriter, int idLogement) throws Exception {
        Optional<Comptes> compte = compteRepository.findById(idCompte);
        Optional<Comptes> compteWriter = compteRepository.findById(idWriter);
        Optional<Habitations> logement = habitationsRepository.findById(idLogement);
        if (compteWriter.isEmpty() ){
            throw new Exception();
        }
        if (compte.isEmpty() && logement.isEmpty()){
            throw new Exception();
        }
        avis.setIdLogement(logement.get());
        avis.setIdCompte(compte.get());
        avis.setIdWriter(compteWriter.get());
        avisRepository.save(avis);
    }

    public void deleteOneAvis(Integer id) {
        avisRepository.deleteById(id);
    }
}
