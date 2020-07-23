/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.19
 */
public class Conversor {
	protected double kProp, kLin;

	public Conversor(double kProp, double kLin) {
		this.kProp = kProp;
		this.kLin = kLin;
	}

	public double getKProp() {
		return kProp;
	}

	public double getKLin() {
		return kLin;
	}

	public double converter(double valor) {
		return valor * kProp + kLin;
	}

	@Override
	public String toString() {
		return "Conversor[kProp=" + kProp + ",kLin= " + kLin + "]";
	}
}
