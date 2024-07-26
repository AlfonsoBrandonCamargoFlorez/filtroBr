package com.habilidades.aplication;

import java.sql.SQLException;

import com.habilidades.domain.service.HabilidadService;

public class DeleteHabilidadCase {
    private final HabilidadService habilidadService;

    public DeleteHabilidadCase(HabilidadService habilidadService) {
        this.habilidadService = habilidadService;
    }

    public void execute(int id) throws SQLException {
        habilidadService.deleteHabilidad(id);
    }
}
