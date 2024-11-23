# SISTEMA-QUE-GUARDA-LINKS-UTEIS-POR-ASSUNTO
Utilizando o exemplo dado no bimestre passado foi construido um sistema que guarda links por assunto, no total 4 versões que são aprimoradas desde a versão 1.0 a 1.4
Sistema de Gerenciamento de Links Úteis
Este é um projeto desenvolvido em Java para gerenciar links úteis organizados por assunto. Ele inclui operações básicas de CRUD (Create, Read, Update, Delete) e utiliza um arquivo de texto (links.txt) para persistência de dados.

Funcionalidades
Adicionar Links: Permite inserir novos links com um assunto e uma URL específicos.

Listar Links: Exibe todos os links cadastrados até o momento, organizados por assunto.

Editar Links: Permite alterar o assunto ou a URL de um link existente.

Excluir Links: Possibilita a exclusão de links após confirmação do usuário.

Buscar Links: Filtra links utilizando palavras-chave associadas ao assunto ou à URL.

Persistência de Dados: Salva e carrega os links de um arquivo texto (links.txt), garantindo que as alterações sejam mantidas entre as execuções do sistema.

Estrutura do Projeto
Classe Link
Representa a estrutura básica de um link, contendo informações essenciais:

Atributos:

String assunto: O assunto relacionado ao link (ex: "Programação", "Notícias").

String url: A URL do link (ex: "https://java.com").

Construtor:

java
public Link(String assunto, String url) {
    this.assunto = assunto;
    this.url = url;
}
Métodos de Acesso (Getters e Setters):

java
public String getAssunto() {
    return this.assunto;
}

public void setAssunto(String assunto) {
    this.assunto = assunto;
}

public String getUrl() {
    return this.url;
}

public void setUrl(String url) {
    this.url = url;
}
Classe GerenciadorLinks
Gerencia as operações CRUD e a interação com o usuário. Contém os seguintes métodos:

main(String[] args): Ponto de entrada do programa. Exibe o menu principal e gerencia a interação com o usuário.

java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Link> listaLinks = new ArrayList<>();
    carregarArquivo(listaLinks);  // Carrega links do arquivo de texto

    int opcao;
    do {
        // Exibição do menu
        System.out.println("=== Menu de Gerenciamento de Links ===");
        System.out.println("1. Adicionar link");
        System.out.println("2. Listar links");
        System.out.println("3. Editar link");
        System.out.println("4. Excluir link");
        System.out.println("5. Buscar links");
        System.out.println("6. Sair");

        // Recebe a opção do usuário
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer

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
                salvarArquivo(listaLinks);
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    } while (opcao != 6);
}
adicionarLink(Scanner scanner, ArrayList<Link> listaLinks): Adiciona um novo link ao sistema. O usuário informa o assunto e a URL, e o sistema verifica se a URL já existe para evitar duplicatas.

java
public static void adicionarLink(Scanner scanner, ArrayList<Link> listaLinks) {
    System.out.print("Informe o assunto: ");
    String assunto = scanner.nextLine();

    System.out.print("Informe a URL: ");
    String url = scanner.nextLine();

    // Verifica se o link já existe
    for (Link link : listaLinks) {
        if (link.getUrl().equals(url)) {
            System.out.println("Erro: Link já cadastrado.");
            return;
        }
    }

    // Adiciona o novo link
    Link novoLink = new Link(assunto, url);
    listaLinks.add(novoLink);
    System.out.println("Link adicionado com sucesso!");
    salvarArquivo(listaLinks);
}
listarLinks(ArrayList<Link> listaLinks): Lista todos os links cadastrados, organizados em ordem alfabética de assunto.

java
public static void listarLinks(ArrayList<Link> listaLinks) {
    if (listaLinks.isEmpty()) {
        System.out.println("Nenhum link cadastrado.");
    } else {
        System.out.println("Lista de Links:");
        listaLinks.sort(Comparator.comparing(Link::getAssunto));  // Ordena por assunto
        for (int i = 0; i < listaLinks.size(); i++) {
            Link link = listaLinks.get(i);
            System.out.println((i + 1) + ". [" + link.getAssunto() + "] " + link.getUrl());
        }
    }
}
editarLink(Scanner scanner, ArrayList<Link> listaLinks): Permite editar o assunto ou a URL de um link existente. O usuário fornece o número do link para localizar o item correto.

java
public static void editarLink(Scanner scanner, ArrayList<Link> listaLinks) {
    System.out.print("Informe o número do link a ser editado: ");
    int numero = scanner.nextInt();
    scanner.nextLine();  // Limpa o buffer
    if (numero < 1 || numero > listaLinks.size()) {
        System.out.println("Número inválido.");
        return;
    }

    Link link = listaLinks.get(numero - 1);

    System.out.print("Novo assunto (deixe em branco para não alterar): ");
    String novoAssunto = scanner.nextLine();
    if (!novoAssunto.isEmpty()) {
        link.setAssunto(novoAssunto);
    }

    System.out.print("Nova URL (deixe em branco para não alterar): ");
    String novaUrl = scanner.nextLine();
    if (!novaUrl.isEmpty()) {
        link.setUrl(novaUrl);
    }

    System.out.println("Link editado com sucesso!");
    salvarArquivo(listaLinks);
}
excluirLink(Scanner scanner, ArrayList<Link> listaLinks): Permite excluir um link após confirmação do usuário. O usuário informa o número do link a ser removido.

java
public static void excluirLink(Scanner scanner, ArrayList<Link> listaLinks) {
    System.out.print("Informe o número do link a ser excluído: ");
    int numero = scanner.nextInt();
    scanner.nextLine();  // Limpa o buffer

    if (numero < 1 || numero > listaLinks.size()) {
        System.out.println("Número inválido.");
        return;
    }

    System.out.print("Tem certeza que deseja excluir este link? (S/N): ");
    String confirmacao = scanner.nextLine();

    if (confirmacao.equalsIgnoreCase("S")) {
        listaLinks.remove(numero - 1);
        System.out.println("Link excluído com sucesso.");
        salvarArquivo(listaLinks);
    } else {
        System.out.println("Exclusão cancelada.");
    }
}
buscarLinks(Scanner scanner, ArrayList<Link> listaLinks): Permite buscar links utilizando uma palavra-chave que pode fazer parte do assunto ou da URL.

java
public static void buscarLinks(Scanner scanner, ArrayList<Link> listaLinks) {
    System.out.print("Digite a palavra-chave para busca: ");
    String palavraChave = scanner.nextLine();

    boolean encontrado = false;
    for (Link link : listaLinks) {
        if (link.getAssunto().contains(palavraChave) || link.getUrl().contains(palavraChave)) {
            System.out.println("Encontrado: [" + link.getAssunto() + "] " + link.getUrl());
            encontrado = true;
        }
    }

    if (!encontrado) {
        System.out.println("Nenhum link encontrado.");
    }
}
Persistência de Dados
Os dados dos links são armazenados em um arquivo de texto (links.txt) no seguinte formato:

Assunto
URL
Assunto
URL
Métodos de Persistência
salvarArquivo(): Grava a lista de links no arquivo de texto.

carregarArquivo(): Carrega os links do arquivo para a lista quando o programa é iniciado.
