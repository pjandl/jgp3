/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 7.11
 */
public class Produtor extends Thread {
	private int quantidade;
	private Deposito deposito;

	public Produtor(int quant, Deposito dep) {
		quantidade = quant;
		deposito = dep;
	}

	@Override
	public void run() {
		System.out.println("Produtor [INICIO]");
		int total = 0;
		for (int i = 0; i < quantidade; i++) {
			int valor = (int) (Math.random() * 1234);
			deposito.armazenar(valor);
			System.out.println("Produtor [OUT=" + valor + "]");
			total += valor;
		}
		System.out.println("Produtor [FIM total=" + total + "]");
	}
}
