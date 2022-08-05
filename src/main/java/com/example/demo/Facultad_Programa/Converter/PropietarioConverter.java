package com.example.demo.Facultad_Programa.Converter;

import org.springframework.stereotype.Component;
import com.example.demo.Facultad_Programa.Entity.Propietario;
import com.example.demo.Facultad_Programa.Model.PropietarioModel;


@Component("propietarioConverter")
public class PropietarioConverter {

	public PropietarioModel entityToModel(Propietario propietario) {
		PropietarioModel pro = new PropietarioModel();
            if(propietario!=null){
                pro.setId(propietario.getId());
                pro.setNombre(propietario.getNombre());
                pro.setComentarios(propietario.getComentarios());
                pro.setCorreo(propietario.getCorreo());
                pro.setDireccion(propietario.getDireccion());
                pro.setTelefono(propietario.getTelefono());

            }
        return pro;
    }
	
    public Propietario modelToEntity(PropietarioModel propietario) {
    	Propietario pro = new Propietario();
            if(propietario!=null){
                pro.setId(pro.getId());
                pro.setNombre(propietario.getNombre());
                pro.setComentarios(propietario.getComentarios());
                pro.setCorreo(propietario.getCorreo());
                pro.setDireccion(propietario.getDireccion());
                pro.setTelefono(propietario.getTelefono());
            }
        return pro;
    }

	
	
	
}
