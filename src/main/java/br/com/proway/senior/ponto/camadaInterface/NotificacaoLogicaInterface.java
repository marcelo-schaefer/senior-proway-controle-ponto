package br.com.proway.senior.ponto.camadaInterface;

import java.util.ArrayList;

import br.com.proway.senior.ponto.camadaEntidade.Colaborador;
import br.com.proway.senior.ponto.camadaEntidade.Notificacao;

public interface NotificacaoLogicaInterface {
	public ArrayList<Colaborador> retornaColaboradoresASeremNotificados(ArrayList<Colaborador> listaColaborador);
	
	public Notificacao enviarNotificacao(Integer idDestinatario, String mensagem);
	
	public boolean validarMensagem(String mensagem);
	
	public Colaborador validarDestinatario(Integer id);
	
}
