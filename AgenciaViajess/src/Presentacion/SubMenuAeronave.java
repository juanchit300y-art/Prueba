package Presentacion;

import Controllers.AeronaveController;
import Modelos.Aeronave;
import java.util.List;
import java.util.Scanner;

public class SubMenuAeronave {
    private AeronaveController controlador;
    Scanner scanner;

    public SubMenuAeronave(Scanner scanner) {
        this.controlador = new AeronaveController();
        this.scanner = scanner;
    }

    public SubMenuAeronave(AeronaveController controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }

    public AeronaveController getControlador() {
        return controlador;
    }

    public void setControlador(AeronaveController controlador) {
        this.controlador = controlador;
    }

    public void verSubMenuAeronave() {
        int inicio = 1;
        while (inicio != 0) {
            System.out.println("======== Bienvenido al menu de Gestion de Aeronave ========");
            System.out.println("Seleccione la opcion deseada: ");
            System.out.println("1. Añadir Aeronave");
            System.out.println("2. Modificar Aeronave");
            System.out.println("3. Eliminar Aeronave");
            System.out.println("4. Ver todas las Aeronaves");
            System.out.println("5. Buscar Aeronave");
            System.out.println("======== Presione 0 para volver ========");
            inicio = scanner.nextInt();
            scanner.nextLine();

            switch (inicio) {
                case 0:
                    break;
                case 1:
                    añadirAeronave();
                    break;
                case 2:
                    modificarAeronave();
                    break;
                case 3:
                    eliminarAeronave();
                    break;
                case 4:
                    verTodasAeronaves();
                    break;
                case 5:
                    buscarAeronave();
                    break;
                default:
                    System.out.println("======== Numero invalido, ingrese una opcion válida ========");
            }
        }
    }

    public void añadirAeronave() {
        System.out.println("Para añadir la nueva aeronave:");
        System.out.println("Ingrese el nombre de la aeronave:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el modelo de la aeronave:");
        String modelo = scanner.nextLine();

        if (controlador.añadirAeronave(nombre, modelo)) {
            System.out.println("======== La aeronave se guardó correctamente ========");
        } else {
            System.out.println("======== No fue posible guardar la aeronave, revise los datos ========");
        }
    }

    public void modificarAeronave() {
        System.out.println("Para modificar una aeronave:");
        System.out.println("Ingrese el id de la Aeronave a modificar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aeronave aeronave = controlador.getGeneralById(id);
        if (aeronave == null) {
            System.out.println("======== El id ingresado no existe ========");
        } else {
            System.out.println("Datos actuales de la aeronave:");
            System.out.println(aeronave);

            System.out.println("Ingrese el nuevo nombre (Enter para dejar igual):");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el nuevo modelo (Enter para dejar igual):");
            String modelo = scanner.nextLine();

            if (controlador.actualizarAeronave(id, nombre, modelo)) {
                System.out.println("======== La aeronave fue modificada correctamente ========");
            } else {
                System.out.println("======== No fue posible modificar la aeronave ========");
            }
        }
    }

    public void eliminarAeronave() {
        System.out.println("Para eliminar una aeronave:");
        System.out.println("Ingrese el id de la aeronave que desea eliminar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aeronave aeronave = controlador.getGeneralById(id);
        if (aeronave == null) {
            System.out.println("======== Aeronave inexistente ========");
        } else {
            System.out.println("La aeronave que será eliminada:");
            System.out.println(aeronave);

            System.out.println("¿Está seguro que desea eliminarla?");
            System.out.println("Presione 1 para confirmar y 2 para cancelar");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (controlador.eliminarObjeto(id)) {
                        System.out.println("======== Aeronave eliminada correctamente ========");
                    } else {
                        System.out.println("======== No fue posible eliminar la aeronave ========");
                    }
                    break;
                case 2:
                    System.out.println("======== Operación cancelada ========");
                    break;
                default:
                    System.out.println("======== Opción inválida ========");
            }
        }
    }

    public void verTodasAeronaves() {
        System.out.println("======== Todas las aeronaves registradas ========");
        List<Aeronave> lista = controlador.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("======== No hay aeronaves registradas ========");
        } else {
            for (Aeronave a : lista) {
                System.out.println(a);
            }
        }
    }

    public void buscarAeronave() {
        System.out.println("Para buscar una aeronave:");
        System.out.println("Ingrese el ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aeronave aeronave = controlador.getGeneralById(id);
        if (aeronave == null) {
            System.out.println("======== Aeronave no encontrada ========");
        } else {
            System.out.println(aeronave);
        }
    }
}
