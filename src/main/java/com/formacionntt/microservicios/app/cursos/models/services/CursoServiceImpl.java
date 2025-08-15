package com.formacionntt.microservicios.app.cursos.models.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionntt.microservicios.app.cursos.models.entity.Curso;
import com.formacionntt.microservicios.app.cursos.models.repository.CursoRepository;
import com.formacionntt.microservicios.commons.services.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		// TODO Auto-generated method stub
		return repository.findCursoByAlumnoId(id);
	}

}
