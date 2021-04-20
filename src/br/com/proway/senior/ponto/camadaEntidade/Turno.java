package br.com.proway.senior.ponto.camadaEntidade;

public enum Turno {
	PRIMEIRO_TURNO(1), SEGUNDO_TURNO(2), TERCEIRO_TURNO(3), COMERCIAL(4);

	/**
	 * Vari�vel do tipo inteiro utilizada no construtor.
	 */
	private int valor;

	/**
	 * 
	 * Retorna um n�mero inteiro referente ao enumerador, facilitando o registro no
	 * banco de dados.
	 * 
	 * @param valor Numero referente ao enumerador.
	 */
	private Turno(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

}
