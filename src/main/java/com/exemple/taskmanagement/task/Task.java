package com.exemple.taskmanagement.task;

import com.exemple.taskmanagement.category.Category;
import com.exemple.taskmanagement.responsible.Responsible;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    private String title;

    private String description;

    @Column(name= "data")
    private LocalDateTime dateTime;

    private String status;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name="responsible_id")
    private Responsible responsible;

    public Task(Long id, String title, String description, LocalDateTime dateTime, String status, Category category, Responsible responsible) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.status = status;
        this.category = category;
        this.responsible = responsible;
    }

    public Task() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTile() {
        return title;
    }

    public void setTile(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }
}
