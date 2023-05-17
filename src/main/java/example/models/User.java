package example.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long   ID;
	private String username;
	private String email;
	private String password;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "role_id")
	private Role  role;

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	private List<Task> tasks=new ArrayList<>();


	public User() {
	}

	public User(String username, String email, String password, Role role, List<Task> tasks) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.tasks = tasks;
	}

	public Long getID() {
		return ID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
