package br.cefetmg.inf.lp1.llp1.lista07.p1038;

import java.util.Scanner;
import java.util.Locale;

class Lanche {
    int codigo;
    String nome;
    double preco;
    
    Lanche(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }
}

public class Main {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        
        int num_elementos = 6;
                
        Lanche[] cardapio = new Lanche[num_elementos];
        
        cardapio[1] = new Lanche(1, "Cachorro Quente", 4.00);
        cardapio[2] = new Lanche(2, "X-Salada", 4.50);
        cardapio[3] = new Lanche(3, "X-Bacon", 5.00);
        cardapio[4] = new Lanche(4, "Torrada simples", 2.00);
        cardapio[5] = new Lanche(5, "Refrigerante", 1.50);
        
        int cod = input.nextInt();
        int qntd = input.nextInt();
        
        double total = cardapio[cod].preco * qntd;
        
        System.out.printf("Total: R$ %.2f\n", total);
    }
}
