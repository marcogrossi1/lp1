package br.cefetmg.inf.lp1.llp1.lista16.p1068;

import java.util.Stack;
import java.util.EmptyStackException;
import java.util.Scanner;
    
@SuppressWarnings("SequencedCollectionMethodCanBeUsed")
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while(input.hasNext()) {
            Stack<String> pilha = new Stack<>();
            String a = input.nextLine();
            
            int err = 0;
            try {
                for(char x : a.toCharArray()) {
                    if (x == '(') {
                        String b = String.valueOf(x);
                        pilha.add(b);
                    }

                    else if(x == ')') {
                        if(pilha.isEmpty()) {
                            err = 1;
                            break;
                        }
                        
                        String aux = pilha.remove(0);
                        if(!aux.equals("(")) {
                            err = 1;
                            break;
                        }
                    }
                }
            }

            catch(EmptyStackException e) {
                System.out.println("Erro! A pilha está vazia. (pilha.pop() implementation)");
            }

            catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("Erro! A pilha está vazia. (pilha.remove(0) implementation)");
            }

            if(!pilha.isEmpty()|| err == 1)
                System.out.println("incorrect");

            else
                System.out.println("correct");
        }
        
        input.close();
    } 
}