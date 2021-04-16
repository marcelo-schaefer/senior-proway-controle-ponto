package br.com.proway.senior.ponto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.proway.senior.ponto.ferramentas.LocalizadorParaPonto;

public class LocalizadorParaPontoTest {

	@Test
	public void localizadorBiometria() {
		LocalizadorParaPonto classe = new LocalizadorParaPonto();

		String localizacao = "rua 7, 1749";
		String formaPonto = "biometria";

		String rest = classe.localizacaoDoPonto(localizacao, formaPonto);
		assertEquals("empresa", rest);
	}

	@Test
	public void localizadorSenhaNaoDigital() {
		LocalizadorParaPonto classe = new LocalizadorParaPonto();

		String localizacao = "rua 7, 1749";
		String formaPonto = "senha nao digital";

		String rest = classe.localizacaoDoPonto(localizacao, formaPonto);
		assertEquals("empresa", rest);
	}

	@Test
	public void localizadorCartao() {
		LocalizadorParaPonto classe = new LocalizadorParaPonto();

		String localizacao = "rua 7, 1749";
		String formaPonto = "cartao";

		String rest = classe.localizacaoDoPonto(localizacao, formaPonto);
		assertEquals("empresa", rest);
	}

	@Test
	public void localizadorRemoto() {
		LocalizadorParaPonto classe = new LocalizadorParaPonto();

		String localizacao = "rua 15, 472";
		String formaPonto = "aplicativo";

		classe.localizacaoDoPonto(localizacao, formaPonto);
		String rest = classe.localizacaoDoPonto(localizacao, formaPonto);
		assertEquals("rua 15, 472", rest);

	}
	@Test
	public void localizadorWeb() {
		LocalizadorParaPonto classe = new LocalizadorParaPonto();

		String localizacao = "rua 15, 472";
		String formaPonto = "web";

		classe.localizacaoDoPonto(localizacao, formaPonto);
		String rest = classe.localizacaoDoPonto(localizacao, formaPonto);
		assertEquals("rua 15, 472", rest);

	}
}
