/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 7.15
 */
public class ProdCons2 {
	public static void main(String a[]) {
		Deposito d = new DepositoSinc();
		Produtor p = new Produtor(4, d);
		Consumidor c = new Consumidor(4, d);
		p.start();
		c.start();
	}
}
