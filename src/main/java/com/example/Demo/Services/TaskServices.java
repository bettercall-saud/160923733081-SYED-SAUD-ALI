package com.example.Demo.Services;

import com.example.Demo.StudentProfile.Task;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class TaskServices {

    private final HashMap<Long, Task> taskMap = new HashMap<>();


    public void createTask(Task task) {
        taskMap.put(task.getId(), task);
    }


    public Task getTaskById(Long id) {
        return taskMap.get(id);
    }


    public void updateTask(Task task) {
        taskMap.put(task.getId(), task);
    }


    public void deleteTask(Long id) {
        taskMap.remove(id);
    }


    public Collection<Task> getAllTasks() {
        return taskMap.values();
    }
}
