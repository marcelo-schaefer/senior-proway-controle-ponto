package br.com.proway.senior.ponto.camadaEntidade;

import java.util.ArrayList;

public class HistoricoMensal<T> {
	private ArrayList<T> objetos;
	private int ano;
	private int mes;
	
	public HistoricoMensal(T novoObjeto) {
		this.objetos = new ArrayList<T>();
		objetos.add(novoObjeto);
	}

	public HistoricoMensal() {
		this.objetos = new ArrayList<T>();
	}
	
	public HistoricoMensal(ArrayList<T> objetos, int ano, int mes) {
		super();
		this.objetos = objetos;
		this.ano = ano;
		this.mes = mes;
	}

	public ArrayList<T> getObjetos() {
		return objetos;
	}

	public void setObjetos(ArrayList<T> objetos) {
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
