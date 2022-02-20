package ca.uqac.API.repository;

import ca.uqac.API.entity.Disponibilites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilitesRepository extends CrudRepository<Disponibilites, Integer> {
}
