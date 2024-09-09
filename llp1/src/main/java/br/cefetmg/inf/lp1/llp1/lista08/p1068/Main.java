package br.cefetmg.inf.lp1.llp1.lista08.p1068;
import java.util.Scanner;

class PilhaArray {
    private int capacidade = 5, OFF_SET = 5, tam = 0;
    private String[] pilha = new String[capacidade];

    public void empilhar(String item) {
        if(tam == capacidade) 
            capacidade += OFF_SET;

        String aux[] = new String[capacidade];
        
        System.arraycopy(pilha, 0, aux, 1, tamanho());
        pilha = aux;

        pilha[0] = item;

        tam++;
    } 

    public String desempilhar() {
        String resultado = pilha[0];

        if(vazia()) {
            resultado = null;
        }
        
        else if(!vazia()) {
            if((capacidade - tam) >= (2 * OFF_SET))
                capacidade -= OFF_SET;
            
            String aux[] = new String[capacidade];
            
            tam--;
            System.arraycopy(pilha, 1, aux, 0, tamanho());
            
            pilha = aux;
        }
        
        return resultado;
    }

    public boolean vazia() {
        if(tam == 0)
            return  true;
        
        return false;
    }

    public int tamanho() {
        return tam;
    }

    public void exibeFila() {
        for(int i = 0; i < tam; ++i) {
            System.out.println(pilha[i]);
        }
    }
}

class PilhaEncadeada {
    class Node {
        Node proximo, anterior;

        char item;

        Node(char item) {
            this.item = item;
        }
    }
    
    Node primeiro = null;
    Node atual = null;
    private int tam = 0;

    public void empilhar(char item) {
        if(vazia()) {
            primeiro = new Node(item);
            atual = primeiro;
        }

        else if(!vazia()){
            Node novo = new Node(item);

            if(primeiro.proximo == null) {
                primeiro.proximo = novo;
                novo.anterior = primeiro;
            }

            else {
                atual.proximo = novo;
                novo.anterior = atual;
            }

            atual = novo;
        }

        tam++;
    }

    public char desempilhar() {
        Node resultado = atual;
        
        if(vazia()) {
            return (char) -1;
        }
        
        else if(!vazia()) {
            atual = atual.anterior;
        }

        tam--;

        return resultado.item;
    }
    
    public boolean vazia() {
        if(tam == 0)
            return  true;
        
        return false;
    }

    public int tamanho() {
        return tam;
    }

    public void exibeFila(Node elemento) {
        if(elemento != null) {
            System.out.println(elemento.item);

            if(elemento.proximo != null)
                exibeFila(elemento.proximo);
        }
    }
}

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while(input.hasNext()) {
            PilhaArray pilha = new PilhaArray();
            String a = input.nextLine();
            int err = 0;
            for(char x : a.toCharArray()) {
                if (x == '(') {
                    String b = String.valueOf(x);
                    pilha.empilhar(b);
                }
                
                else if(x == ')') {
                    String aux = pilha.desempilhar();
                    if(aux == null) {
                        err = 1;                    
                        break;
                    }

                    else if(!aux.equals("(")) {
                        err = 1;
                        break;
                    }
                }

                err = 0;
            }

            if(!pilha.vazia() || err == 1)
                System.out.println("incorrect");

            else
                System.out.println("correct");
        }
        
        input.close();
    } 
}