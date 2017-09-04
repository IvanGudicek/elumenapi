package hr.tvz.gudicek.elumen.elumenapi.services;

import java.math.BigDecimal;
import java.util.List;

import hr.tvz.gudicek.elumen.elumenapi.entities.Score;

public interface ScoreService {

	public Score saveOrUpdate(Score entity);

	public void delete(int id);

	public Score get(int id);

	public List<Score> findAll();

	public List<Score> getByUserId(int id);

	public List<Score> getByUserFacebookId(String facebookId);

	public Score updateScoreQuiz(BigDecimal score, int userId, int subjectId);
}
