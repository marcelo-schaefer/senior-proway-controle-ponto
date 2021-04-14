package br.com.proway.senior.ponto;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroPonto {

	/**
	 O método de validaçãoHours Notifificacao foi incorporado nos outros métodos para a realização dos testes,
	 * por essa razão tem os 4 principais métodos comentados.
	 * 
	 */
	public static void main(String[] args) throws UnknownHostException {
		inserirUsuario();
//		horaEntrada();
//		saidaAlmoco();
//		retornoAlmoco();
//		horaSaida();
		validacaoHorasNotificacao(horaEntrada(), saidaAlmoco(), retornoAlmoco(), horaSaida());
		ipLocalNomeMaquina();
	}

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	static LocalDateTime entrada;
	static LocalDateTime saida;
	static LocalDateTime horaSaidaAlmoco;
	static LocalDateTime horaRetornoAlmoco;
	static Duration duracao = Duration.ZERO;
	static int chDia = 8;
	static int horaAlmoco = 1;

	static String usuario = "1234";

	static String inserirUsuario() {
		System.out.println("Usuário: " + usuario);
		return usuario;
	}

	/**
	 * Registra hora de entrada
	 * 
	 * Este método insere uma hora de entrada logo que o usuário insere o seu cartão
	 * de identificação no aparelho identificador
	 * 
	 * @return valor da hora em que se bate o ponto
	 */
	static String horaEntrada() {
		entrada = LocalDateTime.of(2021, 4, 13, 8, 00, 00); // Data/hora estáticos entrada
		System.out.println("Registro Entrada: " + entrada);
		String horarioEntFormatado = entrada.toString();
		return horarioEntFormatado;
	}

	/**
	 * Registra o horário de saída da empresa para o almoço
	 * 
	 * Este método insere uma hora de saída logo que o usuário insere o seu cartão
	 * de identificação no aparelho identificador ao sair da empresa para o almoço
	 * 
	 * @return valor da hora em que se bate o ponto na saída
	 */
	static String saidaAlmoco() {
		horaSaidaAlmoco = LocalDateTime.of(2021, 4, 13, 12, 00, 00); // Data/hora estáticos entrada
		System.out.println("Hora saida almoço: " + horaSaidaAlmoco);
		String horaSaidaAlmocoForm = horaSaidaAlmoco.toString();
		return horaSaidaAlmocoForm;
	}

	/**
	 * Registra o horário de retorno à empresa após o almoço
	 * 
	 * Este método insere no sistema o horário de chegada do funcionário na empresa após o almoço
	 * logo que o mesmo insere o seu cartão de identificação no aparelho identificador
	 * 
	 * @return horário em que se bate o ponto no retorno do funcionário à empresa após o almoço
	 */
	static String retornoAlmoco() {
		horaRetornoAlmoco = LocalDateTime.of(2021, 4, 13, 13, 00, 00); // Data/hora estáticos entrada
		System.out.println("Hora Retorno almoço: " + horaRetornoAlmoco);
		String retornoAlmocoForm = horaRetornoAlmoco.toString();
		return retornoAlmocoForm;
	}

	/**
	 * Registra hora de Saída
	 * 
	 * Este método insere uma hora de saída logo que o usuário insere o seu cartão
	 * de identificação no aparelho identificador
	 * 
	 * @return valor da hora em que se registra o ponto
	 */
	static String horaSaida() {
		saida = LocalDateTime.of(2021, 4, 13, 18, 00, 00); // Data/hora estáticos saída
		System.out.println("Registro saida: " + saida + "\n");
		// System.out.println("Horário de saída: " + saida.format(formatter) + "\n");
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
//	// calcula a quantidade de horas em relação aos 4 pontos batidos diariamente e
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

	/**
	 * 
	 * Método responsável por validar se o horário de saída foi registrado, se o ponto foi batido consecutivamente (margem de 5 min),
	 * se bateu o ponto final antes das 8h trabalhadas ou se ele cumpriu todo o horário de trabalho (tendo ou não horas extras)
	 * 
	 * @param horaEntrada String informa o horário de entrada do usuário
	 * @param saidaAlmoco String informa o horário de saída do usuário para almoço
	 * @param retornoAlmoco String informa o horário de retorno ao local de trabalho do usuário após o almoço
	 * @param horaSaida String informa o horário de saída do usuário da empresa após o fim da jornada de trabalho
	 * @return
	 */
	static String validacaoHorasNotificacao(String horaEntrada, String saidaAlmoco, String retornoAlmoco,
			String horaSaida) {
		
		if (saidaAlmoco == null || horaSaida == null) {
			String faltandoSaida = "Você não bateu o seu registro de saída";
			return faltandoSaida;
		}

		if (horaSaida != null && saidaAlmoco != null) {
			
			duracao = Duration.between(entrada, horaSaidaAlmoco);
			System.out.println("Horas manhã: " + duracao.toHours() + "\n");

			
			duracao = Duration.between(horaRetornoAlmoco, saida);
			System.out.println("Horas tarde: " + duracao.toHours() + "\n");

			duracao = Duration.between(entrada, saida);
			System.out.println("Resultado total de horas no dia: " + (duracao.toHours() - horaAlmoco + "\n"));

			System.out.print("Resultado horas extras/banco de horas: ");
			System.out.println(duracao.toHours() - chDia - horaAlmoco + "\n");

			String dadosEntradaSaida = "Cálculo de horas foi feito com sucesso!";
			return dadosEntradaSaida;
		}

		if (duracao.toMinutes() < 5 && saida.getHour() != 0) {
			String pontoConsecutivo = "Você bateu o ponto consecutivamente";
			return pontoConsecutivo;
		}

		else if (duracao.toHours() < 8 && saida.getHour() != 0) {
			String horarioIncompleto = "Você não cumpriu seu horário de trabalho do dia";
			return horarioIncompleto;
		}

		else if (duracao.toHours() >= 8) {
			System.out.println("Parabéns! Você cumpriu sua jornada!!" + "\n");

			String horasCompletas = "Parabéns! Você cumpriu sua jornada!!";
			return horasCompletas;
		}
		return null;
	}

	/**
	 * Registra Ip e Nome máquina.
	 * 
	 * Este método irá registrar o IP e nome de sua máquina para futuras analises que necessários.
	 * 
	 * @return Retorna valor do IP e Nome da maquina do usuário.
	 */
	static void ipLocalNomeMaquina() throws UnknownHostException {
		/* Ip da maquina */
		String ipMaquina = InetAddress.getLocalHost().getHostAddress();
		System.out.println("Ip da maquina: " + ipMaquina + "\n");

		/* Nome da maquina */
		String nomeMaquina = InetAddress.getLocalHost().getHostName();
		System.out.println("Nome da maquina: " + nomeMaquina + "\n");
	}

	// recebe local e como foi feito o ponto, retorna o local de onde foi
	static String localizacaoDoPonto(String localizacao, String formaDoPonto) {
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