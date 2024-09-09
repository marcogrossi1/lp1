package br.cefetmg.inf.lp1.llp1.lista05.p1985;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        
        int qntdProdutos = input.nextInt();
        double total = 0;
        
        for(int i = 0; i < qntdProdutos; ++i) {
            int codigo = input.nextInt(), qntd = input.nextInt();
            
            switch (codigo) {
                case 1001: total += qntd * 1.5; break;
                case 1002: total += qntd * 2.5; break;
                case 1003: total += qntd * 3.5; break;
                case 1004: total += qntd * 4.5; break;
                case 1005: total += qntd * 5.5;
            }
        }
        
        System.out.printf("%.2f\n", total);
    }
}
