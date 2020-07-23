/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.6
 */
public class Plate implements Comparable<Plate> {
	private double altura, largura; // dimens�es da placa
	private String tipo; // tipo/descri��o da placa

	public Plate(double altura, double largura, String tipo) {
		if (altura <= 0 || largura <= 0)
			throw new RuntimeException("Dimensoes invalidas.");
		this.altura = altura;
		this.largura = largura;
		this.tipo = tipo;
	}

	// apenas m�todos de acesso, assim campos imut�veis
	public double getAltura() {
		return altura;
	}

	public double getLargura() {
		return largura;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public int hashCode() { // fun��o de hashing adaptada
		return (int) (altura * largura - altura);
	}

	// returna retorna mesmo resultado de compareTo
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Plate))
			return false;
		return compareTo((Plate) obj) == 0;
	}

	@Override
	public String toString() { // representa��o textual do objeto
		return "[" + altura + "x" + largura + ":" + tipo + "]";
	}

	// se dimens�es s�o iguais retorna 0, ou considera ordena��o
	// crescente de altura*largura, alturas menores primeiro
	@Override
	public int compareTo(Plate obj) {
		// determina diferen�a das �reas
		double res = altura * largura - obj.getAltura() * obj.getLargura();
		// se diferenca==0, �reas iguais, retorna diferen�a das alturas,
		// sen�o retorna diferen�a das �reas
		return (int) (res == 0 ? altura - obj.getAltura() : res);
	}
}
