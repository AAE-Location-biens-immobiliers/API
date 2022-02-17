package ca.uqac.API.service;

import ca.uqac.API.entity.Comptes;
import ca.uqac.API.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    public void saveCompte(Comptes comptes) {
        compteRepository.save(comptes);
    }

    public void deleteCompte(Integer id) {
        compteRepository.deleteById(id);
    }

    public Comptes getCompte(String email, String password) throws NoSuchElementException {
        Iterator<Comptes> compteIterator = StreamSupport
                .stream(compteRepository.findAll().spliterator(), false)
                .filter(c -> c.getEmail().equals(email) && c.getPassword().equals(password))
                .iterator();
        if (compteIterator.hasNext()){
            return compteIterator.next();
        } else throw new NoSuchElementException();
    }


    public void updateAnnonce(Comptes updateCompte) throws Exception {
        Optional<Comptes> compte = compteRepository.findById(updateCompte.getId());
        if(compte.isEmpty()){
            throw new Exception();
        }
        updateCompte.setAvis(compte.get().getAvis());
        updateCompte.setAvisWritten((compte.get().getAvisWritten()));
        updateCompte.setHabitations(compte.get().getHabitations());
        updateCompte.setFactures(compte.get().getFactures());
        updateCompte.setReservations(compte.get().getReservations());
        saveCompte(updateCompte);
    }
}



















