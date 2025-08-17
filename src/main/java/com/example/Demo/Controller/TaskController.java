package com.example.Demo.Controller;

import com.example.Demo.Services.TaskServices;
import com.example.Demo.StudentProfile.Task;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskServices taskServices;

    // Constructor Injection
    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    // POST - Create Task
    @PostMapping
    public String createTask(@RequestBody Task task) {
        taskServices.createTask(task);
        return "Task created successfully";
    }

    // GET - Get Task by ID
    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskServices.getTaskById(id);
    }

    // GET - Get All Tasks
    @GetMapping
    public Collection<Task> getAllTasks() {
        return taskServices.getAllTasks();
    }

    // PUT - Update Task
    @PutMapping("/{id}")
    public String updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id); // ensure ID consistency
        taskServices.updateTask(task);
        return "Task updated successfully";
    }

    // DELETE - Delete Task
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskServices.deleteTask(id);
        return "Task deleted successfully";
    }
}
