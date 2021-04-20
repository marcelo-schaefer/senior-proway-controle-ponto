package br.com.proway.senior.ponto.camadaEntidade;

import java.util.ArrayList;

public class Colaborador extends Pessoa {
	private Integer idTime;
	private Integer idTurno;
	private boolean ehGerente;
	private boolean ehAtivo;
	private int jornadaEmMinutos;
	private ArrayList<HistoricoMensal<Justificativa>> justificativas;
	private ArrayList<HistoricoMensal<JornadaDeTrabalho>> jornadas;
	
	public Colaborador() {}
	
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
	public HistoricoMensal<Justificativa> getUltimoMesJustificativas(){
		
		HistoricoMensal<Justificativa> ultimoMesJustificativas;
		ultimoMesJustificativas = this.justificativas.get(justificativas.size()-1);
		return ultimoMesJustificativas;
	}

	public void setJustificativas(ArrayList<HistoricoMensal<Justificativa>> justificativas) {
		this.justificativas = justificativas;
	}
	public void adicionaJustificativa(Justificativa novaJustificativa) {
	
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

	public boolean isEhAtivo() {
		
		return ehAtivo;
	}

	public void setEhAtivo(boolean ehAtivo) {
		this.ehAtivo = ehAtivo;
	}

	

}
