package Presentacion;

import Controllers.PlanController;
import Controllers.ElementoPlanController;
import Controllers.EntretenimientoController;
import Modelos.Plan;
import Modelos.ElementoPlan;
import Modelos.Entretenimiento;
import java.util.List;
import java.util.Scanner;

public class SubMenuPlan {

    private Scanner scanner;
    private PlanController planController;
    private ElementoPlanController elementoPlanController;
    private EntretenimientoController entretenimientoController;

    public SubMenuPlan() {
        scanner = new Scanner(System.in);
        planController = new PlanController();
        elementoPlanController = new ElementoPlanController();
        entretenimientoController = new EntretenimientoController();
    }

    public void iniciar() {
        int opcion = -1;

        while (opcion != 0) {

            System.out.println("====== Submenú PLAN ======");
            System.out.println("1. Agregar Plan");
            System.out.println("2. Buscar Plan");
            System.out.println("3. Actualizar Plan");
            System.out.println("4. Eliminar Plan");
            System.out.println("5. Listar Todos los Planes");

            System.out.println("------ Opciones Extras ------");
            System.out.println("6. Ver Elementos de un Plan");
            System.out.println("7. Asignar ElementoPlan a un Plan");
            System.out.println("8. Ver Entretenimientos de un Plan");
            System.out.println("9. Asignar Entretenimiento a un Plan");

            System.out.println("====== Presione 0 para Salir =======");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarPlan();
                    break;
                case 2:
                    buscarPlan();
                    break;
                case 3:
                    actualizarPlan();
                    break;
                case 4:
                    eliminarPlan();
                    break;
                case 5:
                    listarPlanes();
                    break;

                case 6:
                    verElementosPlan();
                    break;
                case 7:
                    asignarElementoPlan();
                    break;
                case 8:
                    verEntretenimientosPlan();
                    break;
                case 9:
                    asignarEntretenimiento();
                    break;

                case 0:
                    System.out.println("Saliendo del submenú Plan...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void agregarPlan() {
        System.out.print("Ingrese el nombre del Plan: ");
        String nombre = scanner.nextLine();

        if (planController.añadirPlan(nombre)) {
            System.out.println("Plan agregado correctamente.");
        } else {
            System.out.println("Error al agregar el Plan.");
        }
    }

    private void buscarPlan() {
        System.out.print("Ingrese el ID del Plan a buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Plan plan = planController.getGeneralById(id);

        if (plan != null) {
            System.out.println("Plan encontrado: " + plan);
        } else {
            System.out.println("No existe un Plan con ese ID.");
        }
    }

    private void actualizarPlan() {
        System.out.print("Ingrese el ID del Plan a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo nombre del Plan: ");
        String nombre = scanner.nextLine();

        if (planController.actualizarPlan(id, nombre)) {
            System.out.println("Plan actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el Plan.");
        }
    }

    private void eliminarPlan() {
        System.out.print("Ingrese el ID del Plan a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (planController.eliminarObjeto(id)) {
            System.out.println("Plan eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar. El Plan tiene elementos o entretenimientos asociados.");
        }
    }

    private void listarPlanes() {
        List<Plan> planes = planController.getAllGeneral();

        if (planes.isEmpty()) {
            System.out.println("No hay planes registrados.");
        } else {
            System.out.println("Lista de Planes:");
            for (Plan p : planes) {
                System.out.println(p);
            }
        }
    }

    // ---------------------- EXTRAS ---------------------------

    private void verElementosPlan() {
        System.out.print("Ingrese el ID del Plan: ");
        int planId = scanner.nextInt();
        scanner.nextLine();

        List<ElementoPlan> elementos = planController.getElementosPlanDePlan(planId);

        if (elementos.isEmpty()) {
            System.out.println("El Plan no tiene ElementosPlan registrados.");
        } else {
            System.out.println("Elementos del Plan:");
            for (ElementoPlan ep : elementos) {
                System.out.println(ep);
            }
        }
    }

    private void asignarElementoPlan() {
        System.out.print("ID del Plan: ");
        int planId = scanner.nextInt();
        System.out.print("ID del ElementoPlan: ");
        int epId = scanner.nextInt();
        scanner.nextLine();

        if (planController.assignElementosPlanToPlan(planId, epId)) {
            System.out.println("ElementoPlan asignado correctamente.");
        } else {
            System.out.println("No se pudo asignar ElementoPlan.");
        }
    }

    private void verEntretenimientosPlan() {
        System.out.print("Ingrese el ID del Plan: ");
        int planId = scanner.nextInt();
        scanner.nextLine();

        List<Entretenimiento> lista = planController.getEntretenimientosDePlan(planId);

        if (lista.isEmpty()) {
            System.out.println("El Plan no tiene Entretenimientos registrados.");
        } else {
            System.out.println("Entretenimientos del Plan:");
            for (Entretenimiento e : lista) {
                System.out.println(e);
            }
        }
    }

    private void asignarEntretenimiento() {
        System.out.print("ID del Plan: ");
        int planId = scanner.nextInt();
        System.out.print("ID del Entretenimiento: ");
        int entId = scanner.nextInt();
        scanner.nextLine();

        if (planController.assignEntretenimientoToPlan(planId, entId)) {
            System.out.println("Entretenimiento asignado correctamente.");
        } else {
            System.out.println("No se pudo asignar Entretenimiento.");
        }
    }
}
