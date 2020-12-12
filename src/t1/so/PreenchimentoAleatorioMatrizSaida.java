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
public class PreenchimentoAleatorioMatrizSaida extends Thread{
        private int [][]matriz_entrada;
        private int [][]matriz_saida;
        private int inlinha;
        private int outlinha;
        private String nome;
        private int num_thread;

    public PreenchimentoAleatorioMatrizSaida(String nome,int num_thread, int [][]matriz_entrada, int [][]matriz_saida, int inlinha, int outlinha) {

        this.nome = nome;
        this.matriz_entrada = matriz_entrada;
        this.matriz_saida = matriz_saida;
        this.inlinha = inlinha;
        this.outlinha = outlinha;
        this.num_thread = num_thread;
        
    }
    
    
    
    
   void PreenchimentoAleatorioSaida()
    {
        
        for(int i=inlinha;i<outlinha;i++)
        {
            for(int j=0;j<matriz_entrada[i].length;j++)
            {
                    
                    matriz_saida[i][j] = matriz_entrada[i][j];
                    matriz_entrada[i][j] = 0;
                   ;
            }
           
        }
    }
   
   
       public void run(){
 
  
            
            System.out.println(nome +""+ num_thread + "   Iniciou");
            
          PreenchimentoAleatorioSaida();
            
            System.out.println(nome +""+ num_thread + "   Terminou");
 
      

              
        
       
    
}
}
