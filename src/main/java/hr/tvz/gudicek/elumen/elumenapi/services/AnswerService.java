package hr.tvz.gudicek.elumen.elumenapi.services;

import java.util.List;

import hr.tvz.gudicek.elumen.elumenapi.entities.Answer;

public interface AnswerService {

	public void saveOrUpdate(Answer entity);

	public void delete(int id);

	public Answer get(int id);

	public List<Answer> findAll();

}
