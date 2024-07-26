package com.habilidades.domain.repository;

import java.sql.SQLException;
import java.util.List;

import com.habilidades.domain.entity.Habilidad;

public interface HabilidadRepository {
    void save(Habilidad habilidad) throws SQLException;
    Habilidad findById(int id) throws SQLException;
    List<Habilidad> findAll() throws SQLException;
    void update(Habilidad habilidad) throws SQLException;
    void delete(int id) throws SQLException;
}
