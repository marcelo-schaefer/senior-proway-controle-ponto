package br.com.proway.senior.ponto.camadaLogica;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;

import br.com.proway.senior.ponto.camadaEntidade.Colaborador;
import br.com.proway.senior.ponto.camadaEntidade.Ponto;
import br.com.proway.senior.ponto.camadaEntidade.TipoDePonto;

public class PontoLogicaTest {
	
	ArrayList<Colaborador> listaColaboradores = new ArrayList<Colaborador>();
	
	public void popularColaboradores() {
		Colaborador colaborador1 = new Colaborador();
		colaborador1.setId(4);
		colaborador1.setIdTime(3);
		colaborador1.setIdTurno(1);
		colaborador1.setEhGerente(false);
		colaborador1.setJornadaEmMinutos(540);
		listaColaboradores.add(colaborador1);
	}
	
	
	public void popularPontos() {	
		Ponto ponto1 = new Ponto();
		ponto1.setId(1);
		ponto1.setIdColaborador(4);
		ponto1.setTipoDePonto(TipoDePonto.Web);
		ponto1.setData(LocalDate.of(2021, 01, 01));
		ponto1.setLocalizacao("Minha casa");
		ponto1.setHorario(LocalDateTime.of(2021, 01, 01, 7, 30, 00));
		PontoLogica.pontos.add(ponto1);
		
		Ponto ponto2 = new Ponto();
		ponto2.setId(2);
		ponto2.setIdColaborador(4);
		ponto2.setTipoDePonto(TipoDePonto.Web);
		ponto2.setData(LocalDate.of(2021, 01, 01));
		ponto2.setLocalizacao("Minha casa");
		ponto2.setHorario(LocalDateTime.of(2021, 01, 01, 9, 00, 00));
		PontoLogica.pontos.add(ponto2);		
		
		Ponto ponto3 = new Ponto();
		ponto3.setId(3);
		ponto3.setIdColaborador(4);
		ponto3.setTipoDePonto(TipoDePonto.Web);
		ponto3.setData(LocalDate.of(2021, 01, 01));
		ponto3.setLocalizacao("Minha casa");
		ponto3.setHorario(LocalDateTime.of(2021, 01, 01, 9, 30, 00));
		PontoLogica.pontos.add(ponto3);	
		
		Ponto ponto4 = new Ponto();
		ponto4.setId(4);
		ponto4.setIdColaborador(4);
		ponto4.setTipoDePonto(TipoDePonto.Web);
		ponto4.setData(LocalDate.of(2021, 01, 01));
		ponto4.setLocalizacao("Minha casa");
		ponto4.setHorario(LocalDateTime.of(2021, 01, 01, 12, 00, 00));
		PontoLogica.pontos.add(ponto4);	
		
		Ponto ponto5 = new Ponto();
		ponto5.setId(5);
		ponto5.setIdColaborador(4);
		ponto5.setTipoDePonto(TipoDePonto.Web);
		ponto5.setData(LocalDate.of(2021, 01, 01));
		ponto5.setLocalizacao("Minha casa");
		ponto5.setHorario(LocalDateTime.of(2021, 01, 01, 13, 30, 00));
		PontoLogica.pontos.add(ponto5);	
		
		Ponto ponto6 = new Ponto();
		ponto6.setId(6);
		ponto6.setIdColaborador(4);
		ponto6.setTipoDePonto(TipoDePonto.Web);
		ponto6.setData(LocalDate.of(2021, 01, 01));
		ponto6.setLocalizacao("Minha casa");
		ponto6.setHorario(LocalDateTime.of(2021, 01, 01, 15, 00, 00));
		PontoLogica.pontos.add(ponto6);	
		
		Ponto ponto7 = new Ponto();
		ponto7.setId(7);
		ponto7.setIdColaborador(4);
		ponto7.setTipoDePonto(TipoDePonto.Web);
		ponto7.setData(LocalDate.of(2021, 01, 01));
		ponto7.setLocalizacao("Minha casa");
		ponto7.setHorario(LocalDateTime.of(2021, 01, 01, 15, 30, 00));
		PontoLogica.pontos.add(ponto7);	
		
		Ponto ponto8 = new Ponto();
		ponto8.setId(8);
		ponto8.setIdColaborador(4);
		ponto8.setTipoDePonto(TipoDePonto.Web);
		ponto8.setData(LocalDate.of(2021, 01, 01));
		ponto8.setLocalizacao("Minha casa");
		ponto8.setHorario(LocalDateTime.of(2021, 01, 01, 18, 00, 00));
		PontoLogica.pontos.add(ponto8);	
		
		Ponto ponto9 = new Ponto();
		ponto9.setId(5);
		ponto9.setIdColaborador(2);
		ponto9.setTipoDePonto(TipoDePonto.Web);
		ponto9.setData(LocalDate.of(2021, 01, 23));
		ponto9.setLocalizacao("Minha casa");
		ponto9.setHorario(LocalDateTime.of(2021, 01, 23, 9, 04, 16));
		PontoLogica.pontos.add(ponto9);
		
		Ponto ponto10 = new Ponto();
		ponto10.setId(8);
		ponto10.setIdColaborador(6);
		ponto10.setTipoDePonto(TipoDePonto.Web);
		ponto10.setData(LocalDate.of(2021, 02, 18));
		ponto10.setLocalizacao("Minha casa");
		ponto10.setHorario(LocalDateTime.of(2021, 02, 18, 14, 45, 55));
		PontoLogica.pontos.add(ponto10);
		
		Ponto ponto11 = new Ponto();
		ponto11.setId(13);
		ponto11.setIdColaborador(11);
		ponto11.setTipoDePonto(TipoDePonto.Web);
		ponto11.setData(LocalDate.of(2021, 02, 10));
		ponto11.setLocalizacao("Minha casa");
		ponto11.setHorario(LocalDateTime.of(2021, 02, 10, 5, 04, 25));
		PontoLogica.pontos.add(ponto11);
		
		Ponto ponto12 = new Ponto();
		ponto12.setId(15);
		ponto12.setIdColaborador(5);
		ponto12.setTipoDePonto(TipoDePonto.Web);
		ponto12.setData(LocalDate.of(2021, 03, 20));
		ponto12.setLocalizacao("Minha casa");
		ponto12.setHorario(LocalDateTime.of(2021, 03, 20, 6, 24, 35));
		PontoLogica.pontos.add(ponto12);	
	}
	
	@Test
	public void testRetornaColaboradoresASeremNotificados() {
		popularPontos();
		popularColaboradores();
		ArrayList<Colaborador> colaboradores = NotificacaoLogica.retornaColaboradoresASeremNotificados(listaColaboradores);
		//fazer popular colaborador com um colaborador só de id 4 e chamar método que retorna colaboradores com jornada de trabalho menor do que a especificada
		
		assertEquals(colaboradores.get(0), listaColaboradores.get(0));
	
		
		
	}

}
