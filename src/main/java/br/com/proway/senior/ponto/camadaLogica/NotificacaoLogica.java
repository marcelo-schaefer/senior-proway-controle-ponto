package br.com.proway.senior.ponto.camadaLogica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import br.com.proway.senior.ponto.camadaEntidade.Colaborador;
import br.com.proway.senior.ponto.camadaEntidade.Notificacao;
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
	 * <h1>Retorna colaboradores a serem notificados</h1> </br>
	 * Verifica se a quantidade de pontos de uma jornada eh par ou impar e se a
	 * quantidade de horas do colaborador foi devidamente cumprida. Se não for,
	 * adiciona na lista de colaboradores a serem notificados.
	 * 
	 * @param listaColaborador ArrayList<Colaborador>, referente aos colaboradores a
	 *                         serem consultados
	 * @return ArrayList<Pessoa>
	 */
	public static ArrayList<Colaborador> retornaColaboradoresASeremNotificados(
			ArrayList<Colaborador> listaColaborador) {
		ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();

		ArrayList<LocalDateTime> listaEntrada = new ArrayList<LocalDateTime>();
		ArrayList<LocalDateTime> listaSaida = new ArrayList<LocalDateTime>();

		for (Colaborador colaborador : listaColaborador) {
			LocalDate dataDeHoje = LocalDate.of(2021, 1, 1);

			ArrayList<Ponto> listaPontos = PontoLogica.pegarPontosDeUmaJornadaPorColaboradorEData(colaborador,
					dataDeHoje);

			if (listaPontos.size() % 2 == 0) {

				/* Verifica se concluiu a jornada de trabalho */
				for (Ponto ponto : listaPontos) {
					if (listaPontos.indexOf(ponto) % 2 == 0) {
						listaEntrada.add(ponto.getHorario());
					} else {
						listaSaida.add(ponto.getHorario());
					}

				}
				int totalMinutos = 0;
				for (int i = 0; i < listaEntrada.size(); i++) {
					LocalDateTime entrada = listaEntrada.get(i);
					LocalDateTime saida = listaSaida.get(i);

					LocalDateTime diferencaTempo = LocalDateTime.from(entrada);

					long horas = diferencaTempo.until(saida, ChronoUnit.HOURS);
					diferencaTempo = diferencaTempo.plusHours(horas);

					long minutos = diferencaTempo.until(saida, ChronoUnit.MINUTES);
					diferencaTempo = diferencaTempo.plusMinutes(minutos);

					totalMinutos += (int) ((horas * 60) + minutos);

				}
				if (totalMinutos < colaborador.getJornadaEmMinutos()) {
					colaboradores.add(colaborador);
					/*
					 * Mandar notificação ao usuário sobre jornada de trabalho não cumprida.
					 */
				}
			} else {
				colaboradores.add(colaborador);
				/*
				 * Mandar notificação ao usuário sobre batida de ponto de entrada sem saída.
				 */
			}
		}

		return colaboradores;
	}

	/**
	 * <h1>Envia notificacao</h1> </br>
	 * Responsavel por enviar uma mensagem em formato de String para um usuario
	 * representado por um identificador. A funcao checa a existencia do usuario e
	 * se a mensagem atende aos requerimentos do sistema.
	 *
	 * @param entidadePessa Pessoa, consultor da pessoa informada.
	 * @param mensagem      String, mensagem a ser enviada.
	 * @param id            Integer, referente ao destinatário da mensagem.
	 * @return boolean representando o sucesso da operacao (true/false)
	 */
	public Notificacao enviarNotificacao(Integer idDestinatario, String mensagem) {
		Notificacao notificacao = new Notificacao();
		if (validarDestinatario(idDestinatario) != null && validarMensagem(mensagem) == true) {
			notificacao.setIdDestinatario(idDestinatario);
			notificacao.setMensagem(mensagem);
			return notificacao;
		} else {
			return null;
		}
	}

	/**
	 * <h1>Validar a mensagem</h1> </br>
	 * A função checa se a mensagem se adequa aos requerimentos do sistema. O
	 * comprimento da mensagem deve estar entre 1 e 200 caracteres, se for aceita, a
	 * mensagem ja eh salva na lista de mensagens.
	 * 
	 * @param mensagem       String, mensagem a ser enviada.
	 * @param entidadePessoa Pessoa, para saber em qual lista pessoa salvar.
	 * @return boolean representando o sucesso da operacao (true/false).
	 */
	public boolean validarMensagem(String mensagem) {
		mensagem = mensagem.trim();
		if (mensagem != null && mensagem.length() > 0 && mensagem.length() <= 200) {
			return true;
		}
		return false;
	}

	/**
	 * <h1>Checar Destinatário</h1> </br>
	 * A funcao checa a existencia do usuario no banco de dados.
	 * 
	 * @param entidadePessoa Pessoa, consultor da pessoa a ser verificada(no caso
	 *                       pelo id).
	 * @param id             Integer, referente a pessoa a ser consultada.
	 * @return boolean representando o sucesso da operação (true/false)
	 */
	public Colaborador validarDestinatario(Integer id) {
		// busca usu�rio no banco de dados pelo id, se existir retorna o colaborador, se n�o
		// existir retorna null
		return null;
	}
}
