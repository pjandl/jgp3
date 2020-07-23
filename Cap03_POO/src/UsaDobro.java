/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.5
 */
public class UsaDobro {
	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		// uso de m�todo est�tico da classe Dobro sem inst�ncia
		System.out.println("No Instancias de Dobro = " + Dobro.getInstancias());
		// declara e inicializa vari�vel inteira com valor arbitr�rio
		int x = 7;
		System.out.println("Instanciando objeto Dobro");
		Dobro d = new Dobro(); // instancia��o
		// uso de m�todos est�ticos e n�o est�ticos da classe Dobro
		System.out.println("No Instancias de Dobro = " + d.getInstancias());
		System.out.println("O dobro de " + x + " = " + d.dobro(x));
		System.out.println("Ultimo valor usado: " + d.ultimoValor);
	}
}
