package br.com.proway.senior.ponto.ferramentas;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

public class CalculoHorasTrabalhadasEmMinutosTest {

	@Test
	public void testCalculoHorasIdeais() {
		CalculoHorasTrabalhadasEmMinutos classe = new CalculoHorasTrabalhadasEmMinutos();

		LocalDate hoje = LocalDate.now();
		LocalDateTime a = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 8, 0);
		LocalDateTime b = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 12, 0);
		LocalDateTime c = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 13, 0);
		LocalDateTime d = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 17, 0);

		Duration i = Duration.between(a, b);
		Duration j = Duration.between(c, d);
		double rest = classe.calculoHorasTrabalhadas(i, j);
		assertEquals(480.0, rest, 0);
	}

	@Test
	public void testCalculoHorasQuebradas() {
		CalculoHorasTrabalhadasEmMinutos classe = new CalculoHorasTrabalhadasEmMinutos();

		LocalDate hoje = LocalDate.now();
		LocalDateTime a = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 7, 48);
		LocalDateTime b = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 12, 12);
		LocalDateTime c = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 13, 55);
		LocalDateTime d = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 17, 34);

		Duration i = Duration.between(a, b);
		Duration j = Duration.between(c, d);
		double rest = classe.calculoHorasTrabalhadas(i, j);
		assertEquals(483.0, rest, 0);
	}

	@Test
	public void testCalculoHorasForaDeOrdem() {
		CalculoHorasTrabalhadasEmMinutos classe = new CalculoHorasTrabalhadasEmMinutos();

		LocalDate hoje = LocalDate.now();
		LocalDateTime a = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 9, 30);
		LocalDateTime b = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 6, 52);
		LocalDateTime c = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 13, 55);
		LocalDateTime d = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 17, 34);

		Duration i = Duration.between(a, b);
		Duration j = Duration.between(c, d);
		double rest = classe.calculoHorasTrabalhadas(i, j);
		assertEquals(61.0, rest, 0);
	}

	@Test
	public void testCalculoHorasDeOutroDia() {
		CalculoHorasTrabalhadasEmMinutos classe = new CalculoHorasTrabalhadasEmMinutos();

		LocalDate hoje = LocalDate.now();
		LocalDateTime a = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 21, 30);
		LocalDateTime b = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 23, 59);
		LocalDateTime c = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), 1 + hoje.getDayOfMonth(), 1, 20);
		LocalDateTime d = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), 1 + hoje.getDayOfMonth(), 7, 14);

		Duration i = Duration.between(a, b);
		Duration j = Duration.between(c, d);
		double rest = classe.calculoHorasTrabalhadas(i, j);
		assertEquals(503.0, rest, 0);
	}

	@Test
	public void testCalculoHorasPassandoDoLimite() {
		CalculoHorasTrabalhadasEmMinutos classe = new CalculoHorasTrabalhadasEmMinutos();

		LocalDate hoje = LocalDate.now();
		LocalDateTime a = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 8, 30);
		LocalDateTime b = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 11, 59);
		LocalDateTime c = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), 13, 20);
		LocalDateTime d = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), 1 + hoje.getDayOfMonth(), 7, 14);

		Duration i = Duration.between(a, b);
		Duration j = Duration.between(c, d);
		double rest = classe.calculoHorasTrabalhadas(i, j);
		assertEquals(690, rest, 0);
	}

}
