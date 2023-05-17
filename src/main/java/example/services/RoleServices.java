package example.services;

import example.models.Role;
import example.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class RoleServices {

	private final RoleRepo roleRepo;

	@Autowired
	public RoleServices(RoleRepo roleRepo) {
		this.roleRepo = roleRepo;
	}

	public Role addRole(Role role) {
		return roleRepo.save(role);
	}
	public Role updateRole(Long roleId, Role updatedRole) {
		Role existingRole = roleRepo.findById(roleId)
				.orElseThrow(() -> new EntityNotFoundException("Role not found"));

		existingRole.setRole(updatedRole.getRole());
		return roleRepo.save(existingRole);
	}
	public Optional<Role> getRole(Long id) {
		return roleRepo.findById(id);
	}
	public void deleteRole(Long id) {
		roleRepo.deleteById(id);
	}
}
