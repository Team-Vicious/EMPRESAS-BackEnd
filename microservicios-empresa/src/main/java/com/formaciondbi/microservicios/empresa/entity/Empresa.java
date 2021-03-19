package com.formaciondbi.microservicios.empresa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 128)
	private String denominacion;
	
	@Column(length = 50)
	private String telefono;
	
	@Column(length = 256)
	private String horarioAtencion;
	
	@Column(length = 1024)
	private String quienSomos;
	
	@Column(length = 1020)
	private String iframe;
	
	@Column(length = 256)
	private String domicilio;
	
	@Column(length = 75)
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	List<Noticia> noticias;
	
	private Date createAt;

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
}
