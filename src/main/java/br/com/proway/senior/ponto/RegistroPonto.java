package br.com.proway.senior.ponto;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroPonto {

	public static void main(String[] args) throws UnknownHostException {
		insereUsuario();
		horaEntrada();
		saidaAlmoco();
		retornoAlmoco();
		horaSaida();
		validacaoHorasNotificacao(horaEntrada(), saidaAlmoco(), retornoAlmoco(), horaSaida());
		ipLocalNomeMaquina();
	}

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	static LocalDateTime entrada;
	static LocalDateTime saida;
	static LocalDateTime horaSaidaAlmoco;
	static LocalDateTime horaRetornoAlmoco;
	static int chDia = 8;
	static int horaAlmoco = 1;

	static String usuario = "1234";

	static String insereUsuario() {
		return usuario;
	}

	/**
	 * Registra hora de entrada
	 * 
	 * Este m�todo insere uma hora de entrada logo que o usu�rio insere o seu cart�o
	 * de identifica��o no aparelho identificador
	 * 
	 * @return valor da hora em que se bate o ponto
	 */
	static String horaEntrada() {
		entrada = LocalDateTime.of(2021, 4, 13, 8, 00, 00); // Data/hora est�ticos entrada
		System.out.println(entrada);
		String horarioEntFormatado = entrada.toString();
		// System.out.println("Hor�rio de entrada: " + entrada.format(formatter) +
		// "\n");
		return horarioEntFormatado;
	}

	/**
	 * Registra o hor�rio de sa�da da empresa para o almo�o
	 * 
	 * Este m�todo insere uma hora de sa�da logo que o usu�rio insere o seu cart�o
	 * de identifica��o no aparelho identificador ao sair da empresa para o almo�o
	 * 
	 * @return valor da hora em que se bate o ponto na sa�da
	 */
	static String saidaAlmoco() {
		horaSaidaAlmoco = LocalDateTime.of(2021, 4, 13, 12, 00, 00); // Data/hora est�ticos entrada
		System.out.println(horaSaidaAlmoco);
		String horaSaidaAlmocoForm = horaSaidaAlmoco.toString();
		return horaSaidaAlmocoForm;
	}

	static String retornoAlmoco() {
		horaRetornoAlmoco = LocalDateTime.of(2021, 4, 13, 13, 00, 00); // Data/hora est�ticos entrada
		String retornoAlmocoForm = horaRetornoAlmoco.toString();
		return retornoAlmocoForm;
	}

	static String horaSaida() {
		saida = LocalDateTime.of(2021, 4, 13, 18, 00, 00); // Data/hora est�ticos sa�da
		System.out.println(saida);
		// System.out.println("Hor�rio de sa�da: " + saida.format(formatter) + "\n");
		String horaSaidaForm = saida.toString();
		return horaSaidaForm;
	}

//	// salva em lista a hora que bateu o ponto
//	public ArrayList<LocalTime> armazenaHora(int id, LocalTime hora) {
//		ArrayList<LocalTime> horas = new ArrayList<>();
//		horas.add(hora);
//		return horas;
//	}
//	
//	// calcula a quantidade de horas em rela��o aos 4 pontos batidos diariamente e
//		// retorna este valor
//		public LocalDateTime horasTrabalhadas(LocalDateTime entrada, LocalDateTime horaSaidaAlmoco, LocalDateTime horaRetornoAlmoco,
//				LocalDateTime saida) {
//
//			Duration manha = Duration.between(entrada, horaSaidaAlmoco);
//			Duration tarde = Duration.between(horaRetornoAlmoco, saida);
//			long i = manha.toMinutes();
//			long j = tarde.toMinutes();
//			long juncao = i + j;
//			double minuto = juncao;
//			int s = (int) Math.round(minuto * 60);
//			int h = s / 3600;
//			int m = (s - 3600 * h) / 60;
//			s = s % 60;
//
//			LocalDate hoje = LocalDate.now();
//
//			LocalDateTime retorno = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), h, m, s);
//			return retorno;
//
//		}

	static String validacaoHorasNotificacao(String horaEntrada, String saidaAlmoco, String retornoAlmoco,
			String horaSaida) {
		Duration duracao = Duration.ZERO;

		/* Caso o usu�rio tenha esquecido de bater o ponto na sa�da */
		if (horaSaida == null) {
			String faltandoSaida = "Voc� n�o bateu o seu registro de sa�da";
			return faltandoSaida;
		}

		if (horaSaida != null) {

			duracao = Duration.between(entrada, horaSaidaAlmoco);
			System.out.println("Horas manh�: " + duracao.toHours() + "\n");

			duracao = Duration.between(horaRetornoAlmoco, saida);
			System.out.println("Horas tarde: " + duracao.toHours() + "\n");

			duracao = Duration.between(entrada, saida);
			System.out.println("Resultado total de horas no dia: " + (duracao.toHours() - horaAlmoco + "\n"));

			System.out.println("Resultado horas extras/banco de horas: ");
//				System.out.println(duracao.toHours());
//				System.out.println(chDia);
//				System.out.println(horaAlmoco);
			System.out.println(duracao.toHours() - chDia - horaAlmoco + "\n");

			String dadosEntradaSaida = "C�lculo de horas foi feito com sucesso!";
			return dadosEntradaSaida;
		}

		/* Caso o usu�rio bata o ponto consecutivamente (antes dos 5 minutos) */
		if (duracao.toMinutes() < 5 && saida.getHour() != 0) {
			String pontoConsecutivo = "Voc� bateu o ponto consecutivamente";
			return pontoConsecutivo;
		}

		/* Caso o usu�rio tenha batido o ponto antes das 8 horas */
		else if (duracao.toHours() < 8 && saida.getHour() != 0) {
			String horarioIncompleto = "Voc� n�o cumpriu seu hor�rio de trabalho do dia";
			return horarioIncompleto;
		}

		/* Caso o usu�rio tenha cumprido as 8 horas trabalhadas e passado delas */
		else if (duracao.toHours() >= 8) {
			System.out.println("Parab�ns! Voc� cumpriu sua jornada!!" + "\n");

			String horasCompletas = "Parab�ns! Voc� cumpriu sua jornada!!";
			return horasCompletas;
		}
		return null; // Caso n�o acesse nenhum m�todo, ocorreu algum problema
	}

	static void ipLocalNomeMaquina() throws UnknownHostException {
		/* Ip da maquina */
		String ipMaquina = InetAddress.getLocalHost().getHostAddress();
		System.out.println("Ip da maquina: " + ipMaquina + "\n");

		/* Nome da maquina */
		String nomeMaquina = InetAddress.getLocalHost().getHostName();
		System.out.println("Nome da maquina: " + nomeMaquina + "\n");
	}

	// recebe local e como foi feito o ponto, retorna o local de onde foi
	public String localizacaoDoPonto(String localizacao, String formaDoPonto) {
		String local;
		switch (formaDoPonto) {
		case "empresa":
			local = "empresa";
			break;
		default:
			local = localizacao;
			break;
		}
		return local;
	}
}