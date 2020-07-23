/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.14
 */
import java.util.*;

public class NovaColecao<E> extends AbstractCollection<E> {
	private E dados[] = null; // array para conteúdo

	public NovaColecao() {
	} // construtor default

	@SuppressWarnings("unchecked")
	public NovaColecao(Collection<E> col) { // constr. parametrizado
		dados = (E[]) col.toArray();
	}

	@Override
	public int size() { // retorna tamanho da coleção
		return dados == null ? 0 : dados.length;
	}

	@Override
	public Iterator<E> iterator() { // retorna Iterator para coleção
		return new Navigator<E>();
	}

	// classe interna privada que define Iterator próprio
	private class Navigator<T> implements Iterator<T> {
		private int pos = 0; // controle de posição

		@Override
		public boolean hasNext() { // verifica se existe próximo
			return pos < dados.length;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() { // retorna próximo elemento
			pos++;
			return (T) dados[pos - 1];
		}

		@Override
		public void remove() { // oper. opcional não implementada
			throw new UnsupportedOperationException();
		}
	}
}
