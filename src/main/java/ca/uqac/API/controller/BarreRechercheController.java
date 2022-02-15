package ca.uqac.API.controller;

import ca.uqac.API.entity.Annonces;
import ca.uqac.API.entity.Avis;
import ca.uqac.API.entity.Disponibilites;
import ca.uqac.API.entity.Habitations;
import ca.uqac.API.repository.HabitationsRepository;
import ca.uqac.API.service.AnnoncesService;
import ca.uqac.API.service.HabitationsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSException;

import java.util.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/search")
public class BarreRechercheController {
    @Autowired
    private HabitationsService habitationsService;
    @Autowired
    private AnnoncesService annoncesService;

    @GetMapping("/")
    public ResponseEntity<List<Annonces>> getAvisFromOneIdAnnounce (@RequestBody JSONObject body) {
        try {
            List<Annonces> annonces = habitationsService.getAllHabitationsForSearchTool(body.getString("pays"), body.getInt("nbPlace"));
            ArrayList<Annonces> valideAnnonces = new ArrayList<>();
            for (Annonces annonce : annonces){
                for (Disponibilites d : annonce.getDisponibilites()){
                    if (d.getDebut().equals(body.getString("debut")) && d.getDebut().equals(body.getString("fin"))){
                        valideAnnonces.add(annonce);
                    }
                }
            }
            return ResponseEntity.ok(valideAnnonces);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
