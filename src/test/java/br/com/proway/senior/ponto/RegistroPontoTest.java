package br.com.proway.senior.controle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RegistroPontoTest {
	
	@Test
	public void testeInsereUsuario() {
		String resultado = RegistroPonto.inserirUsuario();		
		assertEquals("1234", resultado);
	}
	
	@Test
	public void testeHoraEntrada() {
		String horaEntrada = RegistroPonto.horaEntrada();		
		assertEquals("2021-04-13T08:00", horaEntrada);
	}
	
	@Test
	public void testeSaidaAlmoco() {
		String saidaAlmoco = RegistroPonto.saidaAlmoco();
		assertEquals("2021-04-13T12:00", saidaAlmoco);
	}
	
	@Test
	public void testeRetornoAlmoco() {
		String retornoAlmoco = RegistroPonto.retornoAlmoco();		
		assertEquals("2021-04-13T13:00", retornoAlmoco);
	}
	
	@Test
	public void testeHoraSaida() {
		String horaSaida = RegistroPonto.horaSaida();
		assertEquals("2021-04-13T18:00", horaSaida);
	}
	
	@Test
	public void testeNaoBateuHoraSaida() {
		
		String entrada = RegistroPonto.horaEntrada();
		String saidaAlmoco = null;
		String retornoAlmoco = null;
		String saida = null;
		
	 	String saidaNaoRegistrada = RegistroPonto.validacaoHorasNotificacao(entrada, saidaAlmoco, retornoAlmoco, saida);
		assertEquals("Você não bateu o seu registro de saída", saidaNaoRegistrada);
	}
	
	@Test
	public void testeDadosCompletos() {
		
		String entrada = RegistroPonto.horaEntrada();
		String saidaAlmoco = RegistroPonto.saidaAlmoco();
		String retornoAlmoco = RegistroPonto.retornoAlmoco();
		String saida = RegistroPonto.horaSaida();
		
	 	String dadosRetornados = RegistroPonto.validacaoHorasNotificacao(entrada, saidaAlmoco, retornoAlmoco, saida);
		assertEquals("Cálculo de horas foi feito com sucesso!", dadosRetornados);
		
	}
	
}
