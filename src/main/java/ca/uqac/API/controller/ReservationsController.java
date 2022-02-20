package ca.uqac.API.controller;

import ca.uqac.API.entity.Annonces;
import ca.uqac.API.entity.Disponibilites;
import ca.uqac.API.entity.Reservations;
import ca.uqac.API.service.DisponibilitesService;
import ca.uqac.API.service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/reservations")
public class ReservationsController {
    @Autowired
    private ReservationsService reservationsService;

    @Autowired
    private DisponibilitesService disponibilitesService;

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody HashMap<String, Object> body, @RequestParam("idLocataire") int idLocataire, @RequestParam("idAnnonce") int idAnnonce) {
        try {
            final Reservations reservation = new Reservations();
            final LinkedHashMap reservations = (LinkedHashMap) body.get("reservations");

            java.sql.Date debut = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse((String) reservations.get("dateReservationDebut")).getTime());
            java.sql.Date fin = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse((String) reservations.get("dateReservationFin")).getTime());

            reservation.setDateReservationDebut(debut);
            reservation.setDateReservationFin(fin);

            reservationsService.saveReservation(reservation, idLocataire, idAnnonce);

            Disponibilites dispo = new Disponibilites();
            Annonces a = new Annonces();
            a.setIdAnnonce(idAnnonce);
            dispo.setIdAnnonce(a);

            dispo.setDebut(debut);
            dispo.setFin(fin);

            disponibilitesService.saveDisponibilites(dispo);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Reservations>> getReservations(@RequestParam("id") int id) {
        try {
            final List<Reservations> reservations = reservationsService.getAllByIDLocataire(id);
            return ResponseEntity.ok(reservations);
        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
