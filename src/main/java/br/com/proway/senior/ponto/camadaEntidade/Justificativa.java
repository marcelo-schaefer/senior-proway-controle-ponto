package br.com.proway.senior.ponto.camadaEntidade;

import java.util.ArrayList;

public class Justificativa {
	private Integer id;
	private String data;
	private String msg;
	private String img;
	
	private ArrayList<String> dados = new ArrayList<String>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public ArrayList<String> getDados() {
		return dados;
	}

	public void setDados(ArrayList<String> dados) {
		this.dados = dados;
	}
	
	
	
}
