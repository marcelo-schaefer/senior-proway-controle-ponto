package br.com.proway.senior.ponto.camadaLogica;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.proway.senior.ponto.camadaEntidade.Justificativa;

public class JustificativaLogica {
	
	Justificativa entidadeJustificativa = new Justificativa();
	
	/**<h1>Verifica se a data informada é válida.</h1>
	 * </br>
	 * Recebe um parâmetro String <em>data</em>, verifica se
	 * essa data é vália e se está na regra de negócio.
	 * @param data String referente a data.
	 * @return <strong>boolean</strong> true se a data for válida, false caso contrário.
	 */
	public boolean verificaData(String data) {
		String anoSistema = String.valueOf(LocalDate.now());
		int dia, mes, ano, anoAtual;
		anoAtual = Integer.parseInt(anoSistema.substring(0, 4));
		
		if(data == null || data.length() < 1 ||data.length() > 10) {
			return false;
		} else {
			try {
				data = data.replace("-", "");
				data = data.replace("/", "");
				dia = Integer.parseInt(data.substring(0, 2));
				mes = Integer.parseInt(data.substring(2, 4));
				ano = Integer.parseInt(data.substring(4, 8));
				
				if(dia < 1 || dia > 31) {
					return false;
				} else if(mes < 1 || mes > 12) {
					return false;
				}else if(ano < 1900 || ano > anoAtual) {
					return false;
				} 
				return true;
			}catch(NumberFormatException e) {
				return false;
			}
		}
	}
	
	/**<h1>Verifica se a mensagem informada é válida.</h1>
	 * </br>
	 * Recebe um parâmetro String <em>msg</em>, verifica se
	 * essa mensagem é vália e se está na regra de negócio.
	 * @param msg String referente a mensagem
	 * @return <strong>boolean</strong> true se msg for válida, false caso contrário.
	 */
	public boolean verificaMensagem(String msg) {		
		if(msg == null || msg.length() <= 0 || msg.length() > 500) {
			return false;
		} else {
			return true;
		}
	}
	
	/**<h1>Verifica se a imagem informada é válida.</h1>
	 * </br>
	 * Recebe um parâmetro String <em>img</em>, verifica se
	 * essa imagem é vália e se está na regra de negócio.
	 * @param img String referente a imagem
	 * @return <strong>boolean</strong> true se imagem for válida, false caso contrário.
	 */
	public boolean verificaImagem(String img) {		
		if(img == null || img.length() <= 0 || img.length() > 500) {
			return false;
		} else {
			return true;
		}
	}
	
	/**<h1>Envia a justificativa.</h1>
	 * </br>
	 * Recebe os parâmetro String <em>data</em>, String <em>msg</em>, String <em>img</em>  verifica se
	 * ambos são válidos e adiciona eles a lista de dados.
	 * 
	 * @param data String referente a data
	 * @param msg String referente a mendagem
	 * @param img String referente a imagem
	 * @return <strong>boolean</strong> true se se os dados foram
	 * adicionados, false caso contrário.
	 */
	public boolean enviarJustificativa(String data, String msg, String img) {
		if(verificaData(data) == false || verificaImagem(img) == false || verificaMensagem(msg) == false) {
			return false;
		} else {
			ArrayList<String> infos = new ArrayList<String>();
			infos.add(data + msg + img);
			entidadeJustificativa.setDados(infos);
		}
		return true;
	}
}
