package inferencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

/* Utilização do var */

public class InferenciaExemploII {
  public static void main(String[] args) throws IOException {
    printarNomeCompleto("Nadia", "Santos");
    printarSoma(7,9,153,15,22,19);
    connectAndPrintUrl();
  }

  private static void connectAndPrintUrl() {
    try {
      var url = new URL("https://docs.oracle.com/javase/10/language/");
      var urlConnection = url.openConnection();
      var bufferedReader = new BufferedReader(
          new InputStreamReader(urlConnection.getInputStream()));

      System.out.println(bufferedReader.lines()
          .collect(Collectors.joining())
          .replaceAll(">", ">\n"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void printarNomeCompleto(String nome, String sobrenome) {
    var nomeCompleto = String.format("%s %s", nome, sobrenome);
    System.out.println(nomeCompleto);
  }

  public static void printarSoma(int... numeros) {
    int soma;
    if (numeros.length > 0) {
      soma = 0;
      for (var numero : numeros) {
        soma += numero;
      }

      System.out.println("A soma é ::: " + soma);
    }
  }
}
