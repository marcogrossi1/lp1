package br.cefetmg.inf.lp1.llp1.lista05.p1067;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        
        int a = input.nextInt();
        
        for(int i = 0; i <= a; ++i){
            if(i % 2 == 1)
                System.out.printf("%d\n", i);
        }

        input.close();
    }
}
