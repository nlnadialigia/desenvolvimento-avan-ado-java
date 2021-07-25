import java.util.function.Supplier;

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

