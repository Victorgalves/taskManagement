package com.exemple.taskmanagement.responsible;

import jakarta.persistence.*;

@Entity

public class Responsible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
