package com.formaciondbi.microservicios.empresa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formaciondbi.microservicios.empresa.entity.Empresa;
import com.formaciondbi.microservicios.empresa.entity.Noticia;
import com.formaciondbi.microservicios.empresa.repository.NoticiaRepository;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@Service
public class EmpresaServiceImpl extends ServicesImpl<Empresa, Long> implements EmpresaService{

	
	@Autowired
	private NoticiaRepository noticiaRepository;
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Noticia> findNoticiasByEmpresaId(Long id) {
		
		return noticiaRepository.findNoticiasByEmpresaId(id);
	}


	@Override
	@Transactional(readOnly = true)
	public List<Noticia> findByTituloOrResumen(Long id, String term) {
		
		return noticiaRepository.findByTituloOrResumen(id,term);
	}

	
	@Override
	@Transactional(readOnly = true)
	public Page<Noticia> findNoticiaByTituloOrResumenByEmpresaId(Long id, String term, Pageable pageable) {
		
		return noticiaRepository.findNoticiaByTituloOrResumenByEmpresaId(id, term, pageable);
	}

}
