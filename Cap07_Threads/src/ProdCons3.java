/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 7.16
 */
public class ProdCons3 {
	public static void main(String a[]) {
		Deposito d = new DepositoSinc();
		// total de itens produzidos = 4 + 6 (dois produtores)
		Produtor[] pa = { new Produtor(4, d), new Produtor(6, d) };
		// total de itens consumidos = 2 + 3 + 5 (três consumidores)
		Consumidor[] ca = { new Consumidor(2, d), new Consumidor(3, d),
				new Consumidor(5, d) };
		for (Produtor p : pa)
			p.start(); // ativa produtores
		for (Consumidor c : ca)
			c.start(); // ativa consumidores
	}
}
