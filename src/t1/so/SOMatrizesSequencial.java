
package t1.so;



import java.util.Scanner;
import java.util.Random;



public class SOMatrizesSequencial {
    
 
    static int n_linhas= 1000;
    static int n_colunas = 1000;
    static int matriz_entrada[][] = new int[n_linhas][n_colunas];
    static int matriz_saida[][] = new int[n_linhas][n_colunas];
    static int vet[] = new int[(n_colunas * n_linhas)];
    static int quantidade_posicoes_preenchidas_matriz_auxiliar = 0;

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
        int linha=0;
        int coluna =0;
        int contador=0;
        int numero_sorteado = 0;
        int indice = 0;
        int indice_coluna = 0;
        Random random = new Random();
        int linha_vet[] = new int [n_linhas];
        int coluna_vet[] = new int [n_linhas];
        for(int w=0;w<linha_vet.length;w++)
        {
            linha_vet[w] = w;
            coluna_vet[w] = w;
        }
        
        
        linha_vet = shuffle(linha_vet);
        coluna_vet = shuffle(coluna_vet);
       
      
        for(int u=0;u<n_linhas;u++)
        {
            for(int t=0;t<n_linhas;t++)
            {
                    numero_sorteado = random.nextInt(99)+1;
                    matriz_entrada[linha_vet[u]][coluna_vet[t]] = numero_sorteado;
                    
                    
            }
         
        }
        
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
    
    static void PreenchimentoMatrizSaida()
    {
        int posicao[] = new int[2];
        for(int i=0;i<matriz_entrada.length;i++)
        {
            for(int j=0;j<matriz_entrada[i].length;j++)
            {
                    
                  
                    matriz_saida[i][j] = matriz_entrada[i][j];
                   
                    matriz_entrada[i][j] = 0;
                    
                    
            }
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
    public static int[] MergeSort(int[] array, int low, int high) {
    if (high <= low) 
        return array;

        int mid = (low+high)/2;
        MergeSort(array, low, mid);
        MergeSort(array, mid+1, high);
        array = merge(array, low, mid, high);
        return array;
}
    public static int[] merge(int[] array, int low, int mid, int high) {

    int leftArray[] = new int[mid - low + 1];
    int rightArray[] = new int[high - mid];


    for (int i = 0; i < leftArray.length; i++)
        leftArray[i] = array[low + i];
    for (int i = 0; i < rightArray.length; i++)
        rightArray[i] = array[mid + i + 1];

   
    int leftIndex = 0;
    int rightIndex = 0;

    
    for (int i = low; i < high + 1; i++) {
       
        if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
               array[i] = leftArray[leftIndex];
               leftIndex++;
            } else {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        } else if (leftIndex < leftArray.length) {
           
            array[i] = leftArray[leftIndex];
            leftIndex++;
        } else if (rightIndex < rightArray.length) {
          
            array[i] = rightArray[rightIndex];
            rightIndex++;
        }
    }
    return array;
}
   

    public static void PrintaVet(int m1[])
    {
        for (int n = 0; n < m1.length; n++) 
            {
                System.out.print(m1[n] + " ");
            }
            System.out.println();
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
        int escolha = 0;
   
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
            //        Printa(matriz_entrada);
              //      System.out.println("---------------");
                    System.out.println("Preenchimento do tipo linha");
                        time1Total = System.currentTimeMillis();
                        time1MatrizEntrada = System.currentTimeMillis();
                        PreenchimentoLinhaMatrizEntrada();
                        time2MatrizEntrada = System.currentTimeMillis();
                //    Printa(matriz_entrada);
                  //  System.out.println("---------------");
                    System.out.println("Tempo de Execução da matriz da entrada:" + (time2MatrizEntrada - time1MatrizEntrada) + " milissegundos");
                        time1MatrizSaida = System.currentTimeMillis();
                            PreenchimentoMatrizSaida();
                        time2MatrizSaida = System.currentTimeMillis();
                    //    Printa(matriz_saida);
   
                   // System.out.println("---------------");
                     //   Printa(matriz_entrada);
                        System.out.println("---------------------------");
                    System.out.println("Tempo de Execução Matriz Saida:" + (time2MatrizSaida - time1MatrizSaida) + " milissegundos");
                        time1MatrizOrdenacao = System.currentTimeMillis(); 
                            vet = ConverteMatriz(matriz_saida);
                            vet = MergeSort(vet, 0,(n_colunas * n_linhas)-1 );
                            matriz_saida = ConverteVetor(vet);
                        time2MatrizOrdenacao = System.currentTimeMillis();
                        time2Total = System.currentTimeMillis();
                       // Printa(matriz_saida);
                    System.out.println("Tempo de Execução da Ordenação:" + (time2MatrizOrdenacao - time1MatrizOrdenacao) + " milissegundos");
                    System.out.println("Tempo de Execução Total:" + (time2Total - time1Total) + " milissegundos");
                    break;
                case 2:
                     // Printa(matriz_entrada);
                      //System.out.println("---------------");
                    System.out.println("Preenchimento do tipo aleatório");
                        time1Total = System.currentTimeMillis();
                        time1MatrizEntrada = System.currentTimeMillis();
                            PreenchimentoAleatorio();
                        time2MatrizEntrada = System.currentTimeMillis();
                       // Printa(matriz_entrada);
                      //System.out.println("---------------");
                        System.out.println("Tempo de Execução Matriz Entrada:" + (time2MatrizEntrada - time1MatrizEntrada) + " milissegundos");
                        time1MatrizSaida = System.currentTimeMillis();
                        PreenchimentoMatrizSaida();
                        time2MatrizSaida = System.currentTimeMillis();
                       // Printa(matriz_entrada);
                      //System.out.println("---------------");
                      //Printa(matriz_saida);
                     // System.out.println("---------------");
                    System.out.println("Tempo de Execução Matriz Saida:" + (time2MatrizSaida - time1MatrizSaida) + " milissegundos");
                   
                        time1MatrizOrdenacao = System.currentTimeMillis();
                            vet = ConverteMatriz(matriz_saida);
                            vet = MergeSort(vet, 0, (n_colunas * n_linhas)-1);
                            matriz_saida = ConverteVetor(vet);
                        time2MatrizOrdenacao = System.currentTimeMillis();
                    System.out.println("Tempo de Execução Ordenacao da matriz:" + (time2MatrizOrdenacao - time1MatrizOrdenacao) + " milissegundos");
                        time2Total = System.currentTimeMillis();
                    System.out.println("Tempo de Execução Total:" + (time2Total - time1Total) + " milissegundos");
                   //Printa(matriz_entrada);
                     // System.out.println("---------------");
                     // Printa(matriz_saida);
                     // System.out.println("---------------");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
                         
   
  }
    }
