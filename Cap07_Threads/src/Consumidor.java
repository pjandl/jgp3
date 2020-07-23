/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 7.12
 */
public class Consumidor extends Thread {
	private int quantidade;
	private Deposito deposito;

	public Consumidor(int quant, Deposito dep) {
		quantidade = quant;
		deposito = dep;
	}

	@Override
	public void run() {
		System.out.println("Consumidor [INICIO]");
		int total = 0;
		for (int i = 0; i < quantidade; i++) {
			int valor = deposito.retirar();
			System.out.println("Consumidor [IN=" + valor + "]");
			total += valor;
		}
		System.out.println("Consumidor [FIM total=" + total + "]");
	}
}
