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

import hr.tvz.gudicek.elumen.elumenapi.entities.Answer;
import hr.tvz.gudicek.elumen.elumenapi.services.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@PutMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody Answer entity) {
		answerService.saveOrUpdate(entity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Answer entity) {
		answerService.saveOrUpdate(entity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Answer> get(@PathVariable(value = "id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(answerService.get(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") int id) {
		answerService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Answer>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(answerService.findAll());
	}
}
