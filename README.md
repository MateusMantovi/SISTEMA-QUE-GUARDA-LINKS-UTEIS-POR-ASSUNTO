# SISTEMA-QUE-GUARDA-LINKS-UTEIS-POR-ASSUNTO
Utilizando o exemplo dado no bimestre passado foi construido um sistema que guarda links por assunto, no total 4 versões que são aprimoradas desde a versão 1.0 a 1.3
Sistema de Gerenciamento de Links Úteis
Este é um projeto desenvolvido em Java para gerenciar links úteis organizados por assunto. Ele inclui operações básicas de CRUD (Create, Read, Update, Delete) e utiliza um arquivo de texto (links.txt) para persistência de dados.

# Sistema de Gerenciamento de Links Úteis

## Descrição
Este projeto é um sistema desenvolvido em Java para gerenciar links úteis organizados por assunto. Ele permite adicionar, listar, editar, excluir e buscar links. Os dados são armazenados em um arquivo texto (`links.txt`), garantindo persistência entre execuções.

---

## Funcionalidades
### Versão 1.0
- **Adicionar links**: Registre um link com assunto e URL.
- **Listar links**: Visualize todos os links cadastrados.

### Versão 1.1
- **Editar links**: Altere o assunto ou URL de links existentes.
- **Excluir links**: Remova links indesejados.

### Versão 1.2
- **Validações**:
  - Evitar duplicação de URLs ao cadastrar.
  - Mensagens de erro amigáveis para entradas inválidas.
- **Confirmação de exclusão**: Solicita confirmação antes de excluir um link.
- **Ordenação automática**: Links são exibidos em ordem alfabética por assunto.

### Versão 1.3
- **Buscar links**: Filtre links por assunto ou palavras-chave.
- **Documentação completa**: Manual detalhado para uso e manutenção do sistema.

---

## Estrutura do Projeto
- **GerenciadorLinks.java**: Código fonte principal do sistema.
- **links.txt**: Arquivo de armazenamento dos links cadastrados.

---

## Como Usar
- ** Copie e cole os códigos

## Maior aprofundamento do sistema
Sistema de Gerenciamento de Links Úteis
Este é um projeto desenvolvido em Java para gerenciar links úteis organizados por assunto, incluindo operações básicas de CRUD e uso de um arquivo de texto (links.txt) para persistência de dados.

Funcionalidades
Adicionar Links: Inserção de novos links com assunto e URL.

Listar Links: Exibição dos links cadastrados, organizados por assunto.

Editar Links: Alteração do assunto ou URL de um link existente.

Excluir Links: Exclusão de links após confirmação do usuário.

Buscar Links: Filtragem de links por palavras-chave no assunto ou URL.

Persistência de Dados: Salva e carrega links de um arquivo texto.

Estrutura do Projeto
Classe Link
Representa a estrutura básica de um link, com os atributos:

String assunto

String url

Classe GerenciadorLinks
Gerencia as operações CRUD e a interação com o usuário, incluindo os métodos:

main(String[] args): Ponto de entrada do programa.

adicionarLink(Scanner scanner, ArrayList<Link> listaLinks): Adiciona um novo link.

listarLinks(ArrayList<Link> listaLinks): Lista todos os links.

editarLink(Scanner scanner, ArrayList<Link> listaLinks): Edita um link existente.

excluirLink(Scanner scanner, ArrayList<Link> listaLinks): Exclui um link após confirmação.

buscarLinks(Scanner scanner, ArrayList<Link> listaLinks): Busca links por palavra-chave.

Persistência de Dados
Links são armazenados em um arquivo texto (links.txt). Os métodos principais são:

salvarArquivo(): Grava a lista de links no arquivo.

carregarArquivo(): Carrega os links do arquivo para a lista ao iniciar o programa.



