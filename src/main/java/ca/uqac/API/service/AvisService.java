package ca.uqac.API.service;

import ca.uqac.API.entity.Avis;
import ca.uqac.API.entity.Comptes;
import ca.uqac.API.entity.Habitations;
import ca.uqac.API.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AvisService {

    @Autowired
    private AvisRepository avisRepository;

    public Avis saveAvis(Avis avis, Integer idCompte, int idWriter, Integer idLogement) {

        if (idCompte != null) {
            Comptes compte = new Comptes();
            compte.setId(idCompte);
            avis.setIdCompte(compte);
        }

        if(idLogement != null) {
            Habitations logement = new Habitations();
            logement.setIdHabitation(idLogement);
            avis.setIdLogement(logement);
        }

        Comptes compteWriter = new Comptes();
        compteWriter.setId(idWriter);

        avis.setIdWriter(compteWriter);
        return avisRepository.save(avis);
    }

    public void deleteOneAvis(Integer id) {
        avisRepository.deleteById(id);
    }
}
