import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Classe que representa um Link com seu assunto
class Link {
    String assunto;
    String url;

    Link(String assunto, String url) {
        this.assunto = assunto;
        this.url = url;
    }
}

public class GerenciadorLinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Link> listaLinks = new ArrayList<>();

        // Carrega links do arquivo
        carregarArquivo(listaLinks);

        int opcao;
        do {
            System.out.println("\n=== Menu de Gerenciamento de Links ===");
            System.out.println("1. Adicionar link");
            System.out.println("2. Listar links");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    adicionarLink(scanner, listaLinks);
                    break;
                case 2:
                    listarLinks(listaLinks);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    salvarArquivo(listaLinks);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    // Adiciona um novo link à lista
    public static void adicionarLink(Scanner scanner, ArrayList<Link> listaLinks) {
        System.out.print("Informe o assunto do link: ");
        String assunto = scanner.nextLine();
        System.out.print("Informe a URL do link: ");
        String url = scanner.nextLine();

        listaLinks.add(new Link(assunto, url));
        System.out.println("Link adicionado com sucesso!");
    }

    // Lista todos os links
    public static void listarLinks(ArrayList<Link> listaLinks) {
        if (listaLinks.isEmpty()) {
            System.out.println("Nenhum link cadastrado.");
        } else {
            System.out.println("\n=== Lista de Links ===");
            for (int i = 0; i < listaLinks.size(); i++) {
                Link link = listaLinks.get(i);
                System.out.printf("%d. [%s] %s\n", i + 1, link.assunto, link.url);
            }
        }
    }

    // Salva a lista de links no arquivo
    public static void salvarArquivo(ArrayList<Link> listaLinks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("links.txt"))) {
            for (Link link : listaLinks) {
                writer.write(link.assunto + "\n" + link.url + "\n");
            }
            System.out.println("Links salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar links: " + e.getMessage());
        }
    }

    // Carrega os links do arquivo
    public static void carregarArquivo(ArrayList<Link> listaLinks) {
        try (BufferedReader reader = new BufferedReader(new FileReader("links.txt"))) {
            String assunto;
            while ((assunto = reader.readLine()) != null) {
                String url = reader.readLine();
                listaLinks.add(new Link(assunto, url));
            }
            System.out.println("Links carregados com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum arquivo encontrado. Criando novo ao salvar.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar links: " + e.getMessage());
        }
    }
}
