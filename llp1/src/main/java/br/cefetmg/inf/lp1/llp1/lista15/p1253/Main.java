package br.cefetmg.inf.lp1.llp1.lista15.p1253;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.valueOf(in.nextLine());

        for(int i = 0; i < n; ++i) {
            String str = in.nextLine();

            int x = Integer.valueOf(in.nextLine());

            char[] strAux = str.toCharArray();

            for(int j = 0; j < str.length(); ++j) {
                int ch = strAux[j];
                
                if(ch - x < (int) 'A') {
                    ch = 'Z' - (x - (ch - 'A' + 1));
                }
                
                else
                    ch -= x;

                strAux[j] = (char) ch;
            }

            System.out.println(String.valueOf(strAux));
        }

        in.close();
    }
}