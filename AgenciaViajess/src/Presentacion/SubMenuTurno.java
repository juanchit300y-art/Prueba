package Presentacion;

import Controllers.TurnoController;
import Modelos.Turno;
import Modelos.Guia;
import Modelos.ActividadTuristica;
import java.util.List;
import java.util.Scanner;

public class SubMenuTurno {

    private TurnoController controlador;
    private Scanner scanner;

    public SubMenuTurno(Scanner scanner) {
        this.controlador = new TurnoController();
        this.scanner = scanner;
    }

    public SubMenuTurno(TurnoController controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }

    public void verSubMenuTurno() {

        int opcion = 1;
        while (opcion != 0) {
            System.out.println("======== Gestión de Turnos ========");
            System.out.println("1. Añadir Turno");
            System.out.println("2. Modificar Turno");
            System.out.println("3. Eliminar Turno");
            System.out.println("4. Ver todos los Turnos");
            System.out.println("5. Buscar Turno");
            System.out.println("--------- Opciones Extra ---------");
            System.out.println("6. Ver Guía asignado a un Turno");
            System.out.println("7. Ver Actividad Turística asignada a un Turno");
            System.out.println("8. Ver Turnos por Guía");
            System.out.println("9. Ver Turnos por Actividad Turística");
            System.out.println("===Presione 0 para Salir====");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0: break;

                case 1: añadirTurno(); break;
                case 2: modificarTurno(); break;
                case 3: eliminarTurno(); break;
                case 4: verTodosTurnos(); break;
                case 5: buscarTurno(); break;

                case 6: verGuiaDeTurno(); break;
                case 7: verActividadTuristicaDeTurno(); break;
                case 8: verTurnosPorGuia(); break;
                case 9: verTurnosPorActividadTuristica(); break;

                default:
                    System.out.println("===== Opción inválida =====");
            }
        }
    }

    // ======================================================
    //                       CRUD
    // ======================================================

    public void añadirTurno() {
        System.out.println("Ingrese el ID de la Actividad Turística:");
        Integer actividadId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el ID del Guía:");
        Integer guiaId = scanner.nextInt();
        scanner.nextLine();

        if (controlador.añadirTurno(actividadId, guiaId)) {
            System.out.println("===== Turno registrado con éxito =====");
        } else {
            System.out.println("===== No se pudo registrar el Turno =====");
        }
    }

    public void modificarTurno() {
        System.out.println("Ingrese el ID del Turno a modificar:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Turno turno = controlador.getGeneralById(id);

        if (turno == null) {
            System.out.println("===== ID no encontrado =====");
            return;
        }

        System.out.println("Datos actuales:");
        System.out.println(turno);

        System.out.println("Nuevo ID de Actividad Turística (0 para no cambiar):");
        Integer actividadId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nuevo ID de Guía (0 para no cambiar):");
        Integer guiaId = scanner.nextInt();
        scanner.nextLine();

        if (actividadId == 0) actividadId = null;
        if (guiaId == 0) guiaId = null;

        if (controlador.actualizarTurno(id, actividadId, guiaId)) {
            System.out.println("===== Turno modificado =====");
        } else {
            System.out.println("===== No se pudo modificar =====");
        }
    }

    public void eliminarTurno() {
        System.out.println("Ingrese el ID del Turno a eliminar:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Turno turno = controlador.getGeneralById(id);

        if (turno == null) {
            System.out.println("===== ID no encontrado =====");
            return;
        }

        System.out.println("Turno encontrado:");
        System.out.println(turno);

        System.out.println("¿Confirmar eliminación? (1=Sí / 2=No)");
        int confirm = scanner.nextInt();
        scanner.nextLine();

        if (confirm == 1) {
            if (controlador.eliminarObjeto(id)) {
                System.out.println("===== Turno eliminado =====");
            } else {
                System.out.println("===== No se pudo eliminar =====");
            }
        } else {
            System.out.println("===== Cancelado =====");
        }
    }

    public void verTodosTurnos() {
        List<Turno> lista = controlador.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("===== No hay Turnos registrados =====");
        } else {
            for (Turno t : lista) {
                System.out.println(t);
            }
        }
    }

    public void buscarTurno() {
        System.out.println("Ingrese el ID del Turno:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Turno turno = controlador.getGeneralById(id);

        if (turno == null) {
            System.out.println("===== Turno no encontrado =====");
        } else {
            System.out.println(turno);
        }
    }

    // ======================================================
    //                    OPCIONES EXTRA
    // ======================================================

    public void verGuiaDeTurno() {
        System.out.println("Ingrese el ID del Turno:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Guia guia = controlador.getGuiaDeTurno(id);

        if (guia == null) {
            System.out.println("===== No se encontró el Guía =====");
        } else {
            System.out.println(guia);
        }
    }

    public void verActividadTuristicaDeTurno() {
        System.out.println("Ingrese el ID del Turno:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        ActividadTuristica act = controlador.getActividadTuristicaDeTurno(id);

        if (act == null) {
            System.out.println("===== No se encontró la Actividad Turística =====");
        } else {
            System.out.println(act);
        }
    }

    public void verTurnosPorGuia() {
        System.out.println("Ingrese el ID del Guía:");
        Integer guiaId = scanner.nextInt();
        scanner.nextLine();

        List<Turno> lista = controlador.getTurnosByGuia(guiaId);

        if (lista.isEmpty()) {
            System.out.println("===== El Guía no tiene Turnos asignados =====");
        } else {
            for (Turno t : lista) {
                System.out.println(t);
            }
        }
    }

    public void verTurnosPorActividadTuristica() {
        System.out.println("Ingrese el ID de la Actividad Turística:");
        Integer actividadId = scanner.nextInt();
        scanner.nextLine();

        List<Turno> lista = controlador.getTurnosByActividadTuristica(actividadId);

        if (lista.isEmpty()) {
            System.out.println("===== La Actividad Turística no tiene Turnos asignados =====");
        } else {
            for (Turno t : lista) {
                System.out.println(t);
            }
        }
    }
}
