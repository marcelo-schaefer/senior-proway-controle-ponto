package br.com.proway.senior.ponto.camadaInterface;

import java.util.ArrayList;

import br.com.proway.senior.ponto.camadaEntidade.Colaborador;
import br.com.proway.senior.ponto.camadaEntidade.HistoricoMensal;
import br.com.proway.senior.ponto.camadaEntidade.Justificativa;

public interface JustificativaLogicaInterface {
	
	public boolean verificaData(Justificativa entidadeJustificativa);
	
	public boolean verificaMensagem(Justificativa entidadeJustificativa);
	
	public boolean verificaImagem(Justificativa entidadeJustificativa);
	
	public Justificativa criaEVerificaJustificativa(Integer idRecebido, String dataRecebido, String msgRecebido, String imgRecebido);
	
	public ArrayList<HistoricoMensal<Justificativa>> salvarJustificativa(Justificativa novaJustificativa, Colaborador colaboradorRecebido);
	
	public ArrayList<String> consultaJustificativaPessoa(ArrayList<Justificativa> justificativas, int id);
	
	public ArrayList<String> consultaJustificativaStatus(ArrayList<Justificativa> justificativas, String status);
	
}
