package com.example.demo.Facultad_Programa.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.Facultad_Programa.Converter.PropietarioConverter;
import com.example.demo.Facultad_Programa.Entity.Propietario;
import com.example.demo.Facultad_Programa.Model.PropietarioModel;
import com.example.demo.Facultad_Programa.Repository.PropietarioRepository;
import com.example.demo.Facultad_Programa.Service.PropietarioService;

@Service("propietarioServiceImp")
public class PropietarioServiceImp implements PropietarioService {

	@Autowired
	@Qualifier("propietarioRepository")
	private PropietarioRepository propietarioRepository;

	@Autowired
	@Qualifier("propietarioConverter")
	private PropietarioConverter propietarioConverter;
	
	@Override
	public List<PropietarioModel> getAllPropietarios() {
		List<Propietario> listadoPropietario = propietarioRepository.findAll();
		List<PropietarioModel> lista = new ArrayList<>();

		for (Propietario m : listadoPropietario) {
			lista.add(propietarioConverter.entityToModel(m));

		}
		return lista;
	}

	@Override
	public PropietarioModel getPropietarioWithId(Integer id) {
		PropietarioModel pro = propietarioConverter.entityToModel(propietarioRepository.getById(id)); 
        return  pro ;
	}

	@Override
	public PropietarioModel crearPropietario(PropietarioModel propietarioModel) {
		PropietarioModel mas = null;
		try {
			

			System.out.println(propietarioModel.toString());
			
			
			Propietario residuo = propietarioRepository.save(propietarioConverter.modelToEntity(propietarioModel));

			mas = propietarioConverter.entityToModel(residuo);
		} catch (NullPointerException e) {
		} catch (SQLGrammarException e) {
			System.out.println(e);
		}
		return mas;
	}

	@Override
	public boolean deletePropietario(Integer id) {
		boolean resultado =false;
        try {
            propietarioRepository.deleteById(id);  
                 resultado=true;
        } catch (Exception e) {
            //TODO: handle exception
        }
         return resultado;
	}

	@Override
	public PropietarioModel buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
