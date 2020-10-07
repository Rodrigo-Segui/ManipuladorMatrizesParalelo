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
public class T1SO {
    
    static int matriz_entrada[][] = new int[10][10];
    static int matriz_saida[][] = new int[10][10];

    /**
     * @param args the command line arguments
     */
    
    static void PreenchimentoLinha()
    {
        int i;
        int j;
        int m_entrada[][] = new int[10][10];
        int m_saida[][] = new int[10][10];
        int n_sorteado;
        Random random = new Random();
        for(i=0;i<m_entrada.length;i++)
        {
            for(j=0;j<m_entrada[i].length;j++)
            {
                    n_sorteado = random.nextInt(99)+1;
                    m_entrada[i][j] = n_sorteado;
                    Preencha_MatrizSaida(i,j,n_sorteado, m_saida);
                    System.out.println("Matriz Entrada Preenchida" +" "+ "Numero inserido na matriz = " + " " + n_sorteado + " " + "Linha = " + " " + i + " " + "coluna = " + j);
                    Printa(m_entrada);
                    m_entrada[i][j] = 404;
                    System.out.println("Matriz Entrada Após ser transportada");
                    Printa(m_entrada);
            }
            Printa(m_entrada);
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
                    
                    
                    Preencha_MatrizSaida(linha,coluna,numero_sorteado, matriz_saida);
                    System.out.println("Matriz Entrada Preenchida" +" "+ "Numero inserido na matriz = " + " " + numero_sorteado + " " + "Linha = " + " " + linha + " " + "coluna = " + coluna);
                    Printa(matriz_entrada);
                    matriz_entrada[linha][coluna] = 404;
                    System.out.println("Matriz Entrada Após ser transportada");
                    Printa(matriz_entrada);
                    contador++;
                }
        }
        System.out.println("Print da Matriz Final de Entrada");
        Printa(matriz_entrada);
        
    }
    static void Preencha_MatrizSaida(int i, int j, int valor,int matriz_saida[][])
    {
        
        boolean teste;
        teste = VerificaPosicaoVazia(i, j, matriz_saida);
        if(teste == true)
        {
            matriz_saida[i][j] = valor;
        }
        //ordena matriz
        System.out.println("Matriz Saida");
        Printa(matriz_saida);
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
                    PreenchimentoLinha();
                    break;
                case 2:
                    PreenchimentoAleatorio();
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
