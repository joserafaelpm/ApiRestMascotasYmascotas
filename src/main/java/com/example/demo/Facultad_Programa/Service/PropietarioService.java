package com.example.demo.Facultad_Programa.Service;

import java.util.List;

import com.example.demo.Facultad_Programa.Model.PropietarioModel;

public interface PropietarioService {

	public abstract List<PropietarioModel> getAllPropietarios();

    public abstract PropietarioModel getPropietarioWithId(Integer id);

    public abstract PropietarioModel crearPropietario(PropietarioModel propietario);
   
    public abstract boolean deletePropietario(Integer id);

    public abstract PropietarioModel buscarPorNombre(String nombre);
	
	
}
