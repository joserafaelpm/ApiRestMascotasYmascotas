package com.example.demo.Facultad_Programa.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.Facultad_Programa.Converter.TipoMascotaConverter;
import com.example.demo.Facultad_Programa.Entity.TipoMascota;
import com.example.demo.Facultad_Programa.Model.TipoMascotaModel;
import com.example.demo.Facultad_Programa.Repository.TipoMascotaRepository;
import com.example.demo.Facultad_Programa.Service.TipoMascotaService;

@Service("tipoMascotaServiceImpl")
public class TipoMascotaServiceImp implements TipoMascotaService {

	
    @Autowired
    @Qualifier("tipoMascotaRepository")
    private TipoMascotaRepository tipoMascotaRepository;

    @Autowired
    @Qualifier("tipoMascotaConverter")
    private TipoMascotaConverter tipoMascotaConverter;
	
	@Override
	public List<TipoMascotaModel> getAllTipoMascotas() {
		List<TipoMascota> listadoTipo = tipoMascotaRepository.findAll();
        List<TipoMascotaModel> lista = new ArrayList<>();

        for (TipoMascota t : listadoTipo) {
            lista.add(tipoMascotaConverter.entityToModel(t));

        }
        return lista;
	}

	@Override
	public TipoMascotaModel getTipoMascotaWithId(Integer id) {
		 TipoMascotaModel tipo = tipoMascotaConverter.entityToModel(tipoMascotaRepository.getById(id)); 
	        return  tipo ;
	}

	@Override
	public TipoMascotaModel crearTipoMascota(TipoMascotaModel tipomascotaModel) {
		TipoMascotaModel tipo = null;
		try {
			TipoMascota residuo = tipoMascotaRepository.save(tipoMascotaConverter.modelToEntity(tipomascotaModel));
			tipo = tipoMascotaConverter.entityToModel(residuo);
		} catch (NullPointerException e) {
		} catch (SQLGrammarException e) {
			System.out.println(e);
		}
		return tipo;
	}

	@Override
	public boolean deleteMascota(Integer id) {
		boolean resultado =false;
        try {
            tipoMascotaRepository.deleteById(id);  
                 resultado=true;
        } catch (Exception e) {
            //TODO: handle exception
        }
         return resultado;
	}

	@Override
	public TipoMascotaModel buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
