# 📚 Biblioteca Atal - Árvore Binária de Busca (BST)

Este sistema gerencia livros utilizando uma Árvore Binária de Busca (BST) e um array dinâmico. Ele organiza e realiza operações como inserção, ordenação, busca e recomendação de livros.

## Funcionalidades

- **Adicionar Livro**:  
  Livros são inseridos na árvore binária e no array com base em seu título e autor, seguindo a regra de ordenação: valores menores vão para a subárvore esquerda e valores maiores para a subárvore direita.

- **Percorrer a Árvore**:  
  É possível percorrer a árvore em três ordens:
  - **Pré-Ordem**: Raiz, Esquerda, Direita.
  - **Em Ordem**: Esquerda, Raiz, Direita.
  - **Pós-Ordem**: Esquerda, Direita, Raiz.

- **Buscar Sucessor**:  
  Encontra o próximo livro em ordem crescente, localizado como o menor valor na subárvore direita.

- **Buscar Antecessor**:  
  Encontra o livro anterior em ordem crescente, localizado como o maior valor na subárvore esquerda.

- **Recomendação de Livros por Autor**:  
  Percorre a árvore para listar todos os livros de um autor específico.

## Como Funciona

### 1. Adicionar Elemento na Árvore
Ao adicionar um livro, ele é posicionado de acordo com a ordenação:
- Se a árvore estiver vazia, o livro se torna a raiz.
- Caso contrário, o livro é inserido na subárvore esquerda ou direita dependendo do seu título comparado ao nó atual.

### 2. Percorrer a Árvore
Os três tipos de percurso (pré-ordem, em ordem e pós-ordem) são implementados com funções recursivas para navegar pela árvore e processar os nós conforme a ordem especificada.

### 3. Buscar Sucessor e Antecessor
- **Sucessor**: Encontra o menor valor na subárvore direita do nó.
- **Antecessor**: Encontra o maior valor na subárvore esquerda do nó.

### 4. Recomendação por Autor
Percorre a árvore para encontrar todos os livros de um autor especificado, retornando uma lista de livros encontrados.

Usamos um array dinâmico para guardar os livros na lista, que é basicamente uma estrutura que cresce automaticamente conforme novos livros são adicionados. No início, a lista começa com um tamanho que escolhemos (definido quando a SequentialList é criada), com capacidade inicial de 5 elementos. Quando ela fica cheia, a capacidade dobra, permitindo que a lista armazene mais livros sem limite fixo.

Essa escolha é boa para guardar itens em sequência e facilita operações como busca, adição e remoção de elementos, o que funciona bem para uma lista de livros que não muda o tempo todo. Um array dinâmico como esse é eficiente para acessar e buscar itens na ordem em que foram adicionados, mas pode ser menos eficiente para inserções e remoções frequentes em posições aleatórias da lista.

- **Explicação sobre o Algoritmo de Ordenação**
  
No método ordenarPorTituloEAutor(), usamos o Bubble Sort para organizar os livros, primeiro pelo título e, se dois títulos forem iguais, pelo nome do autor. Esse algoritmo é simples: ele percorre a lista várias vezes, trocando a posição de dois livros vizinhos sempre que eles estão na ordem errada. Esse processo continua até que a lista esteja completamente organizada e nenhuma troca adicional seja necessária.

O Bubble Sort pode não ser o mais rápido para listas muito grandes, mas ele pode ser fácil de implementar e funciona bem para listas pequenas ou médias, como essa. A verificação com trocou ajuda a interromper o processo mais cedo, se possível, evitando voltas desnecessárias caso a lista já esteja ordenada antes do fim do processo.

A complexidade do Bubble Sort é O(n²) no pior e no caso médio, devido às várias passagens pela lista e à comparação de cada par de elementos.

<br>

## Aplicação

Sistema desenvolvido em Java (JDK 17) para gerenciar o acervo de uma biblioteca. Este projeto permite o armazenamento, organização, busca e remoção de livros.

## Funcionalidades array

- Armazenamento de dados dos livros no sistema
- Ordenação de livros
- Busca de livros
- Remoção de livros

  ## Funcionalidades árvore

- Recomendação de livros por autor
- Percorrer árvore de livros em pré ordem, em ordem e pós ordem
- Buscar livro sucessor
- Buscar livro antecessor


## 🛠️ Especificações do Projeto

### Estrutura de Dados

- Utiliza uma **lista sequencial** para armazenar objetos que representam os livros, com os seguintes atributos:
  - **Título**
  - **Autor**
  - **Ano de Publicação**

### Algoritmo de Ordenação

- **Bubble Sort**: Implementado para ordenar os livros por **título** e **autor**.

### Interface

- Adicionar livros
- Listar todos os livros
- Ordenar por título e autor
- Buscar um livro específico pelo título
- Remover um livro pelo índice
- Recomendar livros por autor
- Exibir livros em pré ordem
- Exibir livros em ordem 
- Exibir livros em pós ordem
- Exibir livro sucessor
- Exibir livro antecessor

## ⚙️ Pré-requisitos

- **Java JDK 17**: Certifique-se de ter o JDK 17 instalado para executar este projeto.
- **IDE recomendada**: [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Instalação

1. Clone o repositório:
    ```bash
    git clone https://github.com/thiago-ribeiro1/atal-biblioteca-tree.git
    ```

2. Navegue até o diretório do projeto:
    ```bash
    cd atal-biblioteca-tree
    ```

3. Compile e execute o projeto:
    ```bash
    java Main.java
    ```
