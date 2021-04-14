package ponto;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.proway.senior.ponto.VerificacaoSenhaBancoDeDados;

public class VerificacaoSenhaBancoDeDadosTest {

	@Test
	public void testVerificacaoSenhaCerta() {
		VerificacaoSenhaBancoDeDados classe = new VerificacaoSenhaBancoDeDados();

		int i = 123;
		boolean retorno = classe.verificacaoSenhaBancoDeDados(i);
		assertEquals(true, retorno);
	}
	
	@Test
	public void testVerificacaoSenhaErrada() {
		VerificacaoSenhaBancoDeDados classe = new VerificacaoSenhaBancoDeDados();

		int i = 458;
		boolean retorno = classe.verificacaoSenhaBancoDeDados(i);
		assertEquals(false, retorno);
	}

}
