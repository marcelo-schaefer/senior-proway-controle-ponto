package br.com.proway.senior.ponto.camadaLogica;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import br.com.proway.senior.ponto.camadaEntidade.Colaborador;
import br.com.proway.senior.ponto.camadaEntidade.HistoricoMensal;
import br.com.proway.senior.ponto.camadaEntidade.JornadaDeTrabalho;
import br.com.proway.senior.ponto.camadaEntidade.Ponto;
import br.com.proway.senior.ponto.camadaEntidade.TipoDePonto;

public class PontoLogica {
	public static ArrayList<Ponto> pontos = new ArrayList<Ponto>();
	

	/**
	 * Cadastra um registro de ponto.
	 * 
	 * Cadastra um ponto com o ID da pessoa.
	 * 
	 * @param colaborador Colaborador que bateu o ponto.
	 * @return void
	 */
	public void cadastrarPonto(Colaborador pessoa) {

	}

	public static ArrayList<Ponto> pegarTodosOsPontos() {		
		// SQL para pegar todos os pontos do banco
		return pontos;		
	}
	
	/**
	 * Pega registro de pontos de um colaborador.
	 * 
	 * Retorna uma lista contendo todos os pontos de um colaborador.
	 * 
	 * @param colaborador Colaborador a ser consultado.
	 * @return ArrayList<Ponto>
	 */
	public ArrayList<Ponto> pegarPontosPorPessoa(Colaborador colaborador) {
		ArrayList<Ponto> pontos = new ArrayList<Ponto>();
		return pontos;
	}

	/**
	 * Salva o ponto
	 * 
	 * O metodo recebe o tipo do ponto e sua localizacao, pega o final da lsita de
	 * jornadas de trabalho e adciona o ponto nela
	 * 
	 * @param TipoDeponto tipo, enum da maneira que foi feito o ponto
	 * @param String      localizacao, localizacao de onde o usuario bateu o ponto
	 */
	public Ponto salvarPonto(TipoDePonto tipo, String localizacao, Colaborador c) {
		HistoricoMensal<JornadaDeTrabalho> ultimoHistoricoMensal = c.getJornadas().get(c.getJornadas().size() - 1);
		JornadaDeTrabalho ultimaJornadaDoUltimoHistoricoMensal = ultimoHistoricoMensal.getObjetos()
				.get(ultimoHistoricoMensal.getObjetos().size() - 1);
		LocalDateTime dateTimeAtual = LocalDateTime.now();
		Ponto novoPonto = new Ponto(c.getId(), tipo, dateTimeAtual, localizacao);
		ultimaJornadaDoUltimoHistoricoMensal.addPonto(novoPonto);
		return novoPonto;
	}

}
