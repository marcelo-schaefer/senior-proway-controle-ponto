<<<<<<< HEAD
<<<<<<< HEAD
/**
 * 
 */
=======
>>>>>>> refactorOO
=======
>>>>>>> refactorOO
package br.com.proway.senior.ponto;

import java.util.Arrays;
import java.util.List;

/**
 * Módulo de Notificações -
 * 
 * Responsável por enviar notificações para pessoas cadastradas no sistema.
 * ex: Notificações de Ponto Registrado, deferimentos ou indeferimentos de justificativas de pontos, etc...
 *
 */
public class Notificacoes {
<<<<<<< HEAD
<<<<<<< HEAD
=======
	
>>>>>>> refactorOO
=======
	
>>>>>>> refactorOO
	public static short MAX_MESSAGE_LENGTH = 200;
	
	/**
	 * <h1> enviarNotificacao </h1> 
	 * Responsável por enviar uma mensagem em formato de string para um usuário representado por um identificador.
	 * A função checa a existência do usuário e se a mensagem atende aos requerimentos do sistema.
	 *
	 * @param destination String Identificador da pessoa que vai receber a notificação.
	 * @param message String Mensagem a ser enviada. 
	 * @return boolean representando o sucesso da operação (true/false)
	 */
	public boolean enviarNotificacao(String destination, String message) {
		if (checarDestinatario(destination) && checarValidadeMensagem(message)) {
			//System.out.println("Notificação enviada para " + destination + "!");
			//System.out.println("Mensagem: "+message);
			
			// Código que DE FATO envia/mostra a notificação ao perfil do usuário aqui.
			
			return true;
		}
		//System.out.println("Notificação não enviada!");
		return false;
	}
	
	/**
<<<<<<< HEAD
<<<<<<< HEAD
	 * <h1> checarDestinatario </h1> 
=======
	 * <h1>ChecarDestinatario</h1> 
>>>>>>> refactorOO
=======
	 * <h1>ChecarDestinatario</h1> 
>>>>>>> refactorOO
	 * A função checa a existência do usuário no banco de dados.
	 * 
	 * 
	 * @param destination String Identificador da pessoa a ser verificado.
	 * @return boolean representando o sucesso da operação (true/false)
	 */
	public static boolean checarDestinatario(String destination) {
		// Se o destinatário existe na lista de usuários registrados...
		
		String[] arr = {"Tester Testerson", "Dummy", "Bot", "123456"};
		List<String> validUsers = Arrays.asList(arr); //Testando - Remover quando tivermos acesso ao db
		
		if( destination != null &&
			validUsers.contains(destination)) {
			return true;
		}
		else {
			//System.out.println("Destinatário inválido, certifique-se que o usuário existe.");
			return false;
		}
	}
	
	/**
	 * <h1> checarDestinatario </h1> 
	 * A função checa se a mensagem se adequa aos requerimentos do sistema.
	 * O comprimento da mensagem deve estar entre 1 e MAX_MESSAGE_LENGTH caracteres.
	 * 
	 * @param message String Mensagem a ser enviada. 
	 * @return boolean representando o sucesso da operação (true/false)
	 */
	public static boolean checarValidadeMensagem(String message) {
		// Mensagem deve ser não nula, maior que 0 e menor que MAX_MESSAGE_LENGTH caracteres.
		if( message != null &&
			message.length() > 0 &&
			message.length() < MAX_MESSAGE_LENGTH){
			return true;
		}
		else {
			// System.out.println("Mensagem em formato inválido!");
			return false;
		}
	}
}
