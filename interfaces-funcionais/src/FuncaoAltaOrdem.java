public class FuncaoAltaOrdem {
  public static void main(String[] args) {
    /*Calculo soma = (a, b) -> a + b;*/
    Calculo soma = Integer::sum;
    Calculo subtracao = (a, b) -> a - b;
    Calculo multiplicacao = (a, b) -> a * b;
    Calculo divisao = (a, b) -> a / b;

    System.out.println("Operações com os número 25 e 5");
    System.out.println("Soma :: " + executarOpercao(soma, 25, 5));
    System.out.println("Subtracao :: " + executarOpercao(subtracao, 25, 5));
    System.out.println("Multiplicacao :: " + executarOpercao(multiplicacao, 25, 5));
    System.out.println("Divisao :: " + executarOpercao(divisao, 25, 5));
  }

  public static int executarOpercao(Calculo calculo, int a, int b) {
    return calculo.calcular(a, b);
  }
}

@FunctionalInterface
interface Calculo {
  int calcular(int a, int b);
}
/*
  calculo.calcular(a, b) é a mesma coisa que:

  public int soma(int a, b) {
    return a + b;
  }
*/
