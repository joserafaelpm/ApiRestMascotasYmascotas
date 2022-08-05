package com.example.demo.Facultad_Programa.Model;

public class TipoMascotaModel {

	private int id;
	private String descripcion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoMascota [id=" + id + ", descripcion=" + descripcion + "]";
	}

	
}
