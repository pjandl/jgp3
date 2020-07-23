import java.awt.Color;

/**
 * Enumeração para classificação de força de senha, incluindo um método para
 * avaliação de senhas do tipo String ou char[], baseado em 4 critérios: -
 * tamanho da senha; - presença de maiúsculas e minúsculas; - presença de
 * digitos; e - presença de símbolos.
 * 
 * Esta classe é para fins educacionais e seus resultados não devem ser tomados
 * como uma orientação de segurança.
 */
public enum PasswordStrength {
	FRACA(Color.RED), MEDIA(Color.ORANGE), ADEQUADA(Color.YELLOW), ROBUSTA(
			Color.CYAN), FORTE(Color.GREEN);

	PasswordStrength(Color color) {
		this.color = color;
	}

	/**
	 * Método para estimar a força de uma senha.
	 */
	public static PasswordStrength evaluateStrength(String pwd) {
		return evaluateStrength(pwd.toCharArray());
	}

	/**
	 * Método para estimar a força de uma senha.
	 */
	public static PasswordStrength evaluateStrength(char[] pwd) {
		int score = 0;
		boolean upperCase = false;
		boolean lowerCase = false;
		boolean digits = false;
		boolean simbols = false;

		// Verifica tamanho da senha
		if (pwd.length > 5) {
			score++;
		}

		// Analisa caracteres da senha
		for (char c : pwd) {
			if (Character.isLetterOrDigit(c)) {
				if (Character.isDigit(c)) {
					digits=true;
				} else {
					if (Character.isLowerCase(c)) {
						lowerCase=true;
					} else {
						upperCase=true;
					}
				}
			} else {
				simbols=true;
			}
		}
		if (lowerCase && upperCase) score++;
		if (lowerCase || upperCase && digits) score++;
		if (lowerCase && upperCase && digits) score++;
		if (lowerCase || upperCase && simbols) score++;
		if (lowerCase && upperCase && simbols) score++;
		if (lowerCase || upperCase && simbols && digits) score++;
		if (lowerCase && upperCase && digits && simbols) score++;

		switch (score) {
		case 0:
			return FRACA;
		case 1:
			return MEDIA;
		case 2:
			return ADEQUADA;
		case 3:
			return ROBUSTA;
		default: // FORTE
		}
		return FORTE;
	}

	/**
	 * Retorna a cor associada a força de uma senha.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Atributo de cor associada a força de uma senha.
	 */
	private Color color;
}
