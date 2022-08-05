package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Facultad_Programa.Model.TipoMascotaModel;
import com.example.demo.Facultad_Programa.Service.TipoMascotaService;
import com.google.gson.Gson;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TipoMascotaController {

	public static Log LOG = LogFactory.getLog(TipoMascotaController.class);
	public static Gson gson = new Gson();

	TipoMascotaModel m = new TipoMascotaModel();
	@Autowired
	private TipoMascotaService tipomascotaService;
	
	@RequestMapping(value = "/tipoMascota", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TipoMascotaModel>> getAllTipoMascota() {
		List<TipoMascotaModel> listaMascotaModelReturn = null;
		try {
			listaMascotaModelReturn = tipomascotaService.getAllTipoMascotas();
			return new ResponseEntity<>(listaMascotaModelReturn, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.info(" Error : " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/tipoMascota/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<TipoMascotaModel> addMascota(@RequestBody TipoMascotaModel mascota) {
		HashMap<String, String> msg = new HashMap<>();
		TipoMascotaModel mascotaModel = null;
		LOG.info("ESTA ENTRANDO AL CONTROLLER DE RESIDUOS PROFESIONALES");
		try {
			
			mascotaModel = tipomascotaService.crearTipoMascota(mascota);
			
			return new ResponseEntity<>(mascotaModel, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.error("Error: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/tipoMascota/eliminar/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleterMascota(@PathVariable int id) {
		boolean resultado =false;
        try {
			resultado = tipomascotaService.deleteMascota(id);
			
			
        } catch (HibernateException e) {
            LOG.error(" Error : " + e.getMessage());
        }
        return resultado;
	}

	@RequestMapping(value = "/tipoMascota/buscarBy/{id}", method = RequestMethod.GET)
	@ResponseBody
	public TipoMascotaModel buscarByID(@PathVariable int id) {
		TipoMascotaModel resultado = new TipoMascotaModel();
        try {
			resultado = tipomascotaService.getTipoMascotaWithId(id);
			
			
        } catch (HibernateException e) {
            LOG.error(" Error : " + e.getMessage());
        }
        return resultado;
	}

}
