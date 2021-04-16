package br.com.proway.senior.ponto.camadaLogica;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.proway.senior.ponto.camadaEntidade.Justificativa;
import br.com.proway.senior.ponto.camadaEntidade.StatusJustificativa;

public class JustificativaLogicaTest {

		@Test
		public void testConstrutor() {
		Justificativa objetoJustificativa = new Justificativa();
		objetoJustificativa.setMsg("Teste construtor");
		JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);
		
		assertEquals("Teste construtor",minhaJustificativa.entidadeJustificativa.getMsg());
		}
		@Test
		public void testVerificaDataFutura() {
			Justificativa objetoJustificativa = new Justificativa();
			JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);
			minhaJustificativa.entidadeJustificativa.setData("31/02/2031");
			assertFalse(minhaJustificativa.verificaData(objetoJustificativa));
			
			
		}
		@Test
		public void testVerificaDataTraco() {
			Justificativa objetoJustificativa = new Justificativa();
			JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);
			minhaJustificativa.entidadeJustificativa.setData("31-02/2031");
			assertFalse(minhaJustificativa.verificaData(objetoJustificativa));
			
		}
		@Test
		public void testVerificaData() {
			Justificativa objetoJustificativa = new Justificativa();
			JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);
			minhaJustificativa.entidadeJustificativa.setData("16/04/2020");
			assertTrue(minhaJustificativa.verificaData(objetoJustificativa));
			
		}
		
		@Test
		public void testVerificaMsg() {
			Justificativa objetoJustificativa = new Justificativa();
			JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);
			minhaJustificativa.entidadeJustificativa.setMsg("Teste Mensagem");
			assertTrue(minhaJustificativa.verificaMensagem(objetoJustificativa));
		}
		
		@Test
		public void testVerificaImagem(){
			Justificativa objetoJustificativa = new Justificativa();
			JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);
			minhaJustificativa.entidadeJustificativa.setImg("Teste imagem");
			assertTrue(minhaJustificativa.verificaImagem(objetoJustificativa));
		}
		@Test
		public void testEnviarJustificativa(){
			Justificativa objetoJustificativa = new Justificativa();
			JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);
			minhaJustificativa.entidadeJustificativa.setData("16/04/2020");
			minhaJustificativa.entidadeJustificativa.setMsg("Teste mensagem");
			minhaJustificativa.entidadeJustificativa.setImg("Teste imagem");
			assertTrue(minhaJustificativa.verificaImagem(objetoJustificativa));
		}
	
}
