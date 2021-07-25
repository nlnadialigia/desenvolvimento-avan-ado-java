<p align="center">
  <img src="../.github/async.png" width=400 alt="Processamento Assíncrono e Paralelo" /> 
</p>

<p align="center">
  <img src="https://img.shields.io/badge/author-Nadia%20Ligia-c84b31?style=plastic">&nbsp;

  <a href="https://www.linkedin.com/in/nlnadialigia/">
  <img alt="Linkedin" src="https://img.shields.io/badge/-Linkedin -c84b31?style=plastic&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/nlnadialigia/" />
  </a>&nbsp;
  <a href="mailto:nlnadialigia@gmail.com">
    <img alt="Email" src="https://img.shields.io/badge/-Email-c84b31?style=plastic&logo=Gmail&logoColor=white&link=mailto:nlnadialigia@gmail.com" />
  </a>&nbsp;
  <img alt="GitHub last commit (branch)" src="https://img.shields.io/github/last-commit/nlnadialigia/desenvolvimento-avancado-java/async?color=c84b31&style=plastic">
</p>

<br>

# Índice

- [O que é síncrono e assíncrono](#📌-o-que-é-síncrono-e-assíncrono)
  - [Threads](#📎-threads)
  - [Processamento síncrono](#📎-processamento-síncrono)
  - [Processamento assíncrono](#📎-processamento-assíncrono)
- [Desenvolvendo uma API de Threads do Java](#📌-desenvolvendo-uma-api-de-threads-do-java)

<br>

## 📌 O que é síncrono e assíncrono

### 📎 Threads

> É um pequeno programa que trabalha como um subsistema, sendo uma forma de um processo se autodividir em duas ou mais tarefas. Essas tarefas múltiplas podem ser executadas simultaneamente para rodar mais rápido do que um programa em um único bloco ou praticamente juntas.

- Execução de vários programas de forma paralela.

<br>

### 📎 Processamento síncrono

> São todos os processamentos que `ocorrem em sequência` (sincronia). Os processos são executados em fila. É preciso que um processo termine para que outro processo seja executado.

- Exemplo: Imagine você lavando louça e de repente você se lembra que tem que fazer uma ligação. A ligação só poderá ser realizada quando o processo lavar louça for finalizado.

<br>

### 📎 Processamento assíncrono

> Quando dois ou mais processos são `realizados ao mesmo tempo`, é dado o nome de processamento assíncrono. Os processos são realizados simultaneamente sem que um processo necessite que outro termine para ser executado.

- Exemplo: Lavar louça e falar ao telefone ao mesmo tempo. Se você não sabe como fazer isso, prenda o telefone entre a cabeça e o ombro e tenha as mãos livres para lavar louça.

<br>

## 📌 Desenvolvendo uma API de Threads do Java

- Para exemplificar foi criada uma classe com 2 métodos, gerar PDF e Barra de Carregamento enquanto o pdf não é gerado.

  ```java
  public class ThreadExemplo {
    public static void main(String[] args) {
      GeradorPDF iniciarGeradorPdf = new GeradorPDF();
      BarraDeCarregamento iniciarBarraDeCarregamento = new BarraDeCarregamento(iniciarGeradorPdf);

      iniciarGeradorPdf.start();
      iniciarBarraDeCarregamento.start();

    }
  }

  class GeradorPDF extends Thread {
    @Override
    public void run() {
      super.run();

      try {
        System.out.println("Iniciar geração de PDF");
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("PDF Gerado");
    }

  }

  class BarraDeCarregamento extends Thread {

    private final Thread iniciarGeradorPdf;

    public BarraDeCarregamento(Thread iniciarGeradorPdf) {
      this.iniciarGeradorPdf = iniciarGeradorPdf;
    }

    @Override
    public void run() {
      while (true) {
        try {
          Thread.sleep(500);
          if (!iniciarGeradorPdf.isAlive()) {
            break;
          }
          System.out.println("Loading...");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
  ```
