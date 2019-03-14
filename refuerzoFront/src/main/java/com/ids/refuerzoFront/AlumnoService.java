package com.ids.refuerzoFront;

import java.util.List;

public interface AlumnoService {
	
	public List<Alumno> consultaAlumno();
		
	public Alumno consultaAlumno(Long alumno);
	
	public void guardarAlumno(Alumno alumno);
	
	public void borrarAlumno(Long alumnoId);
	
	public void actualizaAlumno(Alumno alumno);
	
}
