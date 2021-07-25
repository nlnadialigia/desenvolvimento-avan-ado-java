package lambda;

public class FuncaoSemLambda {
  public static void main(String[] args) {

    // Funcao com Classe Anônima

    Funcao colocarPrefixoSenhorNaString = new Funcao() {
      @Override
      public String gerar(String valor) {
        return "Sr. " + valor;
      }
    };
    System.out.println(colocarPrefixoSenhorNaString.gerar("João"));


  }
}
