/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.12
 */
public class CriaRet2 {
	public static void main(String arg[]) {
		try {
			// variáveis auxiliares recebem conversão dos argumentos
			double larg = Double.parseDouble(arg[0]); // 1o arg
			double alt = Double.parseDouble(arg[1]); // 2o arg
			// cria objeto
			Retangulo2 retangulo = new Retangulo2(larg, alt);
			// uso implícito de Retangulo2.toString() exibe info do objeto
			System.out.println(retangulo);
		} catch (Exception exc) {
			// exibe erros ocorridos durante a execução
			System.out.println("Erro durante a execucao:\n" + exc);
		}
	}
}
