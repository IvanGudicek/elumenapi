package hr.tvz.gudicek.elumen.elumenapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.gudicek.elumen.elumenapi.entities.Subject;
import hr.tvz.gudicek.elumen.elumenapi.repositories.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public void saveOrUpdate(Subject entity) {
		subjectRepository.save(entity);
	}

	@Override
	public void delete(int id) {
		subjectRepository.delete(id);
	}

	@Override
	public Subject get(int id) {
		return subjectRepository.findOne(id);
	}

	@Override
	public List<Subject> findAll() {
		return subjectRepository.findAll();
	}

}
