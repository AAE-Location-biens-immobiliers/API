package ca.uqac.API.controller;

import ca.uqac.API.entity.Habitations;
import ca.uqac.API.service.HabitationsService;
import ca.uqac.API.utils.Base64Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @PutMapping(value = "")
    public ResponseEntity<?> putHabitation(@RequestBody HashMap<String, Object> body) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            final Habitations habitation = mapper.readValue(new Gson().toJson(body.get("habitation")), Habitations.class);

            final String photoBase64 = (String) body.get("photo");
            if (photoBase64 != null) {
                final byte [] photo = Base64Utils.base64ToByteArray(photoBase64);
                if(photo.length > 2000000) throw new DataIntegrityViolationException("");
                habitation.setPhoto(photo);
            }

            habitationsService.modifierHabitation(habitation);

            return ResponseEntity.ok(null);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.PAYLOAD_TOO_LARGE);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteById(@RequestParam("id") int id) {
        try {
            habitationsService.deleteById(id);
            return ResponseEntity.ok(null);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> postHabitation(@RequestBody HashMap<String, Object> body, @RequestParam("idPersonne") int idPersonne) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            final Habitations habitation = mapper.readValue(new Gson().toJson(body.get("habitation")), Habitations.class);

            final String photoBase64 = (String) body.get("photo");
            if (photoBase64 != null) {
                final byte [] photo = Base64Utils.base64ToByteArray(photoBase64);
                if(photo.length > 2000000) throw new DataIntegrityViolationException("");
                habitation.setPhoto(photo);
            }



            final Habitations hab = habitationsService.ajouterHabitation(habitation, idPersonne);
            return ResponseEntity.ok(hab);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.PAYLOAD_TOO_LARGE);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
