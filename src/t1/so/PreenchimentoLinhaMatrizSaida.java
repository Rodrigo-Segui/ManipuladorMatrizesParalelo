/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1.so;

import java.util.concurrent.Semaphore;

/**
 *
 * @author user
 */
public class PreenchimentoLinhaMatrizSaida extends Thread{
        private int [][]matriz_entrada;
        private int [][]matriz_saida;
        private int inlinha;
        private int outlinha;
        private String nome;
        private Semaphore mutex;
        private Semaphore semaphore;
        private int num_thread;

    public PreenchimentoLinhaMatrizSaida(String nome,int num_thread, int [][]matriz_entrada, int [][]matriz_saida, int inlinha, int outlinha, Semaphore semaphore, Semaphore mutex ) {

        this.nome = nome;
        this.matriz_entrada = matriz_entrada;
        this.matriz_saida = matriz_saida;
        this.inlinha = inlinha;
        this.outlinha = outlinha;
        this.mutex = mutex;
        this.semaphore = semaphore;
        this.num_thread = num_thread;
        
    }
    
    
    
    
   void PreenchimentoLinhaMatrizSaida()
    {
        
        for(int i=inlinha;i<outlinha;i++)
        {
            for(int j=0;j<matriz_entrada[i].length;j++)
            {
                    
                    matriz_saida[i][j] = matriz_entrada[i][j];
                    matriz_entrada[i][j] = 0;
                    //System.out.println("Matriz saida Preenchida" +" "+ "Numero inserido na matriz = " + " " + matriz_entrada[i][j]  + " " + "Linha = " + " " + i + " " + "coluna = " + j);
                   // Printa(matriz_saida);
                    //System.out.println("Matriz entrada desalocada" +" "+ "Numero inserido na matriz = " + " " + matriz_entrada[i][j]  + " " + "Linha = " + " " + i + " " + "coluna = " + j);
                    //Printa(matriz_entrada);
            }
            //Printa(matriz_entrada);
        }
    }
   
       public void run(){
        try{
            semaphore.acquire();
            mutex.acquire();
            
            System.out.println(nome +""+ num_thread + "   Iniciou");
            PreenchimentoLinhaMatrizSaida();
          
            
            System.out.println(nome +""+ num_thread + "   Terminou");
        } catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            mutex.release();
            semaphore.release();
            
        
    }
    
}
}
