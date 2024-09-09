package br.cefetmg.inf.lp1.llp1.lista02.p1008;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        
        int numFun, numHoras;
        double valorHora, salario;
        
        numFun = input.nextInt();
        numHoras = input.nextInt();
        valorHora = input.nextDouble();
        
        salario = numHoras * valorHora;
        
        System.out.printf("NUMBER = %d\nSALARY = U$ %.2f\n", numFun, salario);
    }
}
