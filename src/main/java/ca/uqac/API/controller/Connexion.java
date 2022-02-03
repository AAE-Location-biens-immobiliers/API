package ca.uqac.API.controller;

import ca.uqac.API.entity.Comptes;
import ca.uqac.API.service.connexionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:8080/api")
@RequestMapping("/connexion")
public class Connexion {
    @Autowired
    connexionService connexionService;

    @PostMapping("/new_account")
    public @ResponseBody String add(@RequestBody Comptes comptes) {
        connexionService.saveCompte(comptes);
        return "Saved";
    }

    @GetMapping("/login")
    public ResponseEntity<Comptes> ValidateConnection(@RequestParam("identifiant") String identifiant, @RequestParam("password") String password) {
        try {
            Comptes comptes = connexionService.getCompte(identifiant, password);
            return new ResponseEntity<>(comptes, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
