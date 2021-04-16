package br.com.proway.senior.ponto.camadaEntidade;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ponto {

	private LocalDateTime data;
	private String localizacao;
	private ArrayList<LocalDateTime> pontosDiarios;
	private TipoDePonto tipoPonto;

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public ArrayList<LocalDateTime> getPontosDiarios() {
		return pontosDiarios;
	}

	public void setPontosDiarios(ArrayList<LocalDateTime> pontosDiarios) {
		this.pontosDiarios = pontosDiarios;
	}

	public TipoDePonto getTipoPonto() {
		return tipoPonto;
	}

	public void setTipoPonto(TipoDePonto tipoPonto) {
		this.tipoPonto = tipoPonto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

}
