package br.com.proway.senior.ponto.camadaLogica;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;

import br.com.proway.senior.ponto.camadaEntidade.Pessoa;

public class NotificacaoLogicaTest {

	@Test
	public void testeChecarValidadeMensagem() {
		Pessoa entidadePessoa = new Pessoa();
		NotificacaoLogica minhaClasse = new NotificacaoLogica(entidadePessoa);
		
		ArrayList<String> teste = new ArrayList<String>();
		entidadePessoa.setMensagens(teste);

		assertTrue(minhaClasse.checarValidadeMensagem("Teste1", entidadePessoa));
	}
	
	@Test
	public void testeConsultarNotificacaoPorPessoa() {
		Pessoa entidadePessoa = new Pessoa();
		NotificacaoLogica minhaClasse = new NotificacaoLogica(entidadePessoa);
		
		ArrayList<String> teste = new ArrayList<String>();
		teste.add("asd");
		entidadePessoa.setMensagens(teste);
	
		assertEquals(entidadePessoa.getMensagens(), minhaClasse.consultarNotificacaoPorPessoa(entidadePessoa));
	}
	
	@Test
	public void testeChecarDestinatario() {
		Pessoa entidadePessoa = new Pessoa();
		NotificacaoLogica minhaClasse = new NotificacaoLogica(entidadePessoa);
		
		entidadePessoa.setId(1);
		
		assertEquals(true, minhaClasse.checarDestinatario(entidadePessoa));
	}
	
	@Test
	public void testeEnviarNotificacao() {
		Pessoa entidadePessoa = new Pessoa();
		NotificacaoLogica minhaClasse = new NotificacaoLogica(entidadePessoa);
		
		entidadePessoa.setId(1);
		/*ArrayList<String> lista = new ArrayList<String>();
		lista.add("aa");
		entidadePessoa.setMensagens(lista);*/
		minhaClasse.checarDestinatario(entidadePessoa);
		minhaClasse.checarValidadeMensagem("hjh", entidadePessoa);
		
		assertTrue(minhaClasse.enviarNotificacao(entidadePessoa, "gh"));
	}
}
