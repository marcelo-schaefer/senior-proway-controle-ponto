package br.com.proway.senior.ponto;

import static org.junit.Assert.*;

import org.junit.Test;

public class NotificacoesTest {
	Notificacoes Notificator = new Notificacoes();
	@Test
	public void enviarNotificacao() {
		String dummy = "123456";
		String msg = "It's alive!";
		boolean succ = Notificator.enviarNotificacao(dummy, msg);
		assertTrue(succ);
	}
	
	@Test
	public void falharNotificacao() {
		String dummy = "";
		String msg = "";
		boolean succ = Notificator.enviarNotificacao(dummy, msg);
		assertFalse(succ);
	}
	
	@Test
	public void validarUsuario() {
		String dummy = "Tester Testerson";
		boolean succ = Notificacoes.checarDestinatario(dummy);
		assertTrue(succ);
	}
	
	@Test
	public void invalidarUsuario() {
		String dummy = "Jan Michael Vincent";
		boolean succ = Notificacoes.checarDestinatario(dummy);
		assertFalse(succ);
	}
	
	@Test
	public void validarMensagem() {
		String dummy = "Is this real life? Is it just fantasy?";
		boolean succ = Notificacoes.checarValidadeMensagem(dummy);
		assertTrue(succ);
	}
	
	@Test
	public void invalidarMensagemVazia() {
		String dummy = "";
		boolean succ = Notificacoes.checarValidadeMensagem(dummy);
		assertFalse(succ);
	}
	
	@Test
	public void invalidarMensagemGrandeDemais() {
		String dummy = ".";
		for(int i = 0; i< (Notificacoes.MAX_MESSAGE_LENGTH + 1) ; i++) {
			dummy+="w";
		}
		boolean succ = Notificacoes.checarValidadeMensagem(dummy);
		assertFalse(succ);
	}

}
