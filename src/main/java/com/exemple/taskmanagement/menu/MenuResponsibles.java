package com.exemple.taskmanagement.menu;

import com.exemple.taskmanagement.responsible.Responsible;
import com.exemple.taskmanagement.responsible.ResponsibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MenuResponsibles {

    @Autowired
    private ResponsibleService responsibleService;

    private final Scanner scanner = new Scanner(System.in);

    public void exibir() {

        int opcao;
        do {
            System.out.println("\n--- Menu de Responsáveis ---");
            System.out.println("1. Criar novo reponsável");
            System.out.println("2. Listar reponsáveis");
            System.out.println("3. Remover reponsável");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            System.out.flush();

            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.print("Opção inválida. Digite um número: ");
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> createResponsible();
                case 2 -> listResponsible();
                case 3 -> removeResponsible();
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 4);
    }

    private void createResponsible() {
        System.out.print("Nome: ");
        System.out.flush();
        String name = scanner.nextLine();

        try {
            responsibleService.createResponsible(name);
            System.out.println("Responsável criado(a) com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void listResponsible() {
        List<Responsible> responsibles = responsibleService.listResponsibles();
        if (responsibles.isEmpty()) {
            System.out.println("Nenhum(a) responsável encontrada.");
        } else {
            responsibles.forEach(t -> {
                System.out.printf("\nID: %d | Nome: %s\n", t.getId(), t.getName());
            });
        }
    }

    private void removeResponsible() {
        System.out.print("ID da Reponsável: ");
        System.out.flush();
        Long id = scanner.nextLong();
        scanner.nextLine();

        if (responsibleService.removeResponsibles(id)) {
            System.out.println("Responsável removido(a) com sucesso.");
        } else {
            System.out.println("Responsável não encontrado(a).");
        }
    }
}
