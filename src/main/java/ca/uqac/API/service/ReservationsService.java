package ca.uqac.API.service;

import ca.uqac.API.entity.Annonces;
import ca.uqac.API.entity.Comptes;
import ca.uqac.API.entity.Reservations;
import ca.uqac.API.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ReservationsService {

    @Autowired
    private ReservationRepository reservationRepository;

    public void saveReservation(Reservations reservations, Integer idLocataire, Integer idAnnonce) {
        Comptes c = new Comptes();
        c.setId(idLocataire);

        Annonces a = new Annonces();
        a.setIdAnnonce(idAnnonce);

        reservations.setIdLocataire(c);
        reservations.setIdAnnonce(a);

        reservationRepository.save(reservations);
    }

    public List<Reservations> getAllByIDLocataire(int id) {
        return StreamSupport
                .stream(reservationRepository.findAll().spliterator(), false)
                .filter(r -> r.getIdLocataire().getId() == id)
                .toList();
    }
}
