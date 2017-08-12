package hr.tvz.gudicek.elumen.elumenapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.gudicek.elumen.elumenapi.entities.Subject;
import hr.tvz.gudicek.elumen.elumenapi.repositories.SubjectRepository;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectRepository subjectRepository;

	@PutMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody Subject subject) {
		subjectRepository.save(subject);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Subject subject) {
		subjectRepository.save(subject);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public Subject readContact(@PathVariable(name = "id") int id) {
		return subjectRepository.findOne(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") int id) {
		subjectRepository.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Subject>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(subjectRepository.findAll());
	}

}
