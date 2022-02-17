package ca.uqac.API.service;

import ca.uqac.API.entity.Avis;
import ca.uqac.API.entity.Reservations;
import ca.uqac.API.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class AvisService {
    @Autowired
    private AvisRepository avisRepository;

    public void saveAvis(Avis avis){
        avisRepository.save(avis);
    }
}
