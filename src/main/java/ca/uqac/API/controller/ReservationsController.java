package ca.uqac.API.controller;

import ca.uqac.API.entity.Reservations;
import ca.uqac.API.service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/reservations")
public class ReservationsController {
    @Autowired
    private ReservationsService reservationsService;

    @PostMapping("/register")
    public ResponseEntity<?> add(@RequestBody Reservations reservations) {
        try {
            reservationsService.saveReservation(reservations);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
