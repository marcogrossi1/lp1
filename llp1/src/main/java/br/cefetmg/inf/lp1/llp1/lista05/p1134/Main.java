package br.cefetmg.inf.lp1.llp1.lista05.p1134;

import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        
        int a = input.nextInt(), totalAlcool, totalGasolina, totalDiesel;
        totalAlcool = totalGasolina = totalDiesel = 0;
        
        while (a != 4) {
            switch (a) {
                case 1: ++totalAlcool; break;
                case 2: ++totalGasolina; break;
                case 3: ++totalDiesel; break;
            }
            
            a = input.nextInt();
        }
        
        System.out.printf("MUITO OBRIGADO\n");
        System.out.printf("Alcool: %d\n", totalAlcool);
        System.out.printf("Gasolina: %d\n", totalGasolina);
        System.out.printf("Diesel: %d\n", totalDiesel);
    }
}
