package br.cefetmg.inf.lp1.llp1.lista01.p1001;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        
        int a, b, x;
        a = input.nextInt();
        b = input.nextInt();
        
        x = a + b;
        System.out.printf("X = %d\n", x);

        input.close();
    }
}