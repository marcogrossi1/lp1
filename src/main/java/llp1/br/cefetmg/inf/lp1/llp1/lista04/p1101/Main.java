package llp1.br.cefetmg.inf.lp1.llp1.lista04.p1101;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        int a = input.nextInt(), b = input.nextInt();
        
        while(a > 0 && b > 0) {
            if(a > b) {
                int aux = a;
                a = b;
                b = aux;
            }
            
            int soma = 0;
            
            for(int i = a; i <= b; ++i) {
                System.out.printf("%d ", i);
                soma+=i;
            }
            
            System.out.printf("Sum=%d\n", soma);
            
            a = input.nextInt();
            b = input.nextInt();
        }
    }
}
