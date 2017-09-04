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

import hr.tvz.gudicek.elumen.elumenapi.entities.Question;
import hr.tvz.gudicek.elumen.elumenapi.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@PutMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody Question entity) {
		questionService.saveOrUpdate(entity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Question entity) {
		questionService.saveOrUpdate(entity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Question> get(@PathVariable(value = "id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(questionService.get(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") int id) {
		questionService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Question>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(questionService.findAll());
	}

	@GetMapping("/list/{subjectId}")
	public ResponseEntity<List<Question>> getAllBySubjectId(@PathVariable(value = "subjectId") int subjectId) {
		return ResponseEntity.status(HttpStatus.OK).body(questionService.findBySubjectId(subjectId));
	}

}
