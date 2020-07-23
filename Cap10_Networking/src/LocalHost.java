/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.1
 */
import java.net.*;

public class LocalHost {
	public static void main(String a[]) {
		try {
			InetAddress localIP = InetAddress.getLocalHost();
			System.out
					.println("Endereço IP Local: " + localIP.getHostAddress());
			System.out.println("Nome Host Local  : " + localIP.getHostName());
			System.out.println("Nome/End IP Local: " + localIP);
		} catch (UnknownHostException e) {
			System.err
					.println("Endereço local não pode ser determinado.\n" + e);
		}
	}
}
