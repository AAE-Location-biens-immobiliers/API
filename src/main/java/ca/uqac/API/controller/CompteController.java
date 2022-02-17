package ca.uqac.API.controller;

import ca.uqac.API.entity.Comptes;
import ca.uqac.API.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/connexion")
public class CompteController {
    @Autowired
    private CompteService compteService;

    @PostMapping("/register")
    public ResponseEntity<?> add(@RequestBody Comptes comptes) {
        try {
            compteService.saveCompte(comptes);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<Comptes> ValidateConnection(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            Comptes comptes = compteService.getCompte(email, password);
            comptes.setPassword("");
            return new ResponseEntity<>(comptes, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Comptes comptes) {
        try {
            compteService.updateAnnonce(comptes);
            return new ResponseEntity<>(HttpStatus.OK);
        }  catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Integer id) {
        compteService.deleteCompte(id);
    }
}
