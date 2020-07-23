/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.10
 */
import java.util.Arrays;

public class OrdenaPlate3 {

	public static void main(String[] args) {
		Plate[] plate = { // arrays com conteúdo de OrdenaPlate
				new Plate(10.0, 22.5, "placa 5"),
				new Plate(10.0, 22.5, "placa 4"),
				new Plate(15.0, 10.0, "placa 3"),
				new Plate(10.0, 15.0, "placa 2"),
				new Plate(7.5, 30.0, "placa 1") };
		 // exibe array como criado
		System.out.println("Original:\n" + Arrays.toString(plate));
		// ordenação natural com classe Arrays
		Arrays.sort(plate);
		 // exibe array ordenado
		System.out.println("O.Natural:\n" + Arrays.toString(plate));
		// ordenação com classe Arrays e comparator específico
		Arrays.sort(plate, PlateComparatorFactory.ALTURA);
		 // exibe array ordenado
		System.out.println("O.Altura:\n" + Arrays.toString(plate));
	}
}
