/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.2
 */
import java.util.Scanner;

public class UsaHora {
	public static void main(String args[]) {
		Hora hora = new Hora(); // declara e instancia objeto tipo Hora
		hora.setHorario(15, 30, 10); // ajusta objeto com valores válidos
		System.out.println("Hora: " + hora.toString()); // exibe hora
		Scanner sc = new Scanner(System.in); // prepara console
		// lê valores de hora, minuto e segundo em variáveis auxiliares
		System.out.print("Horas ? ");
		int h = sc.nextInt();
		System.out.print("Minutos ? ");
		int m = sc.nextInt();
		System.out.print("Segundos ? ");
		int s = sc.nextInt();
		sc.close();
		hora.setHorario(h, m, s); // ajusta objeto com valores dados
		System.out.println("Hora: " + hora.toString()); // exibe hora
		if (hora.getHoras() >= 18 || hora.getHoras() < 6)
			System.out.println("E noite!");
		else
			System.out.println("E dia!");
	}
}
