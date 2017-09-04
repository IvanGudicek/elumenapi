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

import hr.tvz.gudicek.elumen.elumenapi.entities.User;
import hr.tvz.gudicek.elumen.elumenapi.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PutMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody User entity) {
		userService.saveOrUpdate(entity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody User entity) {
		userService.saveOrUpdate(entity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<User> get(@PathVariable(value = "id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.get(id));
	}

	@GetMapping("/get/facebook/{facebookId}")
	public ResponseEntity<User> get(@PathVariable(value = "facebookId") String facebookId) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByFacebookId(facebookId));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") int id) {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
	}

	@PutMapping("/login")
	public ResponseEntity<User> facebookLogin(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.facebookUserLogin(user));
	}

	@GetMapping("/login/{facebookId}")
	public ResponseEntity<Long> countUsers(@PathVariable(value = "facebookId") String facebookId) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.countByFacebookId(facebookId));
	}

}
