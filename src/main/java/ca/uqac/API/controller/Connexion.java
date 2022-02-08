package ca.uqac.API.controller;

import ca.uqac.API.entity.Comptes;
import ca.uqac.API.service.connexionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/connexion")
public class Connexion {
    @Autowired
    connexionService connexionService;

    @PostMapping("/register")
    public ResponseEntity add(@RequestBody Comptes comptes) {
        try {
            connexionService.saveCompte(comptes);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<Comptes> ValidateConnection(@RequestParam("identifiant") String identifiant, @RequestParam("password") String password) {
        try {
            Comptes comptes = connexionService.getCompte(identifiant, password);
            comptes.setPassword("");
            return new ResponseEntity<>(comptes, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody Comptes comptes, @PathVariable Integer id) {
        try {
            comptes.setId(id);
            connexionService.saveCompte(comptes);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Integer id) {
        connexionService.deleteCompte(id);
    }
}
