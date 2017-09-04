package hr.tvz.gudicek.elumen.elumenapi.services;

import java.util.List;

import hr.tvz.gudicek.elumen.elumenapi.entities.Subject;

public interface SubjectService {

	public void saveOrUpdate(Subject entity);

	public void delete(int id);

	public Subject get(int id);

	public List<Subject> findAll();
}
