/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 7.20
 */
public class FileMonitorTest {

	public static void main(String args[]) {
		FileMonitor monitor = null;
		if (args.length > 0) {
			System.out.println("Main[inicio]");
			monitor = new FileMonitor(args[0]);
			if (args.length > 1 && args[1].equalsIgnoreCase("-s")) {
				monitor.setDaemon(true);
			}
			monitor.start();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException ie) {
			}
			System.out.println("Main[fim]");
		} else {
			System.out.println("Uso:\n\tFileMonitorTest <nomeArquivo> [-servico]");
		}
	}
}
