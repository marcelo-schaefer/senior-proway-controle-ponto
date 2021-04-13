package ponto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class ArmazenamentoDePonto {

	/**
	 * Armazena o ponto
	 * 
	 * recebe o id do usuario, roda a lista de horas da pessoa, e vai adcionar o
	 * horario passado na lista
	 * 
	 * @param int           id, id da pessoa que esta batendo o ponto
	 * @param LocalDateTime hora, horario que o ponto foi batido
	 * @return
	 */
	public ArrayList<LocalDateTime> armazenaHora(int id, LocalDateTime hora) {

		ArrayList<LocalDateTime> horas = new ArrayList<>(); // lista de horas da pessoa
		/*
		 * for (Pessoa pessoa : listaDePessoa) { 
		 * if (pessoa.getId.equals(id))
		 * listaHorarisoDaPessoa.add(hora) } }
		 */
		horas.add(hora);
		return horas;
	}
}
