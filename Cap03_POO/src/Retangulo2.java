/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.10
 */
public class Retangulo2 {
	private double largura, altura; // dimens�es sao campos privados

	// construtor default aciona outro construtor com this
	public Retangulo2() {
		this(2, 1);
	}

	// construtor parametrizado
	public Retangulo2(double largura, double altura) {
		this.setTamanho(largura, altura);
	}

	// m�todos
	public void setTamanho(double largura, double altura) {
		// verifica valor das vari�veis locais
		if (largura >= 0 && altura >= 0) { // uso expl�cito de this
			// campos recebem valor das vari�veis locais
			this.largura = largura;
			this.altura = altura;
		} else {
			// se dimens�es inadequadas lan�a exce��o n�o monitorada
			throw new RuntimeException("Dimensoes invalidas.");
		}
	}

	// uso impl�cito de this: retorna valor de this.largura
	public double getLargura() {
		return largura;
	}

	// uso impl�cito de this: retorna valor de this.altura
	public double getAltura() {
		return altura;
	}

	@Override
	public String toString() {
		return "Retangulo2[largura=" + largura + ",altura=" + altura + "]";
	}
}
