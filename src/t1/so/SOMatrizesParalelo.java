/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1.so;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */


public class SOMatrizesParalelo extends Thread{
    static int matriz_entrada[][] = new int[10][10];
    static int matriz_saida[][] = new int[10][10];

    private int idThread;
    
    private Semaphore mutex;
    public int inlinha;
    public int outlinha;
    

    public SOMatrizesParalelo(int id, Semaphore mutex,int inlinha,int outlinha) {
        this.idThread = id;
        this.mutex = mutex;
        this.inlinha = inlinha;
        this.outlinha = outlinha;
        start();
    
        
    }
    
    
    

    /**
     * @param args the command line arguments
     */
    
    void PreenchimentoLinhaMatrizEntrada()
    {
       // try{
           // mutex.acquire(); //SEÇÃO DE ENTRADA
            ////////////////////////////////////////////////// SEÇÃO CRITICA
            int n_sorteado;
            Random random = new Random();
            for(int i= inlinha ;i< outlinha ;i++)
                {
                    for(int j=0;j< 10;j++)
                        {
                            n_sorteado = random.nextInt(99)+1;
                            matriz_entrada[i][j] = n_sorteado;
                            //System.out.println("Matriz Entrada Preenchida" +" "+ "Numero inserido na matriz = " + " " + n_sorteado + " " + "Linha = " + " " + i + " " + "coluna = " + j);
                            //Printa(matriz_entrada);
   
                         }
                    System.out.println("Thread" + inlinha + "" + outlinha);
                    System.out.println("-----------------------------------");
                    Printa(matriz_entrada);
                    System.out.println("------------------------------------");
            }
            System.out.println("Acabou Thread" + inlinha + "" + outlinha);
            //Printa(matriz_entrada);
    }
        ////////////////////////////////////////////////// SEÇÃO CRITICA
       //}catch(InterruptedException e) {} 
        //finally {
           // mutex.release();  //SEÇÃO DE SAIDA
        //}
     //}
    
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
    
  
    public void run(){
       // try {
         //   mutex.acquire();
           // } catch (InterruptedException ex) {
             //   Logger.getLogger(T1SOPARALELO.class.getName()).log(Level.SEVERE, null, ex);
            //}
            //System.out.println("TESTE");
            PreenchimentoLinhaMatrizEntrada();
            //mutex.release();

    }
    public static void main(String[] args) 
    {
        
        System.out.println("PARALELO");
        
        Semaphore mutex = new Semaphore(1);
        //for(int numero_mutex = 0; numero_mutex < 5; numero_mutex ++){
          //  mutex[numero_mutex] = new Semaphore(1);
        //}
        
        int escolha = 0;
        int vet1[] = {0, 2, 4, 6 ,8};
        int vet2[] = {2, 4, 6, 8 ,10};
        
        
            Scanner in = new Scanner(System.in);
            System.out.println("Escolha uma das formas de entrada da matriz." + "");
            System.out.println("1- Preenchimento linha.");
            System.out.println("2- Preenchimento aleatorio.");
            System.out.println("0- Encerrar.");
            System.out.println("\n");
            System.out.print("Opção --> ");
            escolha = in.nextInt();
         
               
                    System.out.println("PREENCHENDO MATRIZ ENTRADA");
                    
                    //T1SOPARALELO[] processosPreencherMatrizA = new T1SOPARALELO[5];
                     //processosPreencherMatrizA[0] = new T1SOPARALELO(0,mutex,0, 2);
                     //processosPreencherMatrizA[1] = new T1SOPARALELO(1,mutex,2, 4);
                     
                    SOMatrizesParalelo thread1 = new SOMatrizesParalelo(0,mutex,0, 2);
                    SOMatrizesParalelo thread2 = new SOMatrizesParalelo(1,mutex,2, 4);
                    SOMatrizesParalelo thread3 = new SOMatrizesParalelo(2,mutex,4, 6);
                    SOMatrizesParalelo thread4 = new SOMatrizesParalelo(3,mutex,6, 8);
                    SOMatrizesParalelo thread5 = new SOMatrizesParalelo(4,mutex,8, 10);
                    
                    
                    System.out.println("MATRIZ FINAL");
                    Printa(matriz_entrada);
                    
                    //    for (int i = 0; i < 5; i++) {
                      //    System.out.println("THREAD" + i);
                       //     processos[i] = new T1SOPARALELO(i,mutex,vet1[i], vet2[i]);
                       //     processos[i].run();
                    //} 
                
            

             
  }
    }
