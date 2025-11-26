package Presentacion;

import Controllers.TrayectoController;
import Modelos.Trayecto;
import Modelos.Municipio;
import Modelos.ItinerarioTransporte;
import Modelos.ServicioTransporte;
import java.util.List;
import java.util.Scanner;

public class SubMenuTrayecto {

    private TrayectoController controlador;
    private Scanner scanner;

    public SubMenuTrayecto(Scanner scanner) {
        this.controlador = new TrayectoController();
        this.scanner = scanner;
    }

    public SubMenuTrayecto(TrayectoController controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }

    public void verSubMenuTrayecto() {

        int opcion = 1;
        while (opcion != 0) {

            System.out.println("======== Gestión de Trayectos ========");
            System.out.println("1. Añadir Trayecto");
            System.out.println("2. Modificar Trayecto");
            System.out.println("3. Eliminar Trayecto");
            System.out.println("4. Ver todos los Trayectos");
            System.out.println("5. Buscar Trayecto");
            System.out.println("--------- Opciones Extra ---------");
            System.out.println("6. Ver Municipio Inicio del Trayecto");
            System.out.println("7. Ver Municipio Destino del Trayecto");
            System.out.println("8. Ver Itinerarios de un Trayecto");
            System.out.println("9. Asignar Itinerario a un Trayecto");
            System.out.println("10. Ver Servicios de Transporte de un Trayecto");
            System.out.println("11. Asignar Servicio de Transporte a un Trayecto");
            System.out.println("===Presione 0 para Salir====");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0: break;

                case 1: añadirTrayecto(); break;
                case 2: modificarTrayecto(); break;
                case 3: eliminarTrayecto(); break;
                case 4: verTodosTrayectos(); break;
                case 5: buscarTrayecto(); break;

                case 6: verMunicipioInicio(); break;
                case 7: verMunicipioDestino(); break;
                case 8: verItinerariosDeTrayecto(); break;
                case 9: asignarItinerario(); break;
                case 10: verServiciosDeTrayecto(); break;
                case 11: asignarServicio(); break;

                default:
                    System.out.println("===== Opción inválida =====");
            }
        }
    }

    // ======================================================
    //                       CRUD
    // ======================================================

    public void añadirTrayecto() {
        System.out.println("Ingrese el ID del Municipio de inicio:");
        Integer inicioId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el ID del Municipio destino:");
        Integer destinoId = scanner.nextInt();
        scanner.nextLine();

        if (controlador.añadirTrayecto(inicioId, destinoId)) {
            System.out.println("===== Trayecto registrado con éxito =====");
        } else {
            System.out.println("===== No se pudo registrar el Trayecto =====");
        }
    }

    public void modificarTrayecto() {
        System.out.println("Ingrese el ID del Trayecto a modificar:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Trayecto trayecto = controlador.getGeneralById(id);

        if (trayecto == null) {
            System.out.println("===== ID no encontrado =====");
            return;
        }

        System.out.println("Datos actuales:");
        System.out.println(trayecto);

        System.out.println("Nuevo ID de Municipio Inicio (0 para no cambiar):");
        Integer inicioId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nuevo ID de Municipio Destino (0 para no cambiar):");
        Integer destinoId = scanner.nextInt();
        scanner.nextLine();

        if (inicioId == 0) inicioId = null;
        if (destinoId == 0) destinoId = null;

        if (controlador.actualizarTrayecto(id, inicioId, destinoId)) {
            System.out.println("===== Trayecto modificado =====");
        } else {
            System.out.println("===== No se pudo modificar =====");
        }
    }

    public void eliminarTrayecto() {
        System.out.println("Ingrese el ID del Trayecto a eliminar:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Trayecto trayecto = controlador.getGeneralById(id);

        if (trayecto == null) {
            System.out.println("===== ID no encontrado =====");
            return;
        }

        System.out.println("Trayecto encontrado:");
        System.out.println(trayecto);

        System.out.println("¿Confirmar eliminación? (1=Sí / 2=No)");
        int confirm = scanner.nextInt();
        scanner.nextLine();

        if (confirm == 1) {
            if (controlador.eliminarObjeto(id)) {
                System.out.println("===== Trayecto eliminado =====");
            } else {
                System.out.println("===== No se puede eliminar: tiene relaciones activas =====");
            }
        } else {
            System.out.println("===== Cancelado =====");
        }
    }

    public void verTodosTrayectos() {
        List<Trayecto> lista = controlador.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("===== No hay Trayectos registrados =====");
        } else {
            for (Trayecto t : lista) {
                System.out.println(t);
            }
        }
    }

    public void buscarTrayecto() {
        System.out.println("Ingrese el ID del Trayecto:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Trayecto trayecto = controlador.getGeneralById(id);

        if (trayecto == null) {
            System.out.println("===== Trayecto no encontrado =====");
        } else {
            System.out.println(trayecto);
        }
    }

    // ======================================================
    //                    OPCIONES EXTRA
    // ======================================================

    public void verMunicipioInicio() {
        System.out.println("Ingrese el ID del Trayecto:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Municipio muni = controlador.getMunicipioInicioDeTrayecto(id);

        if (muni == null) {
            System.out.println("===== No se encontró el Municipio de inicio =====");
        } else {
            System.out.println(muni);
        }
    }

    public void verMunicipioDestino() {
        System.out.println("Ingrese el ID del Trayecto:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Municipio muni = controlador.getMunicipioDestinoDeTrayecto(id);

        if (muni == null) {
            System.out.println("===== No se encontró el Municipio destino =====");
        } else {
            System.out.println(muni);
        }
    }

    public void verItinerariosDeTrayecto() {
        System.out.println("Ingrese el ID del Trayecto:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        List<ItinerarioTransporte> lista = controlador.getItinerariosTransporteDeTrayecto(id);

        if (lista.isEmpty()) {
            System.out.println("===== No tiene Itinerarios asignados =====");
        } else {
            for (ItinerarioTransporte it : lista) {
                System.out.println(it);
            }
        }
    }

    public void asignarItinerario() {
        System.out.println("Ingrese el ID del Trayecto:");
        Integer trayectoId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el ID del Itinerario:");
        Integer itinerarioId = scanner.nextInt();
        scanner.nextLine();

        if (controlador.assignItinerarioTransporteToTrayecto(trayectoId, itinerarioId)) {
            System.out.println("===== Itinerario asignado =====");
        } else {
            System.out.println("===== No se pudo asignar =====");
        }
    }

    public void verServiciosDeTrayecto() {
        System.out.println("Ingrese el ID del Trayecto:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        List<ServicioTransporte> lista = controlador.getServiciosTransporteDeTrayecto(id);

        if (lista.isEmpty()) {
            System.out.println("===== No tiene Servicios de Transporte asignados =====");
        } else {
            for (ServicioTransporte s : lista) {
                System.out.println(s);
            }
        }
    }

    public void asignarServicio() {
        System.out.println("Ingrese el ID del Trayecto:");
        Integer trayectoId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el ID del Servicio de Transporte:");
        Integer servicioId = scanner.nextInt();
        scanner.nextLine();

        if (controlador.assignServicioTransporteToTrayecto(trayectoId, servicioId)) {
            System.out.println("===== Servicio de Transporte asignado =====");
        } else {
            System.out.println("===== No se pudo asignar =====");
        }
    }
}
