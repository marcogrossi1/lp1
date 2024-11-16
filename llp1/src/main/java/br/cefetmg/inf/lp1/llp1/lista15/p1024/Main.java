package br.cefetmg.inf.lp1.llp1.lista15.p1024;

import java.util.Scanner;

public class Main {
    public static Boolean isLetter(char a) {
        return ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) ? true : false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = Integer.valueOf(input.nextLine());

        String[] result = new String[n];
        
        for(int i = 0; i < n; ++i) {
            String m = input.nextLine();

            char[] arr = m.toCharArray();

            // First iteration
            for(int j = 0; j < m.length(); ++j) 
                if(isLetter(arr[j]))
                    arr[j] += 3;

            // Second iteration
            int begin = 0;
            int end = arr.length-1;
            char temp;

            while(end>begin){
                temp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = temp;
                
                end--;
                begin++;
            }

            // Third iteration
            for(int j = (int) Math.floor(m.length()/2); j < m.length(); ++j) 
                arr[j] -= 1;    

            result[i] = String.valueOf(arr);
        }

        for(int i = 0; i < n; ++i) 
            System.out.println(result[i]);

        input.close();
    }
}