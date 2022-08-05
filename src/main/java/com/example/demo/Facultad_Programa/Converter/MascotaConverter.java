package com.example.demo.Facultad_Programa.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.example.demo.Facultad_Programa.Entity.Mascota;
import com.example.demo.Facultad_Programa.Model.MascotaModel;

@Component("mascotaConverter")
public class MascotaConverter {

	@Autowired
	@Qualifier("propietarioConverter")
	private PropietarioConverter propietarioConverter;
	
	@Autowired
	@Qualifier("tipoMascotaConverter")
	private TipoMascotaConverter tipoMascotaConverter;
	

	public MascotaModel entityToModel(Mascota mascota) {

		MascotaModel mas = new MascotaModel();
		if (mascota != null) {
			mas.setId(mascota.getId());
			mas.setNombre(mascota.getNombre());
			mas.setPro(mascota.getPro());
			mas.setTipo(mascota.getTipo());

		}
		return mas;
	}

	public Mascota modelToEntity(MascotaModel mascota) {
		Mascota mas = new Mascota();
		if (mascota != null) {
			mas.setId(mascota.getId());
			mas.setNombre(mascota.getNombre());
			mas.setPro(mascota.getPro());
			mas.setTipo(mascota.getTipo());
		}
		return mas;
	}

}
