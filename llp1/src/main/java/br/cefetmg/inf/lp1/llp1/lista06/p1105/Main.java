package br.cefetmg.inf.lp1.llp1.lista06.p1105;

import java.util.Scanner;

public class Main {
    static int[] bancos;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int b, n;

        while (true) {
            b = in.nextInt();
            n = in.nextInt();

            if (b == 0 && n == 0) break;

            bancos = new int[b + 1];
            for (int i = 1; i - 1 < b; i++)
                bancos[i] = in.nextInt();

            for (int i = 0; i < n; i++) {
                int ban_dev, ban_rec, val;
                
                ban_dev = in.nextInt();
                ban_rec = in.nextInt();
                val = in.nextInt();
                bancos[ban_dev] -= val;
                bancos[ban_rec] += val;
            }

            for (int i = 1; i <= b; i++) {
                if (bancos[i] < 0) {
                    System.out.println("N");
                    break;
                }

                if (i == b)
                    System.out.println("S");
            }
        }

        in.close();
    }
}