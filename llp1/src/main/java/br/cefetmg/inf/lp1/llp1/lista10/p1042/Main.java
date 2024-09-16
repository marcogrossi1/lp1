package br.cefetmg.inf.lp1.llp1.lista10.p1042;
import java.util.Scanner;

enum Status {
    SUCESSO, INVALIDA, VAZIA
};

interface Lista {
    Status inserir(Object item);
    Status inserir(Object item, int pos);

    Object remover();
    Object remover(int pos);

    Object pesquisarPos(int pos);

    int tamanho();
    boolean vazia();

    void exibeLista();
}

class ListaArray implements Lista {
    private int capacidade = 5, OFF_SET = 5, tam = 0, ultimo = 0;
    private Object[] lista = new Object[capacidade];
    private Status s = Status.SUCESSO;

    private Object[] addAll(Object[] array1, Object[] array2) {
        Object aux[] = new Object[array1.length + array2.length + 1];
        System.arraycopy(array1, 0, aux, 0, array1.length);
        System.arraycopy(array2, 0, aux, array1.length, array2.length);
        aux[aux.length-1] = lista[tam-1];

        return aux;
    }

    public Status inserir(Object item) {
        if(tamanho() == capacidade) {
            capacidade += OFF_SET;
            Object[] aux = new Object[capacidade];

            System.arraycopy(lista, 0, aux, 0, tamanho());
            lista = aux;
        }

        lista[ultimo] = item;
        ultimo++;
        tam++;

        return s;
    }

    public Status inserir(Object item, int pos) {
        if(tamanho() == capacidade) {
            capacidade += OFF_SET;
            Object[] aux = new Object[capacidade];

            System.arraycopy(lista, 0, aux, 0, tamanho());
            lista = aux;
        }

        Object[] aux1 = new Object[pos+1];
        System.arraycopy(lista, 0, aux1, 0, pos+1);

        Object[] aux2 = new Object[tam - pos];
        System.arraycopy(lista, pos, aux2, 0, tam - pos);

        lista = addAll(aux1, aux2);
        
        lista[pos] = item;
        tam++;
        ultimo++;

        return s;
    }

    public Object remover() {
        Object resultado = lista[0];

        if(vazia()) {
            return null;
        }

        else if(!vazia()) {
            if((capacidade - tam) >= 2*OFF_SET)
                capacidade -= OFF_SET;
            
            Object aux[] = new Object[capacidade];
            System.arraycopy(lista, 1, aux, 0, tamanho());
            
            lista = aux;
            tam--;
            ultimo--;
        }

        return resultado;
    }

    public Object remover(int pos) {
        Object resultado = lista[pos];

        if(vazia())
            return null;

        else if(!vazia()) {
            if((capacidade - tam) >= 2*OFF_SET)
                capacidade -= OFF_SET;

            Object[] aux1 = new Object[pos];
            System.arraycopy(lista, 0, aux1, 0, pos);
            
            Object[] aux2 = new Object[capacidade];
            System.arraycopy(lista, pos+1, aux2, 0, tamanho() - pos-1);

            lista = addAll(aux1, aux2);
 
            tam--;
            ultimo--;
        }

        return resultado;
    }

    public Object pesquisarPos(int pos) {
        if(pos < tamanho())
            return lista[pos];
        return null;
    }

    public void pesquisarItem(Object item) {        
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

    public void exibeLista() {
        for(int i = 0; i < tam; ++i) {
            System.out.println(lista[i]);
        }
    }
}

class ListaEncadeada implements Lista {
    class Node {
        Node proximo;

        Object item;

        Node(Object item) {
            this.item = item;
        }
    }
    
    Node primeiro = null;
    Node atual = null;  
    private int tam = 0;
    private Status s = Status.SUCESSO;

    public Status inserir(Object item) {
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

    public Status inserir(Object item, int pos) {
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

    public Object remover() {
        Node resultado = primeiro;
        
        if(vazia())
            System.out.println("A lista está vazia!");
        
        else if(!vazia()) {
            primeiro = primeiro.proximo;
        }

        tam--;

        return resultado.item;
    }

    public Object remover(int pos) {
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
    
    public Object pesquisarPos(int pos) {
        Node elemento = primeiro;

        for(int i = 0; i < pos; i ++)
            elemento = elemento.proximo;

        return elemento.item;
    }

    public void pesquisarItem(Object item) {
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

    public void exibeLista() {
        Node elemento = primeiro;
        
        for(int i = 0; i < tamanho(); i++) {
            if(elemento != null)
                System.out.println(elemento.item);
            
            elemento = elemento.proximo;
        }
    }
}

class ListaDuplamenteEncadeada implements Lista {
    class Node {
        Node proximo, anterior;

        Object item;

        Node(Object item) {
            this.item = item;
        }
    }
    
    Node primeiro = null;
    Node atual = null;
    private int tam = 0;
    private Status s = Status.SUCESSO;

    public Status inserir(Object item) {
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

    public Status inserir(Object item, int pos) {
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

    public Object remover() {
        Node resultado = primeiro;
        
        if(vazia())
            return null;
        
        else if(!vazia()) {
            primeiro = primeiro.proximo;
        }

        tam--;

        return resultado.item;
    }

    public Object remover(int pos) {
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
    
    public Object pesquisarPos(int pos) {
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

    public void pesquisarItem(Object item) {
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

    public void exibeLista() {
        Node elemento = primeiro;
        
        for(int i = 0; i < tamanho(); i++) {
            if(elemento != null)
                System.out.println(elemento.item);
            
            elemento = elemento.proximo;
        }
    }
}

class Implementa {
    public static Lista sort(Lista lista) {
        int tam = lista.tamanho();
        Object[] a = new Object[lista.tamanho()];

        for(int i = 0; i < tam; i++)
            a[i] = lista.remover();

        for(int j = 0; j < tam-1; j++)
            for(int i = 0; i < tam - 1; i++) {
                if((int) a[i] > (int) a[i+1]) {
                    Object aux = a[i];
                    a[i] = a[i+1];
                    a[i+1] = aux;
                }
            }

        for(int i = 0; i < tam; i++)
            lista.inserir(a[i]);
        
        return lista;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        final int TAM = 3;
        Lista listaBase = new ListaEncadeada();
        Lista listaAux = new ListaArray();

        for(int i = 0; i < TAM; i++) {
            int a = input.nextInt();
            listaBase.inserir(a);
            listaAux.inserir(a);
        }

        Lista lista1 = Implementa.sort(listaBase);

        lista1.exibeLista();
        System.out.println();
        listaAux.exibeLista();
        
        input.close();
    }
}