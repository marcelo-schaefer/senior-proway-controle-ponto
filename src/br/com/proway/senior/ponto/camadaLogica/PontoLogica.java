package br.com.proway.senior.ponto.camadaLogica;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.proway.senior.ponto.camadaEntidade.Colaborador;
import br.com.proway.senior.ponto.camadaEntidade.Ponto;

public class PontoLogica {
	

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
	 * Pega registro de pontos de uma jornada de trabalho de um colaborador.
	 * 
	 * Retorna uma lista de pontos referente a uma jornada de trabalho de
	 * determinado dia de um colaborador.
	 * 
	 * @param colaborador Colaborador a ser consultado.
	 * @param data        Data da jornada a ser retornada.
	 * @return ArrayList<Ponto>
	 */
	public ArrayList<Ponto> pegarPontosDeUmaJornada(Colaborador colaborador, LocalDate data) {
		ArrayList<Ponto> pontos = new ArrayList();
		return pontos;
	}

	/**
	 * Cadastra o ponto batido
	 * 
	 * O metodo recebe todas as caracteristicas de um ponto e armazena elas
	 * 
	 * @param Ponto ponto, tras as caracteristicas de um ponto
	 */
	public void cadastrarPonto(Ponto ponto) {
	}

	public Integer gerarChave(Integer id) {

		return null;
	}

}
