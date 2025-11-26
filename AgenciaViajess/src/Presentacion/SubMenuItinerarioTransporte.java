package Presentacion;

import Controllers.ItinerarioTransporteController;
import Modelos.ItinerarioTransporte;
import Modelos.Reserva;
import Modelos.Trayecto;
import Modelos.Viaje;
import java.util.List;
import java.util.Scanner;

public class SubMenuItinerarioTransporte {

    private Scanner scanner = new Scanner(System.in);
    private ItinerarioTransporteController controller = new ItinerarioTransporteController();

    public void mostrarMenu() {
        int opcion = 1;

        while (opcion != 0) {
            System.out.println("============= SUBMENU ITINERARIO TRANSPORTE ====================");
            System.out.println("1. Crear Itinerario de Transporte");
            System.out.println("2. Actualizar Itinerario de Transporte");
            System.out.println("3. Eliminar Itinerario de Transporte");
            System.out.println("4. Ver Itinerario de Transporte por ID");
            System.out.println("5. Ver todos los Itinerarios de Transporte");

            System.out.println("------ Opciones extras ------");
            System.out.println("6. Ver Itinerarios por ID de Trayecto");
            System.out.println("7. Ver Trayecto asociado a un Itinerario");
            System.out.println("8. Ver Itinerarios por ID de Viaje");
            System.out.println("9. Ver Viaje asociado a un Itinerario");
            System.out.println("10. Ver Reservas asociadas a un Itinerario");
            System.out.println("11. Asignar Reserva a un Itinerario");

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
                    verPorTrayecto();
                    break;
                case 7:
                    verTrayectoDeItinerario();
                    break;
                case 8:
                    verPorViaje();
                    break;
                case 9:
                    verViajeDeItinerario();
                    break;
                case 10:
                    verReservasDeItinerario();
                    break;
                case 11:
                    asignarReserva();
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
        System.out.println("=== Crear Itinerario de Transporte ===");

        System.out.print("Ingrese el orden: ");
        Integer orden = scanner.nextInt();

        System.out.print("Ingrese el ID del Trayecto: ");
        Integer trayectoId = scanner.nextInt();

        System.out.print("Ingrese el ID del Viaje: ");
        Integer viajeId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.añadirItinerarioTransporte(orden, trayectoId, viajeId);

        if (resultado) {
            System.out.println("Itinerario creado correctamente.");
        } else {
            System.out.println("No se pudo crear el itinerario. Verifique los datos.");
        }
    }

    private void actualizar() {
        System.out.println("=== Actualizar Itinerario de Transporte ===");

        System.out.print("Ingrese el ID del Itinerario: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo orden (0 para no cambiar): ");
        Integer orden = scanner.nextInt();
        scanner.nextLine();
        if (orden == 0) orden = null;

        System.out.print("Nuevo ID de Trayecto (0 para no cambiar): ");
        Integer trayectoId = scanner.nextInt();
        scanner.nextLine();
        if (trayectoId == 0) trayectoId = null;

        System.out.print("Nuevo ID de Viaje (0 para no cambiar): ");
        Integer viajeId = scanner.nextInt();
        scanner.nextLine();
        if (viajeId == 0) viajeId = null;

        boolean resultado = controller.actualizarItinerarioTransporte(id, orden, trayectoId, viajeId);

        if (resultado) {
            System.out.println("Itinerario actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar. Verifique los datos.");
        }
    }

    private void eliminar() {
        System.out.println("=== Eliminar Itinerario de Transporte ===");

        System.out.print("Ingrese el ID del Itinerario: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.eliminarObjeto(id);

        if (resultado) {
            System.out.println("Itinerario eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar. El itinerario tiene reservas asociadas.");
        }
    }

    private void verPorId() {
        System.out.println("=== Ver Itinerario de Transporte por ID ===");

        System.out.print("Ingrese el ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        ItinerarioTransporte it = controller.getGeneralById(id);

        if (it != null) {
            System.out.println(it);
        } else {
            System.out.println("No se encontró un itinerario con ese ID.");
        }
    }

    private void verTodos() {
        System.out.println("=== Lista de Itinerarios de Transporte ===");

        List<ItinerarioTransporte> lista = controller.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("No hay registros disponibles.");
        } else {
            for (ItinerarioTransporte it : lista) {
                System.out.println(it);
            }
        }
    }

    private void verPorTrayecto() {
        System.out.println("=== Ver Itinerarios por ID de Trayecto ===");

        System.out.print("Ingrese el ID del Trayecto: ");
        Integer trayectoId = scanner.nextInt();
        scanner.nextLine();

        List<ItinerarioTransporte> lista = controller.getItinerariosTransporteByTrayecto(trayectoId);

        if (lista.isEmpty()) {
            System.out.println("No se encontraron itinerarios para ese trayecto.");
        } else {
            for (ItinerarioTransporte it : lista) {
                System.out.println(it);
            }
        }
    }

    private void verTrayectoDeItinerario() {
        System.out.println("=== Ver Trayecto asociado a un Itinerario ===");

        System.out.print("Ingrese el ID del Itinerario: ");
        Integer itinerarioId = scanner.nextInt();
        scanner.nextLine();

        Trayecto trayecto = controller.getTrayectoDeItinerarioTransporte(itinerarioId);

        if (trayecto != null) {
            System.out.println(trayecto);
        } else {
            System.out.println("No se encontró un trayecto asociado.");
        }
    }

    private void verPorViaje() {
        System.out.println("=== Ver Itinerarios por ID de Viaje ===");

        System.out.print("Ingrese el ID del Viaje: ");
        Integer viajeId = scanner.nextInt();
        scanner.nextLine();

        List<ItinerarioTransporte> lista = controller.getItinerariosTransporteByViaje(viajeId);

        if (lista.isEmpty()) {
            System.out.println("No se encontraron itinerarios para ese viaje.");
        } else {
            for (ItinerarioTransporte it : lista) {
                System.out.println(it);
            }
        }
    }

    private void verViajeDeItinerario() {
        System.out.println("=== Ver Viaje asociado a un Itinerario ===");

        System.out.print("Ingrese el ID del Itinerario: ");
        Integer itinerarioId = scanner.nextInt();
        scanner.nextLine();

        Viaje viaje = controller.getViajeDeItinerarioTransporte(itinerarioId);

        if (viaje != null) {
            System.out.println(viaje);
        } else {
            System.out.println("No se encontró un viaje asociado.");
        }
    }

    private void verReservasDeItinerario() {
        System.out.println("=== Ver Reservas de un Itinerario ===");

        System.out.print("Ingrese el ID del Itinerario: ");
        Integer itinerarioId = scanner.nextInt();
        scanner.nextLine();

        List<Reserva> reservas = controller.getReservasDeItinerarioTransporte(itinerarioId);

        if (reservas.isEmpty()) {
            System.out.println("No hay reservas asociadas a este itinerario.");
        } else {
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }

    private void asignarReserva() {
        System.out.println("=== Asignar Reserva a un Itinerario ===");

        System.out.print("Ingrese el ID del Itinerario: ");
        Integer itinerarioId = scanner.nextInt();

        System.out.print("Ingrese el ID de la Reserva: ");
        Integer reservaId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.assignReservaToItinerarioTransporte(itinerarioId, reservaId);

        if (resultado) {
            System.out.println("Reserva asignada correctamente.");
        } else {
            System.out.println("No se pudo asignar la reserva. Verifique los IDs.");
        }
    }
}
