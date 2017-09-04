package hr.tvz.gudicek.elumen.elumenapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.gudicek.elumen.elumenapi.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	public List<Question> findBySubject_id(int id);

}
