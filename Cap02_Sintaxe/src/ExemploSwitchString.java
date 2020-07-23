/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.15
 */
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExemploSwitchString {
	public static void main(String args[]) {
		if (args.length > 0) { // testa presen�a de argumentos
			switch (args[0].toLowerCase()) { // avalia texto do 1o argumento em
												// min�sculas
			case "data":
				System.out.println(DateFormat.getDateInstance().format(
						new Date()));
				break;
			case "hora":
				System.out.println(DateFormat.getTimeInstance().format(
						new Date()));
				break;
			case "nova-data":
				System.out.println(LocalDate.now().format(
						DateTimeFormatter.ofPattern("dd/MMMM/yyyy")));
				break;
			case "nova-hora":
				System.out.println(LocalTime.now().format(
						DateTimeFormatter.ofPattern("hh:mm:ss")));
				break;
			default:
				System.out.println("Comando nao reconhecido.");
			}
		} else {
			System.out.println("Nao foi fornecido argumento.");
		}
	}
}
