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
		// Instancia��o de circunfer�ncia
		Circunferencia circ = new Circunferencia(2.0);
		// M�todo com assinatura double (void)
		IntToDoubleFunction funMedida = circ::getMedida;
		// M�todo com assinatura double (void)
		DoubleSupplier supArea = circ::area;
		// M�todo com assinatura void(double, double)
		DoubleConsumer consRaio = circ::setRaio;
		// Manipula��o da inst�ncia via refer�ncias para m�todos
		System.out.println("Circunferencia de raio="
				+ funMedida.applyAsDouble(0));
		System.out.println("Area=" + supArea.getAsDouble());
		System.out.println("Modifica��o do raio...");
		consRaio.accept(4.0);
		System.out.println("Circunferencia de raio="
				+ funMedida.applyAsDouble(0));
		System.out.println("Area=" + supArea.getAsDouble());
	}
}
