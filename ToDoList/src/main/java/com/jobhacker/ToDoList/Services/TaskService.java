package com.jobhacker.ToDoList.Services;

import com.jobhacker.ToDoList.Model.Task;
import com.jobhacker.ToDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void insert(Task task){
        Task existName = taskRepository.findByTaskNameAndUserId(task.getTaskName(), task.getUser().getId());
        if(existName == null) {
            taskRepository.save(task);
        }
        else{
            throw new NameException("this task name is exist for this user");
        }
    }

    public void update(Task task){
        Task updatedTask = taskRepository.findById(task.getTaskId()).orElse(null);

        if(updatedTask != null) {
            if (task.getTaskName() != null) {
                updatedTask.setTaskName(task.getTaskName());
            }
            if (task.getDescription() != null) {
                updatedTask.setDescription(task.getDescription());
            }
            if (task.getStartDate() != null) {
                updatedTask.setStartDate(task.getStartDate());
            }
            if (task.getEndDate() != null) {
                updatedTask.setEndDate(task.getEndDate());
            }
            if (task.getStatus() != null) {
                updatedTask.setStatus(task.getStatus());
            }
            taskRepository.save(updatedTask);
        }else{
            throw new NotFoundException();
        }
    }

    public List<Task> getAllTasksByUserId(int userId) {
        return taskRepository.findTasksByUserId(userId);
    }

    public void delete(int taskId){
         taskRepository.deleteById(taskId);
    }

    @Transactional
    public void deleteAll(int userId){
        taskRepository.deleteAllByUserId(userId);
    }

}
