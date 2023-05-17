package example.controllers;

import example.models.Role;
import example.services.RoleServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/role.**")
public class RoleController {
	private RoleServices roleServices;
	public RoleController(RoleServices roleServices) {
		this.roleServices = roleServices;
	}

	@PostMapping(value = "/role.add")
	public ResponseEntity<Role> saveRole(@RequestBody Role role) {
		Role addRole = roleServices.addRole(role);
		return ResponseEntity.ok(addRole);
	}

	@PutMapping(value = "/role.update:{roleId}")
	public ResponseEntity<Role> updateRole(@PathVariable Long roleId, @RequestBody Role updatedRole) {
		Role updated = roleServices.updateRole(roleId, updatedRole);
		return ResponseEntity.ok(updated);
	}

	@PostMapping(value = "/role.get")
	public ResponseEntity<Optional<Role>> getRole(@RequestParam Long id) {
		Optional<Role> role = roleServices.getRole(id);
		return ResponseEntity.ok(role);
	}

	@PostMapping(value = "/role.delete")
	public ResponseEntity<Boolean> deleteRole(@RequestParam Long id) {
		 roleServices.deleteRole(id);
		return ResponseEntity.ok().build();
	}

}
