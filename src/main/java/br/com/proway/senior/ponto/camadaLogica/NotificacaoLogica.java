package br.com.proway.senior.ponto.camadaLogica;

import java.util.ArrayList;

import br.com.proway.senior.ponto.camadaEntidade.Pessoa;

public class NotificacaoLogica {

	Pessoa entidadePessa;

	public NotificacaoLogica(Pessoa pessoa) {
		this.entidadePessa = pessoa;
	}

	/**
	 * <h1>Envia notificacao</h1>
	 * </br>
	 * Responsavel por enviar uma mensagem em formato de String para um usuario
	 * representado por um identificador. A funcao checa a existencia do usuario e
	 * se a mensagem atende aos requerimentos do sistema.
	 *
	 * @param entidadePessa Pessoa, consultor da pessoa informada.
	 * @param mensagem String, mensagem a ser enviada.
	 * @param id Integer, referente ao destinatário da mensagem.
	 * @return boolean representando o sucesso da operacao (true/false)
	 */
	public boolean enviarNotificacao(Pessoa entidadePessoa, String mensagem, Integer id) {
		if (checarDestinatario(entidadePessoa, id) == true && checarValidadeMensagem(mensagem) == true) {
			ArrayList<String> listaMensagem = new ArrayList<String>();
			listaMensagem.add(mensagem);
			entidadePessoa.setMensagens(listaMensagem);
			return true;
		}
		return false;
	}
	
	/**
	 * <h1>Apresenta a lista de mensagens da pessoa.</h1>
	 * </br>
	 * Mostra todas as mensagens de uma pessoa.
	 * 
	 * @param entidadePessoa Pessoa, consultor da pessoa informada(no caso pelo id).
	 * @param id Integer, referente a pessoa a ser consultada.
	 * @return ArrayList<String>, referente a lista de mensagens.
	 */
	public ArrayList<String> consultarNotificacaoPorPessoa(Pessoa entidadePessoa, Integer id) {
		if(checarDestinatario(entidadePessoa, id) == true) {
			return entidadePessoa.getMensagens();
		}
		return null;
	}
	
	/**
	 * <h1>Checar validade da mensagem</h1> 
	 * </br>
	 * A função checa se a mensagem se adequa aos requerimentos
	 * do sistema. O comprimento da mensagem deve estar entre 1 e 200 caracteres, se
	 * for aceita, a mensagem ja eh salva na lista de mensagens.
	 * 
	 * @param mensagem String, mensagem a ser enviada.
	 * @param entidadePessoa Pessoa, para saber em qual lista pessoa salvar.
	 * @return boolean representando o sucesso da operacao (true/false).
	 */
	public boolean checarValidadeMensagem(String mensagem) {
		mensagem = mensagem.trim();
		if (mensagem != null && mensagem.length() > 0 && mensagem.length() <= 200) {
			return true;
		} 
		return false;	
	}

	/**
	 * <h1>Checar Destinatário</h1>
	 * </br>
	 * A funcao checa a existencia do usuario no banco de dados.
	 * 
	 * @param entidadePessoa Pessoa, consultor da pessoa a ser verificada(no caso pelo id).
	 * @param id Integer, referente a pessoa a ser consultada.
	 * @return boolean representando o sucesso da operação (true/false)
	 */
	public boolean checarDestinatario(Pessoa entidadePessoa, Integer id) {
		Integer idGet = entidadePessoa.getId();
		if (id == idGet) {
			return true;
		}
		return false;
	}
}
