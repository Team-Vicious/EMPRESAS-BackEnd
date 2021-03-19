package com.formaciondbi.microservicios.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formaciondbi.microservicios.empresa.entity.Empresa;
import com.formaciondbi.microservicios.empresa.services.EmpresaService;
import com.formaciondbi.microservicios.generics.controllers.ControllerImpl;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

public class EmpresaController extends ControllerImpl<Empresa, ServicesImpl<Empresa,Long>>{

	@Autowired
	private EmpresaService empresaService;
	
	//trae todas las noticias de la empresa
	@GetMapping("/{id}/noticias")
	public ResponseEntity<?> findNoticiasByEmpresaId(@PathVariable Long id){
	
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.empresaService.findNoticiasByEmpresaId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("algo salio mal, intente mas tarde");
		}
	}
	
	//trae las noticias limitadas a 5 en orden descendente(el limit lo saque del request del repository porque da error, despues arreglar y agregar)
	@GetMapping("/{id}/noticias-filtrar/{term}")
	public ResponseEntity<?> finByTituloOrResumen(@PathVariable Long id, @PathVariable String term){
	
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.empresaService.finByTituloOrResumen(id, term));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("algo salio mal, intente mas tarde");
		}
	}
	
	//trae las noticias en orden descendente PAGINADAS
	@GetMapping("/{id}/noticias/paged")
	public ResponseEntity<?> getNoticiasPorEmpresaId(@PathVariable Long id, Pageable pageable){
	
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.empresaService.findAllPageableByEmpresaId(id, pageable));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("algo salio mal, intente mas tarde");
		}
	}
	
	
	
	
}
