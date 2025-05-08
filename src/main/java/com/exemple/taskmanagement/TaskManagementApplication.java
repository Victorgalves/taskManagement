package com.exemple.taskmanagement;

import com.exemple.taskmanagement.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagementApplication implements CommandLineRunner {

    @Autowired
    private Menu menu;

    public static void main(String[] args) {
        SpringApplication.run(TaskManagementApplication.class, args);
    }

    @Override
    public void run(String... args) {
        menu.exibir();
    }
}
