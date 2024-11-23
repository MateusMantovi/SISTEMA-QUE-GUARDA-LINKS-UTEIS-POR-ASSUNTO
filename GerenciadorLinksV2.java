import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Link {
    String assunto;
    String url;

    Link(String assunto, String url) {
        this.assunto = assunto;
        this.url = url;
    }
}

public class GerenciadorLinksV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Link> listaLinks = new ArrayList<>();

        carregarArquivo(listaLinks);

        int opcao;
        do {
            System.out.println("\n=== Menu de Gerenciamento de Links ===");
            System.out.println("1. Adicionar link");
            System.out.println("2. Listar links");
            System.out.println("3. Editar link");
            System.out.println("4. Excluir link");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarLink(scanner, listaLinks);
                    break;
                case 2:
                    listarLinks(listaLinks);
                    break;
                case 3:
                    editarLink(scanner, listaLinks);
                    break;
                case 4:
                    excluirLink(scanner, listaLinks);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    salvarArquivo(listaLinks);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    public static void adicionarLink(Scanner scanner, ArrayList<Link> listaLinks) {
        System.out.print("Informe o assunto do link: ");
        String assunto = scanner.nextLine();
        System.out.print("Informe a URL do link: ");
        String url = scanner.nextLine();

        listaLinks.add(new Link(assunto, url));
        System.out.println("Link adicionado com sucesso!");
    }

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

    public static void editarLink(Scanner scanner, ArrayList<Link> listaLinks) {
        listarLinks(listaLinks);
        if (listaLinks.isEmpty()) return;

        System.out.print("Digite o número do link que deseja editar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice >= 0 && indice < listaLinks.size()) {
            System.out.print("Informe o novo assunto: ");
            String novoAssunto = scanner.nextLine();
            System.out.print("Informe a nova URL: ");
            String novaUrl = scanner.nextLine();

            listaLinks.set(indice, new Link(novoAssunto, novaUrl));
            System.out.println("Link editado com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void excluirLink(Scanner scanner, ArrayList<Link> listaLinks) {
        listarLinks(listaLinks);
        if (listaLinks.isEmpty()) return;

        System.out.print("Digite o número do link que deseja excluir: ");
        int indice = scanner.nextInt() - 1;

        if (indice >= 0 && indice < listaLinks.size()) {
            listaLinks.remove(indice);
            System.out.println("Link excluído com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void salvarArquivo(ArrayList<Link> listaLinks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("links.txt"))) {
            for (Link link : listaLinks) {
                writer.write(link.assunto + "\n" + link.url + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar links: " + e.getMessage());
        }
    }

    public static void carregarArquivo(ArrayList<Link> listaLinks) {
        try (BufferedReader reader = new BufferedReader(new FileReader("links.txt"))) {
            String assunto;
            while ((assunto = reader.readLine()) != null) {
                String url = reader.readLine();
                listaLinks.add(new Link(assunto, url));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum arquivo encontrado. Criando novo ao salvar.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar links: " + e.getMessage());
        }
    }
}
