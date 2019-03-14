package com.ids.refuerzoFront;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	public void setAlumnoRepository(AlumnoRepository alumnoRepository){
		this.alumnoRepository = alumnoRepository;
	}
	
	@Override
	public List<Alumno> consultaAlumno() {
		// TODO Auto-generated method stub
		List<Alumno> alumno = alumnoRepository.findAll();
		return alumno;
	}

	@Override
	public Alumno consultaAlumno(Long alumnoId) {
		// TODO Auto-generated method stub
		Optional<Alumno> optAlumno = alumnoRepository.findById(alumnoId);
		return optAlumno.get();
	}

	@Override
	public void guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		alumnoRepository.save(alumno);
	}

	@Override
	public void borrarAlumno(Long alumnoId) {
		// TODO Auto-generated method stub
		 alumnoRepository.deleteById(alumnoId);
	}

	@Override
	public void actualizaAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		alumnoRepository.save(alumno);
	}

	

}
