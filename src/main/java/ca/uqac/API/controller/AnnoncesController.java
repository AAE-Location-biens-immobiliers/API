package ca.uqac.API.controller;

import ca.uqac.API.entity.Annonces;
import ca.uqac.API.entity.Avis;
import ca.uqac.API.service.AnnoncesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/annonces")
public class AnnoncesController {

    @Autowired
    private AnnoncesService annoncesService;

    @PostMapping("")
    public ResponseEntity<Annonces> add(@RequestBody Annonces annonces) {
        try {
            final Annonces a = annoncesService.saveAnnonce(annonces);
            return ResponseEntity.ok(a);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/avis")
    public ResponseEntity<List<Avis>> getAvisFromOneIdAnnounce(@RequestParam("idAnnounce") int idAnnounce) {
        try {
            Set<Avis> avis = annoncesService.getAllAvisWithIdAnnounce(idAnnounce);
            return ResponseEntity.ok(avis.stream().toList());
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/search")
    public ResponseEntity<List<Annonces>> getAnnoncesSearch (@RequestParam(value = "ville") String ville, @RequestParam(value = "debut",required = false) String debut, @RequestParam(value = "fin",required = false) String fin, @RequestParam(value = "nbPersonne",required = false) Integer nbPersonne){
        try {
            List<Annonces> annonces = annoncesService.search(ville);
            if (debut != null && fin != null) {
                final Date debut_ = new SimpleDateFormat("yyyy-MM-dd").parse(debut);
                final Date fin_ = new SimpleDateFormat("yyyy-MM-dd").parse(fin);
                annonces = annonces.stream()
                        .filter(a -> a.getDisponibilites().stream().anyMatch(d -> {
                            final Date debutSQL = new Date(d.getDebut().getTime());
                            final Date finSQL = new Date(d.getFin().getTime());
                            return debutSQL.compareTo(debut_) <= 0 && finSQL.compareTo(fin_) >= 0;
                        })).toList();
            }
            if(nbPersonne != null){
                annonces = annonces.stream().filter(a -> a.getNombrePlace() == nbPersonne).toList();
            }
            return ResponseEntity.ok(annonces);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("")
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

    @GetMapping("/user")
    public ResponseEntity<List<Annonces>> getAllAnnoncesForIdUser(@RequestParam("id") int id){
        try {
            List<Annonces> annonces = annoncesService.getAllAnnoncesWithIdUser(id);
            return ResponseEntity.ok(annonces);
        }  catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("")
    public void deleteAnnonce(@RequestParam("id") Integer id) {
        annoncesService.deleteAnnonce(id);
    }
}


