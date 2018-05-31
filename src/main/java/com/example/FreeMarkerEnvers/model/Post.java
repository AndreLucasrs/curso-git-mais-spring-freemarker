package com.example.FreeMarkerEnvers.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@Audited
@Table
@AuditTable(value="tbl_post_auditoria")
@Entity(name = "tbl_post")
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "post_seq", sequenceName = "post_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
	private Long id;
	
	@Autowired(required = false)
	@Column(nullable = false, length = 50)
	private String autor;
	
	@Autowired(required = false)
	@Column(nullable = false, length = 150)
	private String titulo;
	
	@Autowired(required = false)
	@Column(nullable = false, length = 2000)
	private String texto;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
