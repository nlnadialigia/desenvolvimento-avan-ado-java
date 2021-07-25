import java.util.function.Consumer;

public class Consumidores {
  public static void main(String[] args) {
    // Consumer<String> imprimirUmaFrase = frase -> System.out.println(frase);
    Consumer<String> imprimirUmaFrase = System.out::println;
    imprimirUmaFrase.accept("Mais um dia de Java");
  }
}
