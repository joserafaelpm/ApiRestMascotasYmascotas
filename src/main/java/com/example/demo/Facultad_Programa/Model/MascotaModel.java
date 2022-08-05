package com.example.demo.Facultad_Programa.Model;

import com.example.demo.Facultad_Programa.Entity.Propietario;
import com.example.demo.Facultad_Programa.Entity.TipoMascota;

public class MascotaModel {

	private int id;
	private String nombre;
	private Propietario pro;
	private TipoMascota tipo;
	private int propietarioModelId;
	private int tipoModelId;

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
	
	
	

	public int getPropietarioModelId() {
		return propietarioModelId;
	}

	public void setPropietarioModelId(int propietarioModelId) {
		this.propietarioModelId = propietarioModelId;
	}

	public int getTipoModelId() {
		return tipoModelId;
	}

	public void setTipoModelId(int tipoModelId) {
		this.tipoModelId = tipoModelId;
	}

	@Override
	public String toString() {
		return "MascotaModel [ nombre=" + nombre + ", pro=" + pro + ", tipo=" + tipo
				+ ", propietarioModelId=" + propietarioModelId + ", tipoModelId=" + tipoModelId + "]";
	}


	
	
}
