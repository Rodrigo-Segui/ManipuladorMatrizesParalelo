/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1.so;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.lang.Thread;


import static t1.so.SOMatrizesSequencial.matriz_entrada;
import static t1.so.SOMatrizesSequencial.n_linhas;
import static t1.so.SOMatrizesSequencial.shuffle;

/** 
 *
 * @author user
 */
public class PreenchimentoAleatorioMatrizEntrada extends Thread {
        private int [][]matriz_entrada;
        private int inlinha;
        private int outlinha;
        private String nome;
        private Semaphore mutex;  //CODIGO VELASCO EBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        private Semaphore semaphore;
        private int num_thread;
        private int []linha_vet;
        private int []coluna_vet;
     
         
    
        public PreenchimentoAleatorioMatrizEntrada(String nome,int num_thread,int inlinha, int outlinha, int [][]matriz_entrada, int []linha_vet, int []coluna_vet, Semaphore semaphore, Semaphore mutex) {

        this.nome = nome;
        this.matriz_entrada = matriz_entrada;
        this.inlinha = inlinha;
        this.outlinha = outlinha;
        this.mutex = mutex;
        this.semaphore = semaphore;
        this.num_thread = num_thread;
        this.linha_vet = linha_vet;
        this.coluna_vet = coluna_vet;
    
    }
    
                
    //FUNCAO VERIFICA DE POSICAO DA MATRIZ JA FOI PREENCHIIDA

    
   //FUNCÃO PREENCHIMENTO ALEATORIO
    void PreenchimentoAleatorioMatrizEntrada()
    {
         
        int numero_sorteado = 0;
        Random random = new Random();
        for(int u= inlinha;u< outlinha ;u++)
        {
            for(int t=0;t<matriz_entrada.length;t++)
            {
                    numero_sorteado = random.nextInt(99)+1;
                    matriz_entrada[linha_vet[u]][coluna_vet[t]] = numero_sorteado;
                    
                    
            }
        
         
        }
}
       
    
    
        @Override
    public void run(){

            System.out.println(nome +""+ num_thread + " Iniciou");
         PreenchimentoAleatorioMatrizEntrada();
        System.out.println(nome +""+ num_thread + " Terminou");
        
  }
   
         
            
        
    }
    

    
    

        