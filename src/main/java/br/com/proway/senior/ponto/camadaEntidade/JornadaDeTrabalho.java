package br.com.proway.senior.ponto.camadaEntidade;

import java.util.ArrayList;

public class JornadaDeTrabalho {
	private ArrayList<Ponto> pontos;
	
	public JornadaDeTrabalho() {
		super();
		this.pontos = new ArrayList<Ponto>();
	}

	public ArrayList<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(ArrayList<Ponto> pontos) {
		this.pontos = pontos;
	}
	
	public void addPonto(Ponto ponto) {
		pontos.add(ponto);
	}
	
	
}
