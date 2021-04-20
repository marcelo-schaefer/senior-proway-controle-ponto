package br.com.proway.senior.ponto.camadaLogica;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


import br.com.proway.senior.ponto.camadaEntidade.Colaborador;
import br.com.proway.senior.ponto.camadaEntidade.Pessoa;
import br.com.proway.senior.ponto.camadaEntidade.Ponto;


public class NotificacaoLogica {

	Pessoa entidadePessoa;
	Ponto entidadePonto;
	Colaborador entidadeColaborador;

	public NotificacaoLogica(Pessoa pessoa) {
		this.entidadePessoa = pessoa;
	}
	
	public NotificacaoLogica(Ponto ponto) {
		this.entidadePonto = ponto;
	}
	
	public NotificacaoLogica(Colaborador colaborador) {
		this.entidadeColaborador = colaborador;
	}
	
	/***
	 * <h1>Valida a jornada de trabalho</h1>
	 * </br>
	 * Verifica se a quantidade de pontos de uma jornada eh par ou impar
	 * e se a quantidade de horas do colaborador foi devidamente cumprida.
	 * @param listaColaborador ArrayList<Colaborador>, referente aos colaboradores a serem consultados
	 * @return ArrayList<Pessoa>
	 */
	public ArrayList<Colaborador> validaJornadaDeTrabalho(ArrayList<Colaborador> listaColaborador) {
		LocalDate data1 = LocalDate.of(2021, 04, 19);
		LocalDateTime entrada;
		LocalDateTime saida;
		long minutos = 0;
		
		for(Colaborador colaborador: listaColaborador) {
			ArrayList<Ponto> listaPontos = pegarJornadaPorColaboradorEData(colaborador, data1);
			if(listaPontos.size() % 2 == 0) {
				/* Verifica se concluiu a jornada de trabalho*/
				for(Ponto pontoEntrada: listaPontos) {
						entrada = pontoEntrada.getHorario();
						listaPontos.remove(listaPontos.indexOf(pontoEntrada));
						for(Ponto pontoSaida : listaPontos) {
							saida = pontoSaida.getHorario();
							listaPontos.remove(listaPontos.indexOf(pontoSaida));
						}
						//minutos = ChronoUnit.MINUTES(entrada, saida);
						
						//calculamos o intervalo em minutos e inserimos na nossa variável minutos
						//break e o ciclo repete
					
				}
				
			} else {
				/*Mandar notificação ao usuário
				 * Bater o ponto para o rh depois alterar*/
			}
		}
		ArrayList<Colaborador> aa = new ArrayList<Colaborador>();
		return aa;
	}
	
	public ArrayList<Ponto> ordenarPontosPorData(ArrayList<Ponto> listaPonto){
		ArrayList<Ponto> aa = new ArrayList<Ponto>();
		return aa;
	}
	
	/***
	 * <h1>Pegar jornada de trabalho por colaborador e data</h1>
	 * </br>
	 * Retorna uma lista de pontos do colaborador informado referente
	 * a data informada.
	 * 
	 * @param colaborador Colaborador, referente ao colaborador a serconsultado.
	 * @param data LocalDate, referente a data informada.
	 * @return ArrayList<Ponto> referente aos pontos.
	 */
	public ArrayList<Ponto> pegarJornadaPorColaboradorEData(Colaborador colaborador, LocalDate data){
		ArrayList<Ponto> aa = new ArrayList<Ponto>();
		return aa;
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
