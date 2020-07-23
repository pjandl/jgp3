/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.6
 */
public class Plate implements Comparable<Plate> {
	private double altura, largura; // dimensões da placa
	private String tipo; // tipo/descrição da placa

	public Plate(double altura, double largura, String tipo) {
		if (altura <= 0 || largura <= 0)
			throw new RuntimeException("Dimensoes invalidas.");
		this.altura = altura;
		this.largura = largura;
		this.tipo = tipo;
	}

	// apenas métodos de acesso, assim campos imutáveis
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
	public int hashCode() { // função de hashing adaptada
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
	public String toString() { // representação textual do objeto
		return "[" + altura + "x" + largura + ":" + tipo + "]";
	}

	// se dimensões são iguais retorna 0, ou considera ordenação
	// crescente de altura*largura, alturas menores primeiro
	@Override
	public int compareTo(Plate obj) {
		// determina diferença das áreas
		double res = altura * largura - obj.getAltura() * obj.getLargura();
		// se diferenca==0, áreas iguais, retorna diferença das alturas,
		// senão retorna diferença das áreas
		return (int) (res == 0 ? altura - obj.getAltura() : res);
	}
}
