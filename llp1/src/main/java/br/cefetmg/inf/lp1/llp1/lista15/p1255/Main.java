package br.cefetmg.inf.lp1.llp1.lista15.p1255;

import java.util.Scanner;

public class Main {
    public static boolean isLetter(char a) {
        return (a >= 'a' && a <= 'z') ? true : false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.valueOf(in.nextLine());

        for(int i = 0; i < n; ++i) {
            int TAM = 26;
            int[] res = new int[TAM];
            String str = in.nextLine().toLowerCase();
            
            int maior = 0;
            for(int j = 0; j < str.length(); ++j) {
                char ch = str.charAt(j);
                    
                if(isLetter(ch)) {
                    res[(int) (ch - 97)]++;
                    
                    if(res[(int) (ch - 97)] > maior) {
                        maior = res[(int) (ch - 97)];
                    }
                }
            }

            for(int j = 0; j < TAM; ++j)
                if(res[j] == maior) {
                    char ch = (char) (j + 97);
                    System.out.print(ch);
                }
            System.out.println();
        }

        in.close();
    }
}