package com.example.demo.Facultad_Programa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Facultad_Programa.Entity.TipoMascota;
@Repository("tipoMascotaRepository")
public interface TipoMascotaRepository extends JpaRepository<TipoMascota, Integer> {
	
	
	
	

}
