package com.exemple.taskmanagement.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    private MenuTasks menuTasks;

    @Autowired
    private MenuCategories menuCategories;

    @Autowired
    private MenuResponsibles menuResponsibles;

    private final Scanner scanner = new Scanner(System.in);

    public void exibir() {

        int opcao;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Área de Tarefas");
            System.out.println("2. Área de Categorias");
            System.out.println("3. Área de Responsáveis");
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
                case 1 -> menuTasks.exibir();
                case 2 -> menuCategories.exibir();
                case 3 -> menuResponsibles.exibir();
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }
}
