

package t1.so;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Semaphore;

/**
 *
 * @author us guri da hulha e de osasco
 */


public class SOMatrizesParalelo extends Thread{
    static int matriz_entrada[][] = new int[1000][1000];
    static int matriz_saida[][] = new int[1000][1000];
    
    
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

        public static int[]  ConverteMatriz(int m[][])
    {
        int vetor [] = new int [(matriz_saida.length * matriz_saida.length)];
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
        int m [][] = new int [matriz_saida.length][matriz_saida.length];
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
         public static int[] shuffle(int[] a) {
        Random rnd = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            int randomNumber = rnd.nextInt(i + 1);
            swap(a, i, randomNumber);
        }
        return a;
    }
             
        public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
 

    public static void main(String[] args) throws InterruptedException 
    {
        
  
        long time1;
        long time2;
        long time1ordenacao;
        long time2ordenacao;
        long time1matrizentrada=0;
        long time2matrizsaida=0;
        long time1matrizsaida=0;
        long time2matrizentrada=0;
        System.out.println("PARALELO");
        int escolha = 0;
        //CASO USE 10 THREADS MATRIZ 1000X1000
        //int vet1[] = {0, 100, 200, 300 ,400,500,600,700,800,900};
        //int vet2[] = {100, 200, 300 ,400,500,600,700,800,900,1000};
        
        //CASO USE 10 THREADS MATRIZ 10X10
        //int vet1[] = {0, 1, 2, 3 ,4,5,6,7,8,9};
        //int vet2[] = {1, 2, 3 ,4,5,6,7,8,9,10};
        
        //CASO USE 5 THREADS MATRIZ 1000X1000
        int vet1[] = {0, 200, 400, 600 ,800};
        int vet2[] = {200, 400, 600, 800 ,1000};
        
        //CASO USE 5 THREADS MATRIZ 10X10
         //int vet1[] = {0, 2, 4, 6 ,8};
         //int vet2[] = {2, 4, 6, 8 ,10};
        Semaphore semaphoreEntrada = new Semaphore(5);
        Semaphore semaphoreSaida = new Semaphore(5);
        Semaphore []mutex = new Semaphore[5];
        for(int x=0; x<5; x++){
            mutex[x] = new Semaphore(1);
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
                   time1 = System.currentTimeMillis();
                   time1matrizentrada = System.currentTimeMillis();
                   PreenchimentoLinhaMatrizEntrada[] processo1 = new PreenchimentoLinhaMatrizEntrada[5];
                    for (int i = 0; i < 5; i++) {
                             processo1[i] = new PreenchimentoLinhaMatrizEntrada("thread preenche matriz entrada",(i + 1), matriz_entrada, vet1[i], vet2[i], semaphoreEntrada, mutex[i]);// 1 2
                             processo1[i].start();
                    }
                   
                   time2matrizentrada = System.currentTimeMillis();
                   
                   time1matrizsaida = System.currentTimeMillis();
                   PreenchimentoLinhaMatrizSaida[] processo2 = new PreenchimentoLinhaMatrizSaida[5];
                   for (int j = 0; j < 5; j++) {
                            processo2[j] = new PreenchimentoLinhaMatrizSaida("thread preenche matriz saida",(j + 1), matriz_entrada, matriz_saida, vet1[j], vet2[j], semaphoreSaida, mutex[j]);// 1 2
                            processo2[j].start();
                    }
                    time2matrizsaida = System.currentTimeMillis();
                    processo2[0].join();processo2[1].join();processo2[2].join();processo2[3].join();processo2[4].join();
                         
                    //cria um pool de threads Fork/Join com o numero de threads do pc -1
                        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() -1); 
                        time1ordenacao = System.currentTimeMillis();
                        System.out.println("Começando a executar o Fork Join Pool");
                        int[] A = ConverteMatriz(matriz_saida); //array que será ordenado
                        MergeSortTask mergeTask = new MergeSortTask(A); //tarefa ForkJoin para ordenar o vetor A
                        pool.invoke(mergeTask);
                        matriz_saida =  ConverteVetor(A);
                        time2ordenacao = System.currentTimeMillis();
                        time2 = System.currentTimeMillis();
                    
                    System.out.println("Tempo de Execução da Ordenação paralelo:" + (time2ordenacao - time1ordenacao) + " milissegundos");
                    System.out.println("Tempo de Execução da Matriz de Entrada: " + (time2matrizentrada - time1matrizentrada) + " milissegundos");
                    System.out.println("Tempo de Execução da Matriz Saida: " + (time2matrizsaida - time1matrizsaida) + " milissegundos");
                    System.out.println("Tempo de Execução Total paralelo com 10 Threads:" + (time2 - time1) + " milissegundos");
                        
                  
                }
                if(escolha == 2){
                    System.out.println("PREECHIMENTO PARALELO ALEATORIAMENTE");
                    time1 = System.currentTimeMillis();
                    time1matrizentrada = System.currentTimeMillis();
                    int linha_vet[] = new int [matriz_entrada.length];
                    int coluna_vet[] = new int [matriz_entrada.length];
                    for(int w=0;w<linha_vet.length;w++)
                        {
                            linha_vet[w] = w;
                            coluna_vet[w] = w;
                        }
          
                    linha_vet = shuffle(linha_vet);
                    coluna_vet = shuffle(coluna_vet);
                    PreenchimentoAleatorioMatrizEntrada[] processo3 = new PreenchimentoAleatorioMatrizEntrada[5];
                        for (int i = 0; i < 5; i++) {
                            processo3[i] = new PreenchimentoAleatorioMatrizEntrada("thread preenche matriz entrada aleatoriamente",(i),vet1[i], vet2[i], matriz_entrada, linha_vet, coluna_vet, semaphoreEntrada, mutex[i]);
                            processo3[i].start();
                            
                        }
                    time2matrizentrada = System.currentTimeMillis(); 
                    processo3[0].join();processo3[1].join();processo3[2].join();processo3[3].join(); 
                        processo3[4].join();  
                    time1matrizsaida = System.currentTimeMillis();
                    PreenchimentoAleatorioMatrizSaida[] processo4 = new PreenchimentoAleatorioMatrizSaida[5];
                    for (int j = 0; j < 5; j++) {
                            processo4[j] = new PreenchimentoAleatorioMatrizSaida("thread preenche matriz saida",(j + 1), matriz_entrada, matriz_saida, vet1[j], vet2[j]);
                            processo4[j].start();
                    }
                    time2matrizsaida=System.currentTimeMillis();
                    processo4[0].join();processo4[1].join();processo4[2].join();processo4[3].join();processo4[4].join();  
                    System.out.println("Começando a executar o Fork Join Pool");
                    //cria um pool de threads Fork/Join com numero de threads do pc -1
                    ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() -1); 
                    time1ordenacao = System.currentTimeMillis();
                    int[] A = ConverteMatriz(matriz_saida); //array que será ordenado
                    MergeSortTask mergeTask = new MergeSortTask(A); //tarefa ForkJoin para ordenar o vetor A
                    pool.invoke(mergeTask);
                    matriz_saida =  ConverteVetor(A);
                    time2ordenacao = System.currentTimeMillis();
                    time2 = System.currentTimeMillis();
                    System.out.println("Tempo de Execução da Ordenação paralelo: " + (time2ordenacao - time1ordenacao) + " milissegundos");
                    System.out.println("Tempo de Execução da Matriz de Entrada: " + (time2matrizentrada - time1matrizentrada) + " milissegundos");
                    System.out.println("Tempo de Execução da Matriz Saida: " + (time2matrizsaida - time1matrizsaida) + " milissegundos");
                    System.out.println("Tempo de Execução Total paralelo com 10 Threads:" + (time2 - time1) + " milissegundos");
                            
                            
                    
                    
                }
                    
                    
         
                
            

             
  }
    }
