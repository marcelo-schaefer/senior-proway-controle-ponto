package br.com.proway.senior.ponto.camadaLogica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import br.com.proway.senior.ponto.camadaEntidade.Colaborador;
import br.com.proway.senior.ponto.camadaEntidade.HistoricoMensal;
import br.com.proway.senior.ponto.camadaEntidade.JornadaDeTrabalho;
import br.com.proway.senior.ponto.camadaEntidade.Justificativa;
import br.com.proway.senior.ponto.camadaEntidade.StatusJustificativa;

public class JustificativaLogica {
	
	public Justificativa entidadeJustificativa;
	
	public JustificativaLogica(Justificativa justificativa) {
		this.entidadeJustificativa = justificativa;
	}
	
	public JustificativaLogica() {
		
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
	
	/**<h1>Recebe dados do usu�rio, verifica dados e cria objeto Justificativa novo.</h1>
	 * </br>
	 * Recebe dados do usu�rio, verifica e cria objeto Justificativa novo.
	 * 
	 * @param Integer idRecebido id da pessoa recebido do usu�rio
	 * @param String dataRecebido data da justificativa recebido do usu�rio
	 * @param String msgRecebido mensagem da justificativa recebido do usu�rio
	 * @param String imgRecebido imagem comprovante da justificativa recebido do usu�rio.
	 * @return Justificativa retorna objeto verificado Justificativa.
	 */
	public Justificativa criaEVerificaJustificativa(Integer idRecebido, String dataRecebido, String msgRecebido, String imgRecebido) {
		StatusJustificativa statusNovo = StatusJustificativa.PENDENTE;
		Justificativa entidadeJustificativa = new Justificativa(idRecebido, dataRecebido, msgRecebido, imgRecebido);
		entidadeJustificativa.setStatus(statusNovo);
		if(verificaData(entidadeJustificativa) == false || verificaImagem(entidadeJustificativa) == false || verificaMensagem(entidadeJustificativa) == false) {
			return null;
		} else {
			ArrayList<String> infos = new ArrayList<String>();
			infos.add(idRecebido +" "+ dataRecebido + " " + msgRecebido + " " + imgRecebido +" "+ statusNovo);
			entidadeJustificativa.setDados(infos);
			return entidadeJustificativa;
		}
		
	}
	
	/**
	 * Salva novo objeto justificativa no hist�rico mensal do colaborador
	 * 
	 * Recebe objeto justificativa e colaborador, cria objetos novos para atualizar
	 * @param novaJustificativa
	 * @param colaboradorRecebido
	 */
	public ArrayList<HistoricoMensal<Justificativa>> salvarJustificativa(Justificativa novaJustificativa, Colaborador colaboradorRecebido) {
		
		Integer idRecebido = colaboradorRecebido.getId();
		ArrayList<HistoricoMensal<Justificativa>> novoHistoricoAtualizado = colaboradorRecebido.getJustificativas();
		if(idRecebido == novaJustificativa.getId()) {
			
			novoHistoricoAtualizado.get(novoHistoricoAtualizado.size()-1).getObjetos().add(novaJustificativa);
			return novoHistoricoAtualizado;
		}
		return null;
	}
	/**
	 * Consulta lista de justificativas por idPessoa.
	 * 
	 * Pergunta id da Pessoa para imprimir lista de justificativas, varre arraylist de 
	 * justificativas e retorna o arraylist com id igual ao escolhido pelo usu�rio.
	 * 
	 * @param ArrayList<Justificativa> da classe Justificativa.
	 * @return ArrayList <String> de dados concatenados do ArrayList de Justificativas.
	 */
	public ArrayList<String> consultaJustificativaPessoa(ArrayList<Justificativa> justificativas, int id){
		
		ArrayList<String> mostraLista = new ArrayList<String>();
	
		for(int i = 0; i<justificativas.size(); i++) {
			if(justificativas.get(i).getId() == id) {
			String textoJustificativa = justificativas.get(i).toString();
			mostraLista.add(textoJustificativa);				
			}
		}
		if(mostraLista.isEmpty()) System.out.println("N�o h� justificativas para esse ID.");
		return mostraLista;
	}
	/**
	 * Consulta de lista de justificativas por status.
	 * Pergunta status para imprimir lista de justificativas, varre arraylist de 
	 * justificativas e retorna o arraylist com status igual ao escolhido pelo usu�rio.
	 * 
	 * @param ArrayList<Justificativa> justificativas
	 * @return ArrayList<String> de dados concatenados do ArrayList de justificativas.
	 */
	
	public ArrayList<String> consultaJustificativaStatus(ArrayList<Justificativa> justificativas, String status){
		
		ArrayList<String> mostraLista = new ArrayList<String>();

		for(int i = 0; i<justificativas.size(); i++) { 
			if(justificativas.get(i).getStatus().toString().equals(status.toUpperCase())){
			String textoJustificativa = justificativas.get(i).toString();
			mostraLista.add(textoJustificativa);				
			}
		}
		if(mostraLista.isEmpty()) System.out.println("N�o h� justificativas para tipo de status.");
		return mostraLista;
	}

	
}
