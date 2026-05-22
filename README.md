# Sistema Conversor de Notas

Projeto desenvolvido em Java para a disciplina de Estrutura de Dados I.

O objetivo do sistema é converter dados de notas escolares de um formato legado para um novo formato utilizando listas encadeadas implementadas manualmente, sem uso de coleções prontas do Java.

---

# Objetivo do Projeto

O sistema lê um arquivo texto contendo dados de alunos e notas no formato antigo:

111#Carlos#8#5

E converte para o novo formato:

26.S1-111;Carlos;8.5

Caso exista ausência de nota (`-1`), o sistema utiliza o valor:

99.9

---

# Tecnologias Utilizadas

- Java 17
- Programação Orientada a Objetos
- Lista Simplesmente Encadeada
- Lista Duplamente Encadeada
- Manipulação de Arquivos Texto

---

# Conceitos Utilizados

O projeto utiliza conceitos básicos de Estrutura de Dados e POO:

- Encapsulamento
- Classes e Objetos
- Nós (Node)
- Lista Encadeada
- Lista Duplamente Encadeada
- Métodos getters e setters
- Estruturas de repetição
- Condicionais
- Leitura e gravação de arquivos

---

# Estrutura do Projeto

```text
SistemaConversorNotas/
│
├── dados.txt
├── dados.csv
│
└── src/
    │
    ├── Main.java
    │
    └── apl2/
        │
        ├── Node.java
        ├── DLinkedList.java
        ├── Operation.java
        ├── Data.java
        ├── NodeOriginal.java
        └── LinkedListOriginal.java
