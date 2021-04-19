package br.com.proway.senior.ponto.camadaEntidade;

import java.util.List;

public class HistoricoMensal<T> {
	private List<T> objetos;
	private int ano;
	private int mes;

	public HistoricoMensal(List<T> objetos, int ano, int mes) {
		super();
		this.objetos = objetos;
		this.ano = ano;
		this.mes = mes;
	}

	public List<T> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<T> objetos) {
		this.objetos = objetos;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	
}
