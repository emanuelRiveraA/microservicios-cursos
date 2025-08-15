package com.formacionntt.microservicios.app.cursos.models.services;

import com.formacionntt.microservicios.app.cursos.models.entity.Curso;
import com.formacionntt.microservicios.commons.services.CommonService;

public interface CursoService extends CommonService<Curso> {
	
	public Curso findCursoByAlumnoId(Long id);

}
