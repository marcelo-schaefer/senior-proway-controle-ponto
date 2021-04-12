package afastamento;

import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class Justificativas {
	public static void main(String[] args) {
		opcoesFormulario();
		dataAfastInicio();
		dataAfastRetorno();
		justifDeclaração();
	}

	static void opcoesFormulario() {
		System.out.println("Formulário");
		System.out.println("\n");
		System.out.println("Que serviço deseja?");
		System.out.println("1 - Falecimento de parentes");
		System.out.println("2 - Ponto registrado incorretamente");
	}

	static void dataAfastInicio() {
		Scanner scanner = new Scanner(System.in);
		int opcao = scanner.nextInt();
		if (opcao == 1) {
			System.out.println("Informa data de início do afastamento:");
			System.out.println("Informa dia: ");
			int diaInicio = scanner.nextInt();
			System.out.println("Informa mês : ");
			int mesInicio = scanner.nextInt();
			System.out.println("Informa ano: ");
			int anoInicio = scanner.nextInt();

			String date = "12/8/2012";
			String[] dateParts = date.split("/");
			String day = dateParts[0];
			String month = dateParts[1];
		}
		if (opcao == 2) {
			Scanner scannerRegistErrado = new Scanner(System.in);
			System.out.println("Informa o horário do registro errado :");
			double horarioRegistro = scannerRegistErrado.nextDouble();

			System.out.println("Informa dia: ");
			int diaRegistro = scannerRegistErrado.nextInt();
			System.out.println("Informa mês : ");
			int mesRegistro = scannerRegistErrado.nextInt();
			System.out.println("Informa ano: ");
			int anoRegistro = scannerRegistErrado.nextInt();
			System.out.println("Informa ano: ");
		}
	}

	static void dataAfastRetorno() {
		Scanner scannerRetorno = new Scanner(System.in);
		System.out.println("Informa data de retorno do afastamento:");
		System.out.println("Informa dia: ");
		int diaRetorno = scannerRetorno.nextInt();
		System.out.println("Informa mês : ");
		int mesRetorno = scannerRetorno.nextInt();
		System.out.println("Informa ano: ");
		int anoRetorno = scannerRetorno.nextInt();
	}

	/*
	 * String[] dateParts = date.split("/"); String day = dateParts[0]; String month
	 * = dateParts[1]; System.out.println(date);
	 */
	static void justifDeclaração() {
		Scanner scannerDeclaração = new Scanner(System.in);
		System.out.println("Descreva sua justificativa");
		String justificativa = scannerDeclaração.next();

		System.out.println("Anexe a declaração de afastamento: ");
		int declaracao = scannerDeclaração.nextInt();

		if (declaracao == 1) {
			System.out.println("Declaração anexada com sucesso!");
		} else if (declaracao == 2) {
			System.out.println("Anexe novamente a declaração");
		}
	}

}
