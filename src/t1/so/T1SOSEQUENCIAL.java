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
public class T1SOSEQUENCIAL {
    
    static int matriz_entrada[][] = new int[10][10];
    static int matriz_saida[][] = new int[10][10];

    /**
     * @param args the command line arguments
     */
    
    static void PreenchimentoLinhaMatrizEntrada()
    {

        int n_sorteado;
        Random random = new Random();
        System.out.println("NUMBER1 "+ matriz_entrada.length);
        
        for(int i=2;i<4;i++)
        {
            for(int j=0;j< matriz_entrada[i].length;j++)
            {
                    System.out.println("NUMBER2 "+ matriz_entrada[i].length);
                    n_sorteado = random.nextInt(99)+1;
                    matriz_entrada[i][j] = n_sorteado;
                    //Preencha_MatrizSaida(i,j,n_sorteado, matriz_saida);
                    System.out.println("Matriz Entrada Preenchida" +" "+ "Numero inserido na matriz = " + " " + n_sorteado + " " + "Linha = " + " " + i + " " + "coluna = " + j);
                    Printa(matriz_entrada);
                    //matriz_entrada[i][j] = 404;
                    //System.out.println("Matriz Entrada Após ser transportada");
                    //Printa(m_entrada);
            }
            //Printa(matriz_entrada);
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
        while(contador<(matriz_entrada[0].length * matriz_entrada[1].length))
        {
                //sorteia linha e coluna 
                linha = sorteio_linha.nextInt(10); 
                coluna = sorteio_coluna.nextInt(10);
                
                //verifica se posicao da matriz_entrada esta vazia
                teste = VerificaPosicaoVazia(linha,coluna,matriz_entrada);
                if(teste==true)
                {
                    numero_sorteado = random.nextInt(99)+1;
                    matriz_entrada[linha][coluna] = numero_sorteado;
                    System.out.println("Matriz Entrada Preenchida" +" "+ "Numero inserido na matriz = " + " " + numero_sorteado + " " + "Linha = " + " " + linha + " " + "coluna = " + coluna);
                    Printa(matriz_entrada);
                    contador++;
                }
        }
        System.out.println("Print da Matriz Final de Entrada");
        Printa(matriz_entrada);
        
    }
    static void PreenchimentoMatrizSaida()
    {
        
        for(int i=0;i<matriz_entrada.length;i++)
        {
            for(int j=0;j<matriz_entrada[i].length;j++)
            {
                    
                    matriz_saida[i][j] = matriz_entrada[i][j];
                    matriz_entrada[i][j] = 0;
                    System.out.println("Matriz saida Preenchida" +" "+ "Numero inserido na matriz = " + " " + matriz_entrada[i][j]  + " " + "Linha = " + " " + i + " " + "coluna = " + j);
                    Printa(matriz_saida);
                    System.out.println("Matriz entrada desalocada" +" "+ "Numero inserido na matriz = " + " " + matriz_entrada[i][j]  + " " + "Linha = " + " " + i + " " + "coluna = " + j);
                    Printa(matriz_entrada);
            }
            //Printa(matriz_entrada);
        }
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
    
    public static void main(String[] args) 
    {
        
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
                    System.out.println("PREENCHENDO MATRIZ ENTRADA");
                    PreenchimentoLinhaMatrizEntrada();
                    System.out.println("PREENCHENDO MATRIZ SAIDA");
                    PreenchimentoMatrizSaida();
                    break;
                case 2:
                    System.out.println("PREENCHENDO MATRIZ ENTRADA");
                    PreenchimentoAleatorio();
                    System.out.println("PREENCHENDO MATRIZ SAIDA");
                    PreenchimentoMatrizSaida();
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
