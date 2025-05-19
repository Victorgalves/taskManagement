package com.exemple.taskmanagement.task;

import com.exemple.taskmanagement.responsible.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t JOIN FETCH t.category JOIN FETCH t.responsible")
    List<Task> findAllWithCategoryAndResponsible();

}
