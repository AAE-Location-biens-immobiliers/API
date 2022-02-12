package ca.uqac.API.repository;

import ca.uqac.API.entity.Habitations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitationsRepository extends CrudRepository<Habitations, Integer> {}
