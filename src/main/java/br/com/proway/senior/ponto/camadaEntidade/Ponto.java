package br.com.proway.senior.ponto.camadaEntidade;

import java.time.LocalDateTime;
import java.util.Date;


public class Ponto {
	private int id;
	private tipo tipo;
	private Date data;
	private String localizacao;
	private LocalDateTime horario;
	
	public enum tipo {
		APLICATIVO_WEB,
		TERMINAL_CRACHA,
		TERMINAL_BIOMETRIA,
		TERMINAL_SENHA;
	}
	
	public Ponto(int id, tipo tipo, Date data, String localizacao) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.data = data;
		this.localizacao = localizacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public tipo gettipo() {
		return tipo;
	}

	public void settipo(tipo tipo) {
		this.tipo = tipo;

	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}
	
}

