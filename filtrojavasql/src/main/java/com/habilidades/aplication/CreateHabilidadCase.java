package com.habilidades.aplication;

import java.sql.SQLException;

import com.habilidades.domain.entity.Habilidad;
import com.habilidades.domain.service.HabilidadService;

public class CreateHabilidadCase {
    private final HabilidadService habilidadService;

    public CreateHabilidadCase(HabilidadService habilidadService) {
        this.habilidadService = habilidadService;
    }

    public void execute(Habilidad habilidad) throws SQLException {
        habilidadService.createHabilidad(habilidad);
    }
}
