package com.habilidades.aplication;

import java.sql.SQLException;

import com.habilidades.domain.entity.Habilidad;
import com.habilidades.domain.service.HabilidadService;

public class FindHabilidadCase {
    private final HabilidadService habilidadService;

    public FindHabilidadCase(HabilidadService habilidadService) {
        this.habilidadService = habilidadService;
    }

    public Habilidad execute(int id) throws SQLException {
        return habilidadService.getHabilidadById(id);
    }
}
