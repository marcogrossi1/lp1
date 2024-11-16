package br.cefetmg.inf.lp1.llp1.lista15.p2591;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.valueOf(in.nextLine());

        for(int i = 0; i < n; ++i) {
            String str = in.nextLine();

            int countA1 = 0;
            
            for(int j = 1; str.charAt(j) == 'a'; ++j) {
                ++countA1;
            }

            int countA2 = 0;

            for(int j = 1 + countA1 + 3; str.charAt(j) == 'a'; ++j) {
                ++countA2;
            }
            
            String res = "k";
            for(int j = 0; j < countA1 * countA2; ++j)
                res += "a";

            System.out.println(res);
        }

        in.close();
    }
}