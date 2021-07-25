<p align="center">
  <img src="../.github/interfaces.png" width=400 alt="Interfaces Funcionais" /> 
</p>

<p align="center">
  <img src="https://img.shields.io/badge/author-Nadia%20Ligia-fd3a69?style=plastic">&nbsp;

  <a href="https://www.linkedin.com/in/nlnadialigia/">
  <img alt="Linkedin" src="https://img.shields.io/badge/-Linkedin -fd3a69?style=plastic&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/nlnadialigia/" />
  </a>&nbsp;
  <a href="mailto:nlnadialigia@gmail.com">
    <img alt="Email" src="https://img.shields.io/badge/-Email-fd3a69?style=plastic&logo=Gmail&logoColor=white&link=mailto:nlnadialigia@gmail.com" />
  </a>&nbsp;
  <img alt="GitHub last commit (branch)" src="https://img.shields.io/github/last-commit/nlnadialigia/desenvolvimento-avancado-java/interfaces?color=fd3a69&style=plastic">
</p>

<br>

# Índice

- [Consumindo API Java](#📌-consumindo-api-java)
  - [Funções de alta ordem](#📎-funções-de-alta-ordem)
  - [Consumer](#📎-consumer)
- [Aprenda sobre parâmetro da função](#📌-aprenda-sobre-parâmetro-da-função)
  - [Function](#📎-function)
  - [Predicate](#📎-predicate)
  - [Suppliers](#📎-suppliers)
  - [Stream](#📎-stream)

<br>

## 📌 Consumindo API Java

### 📎 Funções de alta ordem

É uma função que retorna uma função ou que recebe uma função como parâmetro.

```java
public class FuncaoAltaOrdem {
  public static void main(String[] args) {
    Calculo soma = Integer::sum;
    /*Calculo soma = (a, b) -> a + b;*/

    System.out.println(executarOpercao(soma, 1, 3));
  }

  public static int executarOpercao(Calculo calculo, int a, int b) {
    return calculo.calcular(a, b);
  }
}

@FunctionalInterface
interface Calculo {
  int calcular(int a, int b);
}
```

### 📎 Consumer

Interface funcional que recebe um parâmetro e não retorna nada.

```java
public class Consumidores {
  public static void main(String[] args) {
    // Consumer<String> imprimirUmaFrase = frase -> System.out.println(frase);

		Consumer<String> imprimirUmaFrase = System.out::println;
    imprimirUmaFrase.accept("Mais um dia de Java");
  }
}
```

## 📌 Aprenda sobre parâmetro da função

### 📎 Function

As funções recebem um parâmetro e tem que retornar um parâmetro.

```java
public class Funcoes {
  public static void main(String[] args) {

    Function<String, String> retornaNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
    System.out.println(retornaNomeAoContrario.apply("MARIA"));

    //Function<String, Integer> converterStringParaInteiro = string -> Integer.valueOf(string);
    Function<String, Integer> converterStringParaInteiro = Integer::valueOf;
    System.out.println(converterStringParaInteiro.apply("20"));

    Function<String, Integer> converteParaInteiroEDobraOValor = string -> Integer.parseInt(string) * 2;
    System.out.println(converteParaInteiroEDobraOValor.apply("20"));
  }
}
```

### 📎 Predicate

Os predicados recebem um parâmetro qualquer e retornam um `**boolean**`.

```java
public class Predicados {
  public static void main(String[] args) {

    //Predicate<String> estaVazio = valor -> valor.isEmpty();
    Predicate<String> estaVazio = String::isEmpty;
    System.out.println(estaVazio.test(""));
    System.out.println(estaVazio.test("Liberdade"));
  }
}
```

### 📎 Suppliers

Os supridores não recebem parâmetros e retornam algo do tipo definido no **`generic`**.

```java
public class Supridores {
  public static void main(String[] args) {

    //Supplier<Pessoa> suppliers = () -> new Pessoa();
    Supplier<Pessoa> suppliers = Pessoa::new;

    System.out.println(suppliers.get());
  }
}

class Pessoa {
  final private String nome;
  final private Integer idade;

  public Pessoa() {
    nome = "Nadia Ligia";
    idade = 43;
  }

  @Override
  public String toString() {
    return String.format("nome: %s, idade: %d", nome, idade);
  }
}
```

### 📎 Stream

Recurso que oferece ao desenvolvedor a possibilidade de trabalhar com conjuntos de elementos de forma mais simples e com um número menor de linhas de código.

```java
public class Iteracoes {

  public static void main(String[]args) {
    String[] nomes = {"Nadia", "Ligia", "Paula", "Nadia", "André", "Luiz"};
    Integer[] numeros = {1, 2, 3, 4, 5};
imprimirNomesFiltrados(nomes);
imprimirTodosOsNomes(nomes);

  }

    /*Verificar se tem o nome Nadia no array de nomes*/
    public static void imprimirNomesFiltrados(String...nomes) {

      String nomesParaImprimir = "";

      for (String nome :nomes) {
        if (nome.equals("Nadia")) {
          nomesParaImprimir += " " + nome;
        }
      }
      System.out.println("For: " + nomesParaImprimir);

      /*Utilizando Java API*/
      String nomesParaImprimirDaStream = Stream.of(nomes)
          .filter(nome->nome.equals("Nadia"))
          .collect(Collectors.joining()); //coloca um espaço entre as strings

      System.out.println("Stream: " + nomesParaImprimirDaStream);

    }

    /*Imprimir todos os nomes do array*/
    public static void imprimirTodosOsNomes(String...nomes) {
      for (String nome :nomes) {
        System.out.println("Impresso pelo FOR: " + nome);
      }

      // Utilizando Java API
      Stream.of(nomes)
          .forEach(nome-> System.out.println("Impresso pelo FOREACH: " +nome));
    }
}
```
