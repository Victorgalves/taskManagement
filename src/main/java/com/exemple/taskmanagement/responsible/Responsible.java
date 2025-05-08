package com.exemple.taskmanagement.responsible;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Responsible {

    @Id
    @Column(name = "responsible_id")
    private Long id;
    private String name;

    public Responsible(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Responsible() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
