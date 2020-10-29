/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1.so;


import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author author
 */
public class SOMatrizesSequencial {
    
    static int n_linhas= 1000;
    static int n_colunas = 1000;
    static int matriz_entrada[][] = new int[n_linhas][n_colunas];
    static int matriz_saida[][] = new int[n_linhas][n_colunas];
    static int matriz_auxiliar[][] = new int[100][4];
    static int vet[] = new int[(n_colunas * n_linhas)];
    static int quantidade_posicoes_preenchidas_matriz_auxiliar = 0;
    static String alunoRecebido = "12";

    /**
     * @param args the command line arguments
     */
    
    static void PreenchimentoLinhaMatrizEntrada()
    {

        int n_sorteado;
        Random random = new Random();
        
        for(int i=0;i<matriz_entrada.length;i++)
        {
            for(int j=0;j< matriz_entrada[i].length;j++)
            {
                    n_sorteado = random.nextInt(99)+1;
                    matriz_entrada[i][j] = n_sorteado;
                    
            }
        }
    }
    
    //FUNCÃO PREENCHIMENTO ALEATORIO
    static void PreenchimentoAleatorio()
    {
        
        
        boolean teste;
        int linha;
        int coluna;
        int contador=0;
        int numero_sorteado = 0;
        Random random = new Random();
        Random sorteio_linha = new Random();
        Random sorteio_coluna = new Random();
        System.out.println("chegou aqui");
        System.out.println("--" + matriz_entrada[0].length * matriz_entrada[1].length);
        while(contador<(matriz_entrada[0].length * matriz_entrada[1].length))
        {
                //sorteia linha e coluna 
                linha = sorteio_linha.nextInt(matriz_entrada[0].length); 
                coluna = sorteio_coluna.nextInt(matriz_entrada[1].length);
                
                //verifica se posicao da matriz_entrada esta vazia
                teste = VerificaPosicaoVazia(linha,coluna,matriz_entrada);
                if(teste==true)
                {
                    numero_sorteado = random.nextInt(99)+1;
                    matriz_entrada[linha][coluna] = numero_sorteado;
                    contador++;
                }
        }
        
    }
    static void PreenchimentoMatrizSaida()
    {
        for(int i=0;i<matriz_entrada.length;i++)
        {
            for(int j=0;j<matriz_entrada[i].length;j++)
            {
                    matriz_saida[i][j] = matriz_entrada[i][j];
                    matriz_entrada[i][j] = 0;
            }

        }
 
    }
    
    static int[] PosicaoPreencher(int valor_a_preencher, int []posicao,int linha_padrao,int coluna_padrao){
        int numero, quantidade, posicao_inicial_linha, posicao_inicial_coluna;
        boolean valor_existente = false;
        posicao[0] = -1;
        posicao[1] = -1;   
        
        //VERIFICA 
        for(int linha=0;linha<matriz_auxiliar.length;linha++)
        {
            for(int coluna=0;coluna < matriz_auxiliar[linha].length;coluna++)
            {
                if(valor_a_preencher == matriz_auxiliar[linha][0]){
                    
                    valor_existente = true;
                    System.out.println("VALOR EXISTENTE" + valor_existente);
                    numero = matriz_auxiliar[linha][0];
                    quantidade = matriz_auxiliar[linha][1];
                    posicao_inicial_linha = matriz_auxiliar[linha][2];
                    posicao_inicial_coluna = matriz_auxiliar[linha][3];
                    posicao[1] = posicao_inicial_coluna;
                    posicao[0] = posicao_inicial_linha;
                    
                    
                    for(int y= 0; y < quantidade; y ++){
                        posicao[1] ++;
                        if(posicao[1] == matriz_saida.length){
                            posicao[1] = 0;
                            posicao[0] = posicao[0] + 1;
                            
                        }else{
                            posicao[0] = posicao_inicial_linha;
                            
                        }
                    }
                    
                   matriz_auxiliar[linha][1] = quantidade + 1;
                   break;
                    
            }
                
                
                
            }
        }
        System.out.println("VALOR EXISTENTE" + valor_existente);
        
        if(valor_existente == false){ // verifica posicao a ser inseridade e atualiza matriz auxiliar
            // 0 1 2 3 4
            System.out.println("TEXTO :" + quantidade_posicoes_preenchidas_matriz_auxiliar);
            matriz_auxiliar[quantidade_posicoes_preenchidas_matriz_auxiliar][0] = valor_a_preencher;
            matriz_auxiliar[quantidade_posicoes_preenchidas_matriz_auxiliar][1] = 1;
            matriz_auxiliar[quantidade_posicoes_preenchidas_matriz_auxiliar][2] = linha_padrao;
            matriz_auxiliar[quantidade_posicoes_preenchidas_matriz_auxiliar][3] = coluna_padrao;
            posicao[0] = linha_padrao;
            posicao[1] = coluna_padrao;
            
            quantidade_posicoes_preenchidas_matriz_auxiliar = quantidade_posicoes_preenchidas_matriz_auxiliar +1;
            
        
        }
        
        //ATUALIZANDO TABELA APOS Modificacao
        
        for(int indicelinhatabela = (quantidade_posicoes_preenchidas_matriz_auxiliar + 1);indicelinhatabela < matriz_auxiliar.length; indicelinhatabela ++){
            for(int indicecolunatabela = 0;indicecolunatabela < matriz_auxiliar.length; indicecolunatabela ++ ){
                    if(matriz_auxiliar[indicelinhatabela][0] != 0){
                        matriz_auxiliar[indicelinhatabela][3] ++;
                            if(matriz_auxiliar[indicelinhatabela][3] >= matriz_saida.length){
                                matriz_auxiliar[indicelinhatabela][3] = 0;
                                matriz_auxiliar[indicelinhatabela][2] ++;
                                
                            }
                        
                    }
                
            }
        }
        
        //codigo retorna posicao que o numero deve ser preenchido na matriz de saida
    
        return posicao;
    }
    static void Printa(int m[][])
    {   
        
         for (int[] m1 : m) {
            for (int n = 0; n < m1.length; n++) 
            {
                System.out.print(m1[n] + " ");
            }
            System.out.println();
        }
    }
    
    static void PreencherMatrizEntrada(){
         matriz_entrada[0][0] = 13; 
         matriz_entrada[0][1] = 73; 
         matriz_entrada[0][2] = 58;
         matriz_entrada[0][3] = 95;
         matriz_entrada[0][4] = 95;
         matriz_entrada[1][0] = 85;
         matriz_entrada[1][1] = 4;
         matriz_entrada[1][2] = 31;
         matriz_entrada[1][3] = 96;
         matriz_entrada[1][4] = 97;
         matriz_entrada[2][0] = 79;
         matriz_entrada[2][1] = 80;
         matriz_entrada[2][2] = 44;
         matriz_entrada[2][3] = 79;
         matriz_entrada[2][4] = 8;
         matriz_entrada[3][0] = 83;
         matriz_entrada[3][1] = 9;
         matriz_entrada[3][2] = 87;
         matriz_entrada[3][3] = 76;
         matriz_entrada[3][4] = 83;
         matriz_entrada[4][0] = 32;
         matriz_entrada[4][1] = 78;
         matriz_entrada[4][2] = 99;
         matriz_entrada[4][3] = 22;
         matriz_entrada[4][4] = 40;

    }
            
    //FUNCAO VERIFICA DE POSICAO DA MATRIZ JA FOI PREENCHIIDA
    //RETURN TRUE SE POSICAO AINDA NAO FOI PREENCHIDA
    //RETURN FALSE SE POSICAOJA FOI PREENCHIDA
    static boolean VerificaPosicaoVazia(int linha, int coluna, int m[][])
    {
        int numero = 0;
        numero = m[linha][coluna];
        if(numero == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
        public static int[]  ConverteMatriz(int m[][])
    {
        int vetor [] = new int [(n_colunas * n_linhas)];
        int indice = 0;
        for( int x = 0; x < m.length; x++ )
        {   
            for( int y = 0; y < m[x].length; y++ )
            {
                vetor[indice] = m[x][y];
                indice = indice + 1;
            }
        }
        return vetor;
    }
    
   static int [][] ConverteVetor (int v[])
    {
        int m [][] = new int [n_linhas][n_colunas];
        int indice = 0;
        for( int x = 0; x < m.length; x++ )
        {   
            for( int y = 0; y < m[x].length; y++ )
            {
                m[x][y]= v[indice];
                indice = indice + 1;
            }
        }
        return m;
    }
    
    public static int [] MergeSort(int vetor[], int posicaoInicio, int posicaoFim) 
    {
        int i, j, k, metadeTamanho; 
        int vetorTemp[] = new int [(n_colunas * n_linhas)];
        if(posicaoInicio == posicaoFim)
        {
           return vetor;
        }
        metadeTamanho = (posicaoInicio + posicaoFim ) / 2;

       MergeSort(vetor, posicaoInicio, metadeTamanho);
       MergeSort(vetor, metadeTamanho + 1, posicaoFim);

        i = posicaoInicio;
        j = metadeTamanho + 1;
        k = 0;

    while(i < metadeTamanho + 1 || j  < posicaoFim + 1) {
        if (i == metadeTamanho + 1 ) { 
            vetorTemp[k] = vetor[j];
            j++;
            k++;
        }
        else {
            if (j == posicaoFim + 1) {
                vetorTemp[k] = vetor[i];
                i++;
                k++;
            }
            else {
                if (vetor[i] < vetor[j]) {
                    vetorTemp[k] = vetor[i];
                    i++;
                    k++;
                }
                else {
                    vetorTemp[k] = vetor[j];
                    j++;
                    k++;
                }
            }
        }

    }
    for(i = posicaoInicio; i <= posicaoFim; i++) {
        vetor[i] = vetorTemp[i - posicaoInicio];
    }
    return vetor;
}
    
    public static void main(String[] args) 
    {
        
        long time1MatrizEntrada;
        long time2MatrizEntrada;
        long time1MatrizSaida;
        long time2MatrizSaida; 
        long time1Total;
        long time2Total;
        long time1MatrizOrdenacao;
        long time2MatrizOrdenacao; 
        String substring1 = alunoRecebido.substring(0,1);
        String substring2 = alunoRecebido.substring(1,2);
        System.out.println(" " + substring1);
        System.out.println(" " + substring2);
        int n1 = Integer.parseInt(substring1);
        int n2 = Integer.parseInt(substring2);
        int num = n1 + n2;
        System.out.println("RESULTADO" + num);
        
        int escolha = 0;
        do{
            Scanner in = new Scanner(System.in);
            System.out.println("Escolha uma das formas de entrada da matriz." + "");
            System.out.println("1- Preenchimento linha.");
            System.out.println("2- Preenchimento aleatorio.");
            System.out.println("0- Encerrar.");
            System.out.println("\n");
            System.out.print("Opção --> ");
            escolha = in.nextInt();
            switch(escolha){
                case 1:
                    time1Total = System.currentTimeMillis();
                    //time1MatrizEntrada = System.currentTimeMillis();
                    //System.out.println("PREENCHENDO MATRIZ ENTRADA");
                    PreenchimentoLinhaMatrizEntrada();
                    //time2MatrizEntrada = System.currentTimeMillis();
                    ///System.out.println("Tempo de Execução Matriz Entrada:" + (time2MatrizEntrada - time1MatrizEntrada) + " milissegundos");
                    
                    //System.out.println("-----------------------------");
                    
                    //System.out.println("PREENCHENDO MATRIZ SAIDA");
                    //time1MatrizSaida = System.currentTimeMillis();
                    PreenchimentoMatrizSaida();
                    //time2MatrizSaida = System.currentTimeMillis();
                    //System.out.println("Tempo de Execução Matriz Saida:" + (time2MatrizSaida - time1MatrizSaida) + " milissegundos");
                    //System.out.println("------------------------------");

                    //Printa(matriz_entrada);
                    //Printa(matriz_saida);
                    //time1MatrizOrdenacao = System.currentTimeMillis();
                    //vet = ConverteMatriz(matriz_saida);
                    //PrintaVet(vet);
                    //vet = MergeSort(vet, 0, ((n_colunas * n_linhas) -1));
                    //matriz_saida = ConverteVetor(vet);
                    //time2MatrizOrdenacao = System.currentTimeMillis();
                    //System.out.println("Tempo de Execução Ordenacao:" + (time2MatrizOrdenacao - time1MatrizOrdenacao) + " milissegundos");
                    
                    time2Total = System.currentTimeMillis();
                    
                    System.out.println("Tempo de Execução Total:" + (time2Total - time1Total) + " milissegundos");
                    //Printa(matriz_entrada);
                    Printa(matriz_saida);
                    break;
                case 2:
                    System.out.println("PREENCHENDO MATRIZ ENTRADA");
                    
                    time1Total = System.currentTimeMillis();
                    time1MatrizEntrada = System.currentTimeMillis();
                    PreenchimentoAleatorio();
                    time2MatrizEntrada = System.currentTimeMillis();
                    System.out.println("Tempo de Execução Matriz Entrada:" + (time2MatrizEntrada - time1MatrizEntrada) + " milissegundos");
                    
                    System.out.println("-----------------------------");
                    //Printa(matriz_entrada);
                    //Printa(matriz_saida);
                    System.out.println("PREENCHENDO MATRIZ SAIDA");
                    time1MatrizSaida = System.currentTimeMillis();
                    PreenchimentoMatrizSaida();
                    time2MatrizSaida = System.currentTimeMillis();
                    System.out.println("Tempo de Execução Matriz Saida:" + (time2MatrizSaida - time1MatrizSaida) + " milissegundos");
                    System.out.println("--------------------------------");
                    

                    //Printa(matriz_entrada);
                    //Printa(matriz_saida);
                    time1MatrizOrdenacao = System.currentTimeMillis();
                    vet = ConverteMatriz(matriz_saida);
                    //PrintaVet(vet);
                    vet = MergeSort(vet, 0, ((n_colunas * n_linhas) -1));
                    matriz_saida = ConverteVetor(vet);
                    time2MatrizOrdenacao = System.currentTimeMillis();
                    System.out.println("Tempo de Execução Ordenacao:" + (time2MatrizOrdenacao - time1MatrizOrdenacao) + " milissegundos");
                    //Printa(matriz_saida);
                    time2Total = System.currentTimeMillis();
                    System.out.println("Tempo de Execução Total:" + (time2Total - time1Total) + " milissegundos");
                   // Printa(matriz_entrada);
                    System.out.println("-----------------");
                    //Printa(matriz_saida);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
                         
        }while(escolha != 0);
  }
    }
