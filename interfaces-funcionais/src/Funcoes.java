import java.util.function.Function;

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
