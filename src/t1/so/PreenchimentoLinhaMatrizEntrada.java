/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1.so;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import static t1.so.SOMatrizesParalelo.Printa;
import static t1.so.SOMatrizesParalelo.matriz_entrada;

/**
 *
 * @author user
 */
public class PreenchimentoLinhaMatrizEntrada extends Thread {
        private int [][]matriz_entrada;
        private int inlinha;
        private int outlinha;
        private String nome;
        private Semaphore mutex;
        private Semaphore semaphore;
        private int num_thread;
        
    public PreenchimentoLinhaMatrizEntrada(String nome,int num_thread, int [][]matriz_entrada, int inlinha, int outlinha, Semaphore semaphore, Semaphore mutex ){
        this.nome = nome;
        this.matriz_entrada = matriz_entrada;
        this.inlinha = inlinha;
        this.outlinha = outlinha;
        this.mutex = mutex;
        this.semaphore = semaphore;
        this.num_thread = num_thread;
        
        
    }
     void PreenchimentoLinhaMatrizEntrada()
    {
       // try{
           // mutex.acquire(); //SEÇÃO DE ENTRADA
            ////////////////////////////////////////////////// SEÇÃO CRITICA
            int n_sorteado;
            Random random = new Random();
            for(int i= inlinha ;i< outlinha ;i++)
                {
                    for(int j=0;j< matriz_entrada[i].length;j++)
                        {
                            n_sorteado = random.nextInt(99)+1;
                            matriz_entrada[i][j] = n_sorteado;
                            //System.out.println("Matriz Entrada Preenchida" +" "+ "Numero inserido na matriz = " + " " + n_sorteado + " " + "Linha = " + " " + i + " " + "coluna = " + j);
                           // Printa(matriz_entrada);
   
                         }
                    //System.out.println("Thread" + inlinha + "" + outlinha);
                    //System.out.println("-----------------------------------");
                    
           
                    //System.out.println("----------------------");
                    //Printa(matriz_entrada);
                    //System.out.println("-----------------------");
                   
                    //System.out.println("ACESSO LIBERADO");
                    //System.out.println("------------------------------------");
                    //System.out.println("Acabou Thread" + inlinha + "" + outlinha);
                    
                    
                    
            }
            
            //Printa(matriz_entrada);
    }
        ////////////////////////////////////////////////// SEÇÃO CRITICA
       //}catch(InterruptedException e) {} 
        //finally {
           // mutex.release();  //SEÇÃO DE SAIDA
        //}
     //}
    
    public void run(){
        
        try{
            semaphore.acquire();
            mutex.acquire();
            System.out.println(nome +""+ num_thread + " Iniciou");
            //PreenchimentoLinhaMatrizEntrada();
            int n_sorteado;
            Random random = new Random();
            for(int i= inlinha ;i< outlinha ;i++)
                {
                    for(int j=0;j< matriz_entrada[i].length;j++)
                        {
                            n_sorteado = random.nextInt(99)+1;
                            matriz_entrada[i][j] = n_sorteado;
                            //System.out.println("Matriz Entrada Preenchida" +" "+ "Numero inserido na matriz = " + " " + n_sorteado + " " + "Linha = " + " " + i + " " + "coluna = " + j);
                           // Printa(matriz_entrada);
   
                         }
                }
            
            System.out.println(nome +""+ num_thread + " Terminou");
        } catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            mutex.release();
            semaphore.release();
            
        
    }
        
        //try{
          //  mutex.acquire();
            //System.out.println("----------------");
            //Printa(matriz_entrada);
            //System.out.println("----------------");
        //} catch(InterruptedException e){
          //  e.printStackTrace();
        //}finally{
          //  mutex.release();
        
    //}
        
        
        
        
        
       
        }
    
}
