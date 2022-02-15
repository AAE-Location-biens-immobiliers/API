package ca.uqac.API.repository;

import ca.uqac.API.entity.Annonces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnoncesRepository extends CrudRepository<Annonces, Integer> {
}