/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.55
 */
public class TipoNum<T> { // classe genérica
	private int id;
	private T valor; // campo genérico

	public TipoNum(int id, T valor) { // parâmetro genérico
		setId(id);
		setValor(valor);
	}

	public int getId() {
		return id;
	}

	public T getValor() {
		return valor;
	} // valor de retorno genérico

	public void setId(int id) {
		if (id < 0)
			throw new RuntimeException("id<0");
		this.id = id;
	}

	public void setValor(T valor) { // paraâetro genérico
		if (valor == null)
			throw new RuntimeException("valor==null");
		this.valor = valor;
	}

	public void troca(TipoNum<T> p) { // parâmetro genérico compatível
		T valorAux = p.valor; // variável local genérica
		p.valor = valor;
		valor = valorAux;
	}
}
