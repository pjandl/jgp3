/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.6
 */
public class Retangulo {
	private double largura, altura; // dimens�es sao campos privados

	// construtor default aciona outro construtor com this
	public Retangulo() {
		this(2, 1);
	}

	// construtor parametrizado
	public Retangulo(double largura, double altura) {
		this.setTamanho(largura, altura);
	}

	// m�todos
	public void setTamanho(double largura, double altura) {
		// verifica valor das vari�veis locais
		if (largura >= 0 && altura >= 0) { // uso expl�cito de this
			// campos recebem valor das vari�veis locais
			this.largura = largura;
			this.altura = altura;
		}
	}

	public double getLargura() { // uso impl�cito de this
		return largura; // retorna valor de campo this.largura
	}

	public double getAltura() { // uso impl�cito de this
		return altura; // retorna valor do campo this.altura
	}
}
