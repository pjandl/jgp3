/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.1
 */
public class Hora { // declaracao da classe Hora
	private int hor, min, seg; // três atributos int de acesso restrito

	// métodos de acesso (leitura) dos campos restritos
	public int getHoras() {
		return hor;
	}

	public int getMinutos() {
		return min;
	}

	public int getSegundos() {
		return seg;
	}

	// métodos de alteração (escrita) dos campos restritos
	public void setHoras(int h) {
		if (h >= 0 && h < 24)
			hor = h;
	}

	public void setMinutos(int m) {
		if (m >= 0 && m < 60)
			min = m;
	}

	public void setSegundos(int s) {
		if (s >= 0 && s < 60)
			seg = s;
	}

	public void setHorario(int h, int m, int s) {
		setHoras(h);
		setMinutos(m);
		setSegundos(s);
	}

	// representação textual dos objetos Hora
	public String toString() {
		return String.format("%02d:%02d:%02d", getHoras(), getMinutos(),
				getSegundos());
	}
}
