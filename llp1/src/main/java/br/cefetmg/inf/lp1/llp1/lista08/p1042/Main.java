package br.cefetmg.inf.lp1.llp1.lista08;
import java.util.*;

class FilaCircular {    
    private int primeiro = 0, ultimo = 0, tam = 0, capacidade = 5, OFF_SET = 5;
    private Integer fila[] = new Integer[capacidade];
    
    FilaCircular () {
        capacidade = 5;    
    }

    public void enfileirar(Integer item) {        
        if(tam == capacidade) {
            capacidade += OFF_SET;
            Integer dest[] = new Integer[capacidade];
            System.arraycopy(fila, 0, dest, 0, tamanho());
            fila = dest;
        }

        if(!vazia())
            ultimo = (ultimo + 1) % capacidade;
        
        fila[ultimo] = item;
        tam++;
        
    }

    // O retorno é do tipo void, já que, deste modo, é possível utilizar a função exibeFila() sem maiores complicações;
    public Integer desenfileirar() {
        Integer resultado = fila[primeiro];
        
        if(vazia())
            System.out.println("A lista está vazia!");

        else if(!vazia()) {
            fila[primeiro] = null;
            primeiro = (primeiro + 1) % capacidade;

            if((capacidade - tamanho()) >= (2 * OFF_SET))
                capacidade -= OFF_SET;
        
            Integer[] dest = new Integer[capacidade];

            System.arraycopy(fila, 0, dest, 0, tamanho()+1);
            tam--;
        }

        return resultado;
    }

    public boolean vazia() {
        if(tam == 0)
            return true;
            
        return false;
    }

    public int tamanho() {
        return tam;
    }

    public void exibeFila() {
        for(int i = primeiro; i < primeiro + tam; ++i) {
            System.out.println(fila[i]);
        }
    }
}

class FilaArray {
    private int capacidade = 5, OFF_SET = 5, tam = 0, ultimo = 0;
    private Integer[] fila = new Integer[capacidade];

    public void enfileirar(Integer item) {
        if(tam == capacidade) {
            capacidade += OFF_SET;
            Integer aux[] = new Integer[capacidade];
            System.arraycopy(fila, 0, aux, 0, tamanho());
            fila = aux;
        }

        if(!vazia())    
            fila[ultimo] = item;

        tam++;
        ultimo++;
    } 

    public void desenfileirar() {
        if(vazia())
            System.out.println("A fila está vazia!");
        
        else if(!vazia()) {
            if((capacidade - tam) >= (2 * OFF_SET))
                capacidade -= OFF_SET;
            
            Integer aux[] = new Integer[capacidade];

            System.arraycopy(fila, 1, aux, 0, tam);
            tam--;
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

    public void exibeFila() {
        for(int i = 0; i < tam; ++i) {
            System.out.println(fila[i]);
        }
    }
}

class FilaEncadeada {
    class Node {
        Node proximo;

        int item;

        Node(int item) {
            this.item = item;
        }
    }
    
    Node primeiro = null;
    Node atual = null;
    private int tam = 0;

    public void enfileirar(Integer item) {
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
    }

    public Integer desenfileirar() {
        Node resultado = primeiro;
        
        if(vazia())
            System.out.println("A lista está vazia!");
        
        else if(!vazia()) {
            primeiro = primeiro.proximo;
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

class BubbleSort {
    public static FilaEncadeada sort(FilaEncadeada f) {
        int tam = f.tamanho();
        Integer[] a = new Integer[f.tamanho()];
        
        for(int i = 0; i < tam; i++)
            a[i] = f.desenfileirar();

        for(int j = 0; j < tam-1; j++)
            for(int i = 0; i < tam - 1; i++) {
                if(a[i] > a[i+1]) {
                    int aux = a[i];
                    a[i] = a[i+1];
                    a[i+1] = aux;
                }
            }

        for(int i = 0; i < tam; i++)
            f.enfileirar(a[i]);
        return f;
    }
}

public class Main {
    public static void main (String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        FilaEncadeada filabase = new FilaEncadeada();
        FilaEncadeada filaAux = new FilaEncadeada();

        int TAM = 3;

        for(int i = 0; i < TAM; i++) {
            int a = scanner.nextInt();
            filabase.enfileirar(a);
            filaAux.enfileirar(a);
        }

        FilaEncadeada fila1 = BubbleSort.sort(filabase);

        fila1.exibeFila(fila1.primeiro);
        System.out.println();
        filaAux.exibeFila(filaAux.primeiro);
    }
}