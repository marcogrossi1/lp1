package br.cefetmg.inf.lp1.llp1.lista09.p1068; 
import java.util.Scanner;

enum Status {
    SUCESSO, INVALIDA, VAZIA
};

interface Lista {
    Status inserir(String item);
    Status inserir(String item, int pos);

    String remover();
    String remover(int pos);

    String pesquisarPos(int pos);

    int tamanho();
    boolean vazia();
}

class ListaArray implements Lista {
    private int capacidade = 5, OFF_SET = 5, tam = 0, ultimo = 0;
    private String[] lista = new String[capacidade];
    private Status s = Status.SUCESSO;

    private String[] addAll(String[] array1, String[] array2) {
        String aux[] = new String[array1.length + array2.length + 1];
        System.arraycopy(array1, 0, aux, 0, array1.length);
        System.arraycopy(array2, 0, aux, array1.length, array2.length);
        aux[aux.length-1] = lista[tam-1];

        return aux;
    }

    public Status inserir(String item) {
        if(tamanho() == capacidade) {
            capacidade += OFF_SET;
            String[] aux = new String[capacidade];

            System.arraycopy(lista, 0, aux, 0, tamanho());
            lista = aux;
        }

        lista[ultimo] = item;
        ultimo++;
        tam++;

        return s;
    }

    public Status inserir(String item, int pos) {
        if(tamanho() == capacidade) {
            capacidade += OFF_SET;
            String[] aux = new String[capacidade];

            System.arraycopy(lista, 0, aux, 0, tamanho());
            lista = aux;
        }

        String[] aux1 = new String[pos+1];
        System.arraycopy(lista, 0, aux1, 0, pos+1);

        String[] aux2 = new String[tam - pos];
        System.arraycopy(lista, pos, aux2, 0, tam - pos);

        lista = addAll(aux1, aux2);
        
        lista[pos] = item;
        tam++;
        ultimo++;

        return s;
    }

    public String remover() {
        String resultado = lista[0];

        if(vazia()) {
            return null;
        }

        else if(!vazia()) {
            if((capacidade - tam) >= 2*OFF_SET)
                capacidade -= OFF_SET;
            
            String aux[] = new String[capacidade];
            System.arraycopy(lista, 1, aux, 0, tamanho());
            
            lista = aux;
            tam--;
            ultimo--;
        }

        return resultado;
    }

    public String remover(int pos) {
        String resultado = lista[pos];

        if(vazia())
            return null;

        else if(!vazia()) {
            if((capacidade - tam) >= 2*OFF_SET)
                capacidade -= OFF_SET;

            String[] aux1 = new String[pos];
            System.arraycopy(lista, 0, aux1, 0, pos);
            
            
            
            String[] aux2 = new String[capacidade];
            System.arraycopy(lista, pos+1, aux2, 0, tamanho() - pos-1);
    
            lista = addAll(aux1, aux2);
 
            tam--;
            ultimo--;
        }

        return resultado;
    }

    public String pesquisarPos(int pos) {
        if(pos < tamanho())
            return lista[pos];
        return null;
    }

    public void pesquisarItem(String item) {
        int cont = 0;
        
        for(int i = 0; i < tamanho(); ++i)
            if(lista[i] == item)
                System.out.println(i);
    }

    public int tamanho() {
        return tam;
    }

    public boolean vazia() {
        if (tam == 0)
            return true;
        
        return false;
    }

    void exibeLista() {
        for(int i = 0; i < tam; ++i) {
            System.out.println(lista[i]);
        }
    }
}

class ListaEncadeada implements Lista {
    class Node {
        Node proximo;

        String item;

        Node(String item) {
            this.item = item;
        }
    }
    
    Node primeiro = null;
    Node atual = null;  
    private int tam = 0;
    private Status s = Status.SUCESSO;

    public Status inserir(String item) {
        if(vazia()) {
            primeiro = new Node(item);
            atual = primeiro;
        }

        else if(!vazia()){
            Node novo = new Node(item);

            if(primeiro.proximo == null)
                primeiro.proximo = novo;

            else
                atual.proximo = novo;
            
            atual = novo;
        }

        tam++;

        return s;
    }

    public Status inserir(String item, int pos) {
        Node elemento = primeiro;

        for(int i = 0; i < pos; i++)
            elemento = elemento.proximo;

        Node aux = elemento;

        elemento = primeiro;
        for(int i = 0; i < pos-1; i++)
            elemento = elemento.proximo;

        Node novoItem = new Node(item);

        elemento.proximo = novoItem;
        novoItem.proximo = aux;  

        tam++;
        
        return s;
    }

    public String remover() {
        Node resultado = primeiro;
        
        if(vazia())
            System.out.println("A lista está vazia!");
        
        else if(!vazia()) {
            primeiro = primeiro.proximo;
        }

        tam--;

        return resultado.item;
    }

    public String remover(int pos) {
        Node aux = primeiro;
        Node elementoRetirado = primeiro;
        
        for(int i = 0; i < pos-1; i++) {
            aux = aux.proximo;
        }
        
        for(int i = 0; i < pos; i++) {
            elementoRetirado = elementoRetirado.proximo;
        }
        
        Node resultado = elementoRetirado.proximo;
        aux.proximo = elementoRetirado.proximo;

        tam--;

        return resultado.item;
    }
    
    public String pesquisarPos(int pos) {
        Node elemento = primeiro;

        for(int i = 0; i < pos; i ++)
            elemento = elemento.proximo;

        return elemento.item;
    }

    public void pesquisarItem(String item) {
        Node elemento = primeiro;
        
        for(int i = 0; i < tam; i++) {
            if(elemento.item == item)
                System.out.println(i); 
            
            elemento = elemento.proximo;
        }
    }

    public boolean vazia() {
        if(tam == 0)
            return  true;
        
        return false;
    }

    public int tamanho() {
        return tam;
    }

    public void exibeLista(Node elemento) {
        if(elemento != null) {
            System.out.println(elemento.item);

            if(elemento.proximo != null)
                exibeLista(elemento.proximo);
        }
    }
}

class ListaDuplamenteEncadeada implements Lista {
    class Node {
        Node proximo, anterior;

        String item;

        Node(String item) {
            this.item = item;
        }
    }
    
    Node primeiro = null;
    Node atual = null;
    private int tam = 0;
    private Status s = Status.SUCESSO;

    public Status inserir(String item) {
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

        return s;
    }

    public Status inserir(String item, int pos) {
        if(tamanho()/2 > pos) {
            Node elemento = primeiro;

            for(int i = 0; i < pos; i++)
                elemento = elemento.proximo;

            Node aux = elemento;

            elemento = primeiro;
            for(int i = 0; i < pos-1; i++)
                elemento = elemento.proximo;

            Node novoItem = new Node(item);

            elemento.proximo = novoItem;
            novoItem.proximo = aux;  
        }
        
        else {
            Node elemento = atual;

            for(int i = tam; i > pos; i--)
                elemento = elemento.anterior;

            Node aux = elemento;
            elemento = atual;
            for(int i = tam; i > pos+1; i--)
                elemento = elemento.proximo;

            Node novoItem = new Node(item);

            elemento.anterior = novoItem;
            novoItem.anterior = aux;
        }

        tam++;

        return s;
    }

    public String remover() {
        Node resultado = primeiro;
        
        if(vazia())
            return null;
        
        else if(!vazia()) {
            primeiro = primeiro.proximo;
        }

        tam--;

        return resultado.item;
    }

    public String remover(int pos) {
        Node resultado;
        
        if(vazia())
            return null;

        else if(tamanho()/2 > pos) {
            Node aux = primeiro;
            Node elementoRetirado = primeiro;
            
            for(int i = 0; i < pos-1; i++) {
                aux = aux.proximo;
            }

            for(int i = 0; i < pos; i++) {
                elementoRetirado = elementoRetirado.proximo;
            }

            resultado = elementoRetirado.proximo;
            aux.proximo = elementoRetirado.proximo;
        }

        else {
            Node aux = atual;
            Node elementoRetirado = atual;

            for(int i = tamanho(); i > pos+1; i--)
                aux = aux.anterior;
            
            for(int i = tamanho(); i > pos; i--)
                elementoRetirado = elementoRetirado.anterior;

            resultado = elementoRetirado.anterior;
            aux.anterior = elementoRetirado.anterior;
        }
        
        tam--;

        return resultado.item;
    }
    
    public String pesquisarPos(int pos) {
        Node elemento;
        
        if(tam/2 > pos) {
            elemento = primeiro;

            for(int i = 0; i < pos; i ++)
                elemento = elemento.proximo;
        }

        else {
            elemento = atual;

            for(int i = tamanho(); i > pos; i--)
                elemento = elemento.anterior;
        }
        
        return elemento.item;
    }

    public void pesquisarItem(String item) {
        Node elemento = primeiro;
        
        for(int i = 0; i < tam; i++) {
            if(elemento.item == item)
                System.out.println(i); 
            
            elemento = elemento.proximo;
        }
    }

    public boolean vazia() {
        if(tam == 0)
            return  true;
        
        return false;
    }

    public int tamanho() {
        return tam;
    }

    public void exibeLista(Node elemento) {
        if(elemento != null) {
            System.out.println(elemento.item);

            if(elemento.proximo != null)
                exibeLista(elemento.proximo);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(input.hasNext()) {
            ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
            String a = input.nextLine();
            int err = 0;
            for(char x : a.toCharArray()) {
                if (x == '(') {
                    String b = String.valueOf(x);
                    lista.inserir(b);
                }
                
                else if(x == ')') {
                    String aux = lista.remover();
                    if(aux == null) {
                        err = 1;                    
                        break;
                    }
                }

                err = 0;
            }

            if(!lista.vazia() || err == 1)
                System.out.println("incorrect");

            else
                System.out.println("correct");
        }
                
        input.close();
    }
}