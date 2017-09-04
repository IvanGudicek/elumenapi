package hr.tvz.gudicek.elumen.elumenapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.gudicek.elumen.elumenapi.entities.Answer;
import hr.tvz.gudicek.elumen.elumenapi.repositories.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public void saveOrUpdate(Answer entity) {
		answerRepository.save(entity);
	}

	@Override
	public void delete(int id) {
		answerRepository.delete(id);
	}

	@Override
	public Answer get(int id) {
		return answerRepository.findOne(id);
	}

	@Override
	public List<Answer> findAll() {
		return answerRepository.findAll();
	}

}
