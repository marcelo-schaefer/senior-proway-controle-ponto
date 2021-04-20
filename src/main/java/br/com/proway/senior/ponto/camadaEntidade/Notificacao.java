package br.com.proway.senior.ponto.camadaEntidade;

public class Notificacao {
	private Integer id;
	private Integer idDestinatario;
	private String mensagem;
	
	public Notificacao() {
	}

	public Notificacao(Integer id, Integer idDestinatario, String mensagem) {
		this.id = id;
		this.idDestinatario = idDestinatario;
		this.mensagem = mensagem;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdDestinatario() {
		return idDestinatario;
	}
	public void setIdDestinatario(Integer idDestinatario) {
		this.idDestinatario = idDestinatario;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
