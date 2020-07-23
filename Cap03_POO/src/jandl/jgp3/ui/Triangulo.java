/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.28
 */
package jandl.jgp3.ui;

public class Triangulo extends Forma {
	public Triangulo(double l1, double l2, double l3) {
		super(3); // uso obrigatório do construtor da superclasse
		setMedida(0, l1); // ajuste da medida dos lados
		setMedida(1, l2);
		setMedida(2, l3);
	}

	// impl. método abstrato area() usando fórmula de Herão
	@Override
	public double area() {
		double sp = (getMedida(0) + getMedida(1) + getMedida(2)) / 2;
		double aux = sp * (sp - getMedida(0)) * (sp - getMedida(1))
				* (sp - getMedida(2));
		return Math.sqrt(aux);
	}
}
