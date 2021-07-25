<p align="center">
  <img src="../.github/module.png" width=400 alt="Modularização do Java" /> 
</p>

<p align="center">
  <img src="https://img.shields.io/badge/author-Nadia%20Ligia-9d0191?style=plastic">&nbsp;

  <a href="https://www.linkedin.com/in/nlnadialigia/">
  <img alt="Linkedin" src="https://img.shields.io/badge/-Linkedin -9d0191?style=plastic&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/nlnadialigia/" />
  </a>&nbsp;
  <a href="mailto:nlnadialigia@gmail.com">
    <img alt="Email" src="https://img.shields.io/badge/-Email-9d0191?style=plastic&logo=Gmail&logoColor=white&link=mailto:nlnadialigia@gmail.com" />
  </a>&nbsp;
  <img alt="GitHub last commit (branch)" src="https://img.shields.io/github/last-commit/nlnadialigia/desenvolvimento-avancado-java/module?color=9d0191&style=plastic">
</p>

<br>

# Índice

- [Entendendo o que é a modularização por meio do Jigsaw](#📌-entendendo-o-que-é-a-modularização-por-meio-do-jigsaw)
- [Inciando um projeto com Java Modular](#📌-inciando-um-projeto-com-java-modular)

<br>

## 📌 Entendendo o que é a modularização por meio do Jigsaw

- Há muito tempo se diz sobre modularizar a plataforma Java. É um plano que começou desde antes do Java 7, foi possibilidade no Java 8 e por fim, para permitir mais tempo de desenvolvimento, revisão e testes, foi movido para o Java 9.

- O projeto Jigsaw, como foi chamado, é composto por uma série de JEPs. Algumas delas inclusive já disponíveis no Java 8, como os conhecidos Compact Profiles. A ideia por trás do projeto não é só criar um sistema de módulos, que poderemos usar em nossos projetos, mas também aplicá-lo em toda a plataforma e JDK em busca de melhor organização e desempenho.

- Por padrão, `todo sistema modular já vem com o módulo java.base , java.util` e demais pacotes muitas vezes essenciais para a esmagadora maioria dos projetos.

- Para verificar quais os módulos do java que estão presente:
  ```java
  java --list-modules
  ```
- Os módulos que não vieram por padrão deverão ser adicionados ao arquivo `module-info.java`.

<br>

## 📌 Inciando um projeto com Java Modular

- Para exemplificar foi desenvolvido o projeto de uma calculadora, onde as classes referentes às operações ficaram restritas ao módulo que contém a calculadora.

- Para fazer essas especificações é necessário incluir no arquivo `module-info.java` as informações de importação e requisição em cada módulo.

- O módulo `utils` contém a `Calculadora` e suas classes referente às operações de soma, subtração, divisão e multiplicação.

- O módulo `core` contém somente a classe `Runner`, responsável por rodar o programa.
