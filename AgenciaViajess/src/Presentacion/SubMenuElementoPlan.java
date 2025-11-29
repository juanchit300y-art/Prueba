package Presentacion;

import Controllers.ElementoPlanController;
import Modelos.ElementoPlan;
import Modelos.Plan;
import Modelos.ActividadTuristica;
import java.util.List;
import java.util.Scanner;

public class SubMenuElementoPlan {

    private Scanner scanner;
    private ElementoPlanController elementoPlanController;

    public SubMenuElementoPlan(Scanner scanner) {
        this.elementoPlanController = new ElementoPlanController();
        this.scanner = scanner;
    }

    public void mostrarMenu() {
        int opcion=1;

        while (opcion != 0){
            System.out.println("====== SUBMENÚ ELEMENTO PLAN ======");
            System.out.println("1. Registrar elemento plan");
            System.out.println("2. Ver lista de elementos plan");
            System.out.println("3. Actualizar elemento plan");
            System.out.println("4. Eliminar elemento plan");
            System.out.println("----- OPCIONES EXTRA -----");
            System.out.println("5. Ver elementos plan por ID de plan");
            System.out.println("6. Ver elementos plan por actividad turística");
            System.out.println("7. Ver plan asociado a un elemento plan");
            System.out.println("8. Ver actividad turística de un elemento plan");
            System.out.println("0. Volver");
            System.out.println("=======Presione 0 para Salir========");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarElementoPlan();
                    break;
                case 2:
                    mostrarElementosPlan();
                    break;
                case 3:
                    actualizarElementoPlan();
                    break;
                case 4:
                    eliminarElementoPlan();
                    break;
                case 5:
                    mostrarElementosPorPlan();
                    break;
                case 6:
                    mostrarElementosPorActividad();
                    break;
                case 7:
                    verPlanDeElementoPlan();
                    break;
                case 8:
                    verActividadDeElementoPlan();
                    break;
                case 0:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        }
    }

    private void registrarElementoPlan() {
        System.out.println("====== REGISTRAR ELEMENTO PLAN ======");

        System.out.print("ID Actividad Turística: ");
        Integer actividadId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID del Plan: ");
        Integer planId = scanner.nextInt();
        scanner.nextLine();

        boolean exito = elementoPlanController.añadirElementoPlan(actividadId, planId);

        if (exito) {
            System.out.println("Elemento del plan registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar. Verifique los IDs.");
        }
    }

    private void mostrarElementosPlan() {
        System.out.println("====== LISTA DE ELEMENTOS DEL PLAN ======");

        List<ElementoPlan> elementos = elementoPlanController.getAllGeneral();

        if (elementos.isEmpty()) {
            System.out.println("No hay elementos registrados.");
            return;
        }

        for (ElementoPlan e : elementos) {
            System.out.println(e.toString());
        }
    }

    private void actualizarElementoPlan() {
        System.out.println("====== ACTUALIZAR ELEMENTO PLAN ======");

        System.out.print("ID del elemento plan: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo ID de Actividad Turística (0 para dejar igual): ");
        Integer actividadId = scanner.nextInt();
        scanner.nextLine();
        if (actividadId == 0) actividadId = null;

        System.out.print("Nuevo ID de Plan (0 para dejar igual): ");
        Integer planId = scanner.nextInt();
        scanner.nextLine();
        if (planId == 0) planId = null;

        boolean exito = elementoPlanController.actualizarElementoPlan(id, actividadId, planId);

        if (exito) {
            System.out.println("Elemento plan actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar. Verifique los datos.");
        }
    }

    private void eliminarElementoPlan() {
        System.out.println("====== ELIMINAR ELEMENTO PLAN ======");

        System.out.print("ID del elemento plan: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean exito = elementoPlanController.eliminarObjeto(id);

        if (exito) {
            System.out.println("Elemento plan eliminado.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }

    private void mostrarElementosPorPlan() {
        System.out.println("====== ELEMENTOS DE UN PLAN ======");

        System.out.print("ID del plan: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        List<ElementoPlan> elementos = elementoPlanController.getElementosPlanByPlan(id);

        if (elementos.isEmpty()) {
            System.out.println("Este plan no tiene elementos registrados.");
            return;
        }

        for (ElementoPlan e : elementos) {
            System.out.println(e.toString());
        }
    }

    private void mostrarElementosPorActividad() {
        System.out.println("====== ELEMENTOS POR ACTIVIDAD TURÍSTICA ======");

        System.out.print("ID de la actividad turística: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        List<ElementoPlan> elementos = elementoPlanController.getElementosPlanByActividadTuristica(id);

        if (elementos.isEmpty()) {
            System.out.println("Esta actividad no tiene elementos registrados.");
            return;
        }

        for (ElementoPlan e : elementos) {
            System.out.println(e.toString());
        }
    }

    private void verPlanDeElementoPlan() {
        System.out.println("====== PLAN DE UN ELEMENTO PLAN ======");

        System.out.print("ID del elemento plan: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Plan plan = elementoPlanController.getPlanDeElementoPlan(id);

        if (plan == null) {
            System.out.println("No existe un plan asociado.");
            return;
        }

        System.out.println(plan.toString());
    }

    private void verActividadDeElementoPlan() {
        System.out.println("====== ACTIVIDAD TURÍSTICA DE UN ELEMENTO PLAN ======");

        System.out.print("ID del elemento plan: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        ActividadTuristica actividad = elementoPlanController.getActividadTuristicaDeElementoPlan(id);

        if (actividad == null) {
            System.out.println("No existe una actividad asociada.");
            return;
        }

        System.out.println(actividad.toString());
    }
}
