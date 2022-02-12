package ca.uqac.API.service;

import ca.uqac.API.entity.Habitations;
import ca.uqac.API.repository.HabitationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class HabitationsService {

    @Autowired
    private HabitationsRepository habitationsRepository;

    public List<Habitations> getAllWithUserId(int userId) {
        return StreamSupport
                .stream(habitationsRepository.findAll().spliterator(), false)
                .filter(e -> e.getIdPersonne().getId() == userId)
                .toList();
    }
}
