/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.64
 */
import java.util.Calendar;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

public class PreDefConsSupp {
	public static void main(String[] args) {
		// Define supplier (produtor) de n�mero do m�s corrente
		IntSupplier numMes = () -> Calendar.getInstance().get(Calendar.MONTH) + 1;
		// Define consumer (consumidor) de inteiros
		IntConsumer ref = (v) -> System.out.printf("consumed(%d)", v);
		// Uso do supplier e consumer
		int mes = numMes.getAsInt();
		System.out.println("Supplier::Mes=" + mes);
		System.out.print("Consumer::");
		ref.accept(mes);
		System.out.println();
	}
}
