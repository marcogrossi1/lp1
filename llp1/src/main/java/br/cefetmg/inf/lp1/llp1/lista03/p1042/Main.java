package llp1.br.cefetmg.inf.lp1.llp1.lista03.p1042;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int a, b, c, aux;
        
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        
        int a1 = a, b1 = b, c1 = c;
        
        if(b > c) {
            aux = b;
            b = c;
            c = aux;
        }
        
        if(a > b) {
            aux = a;
            a = b;
            b = aux;
        }
        
        if (b > c) {
            aux = b;
            b = c;
            c = aux;
        }
        
        System.out.printf("%d\n", a);
        System.out.printf("%d\n", b);
        System.out.printf("%d\n", c);
        System.out.printf("\n");
        System.out.printf("%d\n", a1);
        System.out.printf("%d\n", b1);
        System.out.printf("%d\n", c1);
    }
}
