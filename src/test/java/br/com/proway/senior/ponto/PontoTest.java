package br.com.proway.senior.ponto;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class MainTest {
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	@Test
	public void testeInsereUsuario() {
		String resultado = RegistroPonto.insereUsuario();		
		assertEquals("1234", resultado);
	}
	
	@Test
	public void testeHoraEntrada() {
		String horaEntrada = RegistroPonto.horaEntrada();
		assertEquals("13/04/2021 08:00:00", horaEntrada);
	}
	
	@Test
	public void testeSaidaAlmoco() {
		LocalDateTime saidaAlmoco = RegistroPonto.saidaAlmoco();
		
		String horarioFormatado = saidaAlmoco.format(formatter);
		assertEquals("13/04/2021 12:00:00", saidaAlmoco);
	}
	
	@Test
	public void testeRetornoAlmoco() {
		
		String retornoAlmoco = RegistroPonto.retornoAlmoco();		
		assertEquals("13/04/2021 13:00:00", retornoAlmoco);
	}
	
	@Test
	public void testeHoraSaida() {
		String horaSaida = RegistroPonto.horaSaida();
		assertEquals("13/04/2021 18:00:00", horaSaida);
	}
	
//	@Test
//	public void testeNaoBateuHoraSaida() {
//		
//		String entrada = RegistroPonto.horaEntrada();
//		String saida = null;
//		
//	 	String saidaNaoRegistrada = RegistroPonto.validacaoHorasNotificacao(entrada, saida);
//		assertEquals("Você não bateu o seu registro de saída", saidaNaoRegistrada);
//	}
	
	@Test
	public void testeDadosCompletos() {
		
		String entrada = RegistroPonto.horaEntrada();
		String saidaAlmoco = RegistroPonto.saidaAlmoco();
		String retornoAlmoco = RegistroPonto.retornoAlmoco();
		String saida = RegistroPonto.horaSaida();
		
	 	String dadosRetornados = RegistroPonto.validacaoHorasNotificacao(entrada, saidaAlmoco, retornoAlmoco, saida);
		assertEquals("Cálculo de horas foi feito com sucesso!", dadosRetornados);
		
	}
	
	//Continuar
	public void teste() {
		
		String entrada = RegistroPonto.horaEntrada();
		String saidaAlmoco = RegistroPonto.saidaAlmoco();
		String retornoAlmoco = RegistroPonto.retornoAlmoco();
		String saida = RegistroPonto.horaSaida();
		
	 	String dadosRetornados = RegistroPonto.validacaoHorasNotificacao(entrada, saidaAlmoco, retornoAlmoco, saida);
		assertEquals("Cálculo de horas foi feito com sucesso!", dadosRetornados);
		
	}
	
}























