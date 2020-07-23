/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.8
 */
import java.util.Comparator;

public class PlateComparatorFactory {
	public static Comparator<Plate> ALTURA = new Comparator<Plate>() {
		// Comparator baseado na diferença das alturas
		@Override
		public int compare(Plate p1, Plate p2) {
			double dif = p1.getAltura() - p2.getAltura();
			return dif == 0 ? (int) (p1.getLargura() - p2.getLargura())
					: (int) dif;
		}
	};
	public static Comparator<Plate> TIPO = new Comparator<Plate>() {
		// Comparator baseado no tipo (descrição de Plate)
		@Override
		public int compare(Plate p1, Plate p2) {
			// utiliza comparação natural de String
			return p1.getTipo().compareTo(p2.getTipo());
		}
	};
}
