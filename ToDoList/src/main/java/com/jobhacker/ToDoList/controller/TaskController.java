package com.jobhacker.ToDoList.controller;

import com.jobhacker.ToDoList.Model.Task;
import com.jobhacker.ToDoList.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping
    public void addNewTask(@RequestBody Task task){
        taskService.insert(task);
    }

    @GetMapping("/{userId}")
    public List<Task> getAllTasksForUser(@PathVariable int userId) {
        return taskService.getAllTasksByUserId(userId);
    }

    @PutMapping
    public void updateTask(@RequestBody Task task){
        taskService.update(task);
    }

    @DeleteMapping("/deleteAll/{userId}")
    public void deleteAll(@PathVariable int userId){
        taskService.deleteAll(userId);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable int taskId){
        taskService.delete(taskId);
    }
}

