package br.com.proway.senior.teste;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RegistroPonto {

	// salva em lista a hora que bateu o ponto
	public ArrayList<LocalDateTime> armazenaHora(int id, LocalDateTime hora) {
		ArrayList<LocalDateTime> horas = new ArrayList<>();
		horas.add(hora);
		return horas;
	}

	// calcula a quantidade de horas em relação aos 4 pontos batidos diariamente e
	// retorna este valor
	public LocalDateTime horasTrabalhadas(LocalDateTime hora1, LocalDateTime hora2, LocalDateTime hora3,
			LocalDateTime hora4) {
		RegistroPonto classe = new RegistroPonto();

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

	// passa o tempo trabalhado do dia e transforma em minutos, por double, retorna
	// este valor
	public double calculoHorasTrabalhadas(Duration primeiraParte, Duration segundaParte) {

		long i = primeiraParte.toMinutes();
		long j = segundaParte.toMinutes();
		long junsao = i + j;
		double minuto = junsao;

		return minuto;
	}

	// recebe local e como foi feito o ponto, retorna o local de onde foi
	public String localizacaoDoPonto(String localizacao, String formaDoPonto) {
		String local;

		switch (formaDoPonto) {
		case "biometria":
			local = "empresa";
			break;

		case "senha não digital":
			local = "empresa";
			break;

		case "cartao":
			local = "empresa";
			break;

		default:
			local = localizacao;
			break;
		}
		return local;
	}

	// verifica se a impressora possue papel, retorna true ou false
	public boolean retornoImpressora(boolean papel) {
		boolean impressora;
		if (papel) {
			impressora = true;
		} else {
			impressora = false;
		}
		return impressora;
	}

	// confere com a lista de senhas gerais, e retorna se possue ou nao
	public boolean verificacaoSenhaBancoDeDados(Integer senha) {

		boolean contem = false;
		ArrayList<Integer> todasSenhas = new ArrayList<>();
		for (Integer i : todasSenhas) {
			if (i == senha) {
				contem = true;
				break;
			}
		}
		return contem;
	}

	// pega o local time na hora
	public LocalTime horarioDoPonto() {
		LocalTime agora = LocalTime.now();
		return agora;
	}

	public static void main(String[] args) {

		RegistroPonto ponto = new RegistroPonto();
		LocalTime agora = LocalTime.now();
		LocalDateTime hora1 = LocalDateTime.of(2021, 4, 12, 8, 40, 0);
		LocalDateTime hora2 = LocalDateTime.of(2021, 4, 12, 12, 32, 0);
		LocalDateTime hora3 = LocalDateTime.of(2021, 4, 12, 13, 12, 0);
		LocalDateTime hora4 = LocalDateTime.of(2021, 4, 12, 17, 03, 0);

		System.out.println(ponto.horasTrabalhadas(hora1, hora2, hora3, hora4));

	}
}
