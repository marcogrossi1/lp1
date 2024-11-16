package br.cefetmg.inf.lp1.llp1.lista15.p2292;

import java.util.Scanner;

public class Main {
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

        for(int i = 0; i < n; ++i) {
            String[] line = in.nextLine().split(" ");
            
            String p = line[0];
            long c = Long.valueOf(line[1]);
                     
            String binario = "";
            for(int j = 0; j < p.length(); ++j) {
                if(p.charAt(j) == 'X')
                    binario += '0';
                
                else
                    binario += '1';
            }

            long numP = Long.parseLong(reverse(binario), 2) + c;
            binario = reverse(Long.toBinaryString(numP));

            String resStr = new String();
            for(int j = 0; j < p.length(); ++j) {
                if(j >= binario.length()) {
                    while(resStr.length() < p.length()) 
                        resStr += "X";
                }

                else {
                    if(binario.charAt(j) == '1')
                        resStr += "O";
                    
                    else 
                        resStr += "X";
                }
            }

            System.out.println(resStr);
        }
        
        in.close();
    }
}