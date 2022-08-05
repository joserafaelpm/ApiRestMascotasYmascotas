package com.example.demo.Facultad_Programa.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.Facultad_Programa.Converter.MascotaConverter;
import com.example.demo.Facultad_Programa.Converter.PropietarioConverter;
import com.example.demo.Facultad_Programa.Converter.TipoMascotaConverter;
import com.example.demo.Facultad_Programa.Entity.Mascota;
import com.example.demo.Facultad_Programa.Model.MascotaModel;
import com.example.demo.Facultad_Programa.Repository.MascotaRepository;
import com.example.demo.Facultad_Programa.Repository.PropietarioRepository;
import com.example.demo.Facultad_Programa.Repository.TipoMascotaRepository;
import com.example.demo.Facultad_Programa.Service.MascotaService;



@Service("facultadServiceImpl")
public class MascotaServiceImpl implements MascotaService {

	@Autowired
	@Qualifier("mascotaRepository")
	private MascotaRepository mascotaRepository;

	@Autowired
	@Qualifier("mascotaConverter")
	private MascotaConverter mascotaConverter;


    @Autowired
    @Qualifier("tipoMascotaRepository")
    private TipoMascotaRepository tipoMascotaRepository;
	
    @Autowired
    @Qualifier("tipoMascotaConverter")
    private TipoMascotaConverter tipoMascotaConverter;
	
    @Autowired
	@Qualifier("propietarioRepository")
	private PropietarioRepository propietarioRepository;

	@Autowired
	@Qualifier("propietarioConverter")
	private PropietarioConverter propietarioConverter;
	
    
    
    
    
    
	@Override
	public List<MascotaModel> getAllMascotas() {
		List<Mascota> listadoMascota = mascotaRepository.findAll();
		List<MascotaModel> lista = new ArrayList<>();

		for (Mascota m : listadoMascota) {
			System.out.println(mascotaConverter.entityToModel(m).toString());
			lista.add(mascotaConverter.entityToModel(m));
			
		}
		return lista;
	}

	@Override
	public MascotaModel getMascotaWithId(Integer id) {
		
		 MascotaModel mascota = mascotaConverter.entityToModel(mascotaRepository.getById(id)); 
	        return  mascota ;
	}

	@Override
	public MascotaModel crearMascota(MascotaModel mascotaModel) {
		MascotaModel mas = null;
		try {

			System.out.println(mascotaModel.toString());
			System.out.println(mascotaModel.getTipoModelId());
			System.out.println(mascotaModel.getPropietarioModelId());

//			System.out.println(tipoMascotaRepository.findById(mascotaModel.getTipoModelId()).get().toString());
			
//			
			mascotaModel.setTipo((tipoMascotaRepository.findById(mascotaModel.getTipoModelId()).get()));
			mascotaModel.setPro((propietarioRepository.findById(mascotaModel.getPropietarioModelId()).get()));
//			
			Mascota residuo = mascotaRepository.save(mascotaConverter.modelToEntity(mascotaModel));
//
			mas = mascotaConverter.entityToModel(residuo);
			
			
			System.out.println(mascotaModel.toString());

		} catch (NullPointerException e) {
		} catch (SQLGrammarException e) {
			System.out.println(e);
		}
		return mas;
	}

	@Override
	public boolean deleteMascota(Integer id) {
		boolean resultado =false;
        try {
            mascotaRepository.deleteById(id);  
                 resultado=true;
        } catch (Exception e) {
            //TODO: handle exception
        }
         return resultado;
	}

	@Override
	public MascotaModel buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
