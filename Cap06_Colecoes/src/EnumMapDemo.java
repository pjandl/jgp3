/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.26
 */
import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo {
	public enum UF { // Enumera��o de Unidades Federais
		AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO
	}

	public static void main(String[] args) {
		// Cria EnumMap com chaves do tipo enumera��o UF
		Map<UF, String> em = new EnumMap<>(UF.class);
		// Adiciona chaves
		em.put(UF.AM, "Manaus");
		em.put(UF.MG, "Belo Horizonte");
		em.put(UF.SP, "S�o Paulo");
		em.put(UF.RJ, "Rio de Janeiro");
		// Obt�m conte�do de uma chave
		System.out.println("MG? : " + em.get(UF.MG));
		System.out.println("AC? : " + em.get(UF.AC));
		System.out.println("PB? : " + em.getOrDefault(UF.PB, "N/D"));
		// Verifica exist�ncia de conte�do para chave/valor
		System.out.println("AL? : " + em.containsKey(UF.AL));
		System.out.println("Manaus? : " + em.containsValue("Manaus"));
		// Lista chaves, valores e entradas
		System.out.println("Keys    : " + em.keySet());
		System.out.println("Values  : " + em.values());
		System.out.println("Entries : " + em.entrySet());
		System.out.println("toString: " + em);
	}
}
