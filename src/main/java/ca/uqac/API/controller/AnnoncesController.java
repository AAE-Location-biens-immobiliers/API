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

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @GetMapping("/search")
    public ResponseEntity<List<Annonces>> getAnnoncesSearch (@RequestParam(value = "ville") String ville, @RequestParam(value = "debut",required = false)Date debut, @RequestParam(value = "fin",required = false)Date fin, @RequestParam(value = "nbPersonne",required = false) Integer nbPersonne){
        try {
            List<Annonces> annonces = annoncesService.search(ville);
            if (debut != null && fin != null){
                annonces = annonces.stream()
                        .filter(a -> a.getDisponibilites().stream().anyMatch(d -> d.getDebut().equals(debut) && d.getFin().equals(fin)))
                        .toList();
            }
            if(nbPersonne != null){
                annonces = annonces.stream().filter(a -> a.getNombrePlace() == nbPersonne).toList();
            }
            return ResponseEntity.ok(annonces);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAnnonce(@RequestBody Annonces annonces){
        try {
            annoncesService.updateAnnonce(annonces);
            return new ResponseEntity<>(HttpStatus.OK);
        }  catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAnnonce(@PathVariable Integer id) {
        annoncesService .deleteAnnonce(id);
    }
}