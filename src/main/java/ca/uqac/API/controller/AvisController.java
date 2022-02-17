package ca.uqac.API.controller;

import ca.uqac.API.entity.Avis;
import ca.uqac.API.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/avis")
public class AvisController {
    @Autowired
    private AvisService avisService;

    @PostMapping("/register")
    public ResponseEntity<?> add(@RequestBody Avis avis) {
        try{
            avisService.saveAvis(avis);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
