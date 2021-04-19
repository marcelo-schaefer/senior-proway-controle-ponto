package br.com.proway.senior.ponto.camadaEntidade;

import java.time.LocalDateTime;


public class Ponto {
	private int id;
	private TipoDePonto tipoDePonto;
	private LocalDateTime data;
	private String localizacao;
	//ArrayList<PontoDiario> pontosDiarios; quem fez isso?
	
	public enum TipoDePonto {
		APLICATIVO_WEB,
		TERMINAL_CRACHA,
		TERMINAL_BIOMETRIA,
		TERMINAL_SENHA;
	}
	
	

	public Ponto(int id, TipoDePonto tipoDePonto, LocalDateTime data, String localizacao) {
		super();
		this.id = id;
		this.tipoDePonto = tipoDePonto;
		this.data = data;
		this.localizacao = localizacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoDePonto getTipoDePonto() {
		return tipoDePonto;
	}

	public void setTipoDePonto(TipoDePonto tipoDePonto) {
		this.tipoDePonto = tipoDePonto;

	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}


	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	
}

