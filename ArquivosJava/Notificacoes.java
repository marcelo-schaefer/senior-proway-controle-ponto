package br.com.proway.senior.teste;

public class Notificacoes {
	public static short MAX_MESSAGE_LENGTH = 200;

	public boolean enviarNotificacao(String destination, String message) {
		if (checarDestinatario(destination) && checarValidadeMensagem(message)) {
			System.out.println("Notificação enviada para " + destination + "!");
			System.out.println("Mensagem: "+message);
			// Código que envia/mostra a notificação ao perfil do usuário aqui.
			return true;
		}
		
		System.out.println("Notificação não enviada!");
		return false;
	}
	
	public static boolean checarDestinatario(String destination) {
		// Se o destinatário existe na lista de usuários registrados...
		if(destination != null) return true;
		else {
			System.out.println("Destinatário inválido, certifique-se que o usuário existe.");
			return false;
		}
	}
	
	public static boolean checarValidadeMensagem(String message) {
		// Mensagem deve ser não nula, maior que 0 e menor que MAX_MESSAGE_LENGTH caracteres.
		if( message != null &&
			message.length() > 0 &&
			message.length() < MAX_MESSAGE_LENGTH){
			return true;
		}
		else {
			System.out.println("Mensagem em formato inválido!");
			return false;
		}
	}
}
