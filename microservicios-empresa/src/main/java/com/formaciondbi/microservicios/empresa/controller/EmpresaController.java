package com.formaciondbi.microservicios.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.formaciondbi.microservicios.empresa.entity.Empresa;
import com.formaciondbi.microservicios.empresa.services.EmpresaService;
import com.formaciondbi.microservicios.generics.controllers.ControllerImpl;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@RestController
public class EmpresaController extends ControllerImpl<Empresa, ServicesImpl<Empresa,Long>>{

	@Autowired
	private EmpresaService empresaService;
	
	
	//trae todas las noticias por id empresa
	@GetMapping("/{id}/noticias")
	public ResponseEntity<?> findNoticiasByEmpresaId(@PathVariable Long id){
	
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.empresaService.findNoticiasByEmpresaId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("algo salio mal, intente mas tarde \n"+ e.getMessage());
		}
	}
	
	//trae una consulta descendente de noticias por id empresa
	@GetMapping("/{id}/noticias-filtrar/{term}")
	public ResponseEntity<?> findByTituloOrResumen(@PathVariable Long id, @PathVariable String term){
	
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.empresaService.findByTituloOrResumen(id, term));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("algo salio mal, intente mas tarde \n"+ e.getMessage());
		}
	}
	
	//trae una consulta descendente pageable de noticias por id empresa
	@GetMapping("/{id}/noticias-filtrar/{term}/paged")
	public ResponseEntity<?> obtenerPaginable(@PathVariable Long id, @PathVariable String term, Pageable pageable){
	
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.empresaService.findNoticiaByTituloOrResumenByEmpresaId(id, term, pageable));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("algo salio mal, intente mas tarde \n"+ e.getMessage());
		}
	}
	
	
	//trae una noticia por su id
		@GetMapping("/noticias/{id}")
		public ResponseEntity<?> findNoticiaById(@PathVariable Long id){
		
			try {
				return ResponseEntity.status(HttpStatus.OK).body(this.empresaService.findNoticiaById(id));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("algo salio mal, intente mas tarde \n"+ e.getMessage());
			}
		}
	
	
}
