package hr.tvz.gudicek.elumen.elumenapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.gudicek.elumen.elumenapi.entities.Question;
import hr.tvz.gudicek.elumen.elumenapi.repositories.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public void saveOrUpdate(Question entity) {
		questionRepository.save(entity);
	}

	@Override
	public void delete(int id) {
		questionRepository.delete(id);
	}

	@Override
	public Question get(int id) {
		return questionRepository.findOne(id);
	}

	@Override
	public List<Question> findAll() {
		return questionRepository.findAll();
	}

	@Override
	public List<Question> findBySubjectId(int id) {
		return questionRepository.findBySubject_id(id);
	}

}
