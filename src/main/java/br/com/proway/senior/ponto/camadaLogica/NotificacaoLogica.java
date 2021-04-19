package br.com.proway.senior.ponto.camadaLogica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.proway.senior.ponto.camadaEntidade.Pessoa;

public class NotificacaoLogica {

	Pessoa entidadePessa;

	public NotificacaoLogica(Pessoa pessoa) {
		this.entidadePessa = pessoa;
	}

	/**
	 * enviarNotificacao
	 * 
	 * Responsavel por enviar uma mensagem em formato de string para um usuario
	 * representado por um identificador. A funcao checa a existencia do usuario e
	 * se a mensagem atende aos requerimentos do sistema.
	 *
	 * @param Pessoa entidadePessa, ha pessoa que sera relacionada a notificacao
	 * @param String mensagem, mensagem a ser enviada.
	 * @return boolean representando o sucesso da operacao (true/false)
	 */
	public boolean enviarNotificacao(Pessoa entidadePessoa, String mensagem) {

		if (checarDestinatario(entidadePessoa) && checarValidadeMensagem(mensagem, entidadePessoa)) {

			return true;
		}
		System.out.println("notificaao nao enviada!");
		return false;
	}

	/**
	 * ChecarDestinatario
	 * 
	 * A funcao checa a existencia do usuario no banco de dados
	 * 
	 * @param Pessoa entidadePessoa, identificador da pessoa a ser verificada.
	 * @return boolean representando o sucesso da operação (true/false)
	 */
	public boolean checarDestinatario(Pessoa entidadePessoa) {
		// Se o destinatario existe na lista de usuarios registrados

		Integer idGet = entidadePessoa.getId();

		for (Pessoa pessoa : entidadePessoa.getListaPessoa()) {
			if (pessoa.getId().equals(idGet)) {
				return true;
			}
		}
		System.out.println("destinatario nao encontrado");
		return false;

	}

	/**
	 * Apresenta a lisata de mensagens da pessoa
	 * 
	 * @param Pessoa entidadePessoa, de quem vai pegar a lista
	 * @return ArrayList<String>, lista de mensagens
	 */
	public ArrayList<String> consultarNotificacaoPorPessoa(Pessoa entidadePessoa) {

		return entidadePessoa.getMensagens();
	}

	/**
	 * Checar destinatario A funcao checa se a mensagem se adequa aos requerimentos
	 * do sistema. O comprimento da mensagem deve estar entre 1 e 200 caracteres, se
	 * for aceita, a mensagem ja eh salva na lista de mensagens.
	 * 
	 * @param String Mensagem, mensagem a ser enviada.
	 * @param Pessoa entidadePessoa, para saber em qual lista pessoa salvar
	 * @return boolean representando o sucesso da operacao (true/false)
	 */
	public boolean checarValidadeMensagem(String mensagem, Pessoa entidadePessoa) {
		// Mensagem deve ser não nula, maior que 0 e menor que MAX_MESSAGE_LENGTH
		// caracteres.
		mensagem = mensagem.trim();
		if (mensagem != null && mensagem.length() > 0 && mensagem.length() <= 200) {
			entidadePessoa.getMensagens().add(mensagem);
			return true;
		} else {
			System.out.println("Mensagem em formato invalido!");
			return false;
		}
	}
}
