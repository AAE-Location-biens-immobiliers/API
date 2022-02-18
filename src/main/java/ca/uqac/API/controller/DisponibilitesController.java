package ca.uqac.API.controller;

import ca.uqac.API.entity.Annonces;
import ca.uqac.API.entity.Disponibilites;
import ca.uqac.API.service.DisponibilitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/disponibilites")
public class DisponibilitesController {
    @Autowired
    private DisponibilitesService disponibilitesServices;

    @PostMapping("/register")
    public ResponseEntity<?> save(@RequestBody Disponibilites disponibilites, @RequestParam("idAnnonce") int idAnnonce) {
        try {
            disponibilitesServices.saveDisponibilites(disponibilites, idAnnonce);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Annonces>> getAnnounceForDisponibility (@RequestBody Disponibilites disponibility) {
        try {
            List<Annonces> announces = disponibilitesServices.getAllAnnounceWithDisponibility(disponibility);
            return ResponseEntity.ok(announces);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
