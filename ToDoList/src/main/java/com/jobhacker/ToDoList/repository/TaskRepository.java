package com.jobhacker.ToDoList.repository;

import com.jobhacker.ToDoList.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {

    @Query("SELECT t FROM Task t WHERE t.user.id = :userId")
    List<Task> findTasksByUserId(@Param("userId") int userId);

    void deleteAllByUserId(int userId);

    Task findByTaskNameAndUserId(String taskName, int userId);

    Task findByTaskName(String title);
}
