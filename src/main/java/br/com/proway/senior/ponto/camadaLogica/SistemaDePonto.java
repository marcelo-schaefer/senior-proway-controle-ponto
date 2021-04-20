package br.com.proway.senior.ponto.camadaLogica;

/**
 * Sistema de Ponto
 * Classe temporária de caráter "controller" para fazer o papel de "servidor" do sistema de ponto.
 * Futuramente essa classe será refatorada para ser uma API web.
 * Executa métodos em horários pré-programados para controlar o sistema de ponto..
 * @author 
 */
public class SistemaDePonto {


	
	/**
	 * Implementar ao integrar autênticação no sistema.
	 */
	private void autenticar() {
		
	}
	
	/** Fechamento da Jornada
	 * Em horários pré-definidos (nos horários dos turnos de trabalho).
	 * O sistema de pontos executa esse método para realizar o fechamento da jornada de trabalho dos colaboradores
	 * daquele turno. É durante esse fechamento que o sistema deve verificar pontos batidos incorretamente e enviar notificações
	 * de alerta, para que pontos possam ser justificados.
	 */
	private void fechamentoDaJornada() {
		// De acordo
	}
	

}
