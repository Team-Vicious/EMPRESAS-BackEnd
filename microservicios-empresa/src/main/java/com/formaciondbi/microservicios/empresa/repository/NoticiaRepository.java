package com.formaciondbi.microservicios.empresa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.formaciondbi.microservicios.empresa.entity.Noticia;
import com.formaciondbi.microservicios.generics.repository.Repository;

public interface NoticiaRepository extends Repository<Noticia, Long>{

	//trae todas las noticias por id empresa
	@Query("select n from Empresa e join e.noticias n where e.id=?1")
	public List<Noticia> findNoticiasByEmpresaId(Long id); 
	
	//trae una consulta descendente de noticias por id empresa
	@Query("select n from Empresa e join e.noticias n where e.id=?1 AND upper(n.titulo) like upper(concat('%', ?2, '%')) or upper(n.resumen) like upper(concat('%', ?2, '%')) ORDER BY n.createAt DESC")
	public List<Noticia> findByTituloOrResumen(Long id, String term);
	
	//trae una consulta descendente pageable de noticias por id empresa
	@Query("select n from Empresa e join e.noticias n where e.id=?1 AND upper(n.titulo) like upper(concat('%', ?2, '%')) or upper(n.resumen) like upper(concat('%', ?2, '%')) ORDER BY n.createAt DESC")
	public Page<Noticia> findNoticiaByTituloOrResumenByEmpresaId(Long id, String term, Pageable pageable);


	//trae una noticia por su id
	@Query("select n from Empresa e join e.noticias n where n.id=?1")
	public Noticia findNoticiaById(Long id);
}
