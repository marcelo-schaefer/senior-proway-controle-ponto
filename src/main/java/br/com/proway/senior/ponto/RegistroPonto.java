package br.com.proway.senior.ponto;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class RegistroPonto {

	/**
	 O m�todo de valida��oHours Notifificacao foi incorporado nos outros m�todos para a realiza��o dos testes,
	 * por essa raz�o tem os 4 principais m�todos comentados.
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
		System.out.println("Usu�rio: " + usuario);
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
		System.out.println("Registro Entrada: " + entrada);
		String horarioEntFormatado = entrada.toString();
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
		System.out.println("Hora saida almo�o: " + horaSaidaAlmoco);
		String horaSaidaAlmocoForm = horaSaidaAlmoco.toString();
		return horaSaidaAlmocoForm;
	}

	/**
	 * Registra o hor�rio de retorno � empresa ap�s o almo�o
	 * 
	 * Este m�todo insere no sistema o hor�rio de chegada do funcion�rio na empresa ap�s o almo�o
	 * logo que o mesmo insere o seu cart�o de identifica��o no aparelho identificador
	 * 
	 * @return hor�rio em que se bate o ponto no retorno do funcion�rio � empresa ap�s o almo�o
	 */
	static String retornoAlmoco() {
		horaRetornoAlmoco = LocalDateTime.of(2021, 4, 13, 13, 00, 00); // Data/hora est�ticos entrada
		System.out.println("Hora Retorno almo�o: " + horaRetornoAlmoco);
		String retornoAlmocoForm = horaRetornoAlmoco.toString();
		return retornoAlmocoForm;
	}

	/**
	 * Registra hora de Sa�da
	 * 
	 * Este m�todo insere uma hora de sa�da logo que o usu�rio insere o seu cart�o
	 * de identifica��o no aparelho identificador
	 * 
	 * @return valor da hora em que se registra o ponto
	 */
	static String horaSaida() {
		saida = LocalDateTime.of(2021, 4, 13, 18, 00, 00); // Data/hora est�ticos sa�da
		System.out.println("Registro saida: " + saida + "\n");
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

	/**
	 * 
	 * M�todo respons�vel por validar se o hor�rio de sa�da foi registrado, se o ponto foi batido consecutivamente (margem de 5 min),
	 * se bateu o ponto final antes das 8h trabalhadas ou se ele cumpriu todo o hor�rio de trabalho (tendo ou n�o horas extras)
	 * 
	 * @param horaEntrada String informa o hor�rio de entrada do usu�rio
	 * @param saidaAlmoco String informa o hor�rio de sa�da do usu�rio para almo�o
	 * @param retornoAlmoco String informa o hor�rio de retorno ao local de trabalho do usu�rio ap�s o almo�o
	 * @param horaSaida String informa o hor�rio de sa�da do usu�rio da empresa ap�s o fim da jornada de trabalho
	 * @return
	 */
	static String validacaoHorasNotificacao(String horaEntrada, String saidaAlmoco, String retornoAlmoco,
			String horaSaida) {
		
		if (saidaAlmoco == null || horaSaida == null) {
			String faltandoSaida = "Voc� n�o bateu o seu registro de sa�da";
			return faltandoSaida;
		}

		if (horaSaida != null && saidaAlmoco != null) {
			
			duracao = Duration.between(entrada, horaSaidaAlmoco);
			System.out.println("Horas manh�: " + duracao.toHours() + "\n");

			
			duracao = Duration.between(horaRetornoAlmoco, saida);
			System.out.println("Horas tarde: " + duracao.toHours() + "\n");

			duracao = Duration.between(entrada, saida);
			System.out.println("Resultado total de horas no dia: " + (duracao.toHours() - horaAlmoco + "\n"));

			System.out.print("Resultado horas extras/banco de horas: ");
			System.out.println(duracao.toHours() - chDia - horaAlmoco + "\n");

			String dadosEntradaSaida = "C�lculo de horas foi feito com sucesso!";
			return dadosEntradaSaida;
		}

		if (duracao.toMinutes() < 5 && saida.getHour() != 0) {
			String pontoConsecutivo = "Voc� bateu o ponto consecutivamente";
			return pontoConsecutivo;
		}

		else if (duracao.toHours() < 8 && saida.getHour() != 0) {
			String horarioIncompleto = "Voc� n�o cumpriu seu hor�rio de trabalho do dia";
			return horarioIncompleto;
		}

		else if (duracao.toHours() >= 8) {
			System.out.println("Parab�ns! Voc� cumpriu sua jornada!!" + "\n");

			String horasCompletas = "Parab�ns! Voc� cumpriu sua jornada!!";
			return horasCompletas;
		}
		return null;
	}

	/**
	 * Registra Ip e Nome m�quina.
	 * 
	 * Este m�todo ir� registrar o IP e nome de sua m�quina para futuras analises que necess�rios.
	 * 
	 * @return Retorna valor do IP e Nome da maquina do usu�rio.
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