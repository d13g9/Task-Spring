package com.dw3.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dw3.app.model.Task;
import com.dw3.app.model.TaskRepository;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class TaskController {
	
	private final TaskRepository repository;
	
	public TaskController(TaskRepository repository) {
		super();
		this.repository = repository;
	}
	
	@CrossOrigin("http://localhost:4200/")
	@PostMapping("/addtask")
	  Task newEmployee(@RequestBody Task task) {
	    return repository.save(task);
	  }
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/getalltasks")
	  List<Task> all() {
	    return repository.findAll();
	  }
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/taks/findbyid/{id}")
	  Task one(@PathVariable Long id) throws TaksNotfoundExcpetion {

	    return repository.findById(id)
	      .orElseThrow(() -> new TaksNotfoundExcpetion(id));
	  }
	
	@CrossOrigin(origins="http://localhost:4200/")
	@PutMapping("/task/{id}")
	  Task replaceEmployee(@RequestBody Task newTask, @PathVariable Long id) {

	    return repository.findById(id)
	      .map(task -> {
	        task.setTasktitle(newTask.getTasktitle());
	        task.setTaskdescription(newTask.getTaskdescription());
	        task.setStatus(newTask.getStatus());
	        return repository.save(task);
	      })
	      .orElseGet(() -> {
	        newTask.setId(id);
	        return repository.save(newTask);
	      });
	  }
	
	@CrossOrigin("http://localhost:4200/")
	 @DeleteMapping("/task/{id}")
	  void deleteEmployee(@PathVariable Long id) {
	    repository.deleteById(id);
	  }

}
