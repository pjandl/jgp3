/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.7
 */
public class CriaRet1 {
	public static void main(String arg[]) {
		// variáveis auxiliares recebem conversão dos argumentos
		double larg = Double.parseDouble(arg[0]); // 1o arg
		double alt = Double.parseDouble(arg[1]); // 2o arg
		// cria objeto
		Retangulo retangulo = new Retangulo(larg, alt);
		// uso implícito de Retangulo.toString() exibe info do objeto
		System.out.println("Retangulo[" + retangulo.getLargura() + "x"
				+ retangulo.getAltura() + "]");
	}
}
