/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.11
 */
public class Retangulo3 {
	private double largura, altura; // dimensões são campos privados

	// construtor default aciona outro construtor com this
	public Retangulo3() throws Exception {
		this(2, 1);
	}

	// construtor parametrizado
	public Retangulo3(double larg, double alt) throws Exception {
		this.setTamanho(larg, alt);
	}

	// métodos
	public void setTamanho(double largura, double altura) throws Exception {
		// verifica valor das variáveis locais
		if (largura >= 0 && altura >= 0) { // uso explícito de this
			// campos recebem valor das variáveis locais
			this.largura = largura;
			this.altura = altura;
		} else {
			// se dimensões inadequadas lança exceção monitorada
			throw new Exception("Dimensoes invalidas.");
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
		return "Retangulo3[largura=" + largura + ",altura=" + altura + "]";
	}
}
