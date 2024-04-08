package llp1.br.cefetmg.inf.lp1.llp1.lista03.p1038;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        
        int codigo, qntd;
        double valorFinal = 0;
        
        codigo = input.nextInt();
        qntd = input.nextInt();
        
        switch (codigo) {
            case 1 -> {
                valorFinal = qntd*4;
            }
            
            case 2 -> {
                valorFinal = qntd*4.5;
            }
            
            case 3 -> {
                valorFinal = qntd*5;
            }
            
            case 4 -> {
                valorFinal = qntd*2;
            }
            
            case 5 -> {
                valorFinal = qntd*1.5;
            }
        }
        
        System.out.printf("Total: R$ %.2f\n", valorFinal);
    }
}