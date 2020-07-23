/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.55
 */
public class TipoNum<T> { // classe gen�rica
	private int id;
	private T valor; // campo gen�rico

	public TipoNum(int id, T valor) { // par�metro gen�rico
		setId(id);
		setValor(valor);
	}

	public int getId() {
		return id;
	}

	public T getValor() {
		return valor;
	} // valor de retorno gen�rico

	public void setId(int id) {
		if (id < 0)
			throw new RuntimeException("id<0");
		this.id = id;
	}

	public void setValor(T valor) { // para�etro gen�rico
		if (valor == null)
			throw new RuntimeException("valor==null");
		this.valor = valor;
	}

	public void troca(TipoNum<T> p) { // par�metro gen�rico compat�vel
		T valorAux = p.valor; // vari�vel local gen�rica
		p.valor = valor;
		valor = valorAux;
	}
}
