package com.exemple.taskmanagement.category;

import com.exemple.taskmanagement.responsible.Responsible;
import com.exemple.taskmanagement.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c, COUNT(t) FROM Category c LEFT JOIN c.tasks t GROUP BY c ORDER BY c.id")
    List<Object[]> countTaskCategory();

    List<Category> findByAtivo(int ativo);
}