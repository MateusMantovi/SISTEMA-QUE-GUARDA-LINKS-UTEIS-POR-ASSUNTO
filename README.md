# SISTEMA-QUE-GUARDA-LINKS-UTEIS-POR-ASSUNTO
Utilizando o exemplo dado no bimestre passado foi construido um sistema que guarda links por assunto, no total 4 versões que são aprimoradas desde a versão 1.0 a 1.3
Sistema de Gerenciamento de Links Úteis
Este é um projeto desenvolvido em Java para gerenciar links úteis organizados por assunto. Ele inclui operações básicas de CRUD (Create, Read, Update, Delete) e utiliza um arquivo de texto (links.txt) para persistência de dados.

# Sistema de Gerenciamento de Links Úteis

## Descrição
Este projeto é um sistema desenvolvido em Java para gerenciar links úteis organizados por assunto. Ele permite adicionar, listar, editar, excluir e buscar links. Os dados são armazenados em um arquivo texto (`links.txt`), garantindo persistência entre execuções.

# Projeto de Gerenciamento de Links

## Objetivo do Projeto
Nosso projeto visa desenvolver um sistema prático e eficiente para organizar links úteis. Com ele, você poderá armazenar, listar, editar, excluir e buscar links sobre diversos assuntos. Todos os dados são armazenados em um arquivo de texto, garantindo que nada seja perdido entre as sessões. Desenvolvido em Java, o projeto foca na simplicidade, legibilidade e boas práticas de desenvolvimento de software.

## O Sistema
O sistema de gerenciamento de links oferece uma interface de linha de comando (CLI) intuitiva e de fácil uso, permitindo que você:

- **Adicionar Links**: Armazene links com um título e uma URL, facilitando a organização e a categorização.
- **Listar Links**: Visualize todos os links armazenados, organizados por assunto ou categorias específicas.
- **Editar Links**: Modifique os detalhes (título ou URL) de um link existente de forma rápida e simples.
- **Excluir Links**: Remova links que não são mais necessários, mantendo seu repositório limpo e relevante.
- **Buscar Links**: Encontre links específicos usando palavras-chave no título ou na URL, garantindo acesso rápido às informações desejadas.

## Persistência de Dados
Os links são armazenados em um arquivo de texto denominado `links.txt`, assegurando que os dados sejam preservados entre as sessões de uso, evitando a perda de informações importantes.

## Estrutura do Projeto
O projeto é composto pelas seguintes classes principais:

- **Link**: Representa cada link armazenado, incluindo seu título e URL.
- **CrudLinks**: Contém a lógica central do sistema, incluindo as operações de CRUD (Create, Read, Update, Delete), além da busca e manipulação de arquivos.

## Evolução do Sistema

### Versão 1: Estrutura Básica com CRUD e Persistência
Na primeira versão, foi implementada a estrutura básica do sistema, incluindo as funcionalidades de CRUD e persistência dos dados em arquivo. O sistema apresenta um menu simples com as opções de adicionar, listar, editar e excluir links, garantindo que os dados sejam mantidos entre as execuções.

### Versão 2: Funcionalidade de Busca e Validações Simples
A segunda versão do sistema trouxe melhorias significativas, como a funcionalidade de busca por palavras-chave e validações básicas para garantir a integridade das entradas fornecidas. Além disso, a persistência dos dados foi otimizada para maior eficiência.

### Versão 3: Interface Aprimorada e Mensagens de Erro Detalhadas
Na terceira versão, o foco foi aprimorar a experiência do usuário, com a introdução de um menu mais amigável e mensagens de erro detalhadas. O sistema agora solicita confirmações antes de excluir ou editar um link, reduzindo a chance de erros acidentais.

### Versão 4: Otimização de Código e Persistência Aprimorada
Na quarta versão, o código foi refatorado para ser mais modular e reutilizável. Houve melhorias significativas na manipulação de arquivos e uma documentação mais completa foi criada, facilitando a compreensão e manutenção do projeto.


## Estrutura do Projeto
- **GerenciadorLinks.java**: Código fonte principal do sistema.
- **links.txt**: Arquivo de armazenamento dos links cadastrados.

---

## Como Usar
- ** Copie e cole os códigos

