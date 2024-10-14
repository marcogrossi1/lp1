package br.cefetmg.inf.lp1.llp1.lista11.p1042;

import java.util.Scanner;

interface Lista {
    boolean inserir(Object item);
    boolean inserir(Object item, int pos);
    Object remover();
    Object remover(int pos);
    Object pesquisarPos(int pos);
    int tamanho();
    boolean vazia();
    void exibeLista();
}

class ListaArray implements Lista {
    private int capacidade = 5;
    private int tam = 0;
    private Object[] lista = new Object[capacidade];

    public boolean inserir(Object item) {
        if (tam == capacidade) {
            capacidade *= 2;
            Object[] novoArray = new Object[capacidade];
            System.arraycopy(lista, 0, novoArray, 0, tam);
            lista = novoArray;
        }
        lista[tam++] = item;
        return true;
    }

    public boolean inserir(Object item, int pos) {
        if (pos < 0 || pos > tam) {
            return false; // posição inválida
        }
        if (tam == capacidade) {
            capacidade *= 2;
            Object[] novoArray = new Object[capacidade];
            System.arraycopy(lista, 0, novoArray, 0, tam);
            lista = novoArray;
        }
        System.arraycopy(lista, pos, lista, pos + 1, tam - pos);
        lista[pos] = item;
        tam++;
        return true;
    }

    public Object remover() {
        if (vazia()) return null;
        Object item = lista[0];
        System.arraycopy(lista, 1, lista, 0, --tam);
        return item;
    }

    public Object remover(int pos) {
        if (pos < 0 || pos >= tam) return null;
        Object item = lista[pos];
        System.arraycopy(lista, pos + 1, lista, pos, --tam - pos);
        return item;
    }

    public Object pesquisarPos(int pos) {
        if (pos < 0 || pos >= tam) return null;
        return lista[pos];
    }

    public int tamanho() {
        return tam;
    }

    public boolean vazia() {
        return tam == 0;
    }

    public void exibeLista() {
        for (int i = 0; i < tam; i++) {
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

    private Node primeiro = null;
    private int tam = 0;

    public boolean inserir(Object item) {
        if (primeiro == null) {
            primeiro = new Node(item);
        } else {
            Node atual = primeiro;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = new Node(item);
        }
        tam++;
        return true;
    }

    public boolean inserir(Object item, int pos) {
        if (pos < 0 || pos > tam) return false;

        Node novo = new Node(item);
        if (pos == 0) {
            novo.proximo = primeiro;
            primeiro = novo;
        } else {
            Node atual = primeiro;
            for (int i = 1; i < pos; i++) {
                atual = atual.proximo;
            }
            novo.proximo = atual.proximo;
            atual.proximo = novo;
        }
        tam++;
        return true;
    }

    public Object remover() {
        if (vazia()) return null;
        Object item = primeiro.item;
        primeiro = primeiro.proximo;
        tam--;
        return item;
    }

    public Object remover(int pos) {
        if (pos < 0 || pos >= tam) return null;

        Node atual = primeiro;
        if (pos == 0) {
            return remover();
        } else {
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.proximo;
            }
            Object item = atual.proximo.item;
            atual.proximo = atual.proximo.proximo;
            tam--;
            return item;
        }
    }

    public Object pesquisarPos(int pos) {
        if (pos < 0 || pos >= tam) return null;
        Node atual = primeiro;
        for (int i = 0; i < pos; i++) {
            atual = atual.proximo;
        }
        return atual.item;
    }

    public int tamanho() {
        return tam;
    }

    public boolean vazia() {
        return tam == 0;
    }

    public void exibeLista() {
        Node atual = primeiro;
        while (atual != null) {
            System.out.println(atual.item);
            atual = atual.proximo;
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

    private Node primeiro = null;
    private Node ultimo = null;
    private int tam = 0;

    public boolean inserir(Object item) {
        Node novo = new Node(item);
        if (primeiro == null) {
            primeiro = ultimo = novo;
        } else {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            ultimo = novo;
        }
        tam++;
        return true;
    }

    public boolean inserir(Object item, int pos) {
        if (pos < 0 || pos > tam) return false;

        Node novo = new Node(item);
        if (pos == 0) {
            novo.proximo = primeiro;
            if (primeiro != null) {
                primeiro.anterior = novo;
            }
            primeiro = novo;
            if (ultimo == null) {
                ultimo = novo;
            }
        } else if (pos == tam) {
            return inserir(item);
        } else {
            Node atual = primeiro;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.proximo;
            }
            novo.proximo = atual.proximo;
            novo.anterior = atual;
            atual.proximo.anterior = novo;
            atual.proximo = novo;
        }
        tam++;
        return true;
    }

    public Object remover() {
        if (vazia()) return null;
        Object item = primeiro.item;
        if (primeiro == ultimo) {
            primeiro = ultimo = null;
        } else {
            primeiro = primeiro.proximo;
            primeiro.anterior = null;
        }
        tam--;
        return item;
    }

    public Object remover(int pos) {
        if (pos < 0 || pos >= tam) return null;

        if (pos == 0) {
            return remover();
        } else {
            Node atual = primeiro;
            for (int i = 0; i < pos; i++) {
                atual = atual.proximo;
            }
            Object item = atual.item;
            if (atual == ultimo) {
                ultimo = atual.anterior;
                ultimo.proximo = null;
            } else {
                atual.anterior.proximo = atual.proximo;
                atual.proximo.anterior = atual.anterior;
            }
            tam--;
            return item;
        }
    }

    public Object pesquisarPos(int pos) {
        if (pos < 0 || pos >= tam) return null;
        Node atual = primeiro;
        for (int i = 0; i < pos; i++) {
            atual = atual.proximo;
        }
        return atual.item;
    }

    public int tamanho() {
        return tam;
    }

    public boolean vazia() {
        return tam == 0;
    }

    public void exibeLista() {
        Node atual = primeiro;
        while (atual != null) {
            System.out.println(atual.item);
            atual = atual.proximo;
        }
    }
}

class ordena {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Lista sort(Lista lista) {
        int tamanho = lista.tamanho();
        Object[] array = new Object[tamanho];
      
        for (int i = 0; i < tamanho; i++) {
            array[i] = lista.remover();
        }

        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (((Comparable) array[j]).compareTo(array[j + 1]) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        Lista novaLista;
        if (lista instanceof ListaArray) {
            novaLista = new ListaArray();
        } else if (lista instanceof ListaEncadeada) {
            novaLista = new ListaEncadeada();
        } else if (lista instanceof ListaDuplamenteEncadeada) {
            novaLista = new ListaDuplamenteEncadeada();
        } else {
            throw new IllegalArgumentException("Tipo de lista não suportado.");
        }

        for (Object item : array) {
            novaLista.inserir(item);
        }

        return novaLista;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        final int TAM = 3;
        Lista listaBase = new ListaEncadeada();
        Lista listaAux = new ListaArray();

        for (int i = 0; i < TAM; i++) {
            int a = input.nextInt();
            listaBase.inserir(a);
            listaAux.inserir(a);
        }

        Lista listaOrdenada = ordena.sort(listaBase);

        listaOrdenada.exibeLista();
        System.out.println();
        listaAux.exibeLista();
        
        input.close();
    }
}