/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1.so;

import java.util.Random;
import java.util.concurrent.Semaphore;
import sun.jvm.hotspot.runtime.Threads;

/**
 *
 * @author user
 */
public class PreenchimentoAleatorioMatrizEntrada extends Threads {
        private int [][]matriz_entrada;
        private int inlinha;
        private int outlinha;
        private String nome;
        private Semaphore mutex;
        private Semaphore semaphore;
        private int num_thread;
    
        public PreenchimentoAleatorioMatrizEntrada(String nome,int num_thread, int [][]matriz_entrada, int inlinha, int outlinha, Semaphore semaphore, Semaphore mutex) {
        this.nome = nome;
        this.matriz_entrada = matriz_entrada;
        this.inlinha = inlinha;
        this.outlinha = outlinha;
        this.mutex = mutex;
        this.semaphore = semaphore;
        this.num_thread = num_thread;
    
    }
    
                
    //FUNCAO VERIFICA DE POSICAO DA MATRIZ JA FOI PREENCHIIDA
    //RETURN TRUE SE POSICAO AINDA NAO FOI PREENCHIDA
    //RETURN FALSE SE POSICAOJA FOI PREENCHIDA
    boolean VerificaPosicaoVazia(int linha, int coluna, int m[][])
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
    
    
    
   //FUNCÃO PREENCHIMENTO ALEATORIO
    void PreenchimentoAleatorio()
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
                    //Printa(matriz_entrada);
                    contador++;
                }
        }
        System.out.println("Print da Matriz Final de Entrada");
       // Printa(matriz_entrada);
        
    }
    
    
}
