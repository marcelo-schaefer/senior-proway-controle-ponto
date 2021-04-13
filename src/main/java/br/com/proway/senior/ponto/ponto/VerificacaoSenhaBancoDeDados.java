package ponto;

import java.util.ArrayList;

public class VerificacaoSenhaBancoDeDados {

	/**
	 * Verifica a senha
	 * 
	 * o metodo recebe a senha do usuario, procura no banco de dados e retorna um
	 * boolean informando se sim ou nao
	 * 
	 * @param Integer senha, senha do usuario
	 * @return boolean contem, retorna se a senha existe no banco de dados
	 */
	public boolean verificacaoSenhaBancoDeDados(Integer senha) {

		boolean contem = false;
		ArrayList<Integer> todasSenhas = new ArrayList<Integer>();
		todasSenhas.add(123);
		for (Integer i : todasSenhas) {
			if (i == senha) {
				contem = true;
				break;
			}
		}
		return contem;
	}
}
