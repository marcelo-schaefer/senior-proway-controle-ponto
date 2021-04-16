package br.com.proway.senior.ponto.camadaLogica;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.proway.senior.ponto.camadaEntidade.Justificativa;
import br.com.proway.senior.ponto.camadaEntidade.StatusJustificativa;

public class JustificativaLogica {
	
	Justificativa entidadeJustificativa;
	
	public JustificativaLogica(Justificativa justificativa) {
		this.entidadeJustificativa = justificativa;
	}
	
	/**<h1>Verifica se a data informada é válida.</h1>
	 * </br>
	 * Recebe um parâmetro String <em>data</em>, verifica se
	 * essa data é válida e se está na regra de negócio.
	 * @param Classe Justificativa com atributo data.
	 * @return <strong>boolean</strong> true se a data for válida, false caso contrário.
	 */
	public boolean verificaData(Justificativa entidadeJustificativa) {
		String dataGet = entidadeJustificativa.getData();
		String anoSistema = String.valueOf(LocalDate.now());
		int dia, mes, ano, anoAtual;
		anoAtual = Integer.parseInt(anoSistema.substring(0, 4));
		
		if(dataGet == null || dataGet.length() < 1 ||dataGet.length() > 10) {
			return false;
		} else {
			try {
				dataGet = dataGet.replace("-", "");
				dataGet = dataGet.replace("/", "");
				dataGet = dataGet.replace(".", "");
				dia = Integer.parseInt(dataGet.substring(0, 2));
				mes = Integer.parseInt(dataGet.substring(2, 4));
				ano = Integer.parseInt(dataGet.substring(4, 8));
				
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
	 * essa mensagem é válida e se está na regra de negócio.
	 * @param Classe entidadeJustificativa com atributo mensagem.
	 * @return <strong>boolean</strong> true se msg for válida, false caso contrário.
	 */
	public boolean verificaMensagem(Justificativa entidadeJustificativa) {	
		String msgGet = entidadeJustificativa.getMsg();
		if(msgGet == null || msgGet.length() <= 0 || msgGet.length() > 500) {
			return false;
		} else {
			return true;
		}
	}
	
	
	/**<h1>Verifica se a imagem informada é válida.</h1>
	 * </br>
	 * Recebe um parâmetro String <em>img</em>, verifica se
	 * essa imagem é válida e se está na regra de negócio.
	 * @param Classe Justificativa com atributo img.
	 * @return <strong>boolean</strong> true se imagem for válida, false caso contrário.
	 */
	public boolean verificaImagem(Justificativa entidadeJustificativa) {	
		String imgGet = entidadeJustificativa.getImg();
		if(imgGet == null || imgGet.length() <= 0 || imgGet.length() > 500) {
			return false;
		} else {
			return true;
		}
	}
	
	/**<h1>Envia a justificativa.</h1>
	 * </br>
	 * Recebe a classe Justificativa verifica se
	 * atributos são válidos e adiciona eles a lista de dados.
	 * 
	 * @param Classe Justificativa com atribuos data, mensagem e imagem.
	 * @return <strong>boolean</strong> true se se os dados foram
	 * adicionados, false caso contrário.
	 */
	public boolean cadastrarJustificativa(Justificativa entidadeJustificativa) {
		String dataGet = entidadeJustificativa.getData();
		String dataMsg = entidadeJustificativa.getMsg();
		String dataImg = entidadeJustificativa.getImg();
		if(verificaData(entidadeJustificativa) == false || verificaImagem(entidadeJustificativa) == false || verificaMensagem(entidadeJustificativa) == false) {
			return false;
		} else {
			ArrayList<String> infos = new ArrayList<String>();
			infos.add(dataGet + " " + dataMsg + " " + dataImg);
			entidadeJustificativa.setDados(infos);
		}
		return true;
	}
	
}
