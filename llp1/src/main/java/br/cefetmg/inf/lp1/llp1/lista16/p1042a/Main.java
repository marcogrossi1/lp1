package br.cefetmg.inf.lp1.llp1.lista16.p1042a;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class ordena {
    /**
     * @param lista
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Queue<Integer> sort(Queue<Integer> lista) {
        int tamanho = lista.size();
        Object[] array = new Object[tamanho];
      
        for (int i = 0; i < tamanho; i++) {
            array[i] = lista.poll();
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

        Queue<Integer> novaLista = new LinkedList<Integer>();

        for (Object item : array) {
            novaLista.add((Integer) item);
        }

        return novaLista;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        final int TAM = 3;
        Queue<Integer> listaBase = new LinkedList<Integer>();
        Queue<Integer> listaAux = new LinkedList<Integer>();

        try {
            for (int i = 0; i < TAM; i++) {
                int a = input.nextInt();
                listaBase.add(a);
                listaAux.add(a);
            }
        }

        catch(ClassCastException e) {
            System.out.println("Erro! Este elemento não pode ser adicionado.");
        }

        catch(IllegalArgumentException e) {
            System.out.println("Erro! Argumento ilegal.");
        }

        Queue<Integer> listaOrdenada = ordena.sort(listaBase);
        
        for(int num : listaOrdenada)
            System.out.println(num);
        
        System.out.println();
        
        for(int num : listaAux)
            System.out.println(num);

        input.close();
    }
}