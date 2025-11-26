package Presentacion;

import Controllers.ActividadTuristicaController;
import Modelos.ActividadTuristica;
import Modelos.ElementoPlan;
import Modelos.Turno;
import java.util.List;
import java.util.Scanner;

public class SubMenuActividadTuristica {

    private ActividadTuristicaController controlador;
    Scanner scanner;

    public SubMenuActividadTuristica(Scanner scanner) {
        this.controlador = new ActividadTuristicaController();
        this.scanner = scanner;
    }

    public SubMenuActividadTuristica(ActividadTuristicaController controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }

    public void verSubMenuActividadTuristica() {
        int inicio = 1;
        while (inicio != 0) {
            System.out.println("======== Gestión de Actividades Turísticas ========");
            System.out.println("Seleccione la opción deseada:");
            System.out.println("1. Añadir Actividad Turística");
            System.out.println("2. Modificar Actividad Turística");
            System.out.println("3. Eliminar Actividad Turística");
            System.out.println("4. Ver todas las Actividades Turísticas");
            System.out.println("5. Buscar Actividad Turística");
            System.out.println("6. Gestionar Turnos / Elementos del Plan");
            System.out.println("======== Presione 0 para volver ========");
            inicio = scanner.nextInt();
            scanner.nextLine();

            switch (inicio) {
                case 0:
                    break;
                case 1:
                    añadirActividadTuristica();
                    break;
                case 2:
                    modificarActividadTuristica();
                    break;
                case 3:
                    eliminarActividadTuristica();
                    break;
                case 4:
                    verTodasActividadesTuristicas();
                    break;
                case 5:
                    buscarActividadTuristica();
                    break;
                case 6:
                    gestionRelacionada();
                    break;
                default:
                    System.out.println("======== Número inválido, ingrese una opción válida ========");
            }
        }
    }

    public void añadirActividadTuristica() {
        System.out.println("Para añadir una nueva Actividad Turística:");
        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el ID del municipio donde se realizará:");
        Integer municipioId = scanner.nextInt();
        scanner.nextLine();

        if (controlador.añadirActividadTuristica(nombre, municipioId)) {
            System.out.println("======== Actividad Turística guardada correctamente ========");
        } else {
            System.out.println("======== Error al guardar, revise los datos ingresados ========");
        }
    }

    public void modificarActividadTuristica() {
        System.out.println("Ingrese el ID de la Actividad Turística a modificar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        ActividadTuristica actividad = controlador.getGeneralById(id);
        if (actividad == null) {
            System.out.println("======== ID no encontrado ========");
            return;
        }

        System.out.println("Datos actuales:");
        System.out.println(actividad);

        System.out.println("Ingrese el nuevo nombre (Enter para mantener):");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el nuevo ID de municipio (0 para mantener):");
        Integer municipioId = scanner.nextInt();
        scanner.nextLine();

        if (municipioId == 0) municipioId = null;

        if (controlador.actualizarActividadTuristica(id, nombre, municipioId)) {
            System.out.println("======== Modificación guardada correctamente ========");
        } else {
            System.out.println("======== Error al modificar, revise los datos ========");
        }
    }

    public void eliminarActividadTuristica() {
        System.out.println("Ingrese el ID de la Actividad Turística a eliminar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        ActividadTuristica actividad = controlador.getGeneralById(id);
        if (actividad == null) {
            System.out.println("======== Actividad no encontrada ========");
            return;
        }

        System.out.println("Actividad encontrada:");
        System.out.println(actividad);

        System.out.println("¿Está seguro que desea eliminarla?");
        System.out.println("1. Confirmar");
        System.out.println("2. Cancelar");
        int eleccion = scanner.nextInt();
        scanner.nextLine();

        if (eleccion == 1) {
            if (controlador.eliminarObjeto(id)) {
                System.out.println("======== Actividad eliminada correctamente ========");
            } else {
                System.out.println("======== No se puede eliminar: tiene Turnos o Elementos del Plan asignados ========");
            }
        } else {
            System.out.println("======== Eliminación cancelada ========");
        }
    }

    public void verTodasActividadesTuristicas() {
        List<ActividadTuristica> actividades = controlador.getAllGeneral();

        System.out.println("======== Actividades Turísticas Registradas ========");
        if (actividades.isEmpty()) {
            System.out.println("No hay actividades registradas.");
        } else {
            for (ActividadTuristica act : actividades) {
                System.out.println(act);
            }
        }
    }

    public void buscarActividadTuristica() {
        System.out.println("Ingrese el ID de la Actividad Turística a buscar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        ActividadTuristica actividad = controlador.getGeneralById(id);
        if (actividad == null) {
            System.out.println("======== No se encontró actividad con ese ID ========");
        } else {
            System.out.println(actividad);
        }
    }

    public void gestionRelacionada() {
        System.out.println("Seleccione qué desea gestionar:");
        System.out.println("1. Turnos de una Actividad Turística");
        System.out.println("2. Elementos del Plan de una Actividad Turística");
        System.out.println("======== Presione 0 para volver ========");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 0:
                return;

            case 1:
                System.out.println("Ingrese el ID de la Actividad Turística:");
                int idT = scanner.nextInt();
                scanner.nextLine();

                List<Turno> turnos = controlador.getTurnosDeActividadTuristica(idT);
                System.out.println("=== Turnos Asociados ===");
                if (turnos.isEmpty()) System.out.println("No hay turnos asociados.");
                else turnos.forEach(System.out::println);
                break;

            case 2:
                System.out.println("Ingrese el ID de la Actividad Turística:");
                int idE = scanner.nextInt();
                scanner.nextLine();

                List<ElementoPlan> elementos = controlador.getElementosPlanActividadTuristica(idE);
                System.out.println("=== Elementos del Plan Asociados ===");
                if (elementos.isEmpty()) System.out.println("No hay elementos asociados.");
                else elementos.forEach(System.out::println);
                break;

            default:
                System.out.println("======== Opción inválida ========");
        }
    }
}
