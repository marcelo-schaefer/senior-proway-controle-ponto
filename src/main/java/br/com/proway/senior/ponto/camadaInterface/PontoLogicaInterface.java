package br.com.proway.senior.ponto.camadaInterface;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.proway.senior.ponto.camadaEntidade.Colaborador;
import br.com.proway.senior.ponto.camadaEntidade.Ponto;
import br.com.proway.senior.ponto.camadaEntidade.TipoDePonto;

public interface PontoLogicaInterface {
	public void cadastrarPonto(Colaborador pessoa);
	
	public ArrayList<Ponto> pegarTodosOsPontos();
	
	public ArrayList<Ponto> pegarPontosPorPessoa(Colaborador colaborador);
	
	public Ponto salvarPonto(TipoDePonto tipo, String localizacao, Colaborador c);
	
	public ArrayList<Ponto> pegarPontosDeUmaJornadaPorColaboradorEData(Colaborador colaborador, LocalDate data);
}
