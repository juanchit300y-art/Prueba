package Presentacion;

import Controllers.ActividadTuristicaController;
import Modelos.ActividadTuristica;
import Modelos.ElementoPlan;
import Modelos.Turno;
import Modelos.Municipio;
import java.util.List;
import java.util.Scanner;

public class SubMenuActividadTuristica {

    private ActividadTuristicaController controlador;
    private Scanner scanner;

    public SubMenuActividadTuristica(Scanner scanner) {
        this.controlador = new ActividadTuristicaController();
        this.scanner = scanner;
    }

    public SubMenuActividadTuristica(ActividadTuristicaController controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }

    public void verSubMenuActividadTuristica() {
        int opcion = 1;
        while (opcion != 0) {

            System.out.println("======== Gestión de Actividades Turísticas ========");
            System.out.println("1. Añadir Actividad Turística");
            System.out.println("2. Modificar Actividad Turística");
            System.out.println("3. Eliminar Actividad Turística");
            System.out.println("4. Ver todas las Actividades Turísticas");
            System.out.println("5. Buscar Actividad Turística");
            System.out.println("--------- Opciones Extra ---------");
            System.out.println("6. Ver Elementos del Plan de una Actividad Turística");
            System.out.println("7. Asignar Elemento del Plan a una Actividad Turística");
            System.out.println("8. Ver Turnos de una Actividad Turística");
            System.out.println("9. Asignar Turno a una Actividad Turística");
            System.out.println("10. Ver Municipio asociado a una Actividad Turística");
            System.out.println("11. Ver todas las Actividades Turísticas por Municipio");
            System.out.println("===================================");
            System.out.println("0. Volver");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0: break;

                case 1: añadirActividadTuristica(); break;
                case 2: modificarActividadTuristica(); break;
                case 3: eliminarActividadTuristica(); break;
                case 4: verTodasActividadesTuristicas(); break;
                case 5: buscarActividadTuristica(); break;

                case 6: verElementosPlanActividad(); break;
                case 7: asignarElementoPlanActividad(); break;
                case 8: verTurnosActividad(); break;
                case 9: asignarTurnoActividad(); break;
                case 10: verMunicipioActividad(); break;
                case 11: verActividadesPorMunicipio(); break;

                default:
                    System.out.println("===== Opción inválida =====");
            }
        }
    }

    // --------------------- CRUD -------------------------

    public void añadirActividadTuristica() {
        System.out.println("Ingrese el nombre de la Actividad Turística:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el ID del Municipio asociado:");
        Integer idMunicipio = scanner.nextInt();
        scanner.nextLine();

        if (controlador.añadirActividadTuristica(nombre, idMunicipio)) {
            System.out.println("===== Actividad Turística registrada con éxito =====");
        } else {
            System.out.println("===== No se pudo registrar la Actividad Turística =====");
        }
    }

    public void modificarActividadTuristica() {
        System.out.println("Ingrese el ID de la Actividad Turística a modificar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        ActividadTuristica actividad = controlador.getGeneralById(id);

        if (actividad == null) {
            System.out.println("===== ID no encontrado =====");
            return;
        }

        System.out.println("Datos actuales:");
        System.out.println(actividad);

        System.out.println("Nuevo nombre (Enter para no cambiar):");
        String nombre = scanner.nextLine();

        System.out.println("Nuevo ID de Municipio (0 para no cambiar):");
        Integer muniId = scanner.nextInt();
        scanner.nextLine();

        if (muniId == 0) muniId = null;

        if (controlador.actualizarActividadTuristica(id, nombre, muniId)) {
            System.out.println("===== Actividad Turística modificada =====");
        } else {
            System.out.println("===== No se pudo modificar =====");
        }
    }

    public void eliminarActividadTuristica() {
        System.out.println("Ingrese el ID de la Actividad Turística a eliminar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        ActividadTuristica actividad = controlador.getGeneralById(id);

        if (actividad == null) {
            System.out.println("===== ID no encontrado =====");
            return;
        }

        System.out.println("Actividad encontrada:");
        System.out.println(actividad);
        System.out.println("¿Confirmar eliminación? (1=Sí / 2=No)");
        int confirm = scanner.nextInt();

        if (confirm == 1) {
            if (controlador.eliminarObjeto(id)) {
                System.out.println("===== Actividad eliminada =====");
            } else {
                System.out.println("===== No se puede eliminar: tiene relaciones activas =====");
            }
        } else {
            System.out.println("===== Cancelado =====");
        }
    }

    public void verTodasActividadesTuristicas() {
        List<ActividadTuristica> lista = controlador.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("===== No hay Actividades Turísticas registradas =====");
        } else {
            for (ActividadTuristica act : lista) {
                System.out.println(act);
            }
        }
    }

    public void buscarActividadTuristica() {
        System.out.println("Ingrese el ID de la Actividad Turística:");
        int id = scanner.nextInt();
        scanner.nextLine();

        ActividadTuristica actividad = controlador.getGeneralById(id);

        if (actividad == null) {
            System.out.println("===== Actividad no encontrada =====");
        } else {
            System.out.println(actividad);
        }
    }

    // ------------------------ EXTRAS -----------------------

    public void verElementosPlanActividad() {
        System.out.println("Ingrese el ID de la Actividad Turística:");
        int id = scanner.nextInt();
        scanner.nextLine();

        List<ElementoPlan> lista = controlador.getElementosPlanActividadTuristica(id);

        if (lista.isEmpty()) {
            System.out.println("===== No tiene Elementos del Plan =====");
        } else {
            for (ElementoPlan ep : lista) {
                System.out.println(ep);
            }
        }
    }

    public void asignarElementoPlanActividad() {
        System.out.println("ID de la Actividad Turística:");
        int idActividad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("ID del Elemento del Plan:");
        int idElemento = scanner.nextInt();
        scanner.nextLine();

        if (controlador.assignElementoPlanToActividadTuristica(idActividad, idElemento)) {
            System.out.println("===== Elemento del Plan asignado =====");
        } else {
            System.out.println("===== No se pudo asignar =====");
        }
    }

    public void verTurnosActividad() {
        System.out.println("Ingrese el ID de la Actividad Turística:");
        int id = scanner.nextInt();
        scanner.nextLine();

        List<Turno> turnos = controlador.getTurnosDeActividadTuristica(id);

        if (turnos.isEmpty()) {
            System.out.println("===== No tiene Turnos asignados =====");
        } else {
            for (Turno t : turnos) {
                System.out.println(t);
            }
        }
    }

    public void asignarTurnoActividad() {
        System.out.println("ID de la Actividad Turística:");
        int idAct = scanner.nextInt();
        scanner.nextLine();

        System.out.println("ID del Turno:");
        int idTurno = scanner.nextInt();
        scanner.nextLine();

        if (controlador.assignTurnoToActividadTuristica(idAct, idTurno)) {
            System.out.println("===== Turno asignado =====");
        } else {
            System.out.println("===== No se pudo asignar =====");
        }
    }

    public void verMunicipioActividad() {
        System.out.println("ID de la Actividad Turística:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Municipio muni = controlador.getMunicipioDeActividadTuristica(id);

        if (muni == null) {
            System.out.println("===== No se encontró el Municipio =====");
        } else {
            System.out.println(muni);
        }
    }

    public void verActividadesPorMunicipio() {
        System.out.println("Ingrese el ID del Municipio:");
        int id = scanner.nextInt();
        scanner.nextLine();

        List<ActividadTuristica> lista = controlador.getActividadesTuristicasByMunicipio(id);

        if (lista.isEmpty()) {
            System.out.println("===== No hay Actividades para este Municipio =====");
        } else {
            for (ActividadTuristica act : lista) {
                System.out.println(act);
            }
        }
    }
}

