package ferramentas;

import java.time.Duration;

public class CalculoHorasTrabalhadasEmMinutos {

	/**
	 * Calcular minutos trabalhados
	 * 
	 * o metodo recebe duas duracoes, pega em minutos as duas, passa para long, soma
	 * as duas e passa para double
	 * 
	 * @param Duration primeiraParte, duração entre o primeiro ponto e o segundo
	 * @param Duration segundaParte, duração entre o terceiro ponto e o quarto
	 * @return double minutos, soma das duracoes das duas etapas
	 */

	public double calculoHorasTrabalhadas(Duration fhirtTime, Duration secondTime) {

		long i = fhirtTime.toMinutes();
		long j = secondTime.toMinutes();
		long junsao = i + j;
		double minuto = junsao;
		if (minuto > 690) {
			// puxa o metodo de notificacao
			minuto = 690;
		}
		return minuto;
	}
}
