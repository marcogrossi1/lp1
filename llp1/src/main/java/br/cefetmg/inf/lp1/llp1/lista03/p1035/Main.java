package llp1.br.cefetmg.inf.lp1.llp1.lista03.p1035;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        
        int a, b, c, d;
        
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        d = input.nextInt();
        
        if ((b > c) && (d > a) && (c+d > a+b) && (c > 0) && (d > 0) && (a % 2 == 0))
            System.out.println("Valores aceitos");
        
        else
            System.out.println("Valores nao aceitos");
    }
}
