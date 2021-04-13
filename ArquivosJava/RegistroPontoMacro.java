package br.com.proway.senior.teste;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RegistroPonto {

	public static void main(String[] args) throws UnknownHostException {
		insereUsuario();
		horaEntrada();
		horaSaida();
		//validacaoHoras();
//		notificaoExemplos();
		ipLocalNomeMaquina();
		validacaoHoras();
		
	
	}
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	static LocalDateTime entrada;
	static LocalDateTime saida;
	static LocalDateTime horaSaidaAlmoco;
	static LocalDateTime horaRetornoAlmoco;
	static int chDia = 8;

	static String usuario = "1234";

	static void insereUsuario() {
		System.out.println("Insira o seu Usuário:");
		System.out.println("Usuário " + usuario);
	}

	//-----------------------------------------------------
	
	
	static void horaEntrada() {
	entrada = LocalDateTime.of(2021, 4, 12, 8, 47, 34); // Data/hora estáticos entrada
		System.out.println("Horário de entrada: " + entrada.format(formatter) + "\n");
	}
	
	static void horaSaida(){
		saida = LocalDateTime.of(2021, 4, 12, 20, 49, 20); // Data/hora estáticos saída
		System.out.println("Horário de saída: " + saida.format(formatter) + "\n");	
	}
	
	// salva em lista a hora que bateu o ponto
	public ArrayList<LocalTime> armazenaHora(int id, LocalTime hora) {
		ArrayList<LocalTime> horas = new ArrayList<>();
		horas.add(hora);
		return horas;
	}
	
	// calcula a quantidade de horas em relação aos 4 pontos batidos diariamente e
		// retorna este valor
		public LocalDateTime horasTrabalhadas(LocalDateTime entrada, LocalDateTime horaSaidaAlmoco, LocalDateTime horaRetornoAlmoco,
				LocalDateTime saida) {

			Duration manha = Duration.between(entrada, horaSaidaAlmoco);
			Duration tarde = Duration.between(horaRetornoAlmoco, saida);
			long i = manha.toMinutes();
			long j = tarde.toMinutes();
			long juncao = i + j;
			double minuto = juncao;
			int s = (int) Math.round(minuto * 60);
			int h = s / 3600;
			int m = (s - 3600 * h) / 60;
			s = s % 60;

			LocalDate hoje = LocalDate.now();

			LocalDateTime retorno = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), h, m, s);
			return retorno;

		}
		
		static void validacaoHoras() {
			/* Caso o usuário tenha esquecido de bater o ponto na saída*/
			if(saida.getHour() == 0) {
				System.out.println("Você não bateu o seu registro de saída");
			} else {
				System.out.println("Resultado total de horas no dia:");
				Duration hoje = Duration.between(entrada, saida);
				System.out.println(hoje.toHours());
				
				System.out.println();
				System.out.println("Resultado horas extras/banco de horas:");
				System.out.println(hoje.toHours() - chDia);
			}	
		}
		
		static void notificaoExemplos() {
			/* Caso o usuário bata o ponto consecutivamente (antes dos 5 minutos) */
			Duration hoje = null;
			if(hoje.toMinutes() < 5 && saida.getHour() != 0) {
				System.out.println("Você bateu o ponto consecutivamente");
			}
			
			/* Caso o usuário tenha batido o ponto antes das 8 horas*/
			else if(hoje.toHours() < 8 && saida.getHour() != 0) {
				System.out.println("Você não cumpriu seu horário de trabalho do dia");
			} 
			
			/* Caso o usuário tenha cumprido as 8 horas trabalhadas e passado delas*/
			else if(hoje.toHours() >= 8) {
				System.out.println("Parabéns! Você cumpriu sua jornada!!");
			}	
		}
}
		
		
		
	
	//Calculo antigo//
//	static void validacaoHoras() {
//		Duration duracao = Duration.ZERO;
//		
//		/* Caso o usuário tenha esquecido de bater o ponto na saída*/
//		if(saida.getHour() == 0) {
//			System.out.println("Você não bateu o seu registro de saída");
//		} else {
//			System.out.println("Resultado total de horas no dia:");
//			duracao = Duration.between(entrada, saida);
//			System.out.println(duracao.toHours());
//			
//			System.out.println();
//			System.out.println("Resultado horas extras/banco de horas:");
//			System.out.println(duracao.toHours() - chDia);
//		}	
//	}
	
	
//	static void notificaoExemplos() {
//		/* Caso o usuário bata o ponto consecutivamente (antes dos 5 minutos) */
//		Duration duracao =  Duration.ZERO;
//		if(duracao.toMinutes() < 5 && saida.getHour() != 0) {
//			System.out.println("Você bateu o ponto consecutivamente");
//		}
//		
//		/* Caso o usuário tenha batido o ponto antes das 8 horas*/
//		else if(duracao.toHours() < 8 && saida.getHour() != 0) {
//			System.out.println("Você não cumpriu seu horário de trabalho do dia");
//		} 
//		
//		/* Caso o usuário tenha cumprido as 8 horas trabalhadas e passado delas*/
//		else if(duracao.toHours() >= 8) {
//			System.out.println("Parabéns! Você cumpriu sua jornada!!");
//		}	
//	}
//	
//	
//	static void ipLocalNomeMaquina() throws UnknownHostException {
//		/*Ip da maquina*/
//		String ipMaquina = InetAddress.getLocalHost().getHostAddress();
//		System.out.println("Ip da maquina: " + ipMaquina);
//		
//
//		/*Nome da maquina*/
//		String nomeMaquina = InetAddress.getLocalHost().getHostName();
//		System.out.println("Nome da maquina: " + nomeMaquina);
//	}	
//}


/*
 
  public class RegistroPonto {

	// salva em lista a hora que bateu o ponto
	public ArrayList<LocalTime> armazenaHora(int id, LocalTime hora) {
		ArrayList<LocalTime> horas = new ArrayList<>();
		horas.add(hora);
		return horas;
	}

	// calcula a quantidade de horas em relação aos 4 pontos batidos diariamente e
	// retorna este valor
	public LocalDateTime horasTrabalhadas(LocalDateTime hora1, LocalDateTime hora2, LocalDateTime hora3,
			LocalDateTime hora4) {

		Duration manha = Duration.between(hora1, hora2);
		Duration tarde = Duration.between(hora3, hora4);
		long i = manha.toMinutes();
		long j = tarde.toMinutes();
		long junsao = i + j;
		double minuto = junsao;
		int s = (int) Math.round(minuto * 60);
		int h = s / 3600;
		int m = (s - 3600 * h) / 60;
		s = s % 60;

		LocalDate hoje = LocalDate.now();

		LocalDateTime retorno = LocalDateTime.of(hoje.getYear(), hoje.getMonth(), hoje.getDayOfMonth(), h, m, s);
		return retorno;

	}

	//recebe local e como foi feito o ponto, retorna o local de onde foi
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
 * 
 * */
