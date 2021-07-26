<p align="center">
  <img src="../.github/java10.png" width=400 alt="Novidades do Java 10" /> 
</p>

<p align="center">
  <img src="https://img.shields.io/badge/author-Nadia%20Ligia-fd3a69?style=plastic">&nbsp;

  <a href="https://www.linkedin.com/in/nlnadialigia/">
  <img alt="Linkedin" src="https://img.shields.io/badge/-Linkedin -fd3a69?style=plastic&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/nlnadialigia/" />
  </a>&nbsp;
  <a href="mailto:nlnadialigia@gmail.com">
    <img alt="Email" src="https://img.shields.io/badge/-Email-fd3a69?style=plastic&logo=Gmail&logoColor=white&link=mailto:nlnadialigia@gmail.com" />
  </a>&nbsp;
  <img alt="GitHub last commit (branch)" src="https://img.shields.io/github/last-commit/nlnadialigia/desenvolvimento-avancado-java/java10?color=fd3a69&style=plastic">
</p>

<br>

# Índice

- [Inferência de tipo](#📌-inferência-de-tipo)
- [Substituindo declarações por var](#📌-substituindo-declarações-por-var)

<br>

## 📌 Inferência de tipo

> A inferência de tipo representa a capacidade do compilador Java de examinar uma chamada de método e sua declaração correspondente para verificar e determinar o (s) argumento (s) de tipo. O algoritmo de inferência verifica os tipos dos argumentos e, se disponível, o tipo atribuído é retornado. Os algoritmos de inferência tentam encontrar um tipo específico que possa preencher todos os parâmetros de tipo.

- O compilador gera aviso de conversão não verificado, caso não seja usada a inferência do tipo.
- **Sintaxe**

  ```java
  Box<Integer> integerBox = new Box<>();

  ```

  - Onde
    - **Box** - Box é uma classe genérica.
    - **<>** - O operador de diamante indica inferência de tipo.

<br>

- **Exemplo ⇒ Buscar e retornar o HTML da URL discriminada**

  ```java
  public class InferenciaExemploI {
    public static void main(String[] args) throws IOException {
      URL url = new URL("https://docs.oracle.com/javase/10/language/");
      URLConnection urlConnection = url.openConnection();
      BufferedReader bufferedReader = new BufferedReader(
          new InputStreamReader(urlConnection.getInputStream()));

      System.out.println(bufferedReader.lines()
          .collect(Collectors.joining())
          .replaceAll(">", ">\n"));

    }
  }
  ```

## 📌 Substituindo declarações por var

- A partir do Java 10 podemos escolher se vamos deixar o compilador inferir os tipos usando a palavra reservada var

  ```java
  var url = new URL("https://docs.oracle.com/javase/10/language/");
  var urlConnection = url.openConnection();
  var bufferedReader = new BufferedReader(
         new InputStreamReader(urlConnection.getInputStream())
  );
  ```

- Isso se tornou possível porque, a partir do Java 10, o compilador da linguagem, ao encontrar a palavra var no teu código, vai saber que o tipo da variável vai estar no lado direito da declaração.

### 📎 Utilização do var

- variáveis local inicializadas
- variável suporte do enhaced for
- variável suporte do for iterativo
- variável try with resource

### 📎 Não utilização do var

- var não pode ser utilizado em nível de classe
- var não pode ser utilizado como parâmetro
- var não pode ser utilizada em variáveis locais não inicializadas
