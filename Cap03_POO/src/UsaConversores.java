/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.23
 */
import java.util.Scanner;

public class UsaConversores {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in); // prepara console
		System.out.print("Digite temperatura Celsius: ");
		double tempC = sc.nextDouble(); // lê temp Celsius
		sc.close();
		// cria conversor Celsius p/ Kelvin e exibe info
		CelsiusKelvin ck = new CelsiusKelvin();
		System.out.println("ck : " + ck); // uso implícito de toString()
		double tempK = ck.converter(tempC); // conversão C-->K
		System.out.println("tempK = " + tempK + "K"); // resultado
		// cria conversor Kelvin p/ Celsius e exibe info
		KelvinCelsius kc = new KelvinCelsius();
		System.out.println("kc : " + kc); // uso implícito de toString()
		tempC = kc.converter(tempK); // conversão K-->C
		System.out.println("tempC = " + tempC + "C"); // resultado
	}
}
