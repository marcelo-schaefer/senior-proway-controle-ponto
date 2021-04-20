package br.com.proway.senior.ponto.camadaEntidade;

import java.time.LocalDateTime;
import java.util.ArrayList;


import br.com.proway.senior.ponto.camadaLogica.JustificativaLogica;

public class Colaborador extends Pessoa {
	private Integer idTime;
	private Integer idTurno;
	private boolean ehGerente;
	private boolean ehAtivo;
	private int jornadaEmMinutos;
	private ArrayList<HistoricoMensal<Justificativa>> justificativas;
	private ArrayList<HistoricoMensal<JornadaDeTrabalho>> jornadas;
	
	public Colaborador() {}

	public Colaborador() {};
	
	public Colaborador(Integer idTime, Integer idTurno, boolean ehGerente) {
		super();
		this.setIdTime(idTime);
		this.idTurno = idTurno;
		this.ehGerente = ehGerente;
		
		this.jornadas = new ArrayList<HistoricoMensal<JornadaDeTrabalho>>(); // Inicializa o ArrayList jornadas.
		JornadaDeTrabalho primeiraJornada = new JornadaDeTrabalho(); // Inicializa a primeira
																					// JornadaDeTrabalho
		HistoricoMensal<JornadaDeTrabalho> primeiroMes = new HistoricoMensal<JornadaDeTrabalho>(
				primeiraJornada); // Inicializa o hist�rico mensal do primeiro m�s adicionando a
												// primeiraJornada.
		this.jornadas.add(primeiroMes); // Adiciona o primeiro m�s (HistoricoMensal<JornadaDeTrabalho>) na lista de
										// jornadas.
		
		this.justificativas = new ArrayList<HistoricoMensal<Justificativa>>();
		HistoricoMensal<Justificativa> justificativasDoPrimeiroMes = new HistoricoMensal<Justificativa>();
		this.justificativas.add(justificativasDoPrimeiroMes);
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
	/*public Ponto salvarPonto(TipoDePonto tipo, String localizacao) {
		HistoricoMensal<JornadaDeTrabalho> ultimoHistoricoMensal = jornadas.get(jornadas.size() - 1);
		JornadaDeTrabalho ultimaJornadaDoUltimoHistoricoMensal = ultimoHistoricoMensal.getObjetos()
				.get(ultimoHistoricoMensal.getObjetos().size() - 1);
		LocalDateTime dateTimeAtual = LocalDateTime.now();
		Ponto novoPonto = new Ponto(this.getId(), tipo, dateTimeAtual, localizacao);
		ultimaJornadaDoUltimoHistoricoMensal.addPonto(novoPonto);
		return novoPonto;
	}*/
	
	/*public Justificativa salvarJustificativa(Justificativa novaJustificativa) 
		JustificativaLogica novaJustificativaLogica = new JustificativaLogica(novaJustificativa);		
		novaJustificativaLogica.cadastrarJustificativa(novaJustificativa);
		HistoricoMensal<Justificativa> ultimoHistoricoMensalDeJustificativas = justificativas.get(justificativas.size() - 1);
		ultimoHistoricoMensalDeJustificativas.getObjetos().add(novaJustificativa);
		return novaJustificativa;
	}*/
	
	public int getJornadaEmMinutos() {
		return jornadaEmMinutos;
	}

	public void setJornadaEmMinutos(int jornadaEmMinutos) {
		this.jornadaEmMinutos = jornadaEmMinutos;
	}

	public Integer getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}

	public boolean isEhGerente() {
		return ehGerente;
	}

	public void setEhGerente(boolean ehGerente) {
		this.ehGerente = ehGerente;
	}

	public ArrayList<HistoricoMensal<Justificativa>> getJustificativas() {
		return justificativas;
	}

	public void setJustificativas(ArrayList<HistoricoMensal<Justificativa>> justificativas) {
		this.justificativas = justificativas;
	}

	public ArrayList<HistoricoMensal<JornadaDeTrabalho>> getJornadas() {
		return jornadas;
	}

	public void setJornadas(ArrayList<HistoricoMensal<JornadaDeTrabalho>> jornadas) {
		this.jornadas = jornadas;
	}

	public Integer getIdTime() {
		return idTime;
	}

	public void setIdTime(Integer idTime) {
		this.idTime = idTime;
	}

	

}
