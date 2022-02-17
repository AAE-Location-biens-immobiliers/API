package ca.uqac.API.repository;

import ca.uqac.API.entity.Reservations;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservations, Integer> {
}
