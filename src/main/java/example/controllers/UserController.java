package example.controllers;


import example.models.User;
import example.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("/user.**")
public class UserController {
	private UserServices userServices;

	public UserController(UserServices userServices) {
		this.userServices = userServices;
	}

	@PostMapping (value = "/user.add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User addUser = userServices.addUser(user);
		return ResponseEntity.ok(addUser);
	}

	@PostMapping (value = "/user.get", params = {"id"})
	public ResponseEntity<Optional<User>> getUser(@RequestParam("id") Long id) {
		Optional<User> user = userServices.getUserById(id);

		// Check if the user exists
		if (user != null) {
			// Return the user object in ResponseEntity with status 200 (OK)
			return ResponseEntity.ok(user);
		} else {
			// Return ResponseEntity with status 404 (Not Found)
			return ResponseEntity.notFound().build();
		}
	}


	@PostMapping (value = "/user.delete", params = { "id" })
	public ResponseEntity<Boolean> findUser(@RequestParam("id") Long id) {
		if (!id.equals(null)) {
		userServices.deleteUser(id);
		return ResponseEntity.ok().build();
	}else {
		return ResponseEntity.notFound().build();
		}
	}
}
