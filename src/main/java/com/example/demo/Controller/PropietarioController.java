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
import com.example.demo.Facultad_Programa.Model.PropietarioModel;
import com.example.demo.Facultad_Programa.Service.PropietarioService;
import com.google.gson.Gson;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PropietarioController {
	
	public static Log LOG = LogFactory.getLog(PropietarioController.class);
	public static Gson gson = new Gson();
	
	PropietarioModel m = new PropietarioModel();
	
	@Autowired
	private PropietarioService propietarioService;
	
	
	@RequestMapping(value = "/propietario", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<PropietarioModel>> getAllpropietarios() {
		List<PropietarioModel> listaMascotaModelReturn = null;
		try {
			listaMascotaModelReturn = propietarioService.getAllPropietarios();
			return new ResponseEntity<>(listaMascotaModelReturn, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.info(" Error : " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/propietario/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PropietarioModel> addPropietarios(@RequestBody PropietarioModel propietarioModel) {
		HashMap<String, String> msg = new HashMap<>();
		PropietarioModel mascotaModel = null;
		LOG.info("ESTA ENTRANDO AL CONTROLLER DE RESIDUOS PROFESIONALES");
		try {
			
			mascotaModel = propietarioService.crearPropietario(propietarioModel);
			
			return new ResponseEntity<>(mascotaModel, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.error("Error: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/propietario/eliminar/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleterMascota(@PathVariable int id) {
		boolean resultado =false;
        try {
			resultado = propietarioService.deletePropietario(id);
			
			
        } catch (HibernateException e) {
            LOG.error(" Error : " + e.getMessage());
        }
        return resultado;
	}

	@RequestMapping(value = "/propietario/buscarBy/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PropietarioModel buscarByID(@PathVariable int id) {
		PropietarioModel resultado = new PropietarioModel();
        try {
			resultado = propietarioService.getPropietarioWithId(id);
			
			
        } catch (HibernateException e) {
            LOG.error(" Error : " + e.getMessage());
        }
        return resultado;
	}
	
	
	

}
