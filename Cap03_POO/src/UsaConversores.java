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
		double tempC = sc.nextDouble(); // l� temp Celsius
		sc.close();
		// cria conversor Celsius p/ Kelvin e exibe info
		CelsiusKelvin ck = new CelsiusKelvin();
		System.out.println("ck : " + ck); // uso impl�cito de toString()
		double tempK = ck.converter(tempC); // convers�o C-->K
		System.out.println("tempK = " + tempK + "K"); // resultado
		// cria conversor Kelvin p/ Celsius e exibe info
		KelvinCelsius kc = new KelvinCelsius();
		System.out.println("kc : " + kc); // uso impl�cito de toString()
		tempC = kc.converter(tempK); // convers�o K-->C
		System.out.println("tempC = " + tempC + "C"); // resultado
	}
}
