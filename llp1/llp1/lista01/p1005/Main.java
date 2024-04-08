package llp1.br.cefetmg.inf.lp1.llp1.lista01.p1005;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        
        double a, b, media;
        a = input.nextDouble();
        b = input.nextDouble();
        
        media = ((a*3.5) + (b*7.5)) / 11;
        System.out.printf("MEDIA = %.5f\n", media);
    }
}
