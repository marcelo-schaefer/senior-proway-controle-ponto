package br.com.proway.senior.ponto.camadaEntidade;

import java.time.LocalDateTime;

public class Ponto {
	private Integer id;
	private TipoDePonto tipoDePonto;
	private LocalDateTime data;
	private String localizacao;
	private LocalDateTime horario;

	public Ponto(Integer id, TipoDePonto tipoDePonto, LocalDateTime data, String localizacao) {
		super();
		this.id = id;
		this.setTipoDePonto(tipoDePonto);
		this.data = data;
		this.localizacao = localizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	public TipoDePonto getTipoDePonto() {
		return tipoDePonto;
	}

	public void setTipoDePonto(TipoDePonto tipoDePonto) {
		this.tipoDePonto = tipoDePonto;
	}

}
