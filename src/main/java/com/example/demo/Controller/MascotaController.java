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
import com.example.demo.Facultad_Programa.Model.MascotaModel;
import com.example.demo.Facultad_Programa.Service.MascotaService;
import com.example.demo.Facultad_Programa.ServiceImpl.MascotaServiceImpl;
import com.google.gson.Gson;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MascotaController {

	public static Log LOG = LogFactory.getLog(MascotaController.class);
	public static Gson gson = new Gson();

	MascotaModel m = new MascotaModel();
	
	@Autowired
	private MascotaService mascotaService;

	@RequestMapping(value = "/mascota", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<MascotaModel>> getAllMascota() {
		List<MascotaModel> listaMascotaModelReturn = null;
		try {
			listaMascotaModelReturn = mascotaService.getAllMascotas();
			return new ResponseEntity<>(listaMascotaModelReturn, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.info(" Error : " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/mascota/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<MascotaModel> addMascota(@RequestBody MascotaModel mascota) {
		HashMap<String, String> msg = new HashMap<>();
		MascotaModel mascotaModel = null;
		LOG.info("ESTA ENTRANDO AL CONTROLLER DE RESIDUOS PROFESIONALES");
		try {
			
			mascotaModel = mascotaService.crearMascota(mascota);
			
			return new ResponseEntity<>(mascotaModel, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.error("Error: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/mascota/eliminar/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleterMascota(@PathVariable int id) {
		boolean resultado =false;
        try {
			resultado=mascotaService.deleteMascota(id);
			
			
        } catch (HibernateException e) {
            LOG.error(" Error : " + e.getMessage());
        }
        return resultado;
	}

	@RequestMapping(value = "/mascota/buscarBy/{id}", method = RequestMethod.GET)
	@ResponseBody
	public MascotaModel buscarByID(@PathVariable int id) {
		MascotaModel resultado = new MascotaModel();
        try {
			resultado= mascotaService.getMascotaWithId(id);
			
			
        } catch (HibernateException e) {
            LOG.error(" Error : " + e.getMessage());
        }
        return resultado;
	}

	
	
	
	
	
	
	

}
