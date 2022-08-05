package com.example.demo.Facultad_Programa.Service;

import java.util.List;

import com.example.demo.Facultad_Programa.Model.MascotaModel;

public interface MascotaService {
	
    public abstract List<MascotaModel> getAllMascotas();

    public abstract MascotaModel getMascotaWithId(Integer id);

    public abstract MascotaModel crearMascota(MascotaModel mascota);
   
    public abstract boolean deleteMascota(Integer id);

    public abstract MascotaModel buscarPorNombre(String nombre);

 

}
