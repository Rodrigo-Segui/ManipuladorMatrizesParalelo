MANIPULADOR DE MATRIZES SEQUENCIA E PARALELO
<p align="center">
  <a href="#rocket-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#💻-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#começando">Começando</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#memo-licença">Licença</a>
</p>

## :rocket: Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- [JAVA](https://docs.oracle.com/en/java/)

## 💻 Projeto
 
Objetivo: Implementar em Java um algoritmo paralelo/concorrente para manipulação de matrizes, conforme detalhamento apresentado a seguir, e comparar seu desempenho contra uma versão sequencial de um algoritmo equivalente (que cumpra o mesmo objetivo, embora usando uma estratégia diferente e possivelmente mais eficiente para o processamento sequencial).

Detalhamento:

   Sobre o algoritmo
O algoritmo deve preencher com valores aleatórios (dentro de um intervalo de 1 a 100),  todas as posições da matriz de uma matriz de entrada quadrada com 1 M (mega) posições. O preenchimento deverá ser realizado usando uma dentre duas formas diferentes (ou uma ou outra, de acordo com a seleção do usuário). A primeira forma permite liberdade para estabelecer o padrão de escrita das posições da matriz. Na segunda forma, a ordem de escrita das posições da matriz de entrada deve ser aleatória. Na versão paralela da aplicação, múltiplas threads podem se encarregar de fazer o preenchimento da matriz de entrada de forma paralela/concorrente. 
Enquanto (ao mesmo tempo em que) a matriz de entrada é preenchida, o programa deve ler os valores atribuídos a cada posição da matriz de entrada e transportá-los para uma matriz de saída. Um valor só pode ser transportado para a matriz de saída depois de efetivamente escrito na matriz de entrada. Na matriz de saída, todos os valores iguais devem ficar alocados, de alguma forma, contiguamente, como exemplificado abaixo.

10 10 10 56 56 
56 56 56 2 2 
2 2 2 2 2
2 9 9 23 23
23 15 15 21 21



## Começando

 1. Clone esse repositorio ```git clone https://github.com/Rodrigo-Segui/ManipuladorMatrizesParalelo.git```
 2. Inicie  com projeto e compile.
  
 ## :memo: Licença

Esse projeto está sob a licença MIT. Veja o arquivo [LICENSE](https://github.com/Rodrigo-Segui/ManipuladorMatrizesParalelo/blob/master/LICENSE) para mais detalhes
