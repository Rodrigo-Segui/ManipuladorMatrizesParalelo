/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1.so;

import com.sun.tools.javac.code.Attribute;
import java.util.concurrent.RecursiveAction;
import java.util.Arrays;

/** //CODIGO VELASCO EBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
 *
 * @author pirat
 */
public class MergeSortTask extends RecursiveAction {
    private int[] array; //array que será ordenado
    private int inicio; //índice de início
    private int fim; //índice do fim
    
    //ordena o subarray do índice 'inicio' até 'fim'
    public MergeSortTask(int[] array, int inicio, int fim){
        this.array = array;
        this.inicio = inicio;
        this.fim = fim;
    }
    //ordena o array por completo
    public MergeSortTask(int[] array){
        this(array, 0, array.length -1);
    }
    //executa o MergeSort paralelamente com Fork-Join
    @Override
    protected void compute() {
        if(inicio < fim)
        {
            if(fim - inicio <= 8192)
            {
                MergeSort(inicio,fim);
            }
            else{
            int meio = (inicio + fim) / 2; //calcula o meio
            //realiza as chamadas recursivas paralelamente (fork)
            final MergeSortTask  left = new MergeSortTask(array, inicio, meio);
            final MergeSortTask  right = new MergeSortTask(array, meio + 1 , fim);
            invokeAll(left,right);
            merge(inicio, meio , fim);
            }//intercala os subvetores (join)
        }
    }
    //intercala os subvetores esquerdo e direito
    private void merge(int inicio, int meio, int fim){
       
        int leftArray[] = new int[meio - inicio + 1];
    int rightArray[] = new int[fim - meio];

 
    for (int i = 0; i < leftArray.length; i++)
        leftArray[i] = array[inicio+ i];
    for (int i = 0; i < rightArray.length; i++)
        rightArray[i] = array[meio + i + 1];

   
    int leftIndex = 0;
    int rightIndex = 0;

    
    for (int i = inicio; i < fim + 1; i++) {
        
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
    
        
        
        
        
       
    }
 
    
     private void MergeSort(int inicio, int fim)  {
   
    // Se o inicio for menor que o fim menos 1, significa que tem elemento dentro do vetor.
    if(inicio < fim  ) {
      // Guarda a posição do meio do vetor.
      int meio = (inicio + fim) / 2;
      
      // Chama este método recursivamente, indicando novas posições inicio e fim do vetor. //
      MergeSort( inicio, meio);
      
      // Chama este método recursivamente, indicando novas posições do inicio e fim do vetor. 
      MergeSort(meio+1 , fim);
      
      // Chama o método que intercala os elementos do vetor.
      intercala(inicio, meio , fim);
      
    }
    
   }
  
   private void intercala(int inicio, int meio, int fim) {

   
   int leftArray[] = new int[meio - inicio + 1];
    int rightArray[] = new int[fim - meio];

    // Copying our subarrays into temporaries
    for (int i = 0; i < leftArray.length; i++)
        leftArray[i] = array[inicio+ i];
    for (int i = 0; i < rightArray.length; i++)
        rightArray[i] = array[meio + i + 1];

    // Iterators containing current index of temp subarrays
    int leftIndex = 0;
    int rightIndex = 0;

    // Copying from leftArray and rightArray back into array
    for (int i = inicio; i < fim + 1; i++) {
        // If there are still uncopied elements in R and L, copy minimum of the two
        if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
               array[i] = leftArray[leftIndex];
               leftIndex++;
            } else {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        } else if (leftIndex < leftArray.length) {
            // If all elements have been copied from rightArray, copy rest of leftArray
            array[i] = leftArray[leftIndex];
            leftIndex++;
        } else if (rightIndex < rightArray.length) {
            // If all elements have been copied from leftArray, copy rest of rightArray
            array[i] = rightArray[rightIndex];
            rightIndex++;
        }
   
   
    }
   
   
  }
   
}
    
    
    
     
   
   

