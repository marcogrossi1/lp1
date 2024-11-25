package br.cefetmg.inf.lp1.llp1.lista06.p1245;

import java.util.Scanner;
public class Main { 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);

        int botas, par = 0;
        while (input.hasNext()) {
            botas = input.nextInt();
        
            if (botas == 0) {
                break;
            }
        
            int[] tamanho = new int[botas];
            char[] lado = new char[botas];
        
            for (int i = 0; i < botas; i++) {
                tamanho[i] = input.nextInt();
                lado[i] = input.next().charAt(0);
            }
        
            for (int i = 0; i < botas - 1; i++) {
                for (int j = i + 1; j < botas; j++) {
                    if (tamanho[i] == tamanho[j] && lado[i] != lado[j]) {
                        par++;
                        tamanho[i] = 0;
                        tamanho[j] = 0;
                        lado[i] = ' ';
                        lado[j] = ' ';
                    }
                }
            }
        
            System.out.println(par);
            par = 0;
        }
        
        input.close();
    }

    
}