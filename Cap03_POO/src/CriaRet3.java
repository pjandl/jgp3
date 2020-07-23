/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.13
 */
public class CriaRet3 {
	public static void main(String arg[]) {
		try {
			// vari�veis auxiliares recebem convers�o dos argumentos
			double larg = Double.parseDouble(arg[0]); // 1o arg
			double alt = Double.parseDouble(arg[1]); // 2o arg
			// cria objeto
			Retangulo3 retangulo = new Retangulo3(larg, alt);
			// uso impl�cito de Retangulo3.toString() exibe info do objeto
			System.out.println(retangulo);
		} catch (ArrayIndexOutOfBoundsException exc) {
			// trata a falta de argumentos
			System.out.println("Numero insuficiente de argumentos.");
		} catch (NumberFormatException exc) {
			// trata erros de convers�o
			System.out.println("Argumento(s) invalido(s).");
		} catch (Exception exc) {
			// trata erros de instancia��o do ret�ngulo
			System.out.println("Dimensoes invalidas.");
		}
	}
}
