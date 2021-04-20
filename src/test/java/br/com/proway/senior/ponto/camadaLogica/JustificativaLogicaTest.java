package br.com.proway.senior.ponto.camadaLogica;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import br.com.proway.senior.ponto.camadaEntidade.*;
import br.com.proway.senior.ponto.camadaLogica.JustificativaLogica;


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
		public void testCriaEVerificaJustificativa(){
			JustificativaLogica minhaJustificativa = new JustificativaLogica();
			Justificativa objetoJustificativa2 = new Justificativa(1, "16/04/2020", "Teste mensagem", "Teste imagem");
			assertEquals(objetoJustificativa2,minhaJustificativa.criaEVerificaJustificativa(1, "16/04/2020", "Teste mensagem", "Teste imagem"));
		}
		
		@Test
		public void testSalvaJustificativaNoHistorico() {
			Justificativa objetoJustificativa = new Justificativa(5, "11/04/2021", "Teste mensagem", "Teste imagem");
			JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);
			Colaborador colaboradorTest = new Colaborador(1, 1, false);
			colaboradorTest.setId(5);
			colaboradorTest.setNome("Pessoa Test");
			ArrayList<HistoricoMensal<Justificativa>> historicoTest = minhaJustificativa.salvarJustificativa(objetoJustificativa, colaboradorTest);
			ArrayList<Justificativa> justTest = historicoTest.get(historicoTest.size()-1).getObjetos();
			assertEquals(objetoJustificativa, justTest.get(justTest.size()-1));
			
			
		}
		
		@Test
		public void testConsultaJustificativaIdPessoa() {
			Justificativa objetoJustificativa = new Justificativa(1, "16/04/2020", "Teste mensagem", "Teste imagem");
			JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);		
			ArrayList<Justificativa> testeArray = new ArrayList<Justificativa>(); 				
			
			StatusJustificativa statusTest = StatusJustificativa.PENDENTE;
			StatusJustificativa statusTest2 = StatusJustificativa.APROVADO;
						
			minhaJustificativa.entidadeJustificativa.setStatus(statusTest);
			
			testeArray.add(minhaJustificativa.entidadeJustificativa); 				
			
			Justificativa objetoJustificativa2 = new Justificativa(2, "17/04/2020", "Teste mensagem2", "Teste imagem2");
			JustificativaLogica minhaJustificativa2 = new JustificativaLogica(objetoJustificativa2);
			
			minhaJustificativa2.entidadeJustificativa.setStatus(statusTest2);
			
			testeArray.add(minhaJustificativa2.entidadeJustificativa);
			
			String dadosTest = "2 17/04/2020 Teste mensagem2 Teste imagem2 APROVADO";
			
			ArrayList<String> dadosRecebidos = new ArrayList<String>();
			dadosRecebidos.add(dadosTest); 
			
			assertEquals(dadosRecebidos, minhaJustificativa.consultaJustificativaPessoa(testeArray, 2));
		}
		
		@Test
		public void testConsultaJustificativaVazio() {
			Justificativa objetoJustificativa = new Justificativa(1, "16/04/2020", "Teste mensagem", "Teste imagem");
			JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);		
			ArrayList<Justificativa> testeArray = new ArrayList<Justificativa>(); 
			
			StatusJustificativa statusTest = StatusJustificativa.PENDENTE;

			minhaJustificativa.entidadeJustificativa.setStatus(statusTest);
			
			testeArray.add(minhaJustificativa.entidadeJustificativa); 
			
			String dadosTest = "2 17/04/2020 Teste mensagem2 Teste imagem2 APROVADO";
			
			ArrayList<String> dadosRecebidos = new ArrayList<String>();
			dadosRecebidos.add(dadosTest); 
			
			assertNotEquals(dadosRecebidos, minhaJustificativa.consultaJustificativaPessoa(testeArray, 2));
		}
		
		@Test
		public void testConsultaJustificativaStatus() {
			Justificativa objetoJustificativa = new Justificativa(1, "16/04/2020", "Teste mensagem", "Teste imagem");
			JustificativaLogica minhaJustificativa = new JustificativaLogica(objetoJustificativa);		
			ArrayList<Justificativa> testeArray = new ArrayList<Justificativa>(); 				
			
			StatusJustificativa statusTest = StatusJustificativa.PENDENTE;
			StatusJustificativa statusTest2 = StatusJustificativa.APROVADO;
		
			minhaJustificativa.entidadeJustificativa.setStatus(statusTest);
			
			testeArray.add(minhaJustificativa.entidadeJustificativa); 				
			
			Justificativa objetoJustificativa2 = new Justificativa(2, "17/04/2020", "Teste mensagem2", "Teste imagem2");
			JustificativaLogica minhaJustificativa2 = new JustificativaLogica(objetoJustificativa2);	
		
			minhaJustificativa2.entidadeJustificativa.setStatus(statusTest2);
			
			testeArray.add(minhaJustificativa2.entidadeJustificativa);			
			
			String dadosTest = "2 17/04/2020 Teste mensagem2 Teste imagem2 APROVADO";
			
			ArrayList<String> dadosRecebidos = new ArrayList<String>();
			dadosRecebidos.add(dadosTest); 
	
			assertEquals(dadosRecebidos, minhaJustificativa.consultaJustificativaStatus(testeArray, "aprovado"));
		}
}
