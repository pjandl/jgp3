/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.53
 */
import java.util.*;
public class SemGen { // Classe n�o usa gen�ricos
	public static void main(String a[]) {
		// cria lista gen�rica
		List num = new ArrayList();
		num.add(new Integer(10)); // adiciona Integer
		num.add(new Integer(20));
		// uso inconsistente n�o gera erros
		num.add(new String("qualquer coisa"));
		int tot = 0;
		tot += ((Integer)num.get(0)).intValue(); //uso de coer��o
		tot += ((Integer)num.get(1)); // autounboxing
		System.out.println("tot="+ tot);
} }
