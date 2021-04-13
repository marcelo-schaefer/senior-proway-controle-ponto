package ponto;

public class LocalizadorParaPonto {

	/**
	 * Localiza o ponto
	 * 
	 * o metodo recebe a localizacao e a forma que foi feito o ponto, compara a
	 * forma do ponto, caso for na empresa, retoma a localizacao da empresa caso
	 * contrario, utiliza a localizacao passada
	 * 
	 * @param String localizacao, localizacao passada pelo ponto
	 * @param String formaDoPonto, maneira que foi feito o ponto
	 * @return String local, reotrna o local do ponto
	 */
	public String localizacaoDoPonto(String localizacao, String formaDoPonto) {
		String local;

		switch (formaDoPonto) {
		case "biometria":
			local = "empresa";
			break;

		case "senha nao digital":
			local = "empresa";
			break;

		case "cartao":
			local = "empresa";
			break;

		default:
			local = localizacao;
			break;
		}
		return local;
	}
}
