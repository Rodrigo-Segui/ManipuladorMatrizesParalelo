
package t1.so;

import java.util.Scanner;
import java.util.concurrent.Semaphore;



public class SOMatrizesParalelo extends Thread{
    
    
    static int n_linhas= 1000;
    static int n_colunas = 1000;
    static int matriz_entrada[][] = new int[n_linhas][n_colunas];
    static int matriz_saida[][] = new int[n_linhas][n_colunas];
    
 

    
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
        int vet1[] = {0, 200, 400, 600 ,800};
        int vet2[] = {200, 400, 600, 800 ,1000};
        long time1Total;
        long time2Total;
        Semaphore semaphoreEntrada = new Semaphore(5);
        Semaphore semaphoreSaida = new Semaphore(5);
        Semaphore []mutex = new Semaphore[5];
        for (int k= 0; k < 5; k++){
            mutex[k] = new Semaphore(1);
        } 
        
            Scanner in = new Scanner(System.in);
            System.out.println("Escolha uma das formas de entrada da matriz." + "");
            System.out.println("1- Preenchimento linha.");
            System.out.println("2- Preenchimento aleatorio.");
            System.out.println("0- Encerrar.");
            System.out.println("\n");
            System.out.print("Opção --> ");
            escolha = in.nextInt();
           
                if(escolha == 1){
                    time1Total = System.currentTimeMillis();
                    
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
                    
                     System.out.println("tempo Total");
                     time2Total = System.currentTimeMillis();
                     System.out.println("Tempo de Execução Total:" + (time2Total - time1Total) + " milissegundos");
                     //Printa(matriz_entrada);
                     //Printa(matriz_saida);
                }
                if(escolha == 2){
         
                    
                }
                    
        }
    }
