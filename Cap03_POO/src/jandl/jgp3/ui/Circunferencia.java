/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.26
 */
package jandl.jgp3.ui;

import static java.lang.Math.*;

public class Circunferencia extends Forma {
	public Circunferencia(double raio) {
		super(1); // uso obrigatório do construtor da superclasse
		setRaio(raio); // ajuste da medida do raio
	}

	// implementação do método abstrato area()
	@Override
	public double area() {
		return PI * Math.pow(getMedida(0), 2);
	}

	// novo método para ajuste do raio
	public void setRaio(double raio) {
		setMedida(0, raio);
	}

	// Adição para exemplo 3.68
	// comparador estático
	public static int comparador(Circunferencia a, Circunferencia b) {
		return (int) (a.area() - b.area());
	}

	// comparador não-estático
	public int comparador2(Circunferencia b) {
		return (int) (this.area() - b.area());
	}
}
