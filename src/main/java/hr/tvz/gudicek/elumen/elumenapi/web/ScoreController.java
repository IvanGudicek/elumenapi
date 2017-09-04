package hr.tvz.gudicek.elumen.elumenapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.gudicek.elumen.elumenapi.entities.Score;
import hr.tvz.gudicek.elumen.elumenapi.pojo.ScoreForm;
import hr.tvz.gudicek.elumen.elumenapi.services.ScoreService;

@RestController
@RequestMapping("/score")
public class ScoreController {
	@Autowired
	private ScoreService scoreService;
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/insert")
	public Score insert(@RequestBody Score entity) {
		return scoreService.saveOrUpdate(entity);
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/update")
	public Score update(@RequestBody Score entity) {
		return scoreService.saveOrUpdate(entity);
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/get/{id}")
	public Score get(@PathVariable(value = "id") int id) {
		return scoreService.get(id);
	}
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(value = "id") int id) {
		scoreService.delete(id);
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/list")
	public List<Score> getAll() {
		return scoreService.findAll();
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/list/user/id/{id}")
	public List<Score> getByUserId(@PathVariable(value = "id") int id) {
		return scoreService.getByUserId(id);
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/list/user/facebookId/{facebookId}")
	public List<Score> getByUserFacebookId(@PathVariable(value = "facebookId") String facebookId) {
		return scoreService.getByUserFacebookId(facebookId);
	}
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update/user/{userId}/subject/{subjectId}")
	public Score updateScore(@RequestBody ScoreForm scoreForm, @PathVariable(value = "userId") int userId, @PathVariable(value = "subjectId") int subjectId) {
		return scoreService.updateScoreQuiz(scoreForm.getScore(), userId, subjectId);
	}
}
