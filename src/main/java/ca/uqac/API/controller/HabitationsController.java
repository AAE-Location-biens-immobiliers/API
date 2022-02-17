package ca.uqac.API.controller;

import ca.uqac.API.entity.Annonces;
import ca.uqac.API.entity.Avis;
import ca.uqac.API.entity.Disponibilites;
import ca.uqac.API.entity.Habitations;
import ca.uqac.API.service.HabitationsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/habitations")
public class HabitationsController {

    @Autowired
    private HabitationsService habitationsService;

    @PostMapping("/register")
    public ResponseEntity<?> add(@RequestBody Habitations habitation) {
        try {
            habitationsService.saveHabitation(habitation);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Habitations>> getAll(@RequestParam("id") int userId) {
        try {
            List<Habitations> habitations = habitationsService.getAllWithUserId(userId);
            return ResponseEntity.ok(habitations);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
