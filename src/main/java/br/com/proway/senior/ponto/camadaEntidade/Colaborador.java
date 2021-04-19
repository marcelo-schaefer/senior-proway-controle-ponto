package br.com.proway.senior.ponto.camadaEntidade;

public class Colaborador {
	private int id;
	private String nome;	
	private int idSuperior;
	private int idTurno;
	private boolean ehGerente;

	public int getId() {
		return id;
	}

	public Colaborador(int id, String nome, int idSuperior, int idTurno, boolean ehGerente) {
		super();
		this.id = id;
		this.nome = nome;
		this.idSuperior = idSuperior;
		this.idTurno = idTurno;
		this.ehGerente = ehGerente;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getidSuperior() {
		return idSuperior;
	}

	public void setidSuperior(int idSuperior) {
		this.idSuperior = idSuperior;
	}

	public int getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	public boolean isEhGerente() {
		return ehGerente;
	}

	public void setEhGerente(boolean ehGerente) {
		this.ehGerente = ehGerente;
	}

}
