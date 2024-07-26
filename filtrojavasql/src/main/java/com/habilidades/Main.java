package com.habilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.habilidades.aplication.CreateHabilidadCase;
import com.habilidades.aplication.DeleteHabilidadCase;
import com.habilidades.aplication.FindHabilidadCase;
import com.habilidades.aplication.UpdateHabilidadCase;
import com.habilidades.domain.repository.HabilidadRepository;
import com.habilidades.domain.service.HabilidadService;
import com.habilidades.infrastructure.in.HabilidadController;
import com.habilidades.infrastructure.repository.HabilidadRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/sgpzf";
        String username = "root";
        String password = "123456";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            HabilidadRepository habilidadRepository = new HabilidadRepositoryImpl(connection);
            HabilidadService habilidadService = new HabilidadService(habilidadRepository);

            CreateHabilidadCase createHabilidadCase = new CreateHabilidadCase(habilidadService);
            FindHabilidadCase findHabilidadCase = new FindHabilidadCase(habilidadService);
            UpdateHabilidadCase updateHabilidadCase = new UpdateHabilidadCase(habilidadService);
            DeleteHabilidadCase deleteHabilidadCase = new DeleteHabilidadCase(habilidadService);

            HabilidadController habilidadController = new HabilidadController(habilidadService, createHabilidadCase, 
                                                                              findHabilidadCase, updateHabilidadCase, 
                                                                              deleteHabilidadCase);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Habilidades");
                System.out.println("2. Personas");
                System.out.println("0. Salir");

                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (option) {
                    case 1 -> manejarPersonas(scanner);
                    case 2 -> manejarHabilidades(scanner, habilidadController);
                    case 0 -> {
                        System.out.println("Saliendo...");
                        return;
                    }
                    default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            }

        } catch (SQLException e) {
        }
    }

    private static void manejarPersonas(Scanner scanner) {
        while (true) {
            System.out.println("Gestion de Habilidades:");
            System.out.println("1. Crear Habilidad");
            System.out.println("2. Buscar Habilidad");
            System.out.println("3. Actualizar Habilidad");
            System.out.println("4. Eliminar Habilidad");
            System.out.println("0. Regresar al menú principal");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1 -> 
                    System.out.println("Creando persona...");
                
                case 2 -> 
                    System.out.println("Buscando persona...");
              
                case 3 -> 
                    System.out.println("Actualizando persona...");
                
                case 4 -> 
                    System.out.println("Eliminando persona...");
               
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void manejarHabilidades(Scanner scanner, HabilidadController habilidadController) throws SQLException {
        while (true) {
            System.out.println("Gestion de Personas:");
            System.out.println("1. Crear Persona");
            System.out.println("2. Buscar Persona");
            System.out.println("3. Actualizar Persona");
            System.out.println("4. Eliminar Persona");
            System.out.println("0. Regresar al menú principal");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1 -> habilidadController.crear();
                case 2 -> habilidadController.buscar();
                case 3 -> habilidadController.actualizar();
                case 4 -> habilidadController.eliminar();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}
