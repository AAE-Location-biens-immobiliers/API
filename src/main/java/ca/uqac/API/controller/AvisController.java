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

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Avis avis, @RequestParam(value = "idCompte",required = false) Integer idCompte, @RequestParam("idWriter") int idWriter, @RequestParam(value = "idLogement",required = false) Integer idLogement) {
        try{
            Avis newAvis = avisService.saveAvis(avis, idCompte, idWriter, idLogement);
            return ResponseEntity.ok(newAvis);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("")
    public void deleteAccount(@RequestParam("id") Integer id) {
        avisService.deleteOneAvis(id);
    }

}
