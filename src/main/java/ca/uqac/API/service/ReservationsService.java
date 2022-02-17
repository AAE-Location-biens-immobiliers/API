package ca.uqac.API.service;

import ca.uqac.API.entity.Annonces;
import ca.uqac.API.entity.Avis;
import ca.uqac.API.entity.Reservations;
import ca.uqac.API.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class ReservationsService {
    @Autowired
    private ReservationRepository reservationRepository;

    public void saveReservation(Reservations reservations){
        reservationRepository.save(reservations);
    }


}
