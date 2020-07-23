/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.67
 */
import jandl.jgp3.ui.Circunferencia;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import java.util.function.IntToDoubleFunction;

public class RefMetInstancia {
	public static void main(String[] args) throws Exception {
		// Instanciação de circunferência
		Circunferencia circ = new Circunferencia(2.0);
		// Método com assinatura double (void)
		IntToDoubleFunction funMedida = circ::getMedida;
		// Método com assinatura double (void)
		DoubleSupplier supArea = circ::area;
		// Método com assinatura void(double, double)
		DoubleConsumer consRaio = circ::setRaio;
		// Manipulação da instância via referências para métodos
		System.out.println("Circunferencia de raio="
				+ funMedida.applyAsDouble(0));
		System.out.println("Area=" + supArea.getAsDouble());
		System.out.println("Modificação do raio...");
		consRaio.accept(4.0);
		System.out.println("Circunferencia de raio="
				+ funMedida.applyAsDouble(0));
		System.out.println("Area=" + supArea.getAsDouble());
	}
}
