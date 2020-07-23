/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.53
 */
import java.util.*;
public class SemGen { // Classe não usa genéricos
	public static void main(String a[]) {
		// cria lista genérica
		List num = new ArrayList();
		num.add(new Integer(10)); // adiciona Integer
		num.add(new Integer(20));
		// uso inconsistente não gera erros
		num.add(new String("qualquer coisa"));
		int tot = 0;
		tot += ((Integer)num.get(0)).intValue(); //uso de coerção
		tot += ((Integer)num.get(1)); // autounboxing
		System.out.println("tot="+ tot);
} }
