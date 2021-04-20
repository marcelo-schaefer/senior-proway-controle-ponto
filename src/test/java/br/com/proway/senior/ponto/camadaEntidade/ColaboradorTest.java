package br.com.proway.senior.ponto.camadaEntidade;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.proway.senior.ponto.camadaLogica.PontoLogica;

public class ColaboradorTest {


	@Test
	public void testSalvarNovoPonto() {
		Colaborador colaborador = new Colaborador(01, 01, false);
		PontoLogica pontoLogica = new PontoLogica();
		Ponto novoPonto = pontoLogica.salvarPonto(TipoDePonto.Web, "Rua Teste 1337", colaborador);
		HistoricoMensal<JornadaDeTrabalho> ultimoHistoricoMensal = colaborador.getJornadas()
				.get(colaborador.getJornadas().size() - 1);
		JornadaDeTrabalho ultimaJornadaDoUltimoHistoricoMensal = ultimoHistoricoMensal.getObjetos()
				.get(ultimoHistoricoMensal.getObjetos().size() - 1);
		Ponto ultimoPonto = ultimaJornadaDoUltimoHistoricoMensal.getPontos()
				.get(ultimaJornadaDoUltimoHistoricoMensal.getPontos().size() - 1);
		assertEquals(ultimoPonto, novoPonto);
	}	

}
