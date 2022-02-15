package ca.uqac.API.controller;

import ca.uqac.API.entity.Annonces;
import ca.uqac.API.entity.Avis;
import ca.uqac.API.entity.Comptes;
import ca.uqac.API.entity.Disponibilites;
import ca.uqac.API.service.AnnoncesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/annonces")
public class AnnoncesController {

    @Autowired
    private AnnoncesService annoncesService;

    @PostMapping("/register")
    public ResponseEntity<?> add(@RequestBody Annonces annonces) {
        try {
            annoncesService.saveAnnonce(annonces);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/avis")
    public ResponseEntity<List<Avis>> getAvisFromOneIdAnnounce (@RequestParam("idAnnounce") int idAnnounce) {
        try {
            Set<Avis> avis = annoncesService.getAllAvisWithIdAnnounce(idAnnounce);
            return ResponseEntity.ok(avis.stream().toList());
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}