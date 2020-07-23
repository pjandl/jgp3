/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 7.19
 */
import java.io.File;

public class FileMonitor extends Thread {
	private File file;
	public boolean active;

	public FileMonitor(String fileName) {
		file = new File(fileName);
	}

	@Override
	public void run() {
		active = true;
		do {
			System.out.println(this);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
			}
		} while (active);
	}

	public File getFile() {
		return file;
	}

	public String toString() {
		String mode = isDaemon() ? "servico" : "usuario";
		String size = file.exists() ? file.length()+" bytes" : "nao existe";
		return String.format("[FileMonitor|%s] %s:%s", mode,
				file.getAbsoluteFile(), size);
	}

}
