package com.example.demo.Facultad_Programa.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "mascota", schema = "pruebamascota")
public class Mascota {

	@Id
	@Column(name = "idmascota")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "propietario_idpropietario", referencedColumnName = "idpropietario")
	private Propietario pro;

	@ManyToOne
	@JoinColumn(name = "tipo_mascota_idtipo_mascota", referencedColumnName = "idtipo_mascota")
	private TipoMascota tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Propietario getPro() {
		return pro;
	}

	public void setPro(Propietario pro) {
		this.pro = pro;
	}

	public TipoMascota getTipo() {
		return tipo;
	}

	public void setTipo(TipoMascota tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Mascota [  nombre=" + nombre + ", pro=" + pro + ", tipo=" + tipo + "]";
	}

	
}
