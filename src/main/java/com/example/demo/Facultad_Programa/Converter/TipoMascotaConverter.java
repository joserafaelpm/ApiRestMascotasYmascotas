package com.example.demo.Facultad_Programa.Converter;

import org.springframework.stereotype.Component;
import com.example.demo.Facultad_Programa.Entity.TipoMascota;
import com.example.demo.Facultad_Programa.Model.TipoMascotaModel;

@Component("tipoMascotaConverter")
public class TipoMascotaConverter {
	
	public TipoMascotaModel entityToModel(TipoMascota tipomascota) {
		TipoMascotaModel tipo = new TipoMascotaModel();
            if(tipomascota!=null){
                tipo.setId(tipomascota.getId());
                tipo.setDescripcion(tipomascota.getDescripcion());

            }
        return tipo;
    }
	
    public TipoMascota modelToEntity(TipoMascotaModel tipomascota) {
        TipoMascota tipo = new TipoMascota();
            if(tipomascota!=null){
                tipo.setId(tipomascota.getId());
                tipo.setDescripcion(tipomascota.getDescripcion());
            }
        return tipo;
    }

}
