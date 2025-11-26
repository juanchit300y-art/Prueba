package Presentacion;

import Controllers.EntretenimientoController;
import Modelos.Entretenimiento;
import Modelos.Plan;
import Modelos.Viaje;
import java.util.List;
import java.util.Scanner;

public class SubMenuEntretenimiento {

    private Scanner scanner = new Scanner(System.in);
    private EntretenimientoController controller = new EntretenimientoController();

    public void mostrarMenu() {
        int opcion=1;

        while (opcion != 0){
            System.out.println("=============SUBMENU ENTRENIMIENTO ====================");
            System.out.println("1. Crear Entretenimiento");
            System.out.println("2. Actualizar Entretenimiento");
            System.out.println("3. Eliminar Entretenimiento");
            System.out.println("4. Ver Entretenimiento por ID");
            System.out.println("5. Ver todos los Entretenimientos");

            System.out.println("\n------ Opciones extras ------");
            System.out.println("6. Ver Entretenimientos por ID de Plan");
            System.out.println("7. Ver Plan asociado a un Entretenimiento");
            System.out.println("8. Ver Entretenimientos por ID de Viaje");
            System.out.println("9. Ver Viaje asociado a un Entretenimiento");

            System.out.println("=======Presione 0 para Salir========");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

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
                    verPorPlan();
                    break;
                case 7:
                    verPlanDeEntretenimiento();
                    break;
                case 8:
                    verPorViaje();
                    break;
                case 9:
                    verViajeDeEntretenimiento();
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
        System.out.println("=== Crear Entretenimiento ===");
        System.out.print("Ingrese el ID del Viaje: ");
        Integer viajeId = scanner.nextInt();

        System.out.print("Ingrese el ID del Plan: ");
        Integer planId = scanner.nextInt();

        boolean resultado = controller.añadirEntretenimiento(viajeId, planId);

        if (resultado) {
            System.out.println("Entretenimiento creado correctamente.");
        } else {
            System.out.println("Error: Verifique los IDs ingresados.");
        }
    }

    private void actualizar() {
        System.out.println("=== Actualizar Entretenimiento ===");
        System.out.print("Ingrese el ID del Entretenimiento: ");
        Integer id = scanner.nextInt();

        System.out.print("Nuevo ID de Viaje (0 para no cambiar): ");
        Integer viajeId = scanner.nextInt();
        if (viajeId == 0) viajeId = null;

        System.out.print("Nuevo ID de Plan (0 para no cambiar): ");
        Integer planId = scanner.nextInt();
        if (planId == 0) planId = null;

        boolean resultado = controller.actualizarEntretenimiento(id, viajeId, planId);

        if (resultado) {
            System.out.println("Entretenimiento actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar. Verifique los datos.");
        }
    }

    private void eliminar() {
        System.out.println("=== Eliminar Entretenimiento ===");
        System.out.print("Ingrese el ID del Entretenimiento: ");
        Integer id = scanner.nextInt();

        boolean resultado = controller.eliminarObjeto(id);

        if (resultado) {
            System.out.println("Entretenimiento eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar. Verifique el ID ingresado.");
        }
    }

    private void verPorId() {
        System.out.println("=== Ver Entretenimiento por ID ===");
        System.out.print("Ingrese el ID: ");
        Integer id = scanner.nextInt();

        Entretenimiento entretenimiento = controller.getGeneralById(id);

        if (entretenimiento != null) {
            System.out.println(entretenimiento);
        } else {
            System.out.println("No se encontró un entretenimiento con ese ID.");
        }
    }

    private void verTodos() {
        System.out.println("=== Lista de Entretenimientos ===");
        List<Entretenimiento> lista = controller.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("No hay registros disponibles.");
        } else {
            for (Entretenimiento e : lista) {
                System.out.println(e);
            }
        }
    }

    private void verPorPlan() {
        System.out.println("=== Entretenimientos por ID de Plan ===");
        System.out.print("Ingrese el ID del Plan: ");
        Integer planId = scanner.nextInt();

        List<Entretenimiento> lista = controller.getEntrenimientosByPlan(planId);

        if (lista.isEmpty()) {
            System.out.println("No se encontraron registros asociados a ese Plan.");
        } else {
            for (Entretenimiento e : lista) {
                System.out.println(e);
            }
        }
    }

    private void verPlanDeEntretenimiento() {
        System.out.println("=== Plan asociado al Entretenimiento ===");
        System.out.print("Ingrese el ID del Entretenimiento: ");
        Integer id = scanner.nextInt();

        Plan plan = controller.getPlanDeEntretenimiento(id);

        if (plan != null) {
            System.out.println(plan);
        } else {
            System.out.println("No se encontró un plan asociado.");
        }
    }

    private void verPorViaje() {
        System.out.println("=== Entretenimientos por ID de Viaje ===");
        System.out.print("Ingrese el ID del Viaje: ");
        Integer viajeId = scanner.nextInt();

        List<Entretenimiento> lista = controller.getEntrenimientosByViaje(viajeId);

        if (lista.isEmpty()) {
            System.out.println("No se encontraron registros asociados a ese Viaje.");
        } else {
            for (Entretenimiento e : lista) {
                System.out.println(e);
            }
        }
    }

    private void verViajeDeEntretenimiento() {
        System.out.println("=== Viaje asociado al Entretenimiento ===");
        System.out.print("Ingrese el ID del Entretenimiento: ");
        Integer id = scanner.nextInt();

        Viaje viaje = controller.getViajeDeEntretenimiento(id);

        if (viaje != null) {
            System.out.println(viaje);
        } else {
            System.out.println("No se encontró un viaje asociado.");
        }
    }
}

