package example.services;

import example.models.Task;
import example.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class TaskServices {

	private final TaskRepo takRepo;

	@Autowired
	public TaskServices(TaskRepo takRepo) {
		this.takRepo = takRepo;
	}

	public Task save(Task task) {
		return takRepo.save(task);
	}

	public Optional<Task> getTaskById(Long id) {
		return takRepo.findById(id);
	}

	public void deleteTaskById(Long id) {
		takRepo.deleteById(id);
	}

}
