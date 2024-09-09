package br.cefetmg.inf.lp1.llp1.lista04.p2060;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int numCasos = input.nextInt(), mult2, mult3, mult4, mult5;
        mult2 = mult3 = mult4 = mult5 = 0;
        
        for(int i = 0; i < numCasos; ++i) {
            int a = input.nextInt();
            
            if(a % 2 == 0) mult2++;
            if(a % 3 == 0) mult3++;
            if(a % 4 == 0) mult4++;
            if(a % 5 == 0) mult5++;
        }
        
        System.out.printf("%d Multiplo(s) de 2\n", mult2);
        System.out.printf("%d Multiplo(s) de 3\n", mult3);
        System.out.printf("%d Multiplo(s) de 4\n", mult4);
        System.out.printf("%d Multiplo(s) de 5\n", mult5);
    }
}
