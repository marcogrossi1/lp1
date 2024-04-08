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

class Cardapio {    
    Lanche[] lanche;
    
    Cardapio (int num_elementos){
        lanche = new Lanche[num_elementos];
        
        lanche[1] = new Lanche(1, "Cachorro Quente", 4.00);
        lanche[2] = new Lanche(2, "X-Salada", 4.50);
        lanche[3] = new Lanche(3, "X-Bacon", 5.00);
        lanche[4] = new Lanche(4, "Torrada simples", 2.00);
        lanche[5] = new Lanche(5, "Refrigerante", 1.50);
    }
    
    double valorFinal (int cod, int qntd) {
        return lanche[cod].preco * qntd;
    }
}

public class Main {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        
        int num_elementos = 6;
                
        Cardapio card = new Cardapio(num_elementos);

        int cod = input.nextInt();
        int qntd = input.nextInt();
        
        System.out.printf("Total: R$ %.2f\n", card.valorFinal(cod, qntd));
    }
}