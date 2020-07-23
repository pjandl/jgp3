/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.28
 */
import java.util.*;

public class HashtableDemo {
	public static void main(String a[]) {
		// cria hashtable
		Hashtable<Integer, String> cepTable = new Hashtable<>();
		// adiciona entradas (cep, logradouro)
		cepTable.put(13052070, "AC Viracopos, Campinas, SP");
		cepTable.put(13098970, "AC Alphaville, Campinas, SP");
		cepTable.put(13084970, "AC Barao Geraldo, Campinas, SP");
		cepTable.put(13012970, "AC Campinas, Campinas, SP");
		cepTable.put(13060976, "AC Campinas Shopping, Campinas, SP");
		cepTable.put(13091970, "AC Galeria Shopping, Campinas, SP");
		cepTable.put(13092971, "AC Iguatemi, Campinas, SP");
		cepTable.put(13050970, "AC Jardim do Lago, Campinas, SP");
		cepTable.put(13035971, "AC Sao Jorge, Campinas, SP");
		cepTable.put(13060970, "AC Londres, Campinas, SP");
		Scanner sc = new Scanner(System.in); // prepara console
		// solicita CEP
		System.out.print("CEP (8 digitos incluindo tra�o): ");
		String entrada = sc.nextLine(); // l� cep
		sc.close();
		int pt = entrada.indexOf("-"); // localiza tra�o
		if (pt != -1) { // pre-avalia cep
			String campo1 = entrada.substring(0, pt); // separa campos cep
			String campo2 = entrada.substring(pt + 1);
			// cria c�digo
			Integer cep = new Integer(campo1 + campo2);
			// exibe informa��es
			System.out.print("CEP [entrada=" + entrada + "]: ");
			if (cepTable.containsKey(cep)) { // localiza entrada na hastable
				System.out.println(cepTable.get(cep));
			} else {
				System.out.println("nao encontrada!");
			}
		}
	}
}
