package inferencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

/* Busca e retorna o HTLM da URL discriminada */

public class InferenciaExemplo {
  public static void main(String[] args) throws IOException {
    URL url = new URL("https://www.deepl.com/pt-BR/translator/");
    URLConnection urlConnection = url.openConnection();
    BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(urlConnection.getInputStream()));

    System.out.println(bufferedReader.lines()
        .collect(Collectors.joining())
        .replaceAll(">", ">\n"));

  }
}
