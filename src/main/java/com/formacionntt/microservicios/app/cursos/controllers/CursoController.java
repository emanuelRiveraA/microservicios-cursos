package com.formacionntt.microservicios.app.cursos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionntt.microservicios.app.cursos.models.entity.Curso;
import com.formacionntt.microservicios.app.cursos.models.services.CursoService;
import com.formacionntt.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionntt.microservicios.commons.controllers.CommonController;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id){
		Optional<Curso> optCurso = this.service.findById(id);
		if (optCurso.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoBD = optCurso.get();
		cursoBD.setNombre(curso.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoBD));
	}
	
	@PutMapping("/{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id){
		Optional<Curso> optCurso = this.service.findById(id);
		if (optCurso.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoBD = optCurso.get();
		//recorremos la lista de alumnos y se va a gregando al curso
		alumnos.forEach(a -> {
			cursoBD.addAlumno(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoBD));		
	}
	
	
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumnos(@RequestBody Alumno alumno, @PathVariable Long id){
		Optional<Curso> optCurso = this.service.findById(id);
		if (optCurso.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoBD = optCurso.get();
		
		cursoBD.removeAlumno(alumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoBD));		
	}

}
