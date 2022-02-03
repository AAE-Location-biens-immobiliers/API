package ca.uqac.API.repository;

import ca.uqac.API.entity.Comptes;
import org.springframework.data.repository.CrudRepository;

public interface ConnexionRepository extends CrudRepository<Comptes, Integer> {
}