package hr.tvz.gudicek.elumen.elumenapi.services;

import java.util.List;

import hr.tvz.gudicek.elumen.elumenapi.entities.Question;

public interface QuestionService {

	public void saveOrUpdate(Question entity);

	public void delete(int id);

	public Question get(int id);

	public List<Question> findAll();

	public List<Question> findBySubjectId(int id);
}
