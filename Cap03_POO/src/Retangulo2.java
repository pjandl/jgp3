/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.10
 */
public class Retangulo2 {
	private double largura, altura; // dimensões sao campos privados

	// construtor default aciona outro construtor com this
	public Retangulo2() {
		this(2, 1);
	}

	// construtor parametrizado
	public Retangulo2(double largura, double altura) {
		this.setTamanho(largura, altura);
	}

	// métodos
	public void setTamanho(double largura, double altura) {
		// verifica valor das variáveis locais
		if (largura >= 0 && altura >= 0) { // uso explícito de this
			// campos recebem valor das variáveis locais
			this.largura = largura;
			this.altura = altura;
		} else {
			// se dimensões inadequadas lança exceção não monitorada
			throw new RuntimeException("Dimensoes invalidas.");
		}
	}

	// uso implícito de this: retorna valor de this.largura
	public double getLargura() {
		return largura;
	}

	// uso implícito de this: retorna valor de this.altura
	public double getAltura() {
		return altura;
	}

	@Override
	public String toString() {
		return "Retangulo2[largura=" + largura + ",altura=" + altura + "]";
	}
}
