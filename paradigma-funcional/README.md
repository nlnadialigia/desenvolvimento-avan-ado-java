<p align="center">
  <img src="../.github/paradigma.png" width=400 alt="Paradigma Funcional" /> 
</p>

<p align="center">
  <img src="https://img.shields.io/badge/author-Nadia%20Ligia-9d0191?style=plastic">&nbsp;

  <a href="https://www.linkedin.com/in/nlnadialigia/">
  <img alt="Linkedin" src="https://img.shields.io/badge/-Linkedin -9d0191?style=plastic&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/nlnadialigia/" />
  </a>&nbsp;
  <a href="mailto:nlnadialigia@gmail.com">
    <img alt="Email" src="https://img.shields.io/badge/-Email-9d0191?style=plastic&logo=Gmail&logoColor=white&link=mailto:nlnadialigia@gmail.com" />
  </a>&nbsp;
  <img alt="GitHub last commit (branch)" src="https://img.shields.io/github/last-commit/nlnadialigia/desenvolvimento-avancado-java/paradigma?color=9d0191&style=plastic">
</p>

<br>

# Índice

- [Entenda o que é Paradigma Funcional no Java](#📌-entenda-o-que-é-paradigma-funcional-no-java)
- [Funções e imutabilidade em Paradigma Funcional](#📌-funções-e-imutabilidade-em-paradigma-funcional)
- [Lambda no Java](#📌-lambda-no-java)
- [Recursividade](#📌-recursividade)

<br>

## 📌 Entenda o que é Paradigma Funcional no Java

> Programação funcional é o processo de construir software através de composição de funções puras, evitando compartilhamento de estados, dados mutáveis e efeitos colaterais. É declarativa ao invés de imperativa, essa é uma definição de Eric Elliott.

<br>

### 📎 Paradigma Imperativo

> É aquele que expressa o código através de comandos ao computador, nele é possível ter controle de estado dos objetos. As execuções são isntantâneas, ou seja, no momento que declaramos elas são executadas.

```java
public static void main(String[] args) {
  int valor = 10;
  int resultado = valor * 3;

  System.out.println("O resultado é ::" + resultado);
}
```

### 📎 Paradigma Funcional

> Damos uma regra, uma declaração de como queremos que o programa se comporte.

```java
public static void main(String[] args) {
  UnaryOperator<Integer> calcularValorVezes3 = valor -> valor * 3;
  int valor = 10;
  System.out.println("O resultado é ::" + calcularValorVezes3.apply(10));
}
```

<br>

## 📌 Funções e imutabilidade em Paradigma Funcional

### 📎 Composição de funções

> É criar uma nova função através da composição de outras. Por exemplo, vamos criar uma função que vai filtrar um array, filtrando somente os números pares e multiplicando por dois.

```java
public static void main(String[] args) {
  int[] valores = {1, 2, 3, 4};
  Arrays.stream(valores)
      .filter(numero -> numero % 2 == 0)
      .map(numero -> numero * 2)
      .forEach(numero -> System.out.println(numero));
}
```

<br>

### 📎 Funções Puras

> É chamada de pura quando invocada mais de uma vez produz exatamente o mesmo resultado.

```java
public static void main(String[] args) {
  BiPredicate<Integer, Integer> verificarSeEMaior =
      (parametro, valorComparacao) -> parametro > valorComparacao;

  System.out.println(verificarSeEMaior.test(13, 12));
  System.out.println(verificarSeEMaior.test(12,13));
}
```

<br>

### 📎 Imutabilidade

> Significa que uma vez uma variável que recebeu um valor, vai possuir esse valor para sempre, ou quando criamos um objeto ele não pode ser modificado.

```java
public static void main(String[] args) {
  int valor = 20;
  UnaryOperator<Integer> retornarDobro = v -> v * 2;

  System.out.println("Retorna o dobro do valor :: " + retornarDobro.apply(valor));
  System.out.println("Valor" + valor);
}
```

<br>

### 📎 Imperativo x Declarativo

> É muito comum aprender a programar de forma imperativa, onde mandamos alguém fazer algo, Busque o usuário 15 no banco de dados. Valide essas informações do usuário.

> Na programação funcional tentamos programar de forma declarativa, onde declaramos o que desejamos, sem explicitar como será feito. Qual o usuário 15? Quais os erros dessas informações?

<br>

## 📌 Lambda no Java

> Os lambdas obedecem o conceito do paradigma funcional, com eles podemos facilitar legibilidade do nosso código, além disso com a nova API Funcional do Java podemos ter uma alta produtividade para lidar com objetos.

- Primeiramente, devemos entender o que são interfaces funcionais.

- **Interfaces funcionais:** São interfaces que possuem apenas um método abstrato, Exemplo: *public interface Funcao { String gerar (String valor); }*

  ```java
  public interface Funcao {
    String gerar(String valor);
  }
  ```

- Geralmente as interfaces funcionais possuem uma anotação em nível de classe (**`@FunctionalInterface`**), para forçar o compilador a apontar um erro se a interface não estiver do acordo com as regras de uma interface funcional. Esta anotação não obrigatória, pois o compilador consegue reconhecer uma interface em tempo de compilação.

  ```java
  @FunctionalInterface
  public interface Funcao {
    String gerar(String valor);
  }
  ```

- Antes do Java 8, se quiséssemos implementar um comportamento especifico para uma única classe deveríamos utilizar uma classe anônima para implementar este comportamento.

  ```java
  public class FuncaoSemLambda {
    public static void main(String[] args) {

      Funcao colocarPrefixoSenhorNaString = new Funcao() {
        @Override
        public String gerar(String valor) {
          return "Sr. " + valor;
        }
      };
      System.out.println(colocarPrefixoSenhorNaString.gerar("João"));
    }
  }
  ```

- Agora que sabemos como se define uma interface funcional podemos, aprender como se define uma lambda.

- Estrutura de uma lambda:

  `InterfaceFuncional nomeVariavel = parametro → logica`

  ```java
  public class FuncaoComLambda {
    public static void main(String[] args) {
      Funcao colocarPrefixoSenhorNaString = valor -> "Sr. " + valor;
      System.out.println(colocarPrefixoSenhorNaString.gerar("João"));
    }
  }
  ```

### Bastante atenção!!!

- Quando uma lambda possui apenas uma instrução no corpo de sua lógica não é necessário o uso de chaves

  ```java
  Funcao colocarPrefixoSenhorNaString = valor -> "Sr. " + valor;
  ```

- Se a função possui mais de uma instrução DEVEMOS utilizar chaves e explicitar o retorno se o retorno for diferente de void.
  ```java
  Funcao colocarPrefixoSenhorNaString = valor -> {
    String valorComPrefixo = "Sr. " + valor;
    return valorComPrefixo + ".";
  };
  ```
  <br>

## 📌 Recursividade

> Na recursividade, uma função chama a si mesma repetidamente, até atingir uma condição de parada. No caso de Java, um método chama a si mesmo, passando para si objetos primitivos. Cada chamada gera uma nova entrada na pilha de execução, e alguns dados podem ser disponibilizados em um escopo global ou local, através de parâmetros em um escopo global ou local.

- Recursividade tem um papel importante em programação funcional, facilitando que evitemos estados mutáveis e matenhamos nosso programa mais declarativo, e menos imperativo.

  ```java
  public class FatorialRecursivo {
    public static void main(String[] args) {
      System.out.println(fatorial(5));
    }

    public static int fatorial(int value) {
      if (value == 1) {
        return value;
      } else return value * fatorial(value - 1);
    }
  }
  ```

  ![Explicação Recursividade](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/8a4cc1b2-8dc7-41f1-94a6-f7f213f04eab/Captura_de_tela_de_2021-07-24_22-30-53.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210725%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210725T031845Z&X-Amz-Expires=86400&X-Amz-Signature=d8fc0b90e473a78def400da8101c8ea170d22280ef6022bd22b4f0c6d5582574&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Captura_de_tela_de_2021-07-24_22-30-53.png%22)

### 📎 Tail Call (Recursividade em cauda):

- Recursão em cauda é uma recursão onde não há nenhuma linha de código após a chamada do próprio método e, sendo assim, não há nenhum tipo de processamento a ser feito após a chamada recursiva.

  ```java
  public class FatorialTailCall {
    public static void main(String[] args) {
      System.out.println(fatorialA(5));
    }

    public static double fatorialA(double valor) {
      return fatorialComTailCall(valor, 1);
    }

    public static double fatorialComTailCall(double valor, double numero) {
      if (valor == 0) {
        return numero;
      }
      return fatorialComTailCall(valor - 1, numero * valor);
    }
  }
  ```

  ![Explicação Tail Call](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/4222121e-7998-4409-8d68-53630f28359f/Captura_de_tela_de_2021-07-24_23-27-25.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210725%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210725T031953Z&X-Amz-Expires=86400&X-Amz-Signature=5dd16fc174b8540d51271d0ca0e51df01adffcb7f05f1a6400141b729492ecab&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Captura_de_tela_de_2021-07-24_23-27-25.png%22)

> _Observação: A JVM não suporta a recursão em cauda, ele lança um estouro de pilha (StackOverFlow)._

<br>

### 📎 Memoization

> É uma técnica de otimização que consiste no cache do resultado de uma função, baseado nos parâmetros de entrada. Com isso, nas seguintes execuções conseguimos ter uma resposta mais rápida.

```java
public class FatorialMemoization {
  static Map<Integer, Integer> MAPA_FATORIAL = new HashMap<>();

  public static void main(String[] args) {
    long I = System.nanoTime();
    System.out.println(fatorialComMemoization(15));
    long F = System.nanoTime();
    System.out.println("FATORIAL 1 " + (F - I));

    I = System.nanoTime();
    System.out.println(fatorialComMemoization(15));
    F = System.nanoTime();
    System.out.println("FATORIAL 1 " + (F - I));

  }

  public static Integer fatorialComMemoization(Integer value) {
    if (value == 1) {
      return value;
    } else {
      if (MAPA_FATORIAL.containsKey(value)) {
        return MAPA_FATORIAL.get(value);
      } else {
        Integer resultado = value * fatorialComMemoization(value - 1);
        MAPA_FATORIAL.put(value, resultado);
        return resultado;
      }
    }
  }
}
```
