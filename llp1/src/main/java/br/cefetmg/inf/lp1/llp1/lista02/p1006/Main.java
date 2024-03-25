package llp1.br.cefetmg.inf.lp1.llp1.lista02.p1006;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        
        double nota1, nota2, nota3, media;
        
        nota1 = input.nextDouble();
        nota2 = input.nextDouble();
        nota3 = input.nextDouble();
        
        media = (nota1 * 2 + nota2 * 3 + nota3 * 5)/10;
        
        System.out.printf("MEDIA = %.1f\n", media);
    }
}
