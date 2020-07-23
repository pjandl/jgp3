/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.23
 */
import java.io.*;

public class ExemploTryCatchFinally2 {
	public static void main(String args[]) {
		InputStream recurso = null;
		try {
			recurso = new FileInputStream(args[0]);
			// uso do recurso
		} catch (IOException e1) {
			// tratamento de erro na obtenção do recurso
			System.out.println(e1);
		} finally {
			if (recurso != null)
				try {
					recurso.close();
				} catch (IOException e2) {
				}
		}
	}
}
