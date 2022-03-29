package com.dotsystems.portal.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dotsystems.portal.entities.Orgao;
import com.dotsystems.portal.entities.OrgaoSuperior;
import com.dotsystems.portal.entities.Portador;
import com.dotsystems.portal.entities.UnidadeGestora;
import com.dotsystems.portal.repositories.OrgaoRepository;
import com.dotsystems.portal.repositories.OrgaoSuperiorRepository;
import com.dotsystems.portal.repositories.PortadorRepository;
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
		
		osRepository.saveAll(Arrays.asList(os1, os2));
		oRepository.saveAll(Arrays.asList(o1, o2));
		unRepository.saveAll(Arrays.asList(un1, un2, un3));
		porRepository.saveAll(Arrays.asList(po1, po2, po3, po4));
		
	}
}
