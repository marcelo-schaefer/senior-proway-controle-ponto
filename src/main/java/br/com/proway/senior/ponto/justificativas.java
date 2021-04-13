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
		System.out.println("Formul�rio");
		System.out.println("\n");
		System.out.println("Que servi�o deseja?");
		System.out.println("1 - Falecimento de parentes");
		System.out.println("2 - Ponto registrado incorretamente");
	}
	static String obterInicioAfastamento() {	
		/**
		 * A vari�vel diaInicio n�o pode ser maior que o dia 31 e nem menor que um dia.
		 * A vari�vel MesInicio n�o pode ser maior que o m�s 12e nem menor que um m�s. A
		 * variavel anoInicio n�o pode ser maior que o ano de 2021 e nem menor que o ano
		 * de 1960. Na linha 65 a vari�vel dateInicio retorna diaInicio, mesInicio e
		 * anoInicio em um forma de data. Exe: 00/00/00
		 */
		System.out.println("Informa data de in�cio do afastamento");

		while (diaInicio >= 31 || diaInicio <= 1) {
			System.out.println("Informa dia: ");
			diaInicio = scanner.nextInt();
			break;
		}
		while (mesInicio <= 1 || mesInicio >= 12) {
			System.out.println("Informa m�s : ");
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
		 * A vari�vel diaRetorno n�o pode ser maior que o dia 31 e nem menor que um dia.
		 * A vari�vel MesRetorno n�o pode ser maior que o m�s 12 e nem menor que um m�s.
		 * A variavel anoRetorno n�o pode ser maior que o ano de 2021 e nem menor que o
		 * ano de 1960. Na linha 93 a vari�vel dateFim retorna diaRetorno, mesRetorno e
		 * anoRetorno em um forma de data. Exe: 00/00/00
		 */

		while (diaRetorno >= 31 || diaRetorno <= 1) {
			System.out.println("Informa data de retorno do afastamento");
			System.out.println("Informa dia: ");
			diaRetorno = scanner.nextInt();
			break;
		}
		while (mesRetorno >= 12 || mesRetorno <= 1) {
			System.out.println("Informa m�s: ");
			mesRetorno = scanner.nextInt();
			break;
		}
		while (anoRetorno <= 2021 || anoRetorno >= 1960) {
			System.out.println("Informa m�s: ");
			mesRetorno = scanner.nextInt();
			break;
		}
		dateFim = diaRetorno + "/" + mesRetorno + "/" + anoRetorno;
		return dateFim;
	}
	static String obterHorario() {
		/**
		 * A vari�vel diaRegistro n�o pode ser maior que o dia 31 e nem menor que um
		 * dia. A vari�vel MesRegistro n�o pode ser maior que o m�s 12 e nem menor que
		 * um m�s. A variavel anoRegistro n�o pode ser maior que o ano de 2021 e nem
		 * menor que o ano de 1960. Na linha 138 a vari�vel dateRegistro retorna
		 * diaRegistro, MesRegistro e anoRegistro em um forma de data. Exe: 00/00/00
		 */
		while (diaRegistro > 31 || diaRegistro < 1) {
			System.out.println("Informa data de retorno do afastamento");
			System.out.println("Informa dia: ");
			diaRegistro = scanner.nextInt();
			break;
		}
		while (mesRegistro > 12 || mesRegistro < 1) {
			System.out.println("Informa m�s: ");
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
		 * A vari�vel declaracao s� pode receber os valores 1 e 2 e fica dentro do la�o
		 * de repeti��o at� que informem um valor v�lido e retorna para algum lugar.
		 */

		System.out.println("Descreva sua justificativa");
		String justificativa = scanner.next();

		System.out.println("Anexe a declara��o de afastamento: ");
		int declaracao = scanner.nextInt();

		while (declaracao > 2 || declaracao < 1) {
			if (declaracao == 1) {
				System.out.println("Declara��o anexada com sucesso!");
			} else if (declaracao == 2) {
				System.out.println("Anexe novamente a declara��o");
			}
			break;
		}
		return justificativa;
	}
}
