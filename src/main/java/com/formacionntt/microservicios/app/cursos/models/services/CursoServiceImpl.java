package com.formacionntt.microservicios.app.cursos.models.services;

import org.springframework.stereotype.Service;

import com.formacionntt.microservicios.app.cursos.models.entity.Curso;
import com.formacionntt.microservicios.app.cursos.models.repository.CursoRepository;
import com.formacionntt.microservicios.commons.services.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

}
