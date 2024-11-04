package br.cefetmg.inf.lp1.llp1.lista14.deque;

class DequeVaziaException extends Exception {}

interface Deque<T> {
	void inserirInicio(T item);
	void inserirFim(T item);

	T removerInicio() throws DequeVaziaException;
	T removerFim() throws DequeVaziaException;

	int tamanho();
	boolean vazia();

	void exibeDeque() throws NullPointerException;
}


class DequeDuplamenteEncadeada<T> implements Deque<T> {
	class Node {
		Node proximo, anterior;

		T item;

		Node(T item) {
			this.item = item;
		}
	}

	Node primeiro = null;
	Node ultimo = null;
	private int tam = 0;

	public void inserirInicio(T item) {
		if(vazia()) {
			primeiro = new Node(item);
			ultimo = primeiro;
		}

		else if(!vazia()) {
			Node novo = new Node(item);
			
			primeiro.anterior = novo;
			novo.proximo = primeiro;

			primeiro = novo;			
		}

		tam++;
	}

	public void inserirFim(T item) {
        if(vazia()) {
			primeiro = new Node(item);
			ultimo = primeiro;
		}

		else if(!vazia()) {
			Node novo = new Node(item);

			ultimo.proximo = novo;
			novo.anterior = ultimo;
            ultimo = novo;
		}

		tam++;
	}

	public T removerInicio() throws DequeVaziaException {
		Node resultado = primeiro;

		if(vazia())
			throw new DequeVaziaException();

		else {
			primeiro = primeiro.proximo;

			tam--;

			return resultado.item;
		}
	}

	public T removerFim() throws DequeVaziaException {
		Node resultado;

		if(vazia())
			throw new DequeVaziaException();

		else {
			resultado = ultimo;
        	ultimo = ultimo.anterior;

			tam--;

			return resultado.item;
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

	public void exibeDeque() throws NullPointerException{
		Node elemento = primeiro;

		if(elemento == null) {
			throw new NullPointerException();
		}

		for(int i = 0; i < tamanho(); i++) {
			if(elemento != null)
				System.out.println(elemento.item);

			elemento = elemento.proximo;
		}
	}
}

public class Main {
	public static void main(String[] args) {
		DequeDuplamenteEncadeada<Integer> dq = new DequeDuplamenteEncadeada<>();

    	try {
    	    dq.inserirInicio(5);
    	    dq.inserirInicio(3);
    	    dq.inserirInicio(1);
    	    dq.inserirFim(10);
    	    dq.inserirFim(3);
    	    dq.inserirFim(1);

			System.out.println("Deque atual: ");
			dq.exibeDeque();	

			System.out.println("Elementos retirados: ");
		   	System.out.println(dq.removerFim());
		   	System.out.println(dq.removerInicio());
		   	System.out.println(dq.removerFim());
		   	System.out.println(dq.removerInicio());

			System.out.println("Deque final: ");
			dq.exibeDeque();	
    	}

		catch(DequeVaziaException a) {
			System.out.println("Atenção a deque está vazia!");
		}
		
		catch(NullPointerException a) {
			System.out.println("Atenção, há um erro na função exibeDeque()!");
		}
	}
}
