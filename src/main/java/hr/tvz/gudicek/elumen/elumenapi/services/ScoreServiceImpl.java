package hr.tvz.gudicek.elumen.elumenapi.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.gudicek.elumen.elumenapi.entities.Score;
import hr.tvz.gudicek.elumen.elumenapi.repositories.ScoreRepository;
import hr.tvz.gudicek.elumen.elumenapi.repositories.SubjectRepository;
import hr.tvz.gudicek.elumen.elumenapi.repositories.UserRepository;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public Score saveOrUpdate(Score entity) {
		return scoreRepository.save(entity);
	}

	@Override
	public void delete(int id) {
		scoreRepository.delete(id);
	}

	@Override
	public Score get(int id) {
		return scoreRepository.findOne(id);
	}

	@Override
	public List<Score> findAll() {
		return scoreRepository.findAll();
	}

	@Override
	public List<Score> getByUserId(int id) {
		return scoreRepository.findByUser_Id(id);
	}

	@Override
	public List<Score> getByUserFacebookId(String facebookId) {
		return scoreRepository.findByUser_facebookId(facebookId);
	}

	@Override
	public Score updateScoreQuiz(BigDecimal quizScore, int userId, int subjectId) {
		if (scoreRepository.countByUser_idAndSubject_id(userId, subjectId) > 0) {
			Score score = scoreRepository.findByUser_idAndSubject_id(userId, subjectId);
			score.setScore(score.getScore().add(quizScore));
			score.setRoundNumber(score.getRoundNumber() + 1);
			return scoreRepository.save(score);
		} else {
			return scoreRepository.save(
					new Score(quizScore, 1, userRepository.findOne(userId), subjectRepository.findOne(subjectId)));
		}
	}
}
