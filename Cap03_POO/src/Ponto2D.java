/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.3
 */
public class Ponto2D {
	// campos p�blicos: n�o existem restri��es p/ valores de x e y
	public double x, y;

	// constr. default: ponto definido na origem (0, 0)
	public Ponto2D() {
		x = 0;
		y = 0;
	}

	// constr. parametrizado: ponto definido na instancia��o
	public Ponto2D(double px, double py) {
		x = px;
		y = py;
	}

	// determina dist�ncia entre inst�ncia e coordenada dada
	public double distancia(double px, double py) {
		return Math.sqrt(Math.pow(x - px, 2) + Math.pow(y - py, 2));
	}

	// determina dist�ncia entre inst�ncia e ponto dado
	public double distancia(Ponto2D p) {
		return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
	}

	// fornece representa��o textual dos objetos
	public String toString() {
		return "Ponto2D[x=" + x + ",y=" + y + "]";
	}
}
