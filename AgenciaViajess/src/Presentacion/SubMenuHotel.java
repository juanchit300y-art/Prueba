package Presentacion;

import Controllers.HotelController;
import Modelos.Hotel;
import Modelos.Habitacion;
import Modelos.Carro;
import Modelos.Municipio;

import java.util.List;
import java.util.Scanner;

public class SubMenuHotel {

    private Scanner scanner;
    private HotelController controller;
    private SubMenuCarro submenuCarro;
    private SubMenuHabitacion submenuHabitacion;
    public SubMenuHotel(Scanner scanner) {
        this.controller = new HotelController();
        this.scanner = scanner;
        this.submenuCarro= new SubMenuCarro(scanner);
        this.submenuHabitacion= new SubMenuHabitacion(scanner);

    }
    
    public void mostrarMenu() {
        int opcion = 1;

        while (opcion != 0) {
            System.out.println("============= SUBMENU HOTEL ====================");
            System.out.println("1. Crear Hotel");
            System.out.println("2. Actualizar Hotel");
            System.out.println("3. Eliminar Hotel");
            System.out.println("4. Ver Hotel por ID");
            System.out.println("5. Ver todos los Hoteles");

            System.out.println("------ Opciones extras ------");
            System.out.println("6. Ver Habitaciones asociadas a un Hotel");
            System.out.println("7. Asignar Habitación a un Hotel");
            System.out.println("8. Ver Carros asociados a un Hotel");
            System.out.println("9. Asignar Carro a un Hotel");
            System.out.println("10. Ver Hoteles por ID de Municipio");
            System.out.println("11. Ver Municipio asociado a un Hotel");
            System.out.println("12. Gestionar Carros");
            System.out.println("13. Gestionar Habitaciones");

            System.out.println("======= Presione 0 para Salir =======");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    crear();
                    break;
                case 2:
                    actualizar();
                    break;
                case 3:
                    eliminar();
                    break;
                case 4:
                    verPorId();
                    break;
                case 5:
                    verTodos();
                    break;
                case 6:
                    verHabitacionesDeHotel();
                    break;
                case 7:
                    asignarHabitacion();
                    break;
                case 8:
                    verCarrosDeHotel();
                    break;
                case 9:
                    asignarCarro();
                    break;
                case 10:
                    verHotelesPorMunicipio();
                    break;
                case 11:
                    verMunicipioDeHotel();
                    break;
                case 12:
                    submenuCarro.iniciarMenu();
                    break;
                case 13:
                    submenuHabitacion.mostrarMenu();
                    break;
                case 0:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private void crear() {
        System.out.println("=== Crear Hotel ===");

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el correo: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese el ID del Municipio: ");
        Integer municipioId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.añadirHotel(nombre, correo, municipioId);

        if (resultado) {
            System.out.println("Hotel creado correctamente.");
        } else {
            System.out.println("No se pudo crear el hotel. Verifique los datos.");
        }
    }

    private void actualizar() {
        System.out.println("=== Actualizar Hotel ===");

        System.out.print("Ingrese el ID del Hotel: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo nombre (enter si no cambia): ");
        String nombre = scanner.nextLine();
        if (nombre.isEmpty()) nombre = null;

        System.out.print("Nuevo correo (enter si no cambia): ");
        String correo = scanner.nextLine();
        if (correo.isEmpty()) correo = null;

        System.out.print("Nuevo ID de Municipio (0 para no cambiar): ");
        Integer municipioId = scanner.nextInt();
        scanner.nextLine();
        if (municipioId == 0) municipioId = null;

        boolean resultado = controller.actualizarHotel(id, nombre, correo, municipioId);

        if (resultado) {
            System.out.println("Hotel actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar. Verifique los datos.");
        }
    }

    private void eliminar() {
        System.out.println("=== Eliminar Hotel ===");

        System.out.print("Ingrese el ID del Hotel: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.eliminarObjeto(id);

        if (resultado) {
            System.out.println("Hotel eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar. El hotel tiene habitaciones o carros asociados.");
        }
    }

    private void verPorId() {
        System.out.println("=== Ver Hotel por ID ===");

        System.out.print("Ingrese el ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Hotel hotel = controller.getGeneralById(id);

        if (hotel != null) {
            System.out.println(hotel);
        } else {
            System.out.println("No se encontró un hotel con ese ID.");
        }
    }

    private void verTodos() {
        System.out.println("=== Lista de Hoteles ===");

        List<Hotel> lista = controller.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("No hay registros disponibles.");
        } else {
            for (Hotel h : lista) {
                System.out.println(h);
            }
        }
    }

    private void verHabitacionesDeHotel() {
        System.out.println("=== Ver Habitaciones de un Hotel ===");

        System.out.print("Ingrese el ID del Hotel: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        List<Habitacion> lista = controller.getHabitacionesDeHotel(id);

        if (lista.isEmpty()) {
            System.out.println("No hay habitaciones asociadas a este hotel.");
        } else {
            for (Habitacion h : lista) {
                System.out.println(h);
            }
        }
    }

    private void asignarHabitacion() {
        System.out.println("=== Asignar Habitación a un Hotel ===");

        System.out.print("Ingrese el ID del Hotel: ");
        Integer hotelId = scanner.nextInt();

        System.out.print("Ingrese el ID de la Habitación: ");
        Integer habitacionId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.assignHabitacionToHotel(hotelId, habitacionId);

        if (resultado) {
            System.out.println("Habitación asignada correctamente.");
        } else {
            System.out.println("No se pudo asignar la habitación. Verifique los IDs.");
        }
    }

    private void verCarrosDeHotel() {
        System.out.println("=== Ver Carros de un Hotel ===");

        System.out.print("Ingrese el ID del Hotel: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        List<Carro> lista = controller.getCarrosDeHotel(id);

        if (lista.isEmpty()) {
            System.out.println("No hay carros asociados a este hotel.");
        } else {
            for (Carro c : lista) {
                System.out.println(c);
            }
        }
    }

    private void asignarCarro() {
        System.out.println("=== Asignar Carro a un Hotel ===");

        System.out.print("Ingrese el ID del Hotel: ");
        Integer hotelId = scanner.nextInt();

        System.out.print("Ingrese el ID del Carro: ");
        Integer carroId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.assignCarroToHotel(hotelId, carroId);

        if (resultado) {
            System.out.println("Carro asignado correctamente.");
        } else {
            System.out.println("No se pudo asignar el carro. Verifique los datos.");
        }
    }

    private void verHotelesPorMunicipio() {
        System.out.println("=== Ver Hoteles por ID de Municipio ===");

        System.out.print("Ingrese el ID del Municipio: ");
        Integer municipioId = scanner.nextInt();
        scanner.nextLine();

        List<Hotel> lista = controller.getHotelesByMunicipio(municipioId);

        if (lista.isEmpty()) {
            System.out.println("No se encontraron hoteles para ese municipio.");
        } else {
            for (Hotel h : lista) {
                System.out.println(h);
            }
        }
    }

    private void verMunicipioDeHotel() {
        System.out.println("=== Ver Municipio de un Hotel ===");

        System.out.print("Ingrese el ID del Hotel: ");
        Integer hotelId = scanner.nextInt();
        scanner.nextLine();

        Municipio municipio = controller.getMunicipioDeHotel(hotelId);

        if (municipio != null) {
            System.out.println(municipio);
        } else {
            System.out.println("No se encontró un municipio asociado.");
        }
    }
}
