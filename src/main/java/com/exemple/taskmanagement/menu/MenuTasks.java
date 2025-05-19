package com.exemple.taskmanagement.menu;

import com.exemple.taskmanagement.task.Task;
import com.exemple.taskmanagement.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MenuTasks {

    @Autowired
    private TaskService taskService;

    private final Scanner scanner = new Scanner(System.in);

    public void exibir() {

        int opcao;
        do {
            System.out.println("\n--- Menu de Tasks ---");
            System.out.println("1. Criar nova tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Atualizar status de tarefa");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            System.out.flush();

            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.print("Opção inválida. Digite um número: ");
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> createTask();
                case 2 -> listTasks();
                case 3 -> attStatus();
                case 4 -> removeTask();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 5);
    }

    private void createTask() {
        System.out.print("Título: ");
        System.out.flush();
        String title = scanner.nextLine();

        System.out.print("Descrição: ");
        System.out.flush();
        String description = scanner.nextLine();

        System.out.print("Status (PENDENTE, CONCLUIDA, CANCELADA): ");
        System.out.flush();
        String status = scanner.nextLine();

        System.out.print("ID da categoria: ");
        System.out.flush();
        Long categoryId = scanner.nextLong();

        System.out.print("ID do responsável: ");
        System.out.flush();
        Long responsibleId = scanner.nextLong();
        scanner.nextLine();

        try {
            taskService.createTask(title, description, status, categoryId, responsibleId);
            System.out.println("Task criada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void listTasks() {
        List<Task> tarefas = taskService.listTasks();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            tarefas.forEach(t -> {
                System.out.printf("\nID: %d | Título: %s | Status: %s\n", t.getId(), t.getTile(), t.getStatus());
                System.out.printf("Categoria: %s | Responsável: %s\n",
                        t.getCategory().getName(), t.getResponsible().getName());
            });
        }
    }

    private void attStatus() {
        System.out.print("ID da tarefa: ");
        System.out.flush();
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Novo status: ");
        System.out.flush();
        String novoStatus = scanner.nextLine();

        try {
            taskService.attStatus(id, novoStatus);
            System.out.println("Status atualizado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void removeTask() {
        System.out.print("ID da tarefa: ");
        System.out.flush();
        Long id = scanner.nextLong();
        scanner.nextLine();

        if (taskService.removeTasks(id)) {
            System.out.println("Task removida com sucesso.");
        } else {
            System.out.println("Task não encontrada.");
        }
    }
}
