package br.cefetmg.inf.lp1.llp1.lista06.p1105;

import java.util.Scanner;

class Banco {
    int codigo, valorTotal;
    
    void calculaTotal (int valor) {
        valorTotal += valor;
    }    
}

class Mercado {
    Banco[] ban;
    
    Mercado (int num_bancos) {
        ban = new Banco[num_bancos];
        
        ban[0] = new Banco();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int num_bancos = input.nextInt();
        int num_debentures = input.nextInt();
       
        Mercado mercado = new Mercado(num_bancos);
        
        for(int i = 0; i < num_bancos; ++i) {
            mercado.ban[i].valorTotal = input.nextInt();
            mercado.ban[i].codigo = ++i;
        }
        
        while(num_bancos != 0 && num_debentures!= 0) {            
            int banco1, banco2, valor;
            
            for(int i = 0; i < num_debentures; ++i) {
                banco1 = input.nextInt();
                banco2 = input.nextInt();                
                valor = input.nextInt();
                
                mercado.ban[banco1].calculaTotal(valor);
                mercado.ban[banco2].calculaTotal(-valor);
            }
            
            num_bancos = input.nextInt();
            num_debentures = input.nextInt();

            input.close();
        }
    }
}
