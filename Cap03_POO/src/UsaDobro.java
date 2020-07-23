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
		// uso de método estático da classe Dobro sem instância
		System.out.println("No Instancias de Dobro = " + Dobro.getInstancias());
		// declara e inicializa variável inteira com valor arbitrário
		int x = 7;
		System.out.println("Instanciando objeto Dobro");
		Dobro d = new Dobro(); // instanciação
		// uso de métodos estáticos e não estáticos da classe Dobro
		System.out.println("No Instancias de Dobro = " + d.getInstancias());
		System.out.println("O dobro de " + x + " = " + d.dobro(x));
		System.out.println("Ultimo valor usado: " + d.ultimoValor);
	}
}
