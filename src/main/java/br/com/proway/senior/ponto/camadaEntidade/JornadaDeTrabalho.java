package br.com.proway.senior.ponto.camadaEntidade;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class JornadaDeTrabalho {
	private ArrayList<Ponto> pontos;

	private int horas;
	private int minutos;
	private int segundos;
	
	public JornadaDeTrabalho() {
		super();
		this.pontos = new ArrayList<Ponto>();
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
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
