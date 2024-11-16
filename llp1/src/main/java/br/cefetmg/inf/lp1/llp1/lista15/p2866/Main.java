package br.cefetmg.inf.lp1.llp1.lista15.p2866;

import java.util.Scanner;

public class Main {
    public static boolean isLowerCase (char a) {
        return (a >= 'a' && a <= 'z') ? true : false;
    }

    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        int begin = 0;
        char temp;
        int end = arr.length-1;

        while(end>begin){
            temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            
            end--;
            begin++;
        }

        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.valueOf(in.nextLine());

        String[] results = new String[n];

        for(int i = 0; i < n; ++i) {
            String str = reverse(in.nextLine());
            String res = new String();

            for(int j = 0; j < str.length(); ++j) {
                if(isLowerCase(str.charAt(j))) {
                    res += str.charAt(j);
                }
            }

            results[i] = res;

            //System.out.println(String.valueOf(res));
        }

        for(int i = 0; i < n; ++i) 
            System.out.println(results[i]);

        in.close();
    }
}
