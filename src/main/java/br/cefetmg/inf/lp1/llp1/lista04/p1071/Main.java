package br.cefetmg.inf.lp1.llp1.lista04.p1071;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int num1, num2, soma = 0;
        
        num1 = input.nextInt();
        num2 = input.nextInt();
        
        if(num1 > num2){
            int aux = num1;
            num1 = num2;
            num2 = aux;
        }
        
        for(int i = num1+1; i < num2; ++i)
            if(i % 2 != 0) {
                soma += i;
                ++i;
            }
        
        System.out.printf("%d\n", soma);
    }
}