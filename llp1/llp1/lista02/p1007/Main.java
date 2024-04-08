package llp1.br.cefetmg.inf.lp1.llp1.lista02.p1007;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        
        int a,b,c,d, dif;
        
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        d = input.nextInt();
        
        dif = (a*b) - (c*d);
        
        System.out.printf("DIFERENCA = %d\n", dif);
    }
}