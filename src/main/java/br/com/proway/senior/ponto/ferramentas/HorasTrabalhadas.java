package br.com.proway.senior.ponto.ferramentas;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import ferramentas.CalculoHorasTrabalhadasEmMinutos;

public class HorasTrabalhadas {

	/**
	 * Calcula o tempo trabalhado em horas
	 * 
	 * o metodo ultiliza o metodo calcularHora, o resultado dele � passado como um
	 * LocalDateTime (de ano ate segundos)
	 * 
	 * @param LocalDateTime hora1, horario do primeiro ponto
	 * @param LocalDateTime hora2, horario do segundo ponto
	 * @param LocalDateTime hora3, horario do terceiro ponto
	 * @param LocalDateTime hora4, horario do quarto ponto
	 * @return LocalDateTime retorno, tempo trabalhado
	 */
	public LocalDateTime horasTrabalhadas(LocalDateTime hora1, LocalDateTime hora2, LocalDateTime hora3,
			LocalDateTime hora4) {
		CalculoHorasTrabalhadasEmMinutos classe = new CalculoHorasTrabalhadasEmMinutos();

		Duration manha = Duration.between(hora1, hora2);
		Duration tarde = Duration.between(hora3, hora4);

		double minuto = classe.calculoHorasTrabalhadas(manha, tarde);

		int s = (int) Math.round(minuto * 60);
		int h = s / 3600;
		int m = (s - 3600 * h) / 60;
		s = s % 60;

		LocalDate hoje = LocalDate.now();

		LocalDateTime retorno = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), h, m, s);
		return retorno;

	}
}
