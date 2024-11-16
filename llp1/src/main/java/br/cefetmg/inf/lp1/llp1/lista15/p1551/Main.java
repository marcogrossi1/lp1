package br.cefetmg.inf.lp1.llp1.lista15.p1551;

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
            int[] res = new int[26];
            String str = in.nextLine();
            
            for(int j = 0; j < str.length(); ++j) {
            
                char ch = str.charAt(j);

                if(isLetter(ch)) {
                    ++res[ch - 97];
                }
            }

            int aux = 0;
            for(int j = 0; j < TAM; ++j)
                if(res[j] > 0)
                    ++aux;
                    
            if(aux == TAM) System.out.println("frase completa");
            else if(aux >= TAM/2) System.out.println("frase quase completa");
            else System.out.println("frase mal elaborada");
        }

        in.close();
    }   
}
