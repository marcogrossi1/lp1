package br.cefetmg.inf.lp1.llp1.lista11.p1068;

import java.util.Scanner;

interface Lista {
    void inserir(Object item);
    void inserir(Object item, int pos);

    Object remover();
    Object remover(int pos);

    Object pesquisarPos(int pos);

    int tamanho();
    boolean vazia();
}

class ListaArray implements Lista {
    private int capacidade = 5;
    private int tam = 0;
    private Object[] lista = new Object[capacidade];

    public void inserir(Object item) {
        if(tam == capacidade) {
            capacidade *= 2;
            Object[] novaLista = new Object[capacidade];
            System.arraycopy(lista, 0, novaLista, 0, tam);
            lista = novaLista;
        }
        lista[tam++] = item;
    }

    public void inserir(Object item, int pos) {
        if(tam == capacidade) {
            capacidade *= 2;
            Object[] novaLista = new Object[capacidade];
            System.arraycopy(lista, 0, novaLista, 0, tam);
            lista = novaLista;
        }

        if (pos < tam) {
            System.arraycopy(lista, pos, lista, pos + 1, tam - pos);
        }
        lista[pos] = item;
        tam++;
    }

    public Object remover() {
        if(vazia()) return null;

        Object resultado = lista[0];
        System.arraycopy(lista, 1, lista, 0, tam - 1);
        tam--;

        if (tam <= capacidade / 4) {
            capacidade /= 2;
            Object[] novaLista = new Object[capacidade];
            System.arraycopy(lista, 0, novaLista, 0, tam);
            lista = novaLista;
        }
        return resultado;
    }

    public Object remover(int pos) {
        if(vazia() || pos >= tam) return null;

        Object resultado = lista[pos];
        System.arraycopy(lista, pos + 1, lista, pos, tam - pos - 1);
        tam--;

        if (tam <= capacidade / 4) {
            capacidade /= 2;
            Object[] novaLista = new Object[capacidade];
            System.arraycopy(lista, 0, novaLista, 0, tam);
            lista = novaLista;
        }
        return resultado;
    }

    public Object pesquisarPos(int pos) {
        if(pos < tam) return lista[pos];
        return null;
    }

    public int tamanho() {
        return tam;
    }

    public boolean vazia() {
        return tam == 0;
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

    public void inserir(Object item) {
        if(vazia()) {
            primeiro = new Node(item);
            atual = primeiro;
        } else {
            Node novo = new Node(item);
            atual.proximo = novo;
            atual = novo;
        }
        tam++;
    }

    public void inserir(Object item, int pos) {
        if (pos == 0) {
            Node novo = new Node(item);
            novo.proximo = primeiro;
            primeiro = novo;
        } else {
            Node elemento = primeiro;
            for(int i = 0; i < pos - 1; i++) {
                if (elemento == null) return;
                elemento = elemento.proximo;
            }
            Node novo = new Node(item);
            novo.proximo = elemento.proximo;
            elemento.proximo = novo;
        }
        tam++;
    }

    public Object remover() {
        if(vazia()) return null;

        Object resultado = primeiro.item;
        primeiro = primeiro.proximo;
        tam--;
        return resultado;
    }

    public Object remover(int pos) {
        if(vazia() || pos >= tam) return null;

        if (pos == 0) {
            return remover();
        }

        Node elemento = primeiro;
        for(int i = 0; i < pos - 1; i++) {
            elemento = elemento.proximo;
        }
        Node removido = elemento.proximo;
        elemento.proximo = removido.proximo;
        tam--;

        return removido.item;
    }

    public Object pesquisarPos(int pos) {
        if (pos >= tam) return null;

        Node elemento = primeiro;
        for (int i = 0; i < pos; i++) {
            elemento = elemento.proximo;
        }
        return elemento.item;
    }

    public int tamanho() {
        return tam;
    }

    public boolean vazia() {
        return tam == 0;
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

    public void inserir(Object item) {
        Node novo = new Node(item);
        if (vazia()) {
            primeiro = novo;
            atual = primeiro;
        } else {
            atual.proximo = novo;
            novo.anterior = atual;
            atual = novo;
        }
        tam++;
    }

    public void inserir(Object item, int pos) {
        if (pos == 0) {
            Node novo = new Node(item);
            novo.proximo = primeiro;
            if (primeiro != null) {
                primeiro.anterior = novo;
            }
            primeiro = novo;
        } else if (pos >= tam) {
            inserir(item);
        } else {
            Node elemento = primeiro;
            for (int i = 0; i < pos - 1; i++) {
                elemento = elemento.proximo;
            }
            Node novo = new Node(item);
            novo.proximo = elemento.proximo;
            novo.anterior = elemento;
            if (elemento.proximo != null) {
                elemento.proximo.anterior = novo;
            }
            elemento.proximo = novo;
        }
        tam++;
    }

    public Object remover() {
        if(vazia()) return null;

        Object resultado = primeiro.item;
        primeiro = primeiro.proximo;
        if (primeiro != null) {
            primeiro.anterior = null;
        } else {
            atual = null;
        }
        tam--;
        return resultado;
    }

    public Object remover(int pos) {
        if(vazia() || pos >= tam) return null;

        if (pos == 0) {
            return remover();
        }

        Node elemento = primeiro;
        for(int i = 0; i < pos - 1; i++) {
            elemento = elemento.proximo;
        }
        Node removido = elemento.proximo;
        elemento.proximo = removido.proximo;
        if (removido.proximo != null) {
            removido.proximo.anterior = elemento;
        } else {
            atual = elemento;
        }
        tam--;

        return removido.item;
    }

    public Object pesquisarPos(int pos) {
        if (pos >= tam) return null;

        Node elemento;
        if (pos < tam / 2) {
            elemento = primeiro;
            for (int i = 0; i < pos; i++) {
                elemento = elemento.proximo;
            }
        } else {
            elemento = atual;
            for (int i = tam - 1; i > pos; i--) {
                elemento = elemento.anterior;
            }
        }
        return elemento.item;
    }

    public int tamanho() {
        return tam;
    }

    public boolean vazia() {
        return tam == 0;
    }
}

class Parenteses {    
    public static boolean avaliaLista(Lista lista, String a) {
        for (char x : a.toCharArray()) {
            if (x == '(') {
                lista.inserir(String.valueOf(x));
            } else if (x == ')') {
                if (lista.remover() == null) {
                    return false;
                }
            }
        }
        return lista.vazia();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(input.hasNext()) {
            Lista lista = new ListaDuplamenteEncadeada();
            String a = input.nextLine();
            
            if(Parenteses.avaliaLista(lista, a))    
                System.out.println("correct");
            else
                System.out.println("incorrect");
        }
                
        input.close();
    }
}