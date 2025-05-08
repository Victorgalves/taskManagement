package com.exemple.taskmanagement.task;

import com.exemple.taskmanagement.category.Category;
import com.exemple.taskmanagement.responsible.Responsible;
import com.exemple.taskmanagement.task.Task;
import com.exemple.taskmanagement.category.CategoryRepository;
import com.exemple.taskmanagement.responsible.ResponsibleRepository;
import com.exemple.taskmanagement.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ResponsibleRepository responsibleRepository;

    public Task createTask(String title, String description, String status, Long categoryId, Long responsibleId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        Optional<Responsible> responsible = responsibleRepository.findById(responsibleId);

        if (category.isEmpty() || responsible.isEmpty()) {
            throw new IllegalArgumentException("Category ou responsável não encontrados.");
        }

        Task task = new Task();
        task.setTile(title);
        task.setDescription(description);
        task.setStatus(status);
        task.setDateTime(LocalDateTime.now());
        task.setCategory(category.get());
        task.setResponsible(responsible.get());

        return taskRepository.save(task);
    }

    public List<Task> listTasks() {
        return taskRepository.findAll();
    }

    public boolean removeTasks(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Task> findTasks(Long id) {
        return taskRepository.findById(id);
    }

    public Task attStatus(Long id, String novoStatus) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task não encontrada"));
        task.setStatus(novoStatus);
        return taskRepository.save(task);
    }
}
