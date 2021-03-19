package com.formaciondbi.microservicios.empresa.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.formaciondbi.microservicios.empresa.entity.Empresa;
import com.formaciondbi.microservicios.empresa.entity.Noticia;
import com.formaciondbi.microservicios.generics.services.Services;

public interface EmpresaService extends Services<Empresa, Long>{
	
	public List<Noticia> findNoticiasByEmpresaId(Long id); 
	
	public List<Noticia> findByTituloOrResumen(Long id, String term);
	
	public Page<Noticia> findNoticiaByTituloOrResumenByEmpresaId(Long id, String term, Pageable pageable);
	
}
