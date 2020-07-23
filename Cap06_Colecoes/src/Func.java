/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.33
 */
public class Func {
	protected String nome;
	protected int depto;
	protected double salario;

	// construtor
	public Func(String nome, int depto, double salario) {
		super();
		setNome(nome);
		setDepto(depto);
		setSalario(salario);
	}

	// getters
	public String getNome() {
		return nome;
	}

	public int getDepto() {
		return depto;
	}

	public double getSalario() {
		return salario;
	}

	// setters
	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected void setDepto(int depto) {
		this.depto = depto;
	}

	protected void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return String.format("%s[%d|%.2f]", nome, depto, salario);
	}
}
