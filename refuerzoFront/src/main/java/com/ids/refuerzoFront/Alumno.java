package com.ids.refuerzoFront;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ALUMNO")

public class Alumno {
	//Bean de alumnos
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NOMBRE_CONTACTO")
	private String nombre;
	
	@Column(name="TEL_PERSONAL")
	private String tel_personal;
	
	@Column(name="TEL_OFICINA")
	private String tel_oficina;
	
	@Column(name="EMAIL_PERSONAL")
	private String email_personal;
	
	@Column(name="EMAIL_OFICINA")
	private String email_oficina;

	@Column(name="CUMPLE")
	private String cumple;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTel_personal() {
		return tel_personal;
	}

	public void setTel_personal(String tel_personal) {
		this.tel_personal = tel_personal;
	}

	public String getTel_oficina() {
		return tel_oficina;
	}

	public void setTel_oficina(String tel_oficina) {
		this.tel_oficina = tel_oficina;
	}

	public String getEmail_personal() {
		return email_personal;
	}

	public void setEmail_personal(String email_personal) {
		this.email_personal = email_personal;
	}

	public String getEmail_oficina() {
		return email_oficina;
	}

	public void setEmail_oficina(String email_oficina) {
		this.email_oficina = email_oficina;
	}
	
	public String getComple() {
		return cumple;
	}

	public void setComple(String comple) {
		this.cumple = comple;
	}

	
	
}
