/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.50
 */
public class UsaOpcoes {
	public static void main(String a[]) {
		// imprime constantes com for avançado
		for (Opcoes constante : Opcoes.values()) {
			System.out.printf("%-25s #%02d: %-20s\n", constante,
					constante.getValor(), constante.getNome());
			switch (constante) {
			case COMPACTAR:
				System.out.println("Opcao de compactacao");
				break;
			case DESCOMPACTAR:
				System.out.println("Opcao de descompactacao");
				break;
			}
		}
	}
}
