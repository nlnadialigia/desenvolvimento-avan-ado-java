package inferencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

/* Busca e retorna o HTML da URL discriminada */

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
