package com.ids.refuerzoFront;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoRestController {
	
	@Autowired 
	private AlumnoService alumnoService;
	
	public void setAlumnosService(AlumnoService alumnoService){
		this.alumnoService = alumnoService;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/api/alumnos")
	public List<Alumno> consultaAlumnos() {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = alumnoService.consultaAlumno();
		return alumnos;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/api/alumnos/{alumnoId}")
	public Alumno consultaAlumno(@PathVariable (name="alumnoId")Long alumnoId) {
		// TODO Auto-generated method stub
		return alumnoService.consultaAlumno(alumnoId);
		 
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/api/alumnos")
	public void guardarAlumno(@RequestBody Alumno alumno) {
		// TODO Auto-generated method stub
		alumnoService.guardarAlumno(alumno);
		System.out.println("Contacto Agregado con éxito");	
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/api/alumnos/{alumnoId}")
	public void borrarAlumno(@PathVariable(name="alumnoId") Long alumnoId) {
		// TODO Auto-generated method stub
		alumnoService.borrarAlumno(alumnoId);
		System.out.println("Alumno eliminado");
		
	}
	
	@PutMapping("/api/alumnos/{alumnoId}")
	public void actualizaAlumno(@RequestBody Alumno alumno, 
			@PathVariable(name="alumnoId")Long alumnoId) {
		// TODO Auto-generated method stub
		Alumno emp = alumnoService.consultaAlumno(alumnoId);
		if(emp != null) {
			alumnoService.actualizaAlumno(alumno);

		}

	}	
	
}
