package br.cefetmg.inf.lp1.llp1.lista04.p1094;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int numCasos = input.nextInt(), totalCobaias = 0, totalCoelhos = 0, totalRatos = 0, totalSapos = 0;
        
        for(int i = 0; i < numCasos; ++i) {
            int quantia = input.nextInt();
            char tipo = input.next().charAt(0);
            
            totalCobaias += quantia;
            
            switch (tipo) {
                case 'C': totalCoelhos += quantia; break;
                case 'R': totalRatos += quantia; break;
                case 'S': totalSapos += quantia;
            }
        }
        
        System.out.printf("Total: %d cobaias\n", totalCobaias);
        System.out.printf("Total de coelhos: %d\n", totalCoelhos);
        System.out.printf("Total de ratos: %d\n", totalRatos);
        System.out.printf("Total de sapos: %d\n", totalSapos);
        System.out.printf("Percentual de coelhos: %.2f %%\n", (double) totalCoelhos/totalCobaias * 100);
        System.out.printf("Percentual de ratos: %.2f %%\n", (double) totalRatos/totalCobaias * 100);
        System.out.printf("Percentual de sapos: %.2f %%\n", (double) totalSapos/totalCobaias * 100);

        input.close();
    }
}
