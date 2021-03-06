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
import hr.tvz.gudicek.elumen.elumenapi.services.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@PutMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody Subject entity) {
		subjectService.saveOrUpdate(entity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Subject entity) {
		subjectService.saveOrUpdate(entity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Subject> get(@PathVariable(value = "id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(subjectService.get(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") int id) {
		subjectService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Subject>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(subjectService.findAll());
	}

}
