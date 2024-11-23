import java.io.*;
import java.util.*;

// Classe Link representa um link com assunto e URL associados.
class Link {
    String assunto;
    String url;

    // Construtor da classe Link.
    Link(String assunto, String url) {
        this.assunto = assunto;
        this.url = url;
    }
}

public class GerenciadorLinksV4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Link> listaLinks = new ArrayList<>();

        // Carrega links previamente salvos em arquivo.
        carregarArquivo(listaLinks);

        int opcao;
        do {
            System.out.println("\n=== Menu de Gerenciamento de Links ===");
            System.out.println("1. Adicionar link");
            System.out.println("2. Listar links");
            System.out.println("3. Editar link");
            System.out.println("4. Excluir link");
            System.out.println("5. Buscar links");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer.

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
                    buscarLinks(scanner, listaLinks);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    salvarArquivo(listaLinks);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    // Adiciona um novo link à lista com validação para evitar duplicatas.
    public static void adicionarLink(Scanner scanner, ArrayList<Link> listaLinks) {
        System.out.print("Informe o assunto do link: ");
        String assunto = scanner.nextLine();
        System.out.print("Informe a URL do link: ");
        String url = scanner.nextLine();

        // Verifica se a URL já existe na lista.
        for (Link link : listaLinks) {
            if (link.url.equals(url)) {
                System.out.println("Erro: Este link já está cadastrado.");
                return;
            }
        }

        listaLinks.add(new Link(assunto, url));
        System.out.println("Link adicionado com sucesso!");
    }

    // Lista todos os links da lista, ordenados alfabeticamente por assunto.
    public static void listarLinks(ArrayList<Link> listaLinks) {
        if (listaLinks.isEmpty()) {
            System.out.println("Nenhum link cadastrado.");
        } else {
            // Ordena links alfabeticamente por assunto antes de exibir.
            listaLinks.sort(Comparator.comparing(link -> link.assunto.toLowerCase()));
            System.out.println("\n=== Lista de Links ===");
            for (int i = 0; i < listaLinks.size(); i++) {
                Link link = listaLinks.get(i);
                System.out.printf("%d. [%s] %s\n", i + 1, link.assunto, link.url);
            }
        }
    }

    // Edita informações de um link existente.
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

    // Exclui um link após confirmação.
    public static void excluirLink(Scanner scanner, ArrayList<Link> listaLinks) {
        listarLinks(listaLinks);
        if (listaLinks.isEmpty()) return;

        System.out.print("Digite o número do link que deseja excluir: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice >= 0 && indice < listaLinks.size()) {
            System.out.print("Tem certeza que deseja excluir este link? (s/n): ");
            String confirmacao = scanner.nextLine();
            if (confirmacao.equalsIgnoreCase("s")) {
                listaLinks.remove(indice);
                System.out.println("Link excluído com sucesso!");
            } else {
                System.out.println("Exclusão cancelada.");
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Busca links por palavras-chave ou assunto.
    public static void buscarLinks(Scanner scanner, ArrayList<Link> listaLinks) {
        if (listaLinks.isEmpty()) {
            System.out.println("Nenhum link cadastrado.");
            return;
        }

        System.out.print("Digite a palavra-chave ou assunto para buscar: ");
        String termoBusca = scanner.nextLine().toLowerCase();

        System.out.println("\n=== Resultados da Busca ===");
        boolean encontrou = false;
        for (Link link : listaLinks) {
            if (link.assunto.toLowerCase().contains(termoBusca) || link.url.toLowerCase().contains(termoBusca)) {
                System.out.printf("[%s] %s\n", link.assunto, link.url);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum link encontrado para o termo informado.");
        }
    }

    // Salva a lista de links no arquivo.
    public static void salvarArquivo(ArrayList<Link> listaLinks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("links.txt"))) {
            for (Link link : listaLinks) {
                writer.write(link.assunto + "\n" + link.url + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar links: " + e.getMessage());
        }
    }

    // Carrega os links do arquivo.
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
