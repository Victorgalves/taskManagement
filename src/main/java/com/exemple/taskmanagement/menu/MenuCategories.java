package com.exemple.taskmanagement.menu;

import com.exemple.taskmanagement.category.Category;
import com.exemple.taskmanagement.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MenuCategories {

    @Autowired
    private CategoryService categoryService;

    private final Scanner scanner = new Scanner(System.in);

    public void exibir() {

        int opcao;
        do {
            System.out.println("\n--- Menu de Categorias ---");
            System.out.println("1. Criar nova categoria");
            System.out.println("2. Listar categorias ativas");
            System.out.println("3. Listar todas categorias");
            System.out.println("4. Quantidade de tarefas por Categoria");
            System.out.println("5. Remover categoria");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opção: ");
            System.out.flush();

            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.print("Opção inválida. Digite um número: ");
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> createCategory();
                case 2 -> listCategoryAtivas();
                case 3 -> listCategory();
                case 4 -> countTaskCategory();
                case 5 -> removeCategory();
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 6);
    }

    private void createCategory() {
        System.out.print("Nome: ");
        System.out.flush();
        String name = scanner.nextLine();

        System.out.print("Descrição: ");
        System.out.flush();
        String description = scanner.nextLine();

        try {
            categoryService.createCategory(name, description);
            System.out.println("Categoria criada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void listCategoryAtivas() {
        List<Category> categories = categoryService.listCategoriesAtivos();
        if (categories.isEmpty()) {
            System.out.println("Nenhuma categoria encontrada.");
        } else {
            categories.forEach(t -> {
                System.out.printf("\nID: %d | Nome: %s | Descrição: %s\n", t.getId(), t.getName(), t.getDescription());
            });
        }
    }

    private void listCategory() {
        List<Category> categories = categoryService.listCategories();
        if (categories.isEmpty()) {
            System.out.println("Nenhuma categoria encontrada.");
        } else {
            categories.forEach(t -> {
                System.out.printf("\nID: %d | Nome: %s | Descrição: %s\n", t.getId(), t.getName(), t.getDescription());
            });
        }
    }

    private void removeCategory() {
        System.out.print("ID da Categoria: ");
        System.out.flush();
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {
            categoryService.removeCategories(id);
            System.out.println("Categoria removida com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Categoria não encontrada.");
        }
    }

    private void countTaskCategory() {
        List<Object[]> categoriesWithTaskCount = categoryService.countTaskCategory();

        if (categoriesWithTaskCount.isEmpty()) {
            System.out.println("Nenhuma categoria encontrada.");
            return;
        }

        System.out.println("\n--- Lista de Categorias com Contagem de Tarefas ---");
        for (Object[] result : categoriesWithTaskCount) {
            Category category = (Category) result[0];
            Long taskCount = (Long) result[1];
            System.out.println("ID: " + category.getId() +
                    ", Nome: " + category.getName() +
                    ", Tarefas: " + taskCount);
        }
        System.out.println("---------------------------------------------------\n");
    }
}
