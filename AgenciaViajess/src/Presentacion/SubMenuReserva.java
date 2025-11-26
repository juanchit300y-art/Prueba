package Presentacion;

import Controllers.ReservaController;
import Modelos.Reserva;
import Modelos.Habitacion;
import Modelos.ItinerarioTransporte;
import java.util.List;
import java.util.Scanner;

public class SubMenuReserva {

    private Scanner scanner = new Scanner(System.in);
    private ReservaController controller = new ReservaController();

    public void mostrarMenu() {
        int opcion = 1;

        while (opcion != 0) {
            System.out.println("============= SUBMENU RESERVA =======================");
            System.out.println("1. Crear Reserva");
            System.out.println("2. Actualizar Reserva");
            System.out.println("3. Eliminar Reserva");
            System.out.println("4. Ver Reserva por ID");
            System.out.println("5. Ver todas las Reservas");

            System.out.println("------ Opciones extras ------");
            System.out.println("6. Ver Reservas por ID de Habitación");
            System.out.println("7. Ver Habitación asociada a una Reserva");
            System.out.println("8. Ver Reservas por ID de Itinerario de Transporte");
            System.out.println("9. Ver Itinerario de Transporte de una Reserva");

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
                    verReservasPorHabitacion();
                    break;
                case 7:
                    verHabitacionDeReserva();
                    break;
                case 8:
                    verReservasPorItinerario();
                    break;
                case 9:
                    verItinerarioDeReserva();
                    break;
                case 0:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    // ======================================================
    // CRUD
    // ======================================================

    private void crear() {
        System.out.println("=== Crear Reserva ===");

        System.out.print("Ingrese número de personas: ");
        Integer numPersonas = scanner.nextInt();

        System.out.print("Ingrese ID de Habitación: ");
        Integer habitacionId = scanner.nextInt();

        System.out.print("Ingrese ID de Itinerario de Transporte: ");
        Integer itinerarioId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.añadirReserva(numPersonas, habitacionId, itinerarioId);

        if (resultado) {
            System.out.println("Reserva creada correctamente.");
        } else {
            System.out.println("No se pudo crear la reserva. Verifique los datos.");
        }
    }

    private void actualizar() {
        System.out.println("=== Actualizar Reserva ===");

        System.out.print("Ingrese ID de la Reserva: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo número de personas (0 para no cambiar): ");
        Integer numPersonas = scanner.nextInt();
        scanner.nextLine();
        if (numPersonas == 0) numPersonas = null;

        System.out.print("Nuevo ID de Habitación (0 para no cambiar): ");
        Integer habitacionId = scanner.nextInt();
        scanner.nextLine();
        if (habitacionId == 0) habitacionId = null;

        System.out.print("Nuevo ID de Itinerario (0 para no cambiar): ");
        Integer itinerarioId = scanner.nextInt();
        scanner.nextLine();
        if (itinerarioId == 0) itinerarioId = null;

        boolean resultado = controller.actualizarReserva(id, numPersonas, habitacionId, itinerarioId);

        if (resultado) {
            System.out.println("Reserva actualizada correctamente.");
        } else {
            System.out.println("No se pudo actualizar. Verifique los datos.");
        }
    }

    private void eliminar() {
        System.out.println("=== Eliminar Reserva ===");

        System.out.print("Ingrese ID de la Reserva: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.eliminarObjeto(id);

        if (resultado) {
            System.out.println("Reserva eliminada correctamente.");
        } else {
            System.out.println("No se pudo eliminar la reserva.");
        }
    }

    private void verPorId() {
        System.out.println("=== Ver Reserva por ID ===");

        System.out.print("Ingrese el ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Reserva reserva = controller.getGeneralById(id);

        if (reserva != null) {
            System.out.println(reserva);
        } else {
            System.out.println("No se encontró una reserva con ese ID.");
        }
    }

    private void verTodos() {
        System.out.println("=== Lista de Reservas ===");

        List<Reserva> lista = controller.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("No hay registros disponibles.");
        } else {
            for (Reserva r : lista) {
                System.out.println(r);
            }
        }
    }

    // ======================================================
    // EXTRAS (basados 100% en tu controlador real)
    // ======================================================

    private void verReservasPorHabitacion() {
        System.out.println("=== Ver Reservas por ID de Habitación ===");

        System.out.print("Ingrese ID de la Habitación: ");
        Integer habitacionId = scanner.nextInt();
        scanner.nextLine();

        List<Reserva> reservas = controller.getReservasByHabitacion(habitacionId);

        if (reservas.isEmpty()) {
            System.out.println("No hay reservas para esta habitación.");
        } else {
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }

    private void verHabitacionDeReserva() {
        System.out.println("=== Ver Habitación asociada a una Reserva ===");

        System.out.print("Ingrese ID de la Reserva: ");
        Integer reservaId = scanner.nextInt();
        scanner.nextLine();

        Habitacion h = controller.getHabitacionDeReserva(reservaId);

        if (h != null) {
            System.out.println(h);
        } else {
            System.out.println("No se encontró una habitación asociada.");
        }
    }

    private void verReservasPorItinerario() {
        System.out.println("=== Ver Reservas por ID de Itinerario de Transporte ===");

        System.out.print("Ingrese ID del Itinerario: ");
        Integer itinerarioId = scanner.nextInt();
        scanner.nextLine();

        List<Reserva> reservas = controller.getReservasByItinerarioTransporte(itinerarioId);

        if (reservas.isEmpty()) {
            System.out.println("No hay reservas asociadas a este itinerario.");
        } else {
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }

    private void verItinerarioDeReserva() {
        System.out.println("=== Ver Itinerario de Transporte de una Reserva ===");

        System.out.print("Ingrese ID de la Reserva: ");
        Integer reservaId = scanner.nextInt();
        scanner.nextLine();

        ItinerarioTransporte it = controller.getItinerarioTransporteDeReserva(reservaId);

        if (it != null) {
            System.out.println(it);
        } else {
            System.out.println("No se encontró un itinerario asociado.");
        }
    }
}
