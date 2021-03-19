package com.formaciondbi.microservicios.empresa.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.formaciondbi.microservicios.empresa.entity.Empresa;
import com.formaciondbi.microservicios.empresa.entity.Noticia;
import com.formaciondbi.microservicios.empresa.repository.NoticiaRespository;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

public class EmpresaServiceImpl extends ServicesImpl<Empresa, Long> implements EmpresaService{

	@Autowired
	private NoticiaRespository noticiaRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Noticia> findNoticiasByEmpresaId(Long id) {
		
		return noticiaRepository.findNoticiasByEmpresaId(id);
	}


	@Override
	@Transactional(readOnly = true)
	public List<Noticia> finByTituloOrResumen(Long id, String term) {
		
		return noticiaRepository.finByTituloOrResumen(id,term);
	}


	@Override
	@Transactional(readOnly = true)
	public Page<Noticia> findAllPageableByEmpresaId(Long id, Pageable pageable) {
		
		return noticiaRepository.findAllPageableByEmpresaId(id, pageable);
	}
	
	

}
