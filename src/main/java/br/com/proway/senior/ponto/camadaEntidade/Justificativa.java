package br.com.proway.senior.ponto.camadaEntidade;

import java.util.ArrayList;

public class Justificativa {
	private Integer id;
	private String data;
	private String msg;
	private String img;
	private StatusJustificativa status;
	
	
	private ArrayList<String> dados = new ArrayList<String>();

	public Justificativa(Integer id, String data, String msg, String img) {
		this.id = id;
		this.data = data;
		this.msg = msg;
		this.img = img;
	}
	
	public Justificativa() {
	}
	
	@Override
	public String toString() {
		
		return id + " " + data + " " + msg + " " + img + " " + status.toString();
		
	}
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
	
	public StatusJustificativa getStatus() {
		return status;
	}

	public void setStatus(StatusJustificativa status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Justificativa other = (Justificativa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
