package com.habilidades.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.habilidades.domain.entity.Habilidad;
import com.habilidades.domain.repository.HabilidadRepository;

public class HabilidadService {
    private final HabilidadRepository habilidadRepository;

    public HabilidadService(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
    }

    public void createHabilidad(Habilidad habilidad) throws SQLException {
        habilidadRepository.save(habilidad);
    }

    public Habilidad getHabilidadById(int id) throws SQLException {
        return habilidadRepository.findById(id);
    }

    public List<Habilidad> getAllHabilidades() throws SQLException {
        return habilidadRepository.findAll();
    }

    public void updateHabilidad(Habilidad habilidad) throws SQLException {
        habilidadRepository.update(habilidad);
    }

    public void deleteHabilidad(int id) throws SQLException {
        habilidadRepository.delete(id);
    }
}
