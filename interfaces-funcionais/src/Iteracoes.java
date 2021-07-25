import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {

  public static void main(String[] args) {
    String[] nomes = {"Nadia", "Ligia", "Paula", "Nadia", "André", "Luiz"};
    Integer[] numeros = {1, 2, 3, 4, 5};
    imprimirNomesFiltrados(nomes);
    imprimirTodosOsNomes(nomes);
    imprimirODobroDeCadaNumero(numeros);

    // Utilização do STREAM com métodos próprios do JAVA
    List<String> profissoes = new ArrayList<>();
    profissoes.add("Desenvolvedor");
    profissoes.add("Testador");
    profissoes.add("Gerente de projeto");
    profissoes.add("Gerente de qualidade");

    profissoes.stream()
        .filter(profissao -> profissao.startsWith("Gerente"))
        .forEach(System.out::println);
  }

    /*Verificar se tem o nome Nadia no array de nomes*/
    public static void imprimirNomesFiltrados(String... nomes) {

      String nomesParaImprimir = "";

      for (String nome : nomes) {
        if (nome.equals("Nadia")) {
          nomesParaImprimir += " " + nome;
        }
      }
      System.out.println("For: " + nomesParaImprimir);


      /*Utilizando Java API*/
      String nomesParaImprimirDaStream = Stream.of(nomes)
          .filter(nome -> nome.equals("Nadia"))
          .collect(Collectors.joining()); //coloca um espaço entre as strings

      System.out.println("Stream: " + nomesParaImprimirDaStream);


    }

    /*Imprimir todos os nomes do array*/
    public static void imprimirTodosOsNomes(String... nomes) {
      for (String nome : nomes) {
        System.out.println("Impresso pelo FOR: " + nome);
      }

      // Utilizando Java API
      Stream.of(nomes)
          .forEach(nome -> System.out.println("Impresso pelo FOREACH: " + nome));
    }

    /* Imprimir o dobro de cada número do array de números*/
  public static void imprimirODobroDeCadaNumero(Integer... numeros){
    for (Integer numero : numeros) {
      System.out.println(numero*2);
    }

    //Utilizando Java API
    Stream.of(numeros).map(numero -> numero * 2)
        .forEach(System.out::println);
  }
}
