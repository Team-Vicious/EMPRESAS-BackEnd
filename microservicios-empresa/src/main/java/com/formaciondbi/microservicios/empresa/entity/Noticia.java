package com.formaciondbi.microservicios.empresa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "noticias")
public class Noticia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 128)
	private String titulo;
	
	@Column(length = 1024)
	private String resumen;
	
	@Column(length = 128)
	private String imagen;
	
	@Column(length = 20480)
	private String contenidoHtml;
	
	@Column(length = 1020)
	private char publicada;
	
	private Date createAt;

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
}
