/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.40
 */
import java.util.Arrays;

public class SortableObjectArray implements Sortable {
	protected Object[] array;

	public SortableObjectArray() {
		this(10);
	}

	public SortableObjectArray(int tam) {
		array = new Object[tam];
	}

	public void sort() {
		Arrays.sort(array);
	}

	public Object get(int index) {
		return array[index];
	}

	public void set(int index, Object value) {
		array[index] = value;
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}
}
