package com.habilidades.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.habilidades.domain.entity.Habilidad;
import com.habilidades.domain.repository.HabilidadRepository;

public class HabilidadRepositoryImpl implements HabilidadRepository {
    private final Connection connection;

    public HabilidadRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Habilidad habilidad) throws SQLException {
        String query = "INSERT INTO persons (name, lastname, idcity, address, age, email, idgender) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, habilidad.getName());
            stmt.setString(2, habilidad.getLastname());
            stmt.setInt(3, habilidad.getIdcity());
            stmt.setString(4, habilidad.getAddress());
            stmt.setInt(5, habilidad.getAge());
            stmt.setString(6, habilidad.getEmail());
            stmt.setInt(7, habilidad.getIdgenter());
            stmt.executeUpdate();
        }
    }

    @Override
    public Habilidad findById(int id) throws SQLException {
        String query = "SELECT * FROM persons WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Habilidad(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("lastname"),
                    rs.getInt("idcity"),
                    rs.getString("address"),
                    rs.getInt("age"),
                    rs.getString("email"),
                    rs.getInt("idgender")
                );
            }
            return null;
        }
    }

    @Override
    public List<Habilidad> findAll() throws SQLException {
        String query = "SELECT * FROM persons";
        List<Habilidad> habilidades = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                habilidades.add(new Habilidad(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("lastname"),
                    rs.getInt("idcity"),
                    rs.getString("address"),
                    rs.getInt("age"),
                    rs.getString("email"),
                    rs.getInt("idgender")
                ));
            }
        }
        return habilidades;
    }

    @Override
    public void update(Habilidad habilidad) throws SQLException {
        String query = "UPDATE persons SET name = ?, lastname = ?, idcity = ?, address = ?, age = ?, email = ?, idgender = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, habilidad.getName());
            stmt.setString(2, habilidad.getLastname());
            stmt.setInt(3, habilidad.getIdcity());
            stmt.setString(4, habilidad.getAddress());
            stmt.setInt(5, habilidad.getAge());
            stmt.setString(6, habilidad.getEmail());
            stmt.setInt(7, habilidad.getIdgenter());
            stmt.setInt(8, habilidad.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM persons WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
