package com.habilidades.infrastructure.in;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.habilidades.aplication.CreateHabilidadCase;
import com.habilidades.aplication.DeleteHabilidadCase;
import com.habilidades.aplication.FindHabilidadCase;
import com.habilidades.aplication.UpdateHabilidadCase;
import com.habilidades.domain.entity.Habilidad;
import com.habilidades.domain.service.HabilidadService;

public class HabilidadController {
    private final CreateHabilidadCase createHabilidadCase;
    private final FindHabilidadCase findHabilidadCase;
    private final UpdateHabilidadCase updateHabilidadCase;
    private final DeleteHabilidadCase deleteHabilidadCase;

    public HabilidadController(HabilidadService habilidadService, CreateHabilidadCase createHabilidadCase, FindHabilidadCase findHabilidadCase,
                               UpdateHabilidadCase updateHabilidadCase, DeleteHabilidadCase deleteHabilidadCase) {
        this.createHabilidadCase = createHabilidadCase;
        this.findHabilidadCase = findHabilidadCase;
        this.updateHabilidadCase = updateHabilidadCase;
        this.deleteHabilidadCase = deleteHabilidadCase;
    }

    public void crear() throws SQLException {
        
        String name = JOptionPane.showInputDialog("Nombre:");
        String lastname = JOptionPane.showInputDialog("Apellido:");
        int idcity = Integer.parseInt(JOptionPane.showInputDialog("ID Ciudad:"));
        String address = JOptionPane.showInputDialog("Dirección:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
        String email = JOptionPane.showInputDialog("Email:");
        int idgender = Integer.parseInt(JOptionPane.showInputDialog("ID Género:"));

        Habilidad habilidad = new Habilidad(name, lastname, idcity, address, age, email, idgender);
        createHabilidadCase.execute(habilidad);
        JOptionPane.showMessageDialog(null, "Persona creada correctamente!");
    }

    public void buscar() throws SQLException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID de la Persona a buscar:"));
        Habilidad habilidad = findHabilidadCase.execute(id);

        if (habilidad != null) {
            System.out.println("Id: " + habilidad.getId());
            System.out.println("Nombre: " + habilidad.getName());
            System.out.println("Apellido: " + habilidad.getLastname());
            System.out.println("ID Ciudad: " + habilidad.getIdcity());
            System.out.println("Dirección: " + habilidad.getAddress());
            System.out.println("Edad: " + habilidad.getAge());
            System.out.println("Email: " + habilidad.getEmail());
            System.out.println("ID Género: " + habilidad.getIdgenter());
        } else {
            JOptionPane.showMessageDialog(null, "Persona no encontrada!");
        }
    }

    public void actualizar() throws SQLException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID de la Persona a actualizar sus Datos:"));
        String name = JOptionPane.showInputDialog("Nombre:");
        String lastname = JOptionPane.showInputDialog("Apellido:");
        int idcity = Integer.parseInt(JOptionPane.showInputDialog("ID Ciudad:"));
        String address = JOptionPane.showInputDialog("Dirección:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
        String email = JOptionPane.showInputDialog("Email:");
        int idgender = Integer.parseInt(JOptionPane.showInputDialog("ID Género:"));

        Habilidad habilidad = new Habilidad(id, name, lastname, idcity, address, age, email, idgender);
        updateHabilidadCase.execute(habilidad);
        JOptionPane.showMessageDialog(null, "Persona actualizada correctamente!");
    }

    public void eliminar() throws SQLException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID de la Persona a eliminar:"));
        deleteHabilidadCase.execute(id);
        JOptionPane.showMessageDialog(null, "Persona eliminada correctamente!");
    }
}
