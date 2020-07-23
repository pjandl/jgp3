/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.14
 */
import java.util.*;

public class NovaColecao<E> extends AbstractCollection<E> {
	private E dados[] = null; // array para conte�do

	public NovaColecao() {
	} // construtor default

	@SuppressWarnings("unchecked")
	public NovaColecao(Collection<E> col) { // constr. parametrizado
		dados = (E[]) col.toArray();
	}

	@Override
	public int size() { // retorna tamanho da cole��o
		return dados == null ? 0 : dados.length;
	}

	@Override
	public Iterator<E> iterator() { // retorna Iterator para cole��o
		return new Navigator<E>();
	}

	// classe interna privada que define Iterator pr�prio
	private class Navigator<T> implements Iterator<T> {
		private int pos = 0; // controle de posi��o

		@Override
		public boolean hasNext() { // verifica se existe pr�ximo
			return pos < dados.length;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() { // retorna pr�ximo elemento
			pos++;
			return (T) dados[pos - 1];
		}

		@Override
		public void remove() { // oper. opcional n�o implementada
			throw new UnsupportedOperationException();
		}
	}
}
