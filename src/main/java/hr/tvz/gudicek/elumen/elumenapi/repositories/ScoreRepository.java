package hr.tvz.gudicek.elumen.elumenapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.gudicek.elumen.elumenapi.entities.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

	public List<Score> findByUser_Id(int id);

	public List<Score> findByUser_facebookId(String facebookId);

	public Long countByUser_idAndSubject_id(int userId, int subjectId);

	public Score findByUser_idAndSubject_id(int userId, int subjectId);

}
