package com.example.demo.Facultad_Programa.Service;

import java.util.List;

import com.example.demo.Facultad_Programa.Model.TipoMascotaModel;

public interface TipoMascotaService {

	public abstract List<TipoMascotaModel> getAllTipoMascotas();

    public abstract TipoMascotaModel getTipoMascotaWithId(Integer id);

    public abstract TipoMascotaModel crearTipoMascota(TipoMascotaModel tipomascota);
   
    public abstract boolean deleteMascota(Integer id);

    public abstract TipoMascotaModel buscarPorNombre(String nombre);
	
	
}
