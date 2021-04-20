package br.com.proway.senior.ponto.camadaLogica;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import br.com.proway.senior.ponto.camadaEntidade.Pessoa;

public class NotificacaoLogicaTest {
	
	@Test
	public void testeChecarDestinatario() {
		Pessoa entidadePessoa = new Pessoa();
		NotificacaoLogica minhaClasse = new NotificacaoLogica(entidadePessoa);
		
		entidadePessoa.setId(1);
		
		assertEquals(true, minhaClasse.checarDestinatario(entidadePessoa, 1));
	}
	
	@Test
	public void testeChecarValidadeMensagem() {
		Pessoa entidadePessoa = new Pessoa();
		NotificacaoLogica minhaClasse = new NotificacaoLogica(entidadePessoa);

		assertTrue(minhaClasse.checarValidadeMensagem("Mensagem"));
	}
	
	@Test
	public void testeConsultarNotificacaoPorPessoa() {
		Pessoa entidadePessoa = new Pessoa();
		NotificacaoLogica minhaClasse = new NotificacaoLogica(entidadePessoa);
		
		entidadePessoa.setId(1);
		
		ArrayList<String> teste = new ArrayList<String>();
		teste.add("Teste");
		teste.add("Alô");
		teste.add("Teste");
		entidadePessoa.setMensagens(teste);
		
		assertEquals(entidadePessoa.getMensagens(), minhaClasse.consultarNotificacaoPorPessoa(entidadePessoa, 1));
	}
	
	@Test
	public void testeEnviarNotificacao() {
		Pessoa entidadePessoa = new Pessoa();
		NotificacaoLogica minhaClasse = new NotificacaoLogica(entidadePessoa);
		
		entidadePessoa.setId(1);
		ArrayList<String> listaTeste = new ArrayList<String>();
		entidadePessoa.setMensagens(listaTeste);
		
		assertTrue(minhaClasse.enviarNotificacao(entidadePessoa, "Mensagem", 1));
	}
}
