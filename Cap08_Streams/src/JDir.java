/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 8.11
 */
import java.io.File;
import java.util.Date;

public class JDir {
	public static final void main(String args[]) {
		// usa diretorio corrente se nao for dado um argumento
		File f = new File(args.length != 0 ? args[0] : ".");
		StringBuffer sb = new StringBuffer();
		if (f.isDirectory()) { // verifica se e diretorio
			sb.append("Diretorio: " + f.getAbsolutePath() + "\n");
			String arquivos[] = f.list(); // lista elementos do diretorio
			for (int i = 0; i < arquivos.length; i++)
				sb.append(arquivos[i] + "\n");
		} else { // exibe informacoes do arquivo
			sb.append("Arquivo: " + f.getAbsolutePath() + "\n");
			sb.append("Tamanho: " + f.length() + "\n");
			sb.append("Oculto : " + f.isHidden() + "\n");
			sb.append("Modif : " + new Date(f.lastModified()) + "\n");
		}
		System.out.println(sb.toString());
	}
}
