package br.com.proway.senior.ponto.camadaEntidade;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pessoa {

	private Integer id;
	private String nome;
	private Integer idTime;
	private boolean ehGerente;
	private ArrayList<ArrayList<LocalDateTime>> listaMes;
	private ArrayList<String> mensagens;
	
	private ArrayList<Pessoa> listaPessoa;//Talvez desnecessária

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdTime() {
		return idTime;
	}

	public void setIdTime(Integer idTime) {
		this.idTime = idTime;
	}

	public boolean isEhGerente() {
		return ehGerente;
	}

	public void setEhGerente(boolean ehGerente) {
		this.ehGerente = ehGerente;
	}

	public ArrayList<ArrayList<LocalDateTime>> getListaMes() {
		return listaMes;
	}

	public void setListaMes(ArrayList<ArrayList<LocalDateTime>> listaMes) {
		this.listaMes = listaMes;
	}

	public ArrayList<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(ArrayList<String> mensagens) {
		this.mensagens = mensagens;
	}

	public ArrayList<Pessoa> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(ArrayList<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}
}
