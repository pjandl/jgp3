/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 7.14
 */
public class DepositoSinc extends Deposito {
	private boolean ok = false; // vari�vel sinalizadora (flag)

	public synchronized void armazenar(int valor) {
		while (ok == true) { // thread espera se valor dispon�vel
			try {
				wait();
			} catch (InterruptedException ie) {
			}
		}
		this.valor = valor; // armazena valor
		ok = true; // atualiza flag
		notifyAll(); // notifica demais threads
	}

	public synchronized int retirar() {
		while (ok == false) { // thread espera se valor indispon�vel
			try {
				wait();
			} catch (InterruptedException ie) {
			}
		}
		ok = false; // atualiza flag
		notifyAll(); // notifica demais threads
		return valor; // recupera valor
	}
}
