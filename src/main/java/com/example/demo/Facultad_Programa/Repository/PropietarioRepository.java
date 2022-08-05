package com.example.demo.Facultad_Programa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Facultad_Programa.Entity.Propietario;
@Repository("propietarioRepository")
public interface PropietarioRepository extends JpaRepository<Propietario, Integer> {
	
	
	
	

}
