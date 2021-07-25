package lambda;

public class FuncaoComLambda {
  public static void main(String[] args) {
//    Funcao colocarPrefixoSenhorNaString = valor -> "Sr. " + valor;
//    System.out.println(colocarPrefixoSenhorNaString.gerar("João"));
//  }

    Funcao colocarPrefixoSenhorNaString = valor -> {
      String valorComPrefixo = "Sr. " + valor;
      return valorComPrefixo + ".";
    };

    System.out.println(colocarPrefixoSenhorNaString.gerar("Rodrigo"));
  }
}

