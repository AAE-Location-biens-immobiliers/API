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
    public ResponseEntity<?> save(@RequestBody Avis avis, @RequestParam(value = "idCompte",required = false) Integer idCompte, @RequestParam("idWriter") int idWriter, @RequestParam(value = "idlogement",required = false) Integer idlogement) {
        try{
            avisService.saveAvis(avis, idCompte, idWriter, idlogement);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Integer id) {
        avisService .deleteOneAvis(id);
    }

}
