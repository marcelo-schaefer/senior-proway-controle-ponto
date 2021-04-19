package br.com.proway.senior.ponto.camadaLogica;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.proway.senior.ponto.camadaEntidade.Justificativa;
import br.com.proway.senior.ponto.camadaEntidade.StatusJustificativa;
import br.com.proway.senior.ponto.camadaEntidade.StatusJustificativaTest;

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
		
		@Test
		public void testConsultaJustificativa() {
			Justificativa objetoJustificativa = new Justificativa();
			JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);

			minhaJustificativa.entidadeJustificativa.setId(1);
			minhaJustificativa.entidadeJustificativa.setData("16/04/2020");
			minhaJustificativa.entidadeJustificativa.setMsg("Teste mensagem");
			minhaJustificativa.entidadeJustificativa.setImg("Teste imagem");
			StatusJustificativa statusTest = StatusJustificativa.PENDENTE;
			minhaJustificativa.entidadeJustificativa.setStatus(statusTest);
			ArrayList<Justificativa> testeArray = new ArrayList<Justificativa>();
			testeArray.add(minhaJustificativa.entidadeJustificativa);
			
			String infoIdTest = "1";
			String infoDataTest = "16/04/2020";
			String infoMsgTest = "Teste mensagem";		//Pré-definição de dados para teste de retorno de método
			String infoDataImg = "Teste imagem";
			String infoStatusTest = "PENDENTE";
			
			ArrayList<String> dadosRecebidos = new ArrayList<String>();
			dadosRecebidos.add(infoIdTest+" "+infoDataTest + " " + infoMsgTest + " " + infoDataImg +" "+infoStatusTest);
			
			minhaJustificativa.cadastrarJustificativa(objetoJustificativa);
			assertEquals(dadosRecebidos, minhaJustificativa.consultaJustificativaPessoa(testeArray));
		}
}
