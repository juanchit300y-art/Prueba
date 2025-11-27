package Presentacion;

import Controllers.GuiaController;
import Modelos.Guia;
import Modelos.Turno;
import java.util.List;
import java.util.Scanner;

public class SubMenuGuia {

    private Scanner scanner;
    private GuiaController controller;
    private SubMenuTurno submenuTurno;
    public SubMenuGuia(Scanner scanner) {
        this.controller = new GuiaController();
        this.scanner = scanner;
        this.submenuTurno= new SubMenuTurno(scanner);
    }

    public void mostrarMenu() {
        int opcion = 1;

        while (opcion != 0) {
            System.out.println("============= SUBMENU GUIA ====================");
            System.out.println("1. Crear Guía");
            System.out.println("2. Actualizar Guía");
            System.out.println("3. Eliminar Guía");
            System.out.println("4. Ver Guía por ID");
            System.out.println("5. Ver todos los Guías");

            System.out.println("------ Opciones extras ------");
            System.out.println("6. Ver Turnos asignados a un Guía");
            System.out.println("7. Asignar Turno a un Guía");
            System.out.println("8. Gestionar Turnos");

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
                    verTurnosDeGuia();
                    break;
                case 7:
                    asignarTurno();
                    break;
                case 8:
                    submenuTurno.verSubMenuTurno();
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
        System.out.println("=== Crear Guía ===");

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la contraseña: ");
        String contraseña = scanner.nextLine();

        System.out.print("Ingrese el correo: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese los años de experiencia: ");
        Integer años = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.añadirGuia(nombre, contraseña, correo, años);

        if (resultado) {
            System.out.println("Guía creado correctamente.");
        } else {
            System.out.println("Error: Verifique los datos ingresados.");
        }
    }

    private void actualizar() {
        System.out.println("=== Actualizar Guía ===");

        System.out.print("Ingrese el ID del Guía: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo nombre (vacío para no cambiar): ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) nombre = null;

        System.out.print("Nueva contraseña (vacío para no cambiar): ");
        String contraseña = scanner.nextLine();
        if (contraseña.trim().isEmpty()) contraseña = null;

        System.out.print("Nuevo correo (vacío para no cambiar): ");
        String correo = scanner.nextLine();
        if (correo.trim().isEmpty()) correo = null;

        System.out.print("Años de experiencia (-1 para no cambiar): ");
        Integer años = scanner.nextInt();
        scanner.nextLine();
        if (años == -1) años = null;

        boolean resultado = controller.actualizarGuia(id, nombre, contraseña, correo, años);

        if (resultado) {
            System.out.println("Guía actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar. Verifique los datos.");
        }
    }

    private void eliminar() {
        System.out.println("=== Eliminar Guía ===");
        System.out.print("Ingrese el ID del Guía: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.eliminarObjeto(id);

        if (resultado) {
            System.out.println("Guía eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar. El guía tiene turnos asociados.");
        }
    }

    private void verPorId() {
        System.out.println("=== Ver Guía por ID ===");
        System.out.print("Ingrese el ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Guia guia = controller.getGeneralById(id);

        if (guia != null) {
            System.out.println(guia);
        } else {
            System.out.println("No se encontró un guía con ese ID.");
        }
    }

    private void verTodos() {
        System.out.println("=== Lista de Guías ===");
        List<Guia> lista = controller.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("No hay registros disponibles.");
        } else {
            for (Guia g : lista) {
                System.out.println(g);
            }
        }
    }

    private void verTurnosDeGuia() {
        System.out.println("=== Ver Turnos de un Guía ===");
        System.out.print("Ingrese el ID del Guía: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        List<Turno> turnos = controller.getTurnosDeGuia(id);

        if (turnos.isEmpty()) {
            System.out.println("No hay turnos asignados a este guía.");
        } else {
            for (Turno t : turnos) {
                System.out.println(t);
            }
        }
    }

    private void asignarTurno() {
        System.out.println("=== Asignar Turno a un Guía ===");

        System.out.print("Ingrese el ID del Guía: ");
        Integer guiaId = scanner.nextInt();

        System.out.print("Ingrese el ID del Turno: ");
        Integer turnoId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.assignTurnoToGuia(guiaId, turnoId);

        if (resultado) {
            System.out.println("Turno asignado correctamente.");
        } else {
            System.out.println("No se pudo asignar el turno. Verifique los IDs.");
        }
    }
}
