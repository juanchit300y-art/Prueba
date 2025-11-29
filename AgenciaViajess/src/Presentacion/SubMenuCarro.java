package Presentacion;

import java.util.Scanner;
import Controllers.*;
import Modelos.*;
import java.util.List;

public class SubMenuCarro {
    Scanner scanner;
    CarroController carroController;

    public SubMenuCarro(Scanner scanner) {
        this.carroController= new CarroController();
        this.scanner= scanner;
    }

    public SubMenuCarro(CarroController controlador, Scanner scanner) {
        this.carroController = controlador;
        this.scanner = scanner;
    }
    public void iniciarMenu() {
        int opcion=1;

        while (opcion != 0){
            System.out.println("===== MENÚ CARRO =====");
            System.out.println("1. Añadir Carro");
            System.out.println("2. Actualizar Carro");
            System.out.println("3. Eliminar Carro");
            System.out.println("4. Mostrar Todos los Carros");
            System.out.println("========Opciones Extras========");
            System.out.println("5. Asignar Servicio de Transporte a Carro");
            System.out.println("6. Ver Carros por Hotel");
            System.out.println("7. Ver Hotel de un Carro");
            System.out.println("8. Ver Servicios Transporte de un Carro");
            System.out.println("=======Presione 0 para Salir========");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    añadirCarro();
                    break;

                case 2:
                    actualizarCarro();
                    break;

                case 3:
                    eliminarCarro();
                    break;

                case 4:
                    mostrarTodosLosCarros();
                    break;

                case 5:
                    asignarServicioTransporte();          
                    break;

                case 6:
                    mostrarCarrosPorHotel();       
                    break;

                case 7:
                    mostrarHotelDeCarro(); 
                    break;

                case 8:
                    mostrarServiciosDeCarro(); 
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } 
    }

    // ===== OPCIÓN 1 =====
    private void añadirCarro() {
        System.out.println("======== Añadir Carro========");
        System.out.print("Marca del carro: ");
        String marca = scanner.nextLine();

        System.out.print("ID del hotel al que pertenece: ");
        Integer hotelId = scanner.nextInt();
        scanner.nextLine();

        if (carroController.añadirCarro(marca, hotelId)) {
            System.out.println("Carro añadido correctamente.");
        } else {
            System.out.println("Error al añadir: revise la marca o el hotel.");
        }
    }

    // ===== OPCIÓN 2 =====
    private void actualizarCarro() {
        System.out.println("========- Actualizar Carro========");
        System.out.print("ID del carro a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nueva marca (enter para no cambiar): ");
        String marca = scanner.nextLine();

        System.out.print("Nuevo ID de hotel (0 para no cambiar): ");
        int hotelId = scanner.nextInt();
        scanner.nextLine();

        if (hotelId == 0) hotelId = -1;

        boolean actualizado = carroController.actualizarCarro(
            id,
            marca.isEmpty() ? null : marca,
            hotelId == -1 ? null : hotelId
        );

        if (actualizado) {
            System.out.println("Carro actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar: datos inválidos.");
        }
    }

    // ===== OPCIÓN 3 =====
    private void eliminarCarro() {
        System.out.println("======== Eliminar Carro ========");
        System.out.print("ID del carro a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (carroController.eliminarObjeto(id)) {
            System.out.println("Carro eliminado correctamente.");
        } else {
            System.out.println("No se puede eliminar: el carro tiene servicios asociados.");
        }
    }

    // ===== OPCIÓN 4 =====
    private void asignarServicioTransporte() {
        System.out.println("========Asignar Servicio Transporte ========");
        System.out.print("ID del carro: ");
        int carroId = scanner.nextInt();

        System.out.print("ID del servicio transporte: ");
        int servicioId = scanner.nextInt();
        scanner.nextLine();

        boolean asignado = carroController.assignServicioTransporteToCarro(carroId, servicioId);

        if (asignado) {
            System.out.println("Servicio asignado correctamente.");
        } else {
            System.out.println("Error: IDs incorrectos.");
        }
    }

    // ===== OPCIÓN 5 =====
    private void mostrarCarrosPorHotel() {
        System.out.println("======== Carros por Hotel========");
        System.out.print("ID del hotel: ");
        int hotelId = scanner.nextInt();
        scanner.nextLine();

        List<Carro> carros = carroController.getCarrosByHotel(hotelId);

        if (carros.isEmpty()) {
            System.out.println("Este hotel no tiene carros registrados.");
        } else {
            carros.forEach(c -> System.out.println(c + "========"));
        }
    }

    // ===== OPCIÓN 6 =====
    private void mostrarHotelDeCarro() {
        System.out.println("========Hotel del Carro========");
        System.out.print("ID del carro: ");
        int carroId = scanner.nextInt();
        scanner.nextLine();

        Hotel hotel = carroController.getHotelDeCarro(carroId);

        if (hotel == null) {
            System.out.println("El carro no existe o no tiene hotel asignado.");
        } else {
            System.out.println(hotel);
        }
    }

    // ===== OPCIÓN 7 =====
    private void mostrarServiciosDeCarro() {
        System.out.println("======== Servicios de Transporte del Carro========");
        System.out.print("ID del carro: ");
        int carroId = scanner.nextInt();
        scanner.nextLine();

        List<ServicioTransporte> servicios = carroController.getServiciosTransporteDeCarro(carroId);

        if (servicios.isEmpty()) {
            System.out.println("Este carro no tiene servicios de transporte.");
        } else {
            servicios.forEach(s -> System.out.println(s + "\n"));
        }
    }

    // ===== OPCIÓN 8 =====
    private void mostrarTodosLosCarros() {
        System.out.println("======== Lista de todos los carros ======== ");
        List<Carro> carros = carroController.getAllGeneral();

        if (carros.isEmpty()) {
            System.out.println("No hay carros registrados.");
        } else {
            carros.forEach(c -> System.out.println(c + "\n"));
        }
    }
}
