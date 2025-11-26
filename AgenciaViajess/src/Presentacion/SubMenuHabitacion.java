package Presentacion;

import Controllers.HabitacionController;
import Modelos.Habitacion;
import Modelos.Reserva;
import Modelos.Hotel;
import java.util.List;
import java.util.Scanner;

public class SubMenuHabitacion {

    private Scanner scanner = new Scanner(System.in);
    private HabitacionController controller = new HabitacionController();

    public void mostrarMenu() {
        int opcion = 1;

        while (opcion != 0) {
            System.out.println("============= SUBMENU HABITACION ====================");
            System.out.println("1. Crear Habitación");
            System.out.println("2. Actualizar Habitación");
            System.out.println("3. Eliminar Habitación");
            System.out.println("4. Ver Habitación por ID");
            System.out.println("5. Ver todas las Habitaciones");

            System.out.println("------ Opciones extras ------");
            System.out.println("6. Ver Reservas asociadas a una Habitación");
            System.out.println("7. Asignar Reserva a una Habitación");
            System.out.println("8. Ver Habitaciones por ID de Hotel");
            System.out.println("9. Ver Hotel asociado a una Habitación");

            System.out.println("======= Presione 0 para Salir =======");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

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
                    verReservasDeHabitacion();
                    break;
                case 7:
                    asignarReserva();
                    break;
                case 8:
                    verHabitacionesPorHotel();
                    break;
                case 9:
                    verHotelDeHabitacion();
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
        System.out.println("=== Crear Habitación ===");

        System.out.print("Ingrese la capacidad: ");
        Integer capacidad = scanner.nextInt();

        System.out.print("Ingrese el ID del Hotel: ");
        Integer hotelId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.añadirHabitacion(capacidad, hotelId);

        if (resultado) {
            System.out.println("Habitación creada correctamente.");
        } else {
            System.out.println("No se pudo crear la habitación. Verifique los datos.");
        }
    }

    private void actualizar() {
        System.out.println("=== Actualizar Habitación ===");

        System.out.print("Ingrese el ID de la Habitación: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nueva capacidad (0 para no cambiar): ");
        Integer capacidad = scanner.nextInt();
        scanner.nextLine();
        if (capacidad == 0) capacidad = null;

        System.out.print("Nuevo ID de Hotel (0 para no cambiar): ");
        Integer hotelId = scanner.nextInt();
        scanner.nextLine();
        if (hotelId == 0) hotelId = null;

        boolean resultado = controller.actualizarHabitacion(id, capacidad, hotelId);

        if (resultado) {
            System.out.println("Habitación actualizada correctamente.");
        } else {
            System.out.println("No se pudo actualizar. Verifique los datos.");
        }
    }

    private void eliminar() {
        System.out.println("=== Eliminar Habitación ===");

        System.out.print("Ingrese el ID de la Habitación: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.eliminarObjeto(id);

        if (resultado) {
            System.out.println("Habitación eliminada correctamente.");
        } else {
            System.out.println("No se pudo eliminar. La habitación tiene reservas asociadas.");
        }
    }

    private void verPorId() {
        System.out.println("=== Ver Habitación por ID ===");

        System.out.print("Ingrese el ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Habitacion habitacion = controller.getGeneralById(id);

        if (habitacion != null) {
            System.out.println(habitacion);
        } else {
            System.out.println("No se encontró una habitación con ese ID.");
        }
    }

    private void verTodos() {
        System.out.println("=== Lista de Habitaciones ===");

        List<Habitacion> lista = controller.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("No hay registros disponibles.");
        } else {
            for (Habitacion h : lista) {
                System.out.println(h);
            }
        }
    }

    private void verReservasDeHabitacion() {
        System.out.println("=== Ver Reservas de una Habitación ===");

        System.out.print("Ingrese el ID de la Habitación: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        List<Reserva> reservas = controller.getReservasDeHabitacion(id);

        if (reservas.isEmpty()) {
            System.out.println("No hay reservas asociadas a esta habitación.");
        } else {
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }

    private void asignarReserva() {
        System.out.println("=== Asignar Reserva a una Habitación ===");

        System.out.print("Ingrese el ID de la Habitación: ");
        Integer habitacionId = scanner.nextInt();

        System.out.print("Ingrese el ID de la Reserva: ");
        Integer reservaId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.assignReservaToHabitacion(habitacionId, reservaId);

        if (resultado) {
            System.out.println("Reserva asignada correctamente.");
        } else {
            System.out.println("No se pudo asignar la reserva. Verifique los IDs.");
        }
    }

    private void verHabitacionesPorHotel() {
        System.out.println("=== Ver Habitaciones por ID de Hotel ===");

        System.out.print("Ingrese el ID del Hotel: ");
        Integer hotelId = scanner.nextInt();
        scanner.nextLine();

        List<Habitacion> lista = controller.getHabitacionesByHotel(hotelId);

        if (lista.isEmpty()) {
            System.out.println("No se encontraron habitaciones para ese hotel.");
        } else {
            for (Habitacion h : lista) {
                System.out.println(h);
            }
        }
    }

    private void verHotelDeHabitacion() {
        System.out.println("=== Ver Hotel asociado a una Habitación ===");

        System.out.print("Ingrese el ID de la Habitación: ");
        Integer habitacionId = scanner.nextInt();
        scanner.nextLine();

        Hotel hotel = controller.getHotelDeHabitacion(habitacionId);

        if (hotel != null) {
            System.out.println(hotel);
        } else {
            System.out.println("No se encontró un hotel asociado.");
        }
    }
}
