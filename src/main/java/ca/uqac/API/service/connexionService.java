package ca.uqac.API.service;

import ca.uqac.API.entity.Comptes;
import ca.uqac.API.repository.ConnexionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class connexionService {

    @Autowired
    private ConnexionRepository connexionRepository;

    public void saveCompte(Comptes comptes) {
        connexionRepository.save(comptes);
    }

    public Comptes getCompte(String email, String password) throws NoSuchElementException {
        Iterator<Comptes> compteIterator = StreamSupport
                .stream(connexionRepository.findAll().spliterator(), false)
                .filter(c -> c.getEmail().equals(email) && c.getPassword().equals(password))
                .iterator();
        if (compteIterator.hasNext()){
            return compteIterator.next();
        } else throw new NoSuchElementException();
    }

    public void deleteCompte(Integer id) {
        connexionRepository.deleteById(id);
    }

}



















