package example.controllers;

import example.models.Task;
import example.services.TaskServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("/task.**")
public class TaskController {

	private TaskServices taskServices;

	public TaskController(TaskServices taskServices) {
		this.taskServices = taskServices;
	}

	@PostMapping (value = "/task.add")
	public ResponseEntity<Task> addTask(@RequestBody Task task) {
		Task addtask = taskServices.save(task);
		return ResponseEntity.ok(addtask);
	}

	@PostMapping (value = "/task.get", params = "id")
	public ResponseEntity<Optional<Task>> getTask(@RequestParam Long id) {
		Optional<Task> task = taskServices.getTaskById(id);
		return ResponseEntity.ok(task);
	}

	@PostMapping (value = "/task.delete", params = "id")
	public ResponseEntity<Boolean> deleteTask(@RequestParam Long id) {
		if (!id.equals(null)) {
			taskServices.deleteTaskById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}


}
