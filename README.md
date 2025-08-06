# Lab: Criando um Banco Digital com Java e Orientação a Objetos

## 💻 Sobre o Projeto

Este projeto é uma simulação de um banco digital, desenvolvido como parte do desafio de projeto do bootcamp **Santander 2025 - Back-End com Java** da [Digital Innovation One (DIO)](https://web.dio.me).

O objetivo inicial era aplicar os conceitos fundamentais de **Orientação a Objetos** (Abstração, Encapsulamento, Herança e Polimorfismo) em Java para criar a estrutura básica de contas bancárias. A partir dessa base, o projeto foi estendido para incluir funcionalidades mais robustas e realistas, transformando-o em uma simulação mais completa e funcional.

> Para mais informações sobre o bootcamp, acesse: [Santander 2025 - Back-End com Java](https://web.dio.me/track/santander-2025-java-back-end)

---

## 🚀 Evoluções Implementadas

O projeto base foi significativamente aprimorado para refletir um sistema bancário mais próximo da realidade. As principais melhorias estão detalhadas abaixo:

### 1. Modelo de Domínio Enriquecido

*   **`Cliente` com CPF:** A classe `Cliente` foi atualizada para incluir o atributo `cpf`, um identificador único e essencial para qualquer cliente de uma instituição financeira.

*   **`Banco` como Gerenciador Central:** A classe `Banco` deixou de ser apenas um contêiner passivo. Agora, ela gerencia ativamente a lista de contas e possui métodos para adicionar novas contas e listar todos os clientes, evitando a duplicação de informações.

### 2. Sistema de Histórico de Transações

Para que um banco digital seja útil, o cliente precisa de um extrato claro. Para isso, foi criado um sistema completo de transações:

*   **Classe `Transacao`:** Registra os detalhes de cada operação, incluindo:
    *   Data e hora da transação.
    *   Tipo da operação (saque, depósito, etc.).
    *   Valor.
    *   Uma descrição para fácil identificação (ex: "Transferência para Conta 123").

*   **Enum `TipoTransacao`:** Padroniza os tipos de transação (`DEPOSITO`, `SAQUE`, `TRANSFERENCIA_ENVIADA`, `TRANSFERENCIA_RECEBIDA`), tornando o código mais legível e seguro.

### 3. Lógica de Negócio e Validações na Classe `Conta`

A classe `Conta` tornou-se o cérebro das operações, garantindo a integridade dos dados com as seguintes regras:

*   **Validação de Saldo:** Os métodos `sacar()` e `transferir()` agora verificam se o saldo em conta é suficiente antes de concluir a operação, prevenindo saldos negativos indesejados.
*   **Validação de Valores:** Nenhuma operação pode ser realizada com valores negativos ou nulos.
*   **Registro Automático:** Toda operação bem-sucedida (saque, depósito ou transferência) é automaticamente registrada como um objeto `Transacao` na lista de transações da conta.
*   **Transferência Bidirecional:** O método `transferir()` foi aprimorado para registrar a transação tanto na conta de origem (`TRANSFERENCIA_ENVIADA`) quanto na de destino (`TRANSFERENCIA_RECEBIDA`), garantindo que ambos os extratos reflitam a operação corretamente.

### 4. Extrato Detalhado e Funcional

O método `imprimirExtrato()` foi completamente reformulado. Em vez de mostrar apenas o saldo, ele agora exibe:

1.  As informações do titular da conta (nome, CPF, agência e número).
2.  Um histórico completo de todas as transações, formatado de maneira clara.
3.  O saldo final atualizado.

---

## 🛠️ Como Executar

1.  Certifique-se de ter o **Java** e o **Maven** instalados em seu ambiente.
2.  Clone o repositório:
    ```bash
    git clone https://github.com/JuanBailke/Lab-Banco-Digital-DIO.git
    ```
3.  Navegue até o diretório do projeto.
4.  Execute a classe `Main.java` a partir da sua IDE ou compile e execute via terminal. A classe `Main` contém um cenário de exemplo que demonstra a criação de clientes, contas e a realização de diversas operações.

---

## 🔧 Tecnologias Utilizadas

*   **Java 23:** Linguagem principal do projeto.
*   **Maven:** Gerenciador de dependências e build do projeto.
*   **Lombok:** Biblioteca para reduzir código boilerplate (como getters, setters e construtores).

---

*Este projeto demonstra a aplicação prática de POO e a evolução de um sistema simples para uma solução com regras de negócio mais complexas e funcionais.*