package br.com.proway.senior.ponto;

import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class justificativas {

	public static void main(String[] args) {
		opcoesFormulario();
		obterInicioAfastamento();
		obterFimAfast();
		obterHorario();
		justifDeclaracao();
	}
	public static int diaInicio;
	public static int mesInicio;
	public static int anoInicio;
	public static String dateInicio;
	public static int diaRetorno;
	public static int mesRetorno;
	public static int anoRetorno;
	public static String dateFim;
	public static int diaRegistro;
	public static int mesRegistro;
	public static int anoRegistro;
	public static String dateRegistro;
	public static Scanner scanner = new Scanner(System.in);

	static void opcoesFormulario() {
		System.out.println("Formulário");
		System.out.println("\n");
		System.out.println("Que serviço deseja?");
		System.out.println("1 - Falecimento de parentes");
		System.out.println("2 - Ponto registrado incorretamente");
	}
	static String obterInicioAfastamento() {	
		/**
		 * A variável diaInicio não pode ser maior que o dia 31 e nem menor que um dia.
		 * A variável MesInicio não pode ser maior que o mês 12e nem menor que um mês. A
		 * variavel anoInicio não pode ser maior que o ano de 2021 e nem menor que o ano
		 * de 1960. Na linha 65 a variável dateInicio retorna diaInicio, mesInicio e
		 * anoInicio em um forma de data. Exe: 00/00/00
		 */
		System.out.println("Informa data de início do afastamento");

		while (diaInicio >= 31 || diaInicio <= 1) {
			System.out.println("Informa dia: ");
			diaInicio = scanner.nextInt();
			break;
		}
		while (mesInicio <= 1 || mesInicio >= 12) {
			System.out.println("Informa mês : ");
			mesInicio = scanner.nextInt();
			break;
		}
		while (anoInicio <= 1960 || anoInicio >= 2021) {
			System.out.println("Informa ano: ");
			anoInicio = scanner.nextInt();
			break;
		}
		dateInicio = diaInicio + "/" + mesInicio + "/" + anoInicio;
		return dateInicio;
	}
	static String obterFimAfast() {		
		/**
		 * A variável diaRetorno não pode ser maior que o dia 31 e nem menor que um dia.
		 * A variável MesRetorno não pode ser maior que o mês 12 e nem menor que um mês.
		 * A variavel anoRetorno não pode ser maior que o ano de 2021 e nem menor que o
		 * ano de 1960. Na linha 93 a variável dateFim retorna diaRetorno, mesRetorno e
		 * anoRetorno em um forma de data. Exe: 00/00/00
		 */

		while (diaRetorno >= 31 || diaRetorno <= 1) {
			System.out.println("Informa data de retorno do afastamento");
			System.out.println("Informa dia: ");
			diaRetorno = scanner.nextInt();
			break;
		}
		while (mesRetorno >= 12 || mesRetorno <= 1) {
			System.out.println("Informa mês: ");
			mesRetorno = scanner.nextInt();
			break;
		}
		while (anoRetorno <= 2021 || anoRetorno >= 1960) {
			System.out.println("Informa mês: ");
			mesRetorno = scanner.nextInt();
			break;
		}
		dateFim = diaRetorno + "/" + mesRetorno + "/" + anoRetorno;
		return dateFim;
	}
	static String obterHorario() {
		/**
		 * A variável diaRegistro não pode ser maior que o dia 31 e nem menor que um
		 * dia. A variável MesRegistro não pode ser maior que o mês 12 e nem menor que
		 * um mês. A variavel anoRegistro não pode ser maior que o ano de 2021 e nem
		 * menor que o ano de 1960. Na linha 138 a variável dateRegistro retorna
		 * diaRegistro, MesRegistro e anoRegistro em um forma de data. Exe: 00/00/00
		 */
		while (diaRegistro > 31 || diaRegistro < 1) {
			System.out.println("Informa data de retorno do afastamento");
			System.out.println("Informa dia: ");
			diaRegistro = scanner.nextInt();
			break;
		}
		while (mesRegistro > 12 || mesRegistro < 1) {
			System.out.println("Informa mês: ");
			mesRegistro = scanner.nextInt();
			break;
		}
		while (anoRegistro > 2021 || anoRegistro < 1960) {
			System.out.println("Informa ano: ");
			anoRegistro = scanner.nextInt();
			break;
		}
		dateRegistro = diaRegistro + "/" + mesRegistro + "/" + anoRegistro;
		return dateRegistro;
	}
	static String justifDeclaracao() {

		/**
		 * A variável declaracao só pode receber os valores 1 e 2 e fica dentro do laço
		 * de repetição até que informem um valor válido e retorna para algum lugar.
		 */

		System.out.println("Descreva sua justificativa");
		String justificativa = scanner.next();

		System.out.println("Anexe a declaração de afastamento: ");
		int declaracao = scanner.nextInt();

		while (declaracao > 2 || declaracao < 1) {
			if (declaracao == 1) {
				System.out.println("Declaração anexada com sucesso!");
			} else if (declaracao == 2) {
				System.out.println("Anexe novamente a declaração");
			}
			break;
		}
		return justificativa;
	}
}
