/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1.so;


import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author pirat
 */
public class T1SO {

    /**
     * @param args the command line arguments
     */
    
    static void PreenchimentoLinha()
    {
        int i;
        int j;
        int m[][] = new int[10][10];
        Random random = new Random();
        for(i=0;i<m.length;i++)
        {
            for(j=0;j<m[i].length;j++)
            {
                m[i][j]= random.nextInt(99)+1;
                System.out.print(m[i][j]+ " ");
            }
            System.out.println();
        }
    }
    static void PreenchimentoAleatorio()
    {
        boolean teste;
        int i;
        int j;
        int contador=0;
        int m[][] = new int[1000][1000];
        Random random = new Random();
        Random sorteio_linha = new Random();
        Random sorteio_coluna = new Random();
        while(contador<(m[0].length * m[1].length))
        {
                i = sorteio_linha.nextInt(1000);
                j = sorteio_coluna.nextInt(1000);
                teste = Procura(i,j,m);
                if(teste==true)
                {
                    m[i][j]= random.nextInt(99)+1;
                    contador++;
                    System.out.println("I = " + i + " " +"J = " + j + " " + "M" + m[i][j] + " " + "Contador = " + contador);
                    //rinta(m);
                }
                
                //System.out.println("I = " + i + " " +"J = " + j + " " + "M" + m[i][j] + " " + "Contador = " + contador);
        }
        //System.out.println("M.length = " + (m[0].length * m[1].length));
        Printa(m);
        
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
            
    static boolean Procura(int linha, int coluna, int m[][])
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
    
    public static void main(String[] args) 
    {
        
                          int escolha = 0;
                          Scanner in = new Scanner(System.in);
		          System.out.println("Escolha uma das formas de entrada da matriz");
                          System.out.println("1- Preenchimento linha");
                          System.out.println("2 - Preenchimento aleatorio");
                          System.out.println("\n");
                          escolha = in.nextInt();
                          if(escolha==1)
                          {
                              PreenchimentoLinha();
                          }
                          if(escolha==2)
                          {
                             PreenchimentoAleatorio();
                          }
                          
    }
    
}
