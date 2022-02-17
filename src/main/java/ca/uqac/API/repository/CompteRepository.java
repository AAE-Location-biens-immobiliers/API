package ca.uqac.API.repository;

import ca.uqac.API.entity.Comptes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends CrudRepository<Comptes, Integer> {
}