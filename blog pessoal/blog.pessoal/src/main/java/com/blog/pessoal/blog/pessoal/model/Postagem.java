package com.blog.pessoal.blog.pessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class Postagem {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 200)
	private String titulo;
	
	@NotNull
	@Size(min = 5, max = 200)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data =  new java.sql.Date(System.currentTimeMillis());
	
	
	@ManyToOne
	@JsonIgnoreProperties
	private Tema tema;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
}
