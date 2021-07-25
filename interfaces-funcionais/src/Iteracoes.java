import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {

  public static void main(String[] args) {
    String[] nomes = {"Nadia", "Ligia", "Paula", "Nadia", "André", "Luiz"};
    Integer[] numeros = {1, 2, 3, 4, 5};
    imprimirNomesFiltrados(nomes);
    imprimirTodosOsNomes(nomes);

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

    public static void imprimirTodosOsNomes(String... nomes) {
      for (String nome : nomes) {
        System.out.println("Impresso pelo FOR: " + nome);
      }

      // Utilizando Java API
      Stream.of(nomes)
          .forEach(nome -> System.out.println("Impresso pelo FOREACH: " + nome));
    }

}
