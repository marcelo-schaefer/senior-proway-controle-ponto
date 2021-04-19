package test.java.br.com.proway.senior.ponto.camadaLogica;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import main.java.br.com.proway.senior.ponto.camadaEntidade.*;
import main.java.br.com.proway.senior.ponto.camadaLogica.JustificativaLogica;


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
		public void testConsultaJustificativaIdPessoa() {
			Justificativa objetoJustificativa = new Justificativa();
			JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);		
			ArrayList<Justificativa> testeArray = new ArrayList<Justificativa>(); 				
			
			StatusJustificativa statusTest = StatusJustificativa.PENDENTE;
			StatusJustificativa statusTest2 = StatusJustificativa.APROVADO;
			
			minhaJustificativa.entidadeJustificativa.setId(1);
			minhaJustificativa.entidadeJustificativa.setData("16/04/2020");
			minhaJustificativa.entidadeJustificativa.setMsg("Teste mensagem");
			minhaJustificativa.entidadeJustificativa.setImg("Teste imagem");			
			minhaJustificativa.entidadeJustificativa.setStatus(statusTest);
			
			testeArray.add(minhaJustificativa.entidadeJustificativa); 				
			
			Justificativa objetoJustificativa2 = new Justificativa();
			JustificativaLogica minhaJustificativa2 = new JustificativaLogica(objetoJustificativa2);
			
			minhaJustificativa2.entidadeJustificativa.setId(2);
			minhaJustificativa2.entidadeJustificativa.setData("17/04/2020");
			minhaJustificativa2.entidadeJustificativa.setMsg("Teste mensagem2");	
			minhaJustificativa2.entidadeJustificativa.setImg("Teste imagem2");
			minhaJustificativa2.entidadeJustificativa.setStatus(statusTest2);
			
			testeArray.add(minhaJustificativa2.entidadeJustificativa);
			
			String infoIdTest = "2";
			String infoDataTest = "17/04/2020";
			String infoMsgTest = "Teste mensagem2";	
			String infoDataImg = "Teste imagem2";
			String infoStatusTest = "APROVADO";
			
			ArrayList<String> dadosRecebidos = new ArrayList<String>();
			dadosRecebidos.add(infoIdTest+" "+infoDataTest + " " + infoMsgTest + " " + infoDataImg +" "+infoStatusTest); 
			
			minhaJustificativa.cadastrarJustificativa(objetoJustificativa);
			assertEquals(dadosRecebidos, minhaJustificativa.consultaJustificativaPessoa(testeArray));
		}
		
		@Test
		public void testConsultaJustificativaVazio() {
			Justificativa objetoJustificativa = new Justificativa();
			JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);		
			ArrayList<Justificativa> testeArray = new ArrayList<Justificativa>(); 
			
			StatusJustificativa statusTest = StatusJustificativa.PENDENTE;
		
			minhaJustificativa.entidadeJustificativa.setId(1);
			minhaJustificativa.entidadeJustificativa.setData("16/04/2020");
			minhaJustificativa.entidadeJustificativa.setMsg("Teste mensagem");
			minhaJustificativa.entidadeJustificativa.setImg("Teste imagem");
			minhaJustificativa.entidadeJustificativa.setStatus(statusTest);
			
			testeArray.add(minhaJustificativa.entidadeJustificativa); 
			
			String infoIdTest = "2";
			String infoDataTest = "17/04/2020";
			String infoMsgTest = "Teste mensagem2";	
			String infoDataImg = "Teste imagem2";
			String infoStatusTest = "APROVADO";
			
			ArrayList<String> dadosRecebidos = new ArrayList<String>();
			dadosRecebidos.add(infoIdTest+" "+infoDataTest + " " + infoMsgTest + " " + infoDataImg +" "+infoStatusTest); 
			
			minhaJustificativa.cadastrarJustificativa(objetoJustificativa);
			assertNotEquals(dadosRecebidos, minhaJustificativa.consultaJustificativaPessoa(testeArray));
		}
		
		@Test
		public void testConsultaJustificativaStatus() {
			Justificativa objetoJustificativa = new Justificativa();
			JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);		
			ArrayList<Justificativa> testeArray = new ArrayList<Justificativa>(); 				
			
			StatusJustificativa statusTest = StatusJustificativa.PENDENTE;
			StatusJustificativa statusTest2 = StatusJustificativa.APROVADO;
			
			minhaJustificativa.entidadeJustificativa.setId(1);
			minhaJustificativa.entidadeJustificativa.setData("16/04/2020");
			minhaJustificativa.entidadeJustificativa.setMsg("Teste mensagem");
			minhaJustificativa.entidadeJustificativa.setImg("Teste imagem");			
			minhaJustificativa.entidadeJustificativa.setStatus(statusTest);
			
			testeArray.add(minhaJustificativa.entidadeJustificativa); 				
			
			Justificativa objetoJustificativa2 = new Justificativa();
			JustificativaLogica minhaJustificativa2 = new JustificativaLogica(objetoJustificativa2);	
			
			minhaJustificativa2.entidadeJustificativa.setId(2);
			minhaJustificativa2.entidadeJustificativa.setData("17/04/2020");
			minhaJustificativa2.entidadeJustificativa.setMsg("Teste mensagem2");	
			minhaJustificativa2.entidadeJustificativa.setImg("Teste imagem2");
			minhaJustificativa2.entidadeJustificativa.setStatus(statusTest2);
			
			testeArray.add(minhaJustificativa2.entidadeJustificativa);			
			
			String infoIdTest = "2";
			String infoDataTest = "17/04/2020";
			String infoMsgTest = "Teste mensagem2";	
			String infoDataImg = "Teste imagem2";
			String infoStatusTest = "APROVADO";
			
			ArrayList<String> dadosRecebidos = new ArrayList<String>();
			dadosRecebidos.add(infoIdTest+" "+infoDataTest + " " + infoMsgTest + " " + infoDataImg +" "+infoStatusTest); 
			
			minhaJustificativa.cadastrarJustificativa(objetoJustificativa);
			assertEquals(dadosRecebidos, minhaJustificativa.consultaJustificativaStatus(testeArray));
		}
}
