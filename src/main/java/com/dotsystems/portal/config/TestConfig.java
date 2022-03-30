package com.dotsystems.portal.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dotsystems.portal.entities.Orgao;
import com.dotsystems.portal.entities.OrgaoSuperior;
import com.dotsystems.portal.entities.Portador;
import com.dotsystems.portal.entities.Transacao;
import com.dotsystems.portal.entities.UnidadeGestora;
import com.dotsystems.portal.repositories.OrgaoRepository;
import com.dotsystems.portal.repositories.OrgaoSuperiorRepository;
import com.dotsystems.portal.repositories.PortadorRepository;
import com.dotsystems.portal.repositories.TransacaoRepository;
import com.dotsystems.portal.repositories.UnidadeGestoraRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private OrgaoSuperiorRepository osRepository;

	@Autowired
	private OrgaoRepository oRepository;
	
	@Autowired
	private UnidadeGestoraRepository unRepository;
	
	@Autowired
	private PortadorRepository porRepository;
	
	@Autowired
	private TransacaoRepository transRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		OrgaoSuperior os1 = new OrgaoSuperior(1L, "Presidência da República");
		OrgaoSuperior os2 = new OrgaoSuperior(2L, "Ministério do Trabalho");
		
		Orgao o1 = new Orgao(1L, "Gabinete da presidência", os1);
		Orgao o2 = new Orgao(2L, "Secretaria do trabalho", os2);
		
		UnidadeGestora un1 = new UnidadeGestora(170344L, "GERENCIA REG. DE ADMINISTRACAO DO ME - ACRE", o2);
		UnidadeGestora un2 = new UnidadeGestora(167387L, "IF CATARINENSE - CAMPUS FRAIBURGO", o2);
		UnidadeGestora un3 = new UnidadeGestora(114608L, "4º CENTRO DE GEOINFORMACãO", o1);
		
		Portador po1 = new Portador(null, "PAULO CESAR HUCKEMBECK NUNES", "***.337.410-**", un3);
		Portador po2 = new Portador(null, "JOAO MARCOS BARBOZA", "***.561.688-**", un1);
		Portador po3 = new Portador(null, "HILTON SOUSA SILVA JUNIOR", "***.032.917-**", un3);
		Portador po4 = new Portador(null, "CLANDIO DE MATOS MARQUES", "***.110.000-**", un2);
		
		Transacao t1 = new Transacao(null, 2021, 10, "12126675000160", "LOJAS SAO JOSE COMERCIO VAREJISTA DE CAMA, MESA E BANHO EIRELI", "COMPRA A/V - R$ - APRES", LocalDate.parse("2016-11-24"), 722.82, po4);		
		Transacao t2 = new Transacao(null, 2021, 10, "90819061000178", "BANCA 12 ARMAZEM DE PRODUTOS NATURAIS EIRELI", "COMPRA A/V - R$ - APRES", LocalDate.now(), 176.26, po3);
		Transacao t3 = new Transacao(null, 2021, 10, "-2", "NAO SE APLICA", "SAQUE CASH/ATM BB", LocalDate.now(), 400.00, po2);
		Transacao t4 = new Transacao(null, 2021, 10, "10386762000121", "VICENTE LUCHESE BORTOLOTTO E CIA LTDA M E", "COMPRA A/V - R$ - APRES", LocalDate.now(), 1000.82, po1);
		Transacao t5 = new Transacao(null, 2021, 10, "11328757000125", "LOJAS SAO JOSE COMERCIO VAREJISTA DE CAMA, MESA E BANHO EIRELI", "COMPRA A/V - R$ - APRES", LocalDate.now(), 10544.82, po4);
		Transacao t6 = new Transacao(null, 2021, 10, "09253608000100", "KREJCI & CIA LTDA", "COMPRA A/V - R$ - APRES", LocalDate.now(), 200.82, po1);
		
		Transacao t7 = new Transacao(null, 2021, 10, "-11", "ADD IA LTDA", "COMPRA A/V - R$ - APRES", LocalDate.now(), 10000.0, po1);
		Transacao t8 = new Transacao(null, 2021, 10, "-11", "JACAKROASKA & CIA LTDA", "COMPRA A/V - R$ - APRES", LocalDate.now(), 5250.0, po1);

		
		
		osRepository.saveAll(Arrays.asList(os1, os2));
		oRepository.saveAll(Arrays.asList(o1, o2));
		unRepository.saveAll(Arrays.asList(un1, un2, un3));
		porRepository.saveAll(Arrays.asList(po1, po2, po3, po4));
		transRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8));
		
	}
}
