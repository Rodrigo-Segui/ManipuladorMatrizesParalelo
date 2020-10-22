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

    
  

    public static void main(String[] args) 
    {
        
        System.out.println("PARALELO");
        int escolha = 0;
        int vet1[] = {0, 2, 4, 6 ,8};
        int vet2[] = {2, 4, 6, 8 ,10};
        Semaphore semaphoreEntrada = new Semaphore(5);
        Semaphore semaphoreSaida = new Semaphore(5);
        Semaphore []mutex = new Semaphore[5];
        mutex[0] = new Semaphore(1); 
        mutex[1] = new Semaphore(1); 
        mutex[2] = new Semaphore(1); 
        mutex[3] = new Semaphore(1); 
        mutex[4] = new Semaphore(1);
        
            Scanner in = new Scanner(System.in);
            System.out.println("Escolha uma das formas de entrada da matriz." + "");
            System.out.println("1- Preenchimento linha.");
            System.out.println("2- Preenchimento aleatorio.");
            System.out.println("0- Encerrar.");
            System.out.println("\n");
            System.out.print("Opção --> ");
            escolha = in.nextInt();
           
                if(escolha == 1){
                   //System.out.println("PREENCHIMENTO PARALELO MATRIZ ENTRADA POR LINHA");                                         
                   PreenchimentoLinhaMatrizEntrada[] processo1 = new PreenchimentoLinhaMatrizEntrada[5];
                        for (int i = 0; i < 5; i++) {
                            processo1[i] = new PreenchimentoLinhaMatrizEntrada("thread preenche matriz entrada",(i + 1), matriz_entrada, vet1[i], vet2[i], semaphoreEntrada, mutex[i]);// 1 2
                            processo1[i].start();
                        }
                        
                    //System.out.println("PREENCHIMENTO PARALELO MATRIZ SAIDA POR LINHA");   
                    PreenchimentoLinhaMatrizSaida[] processo2 = new PreenchimentoLinhaMatrizSaida[5];
                        for (int i = 0; i < 5; i++) {
                            processo2[i] = new PreenchimentoLinhaMatrizSaida("thread preenche matriz saida",(i + 1), matriz_entrada, matriz_saida, vet1[i], vet2[i], semaphoreSaida, mutex[i]);// 1 2
                            processo2[i].start();
                        }
                    
                        
                     //Printa(matriz_entrada);
                     //Printa(matriz_saida);
                }
                if(escolha == 2){
                   // System.out.println("PREECHIMENTO PARALELO MATRIZ ENTRADA ALEATORIAMENTE");
                   // PreenchimentoLinhaMatrizEntrada[] processos = new PreenchimentoLinhaMatrizEntrada[5];
                     //   for (int i = 0; i < 5; i++) {
                       ///     processos[i] = new PreenchimentoLinhaMatrizEntrada("thread#",(i + 1), matriz_entrada, vet1[i], vet2[i], semaphore, mutex[i]);// 1 2
                          //  processos[i].start();
                        //}
                    
                    
                }
                    
                    
         
                
            

             
  }
    }
