package Presentacion;

import Controllers.AerolineaController;
import Modelos.Aerolinea;
import Modelos.Aeronave;
import java.util.List;
import java.util.Scanner;
import Presentacion.SubMenuAeronave;

public class SubMenuAerolinea {

    private AerolineaController controlador;
    private Scanner scanner;
    private SubMenuAeronave submenuAeronave;
    public SubMenuAerolinea(Scanner scanner) {
        this.controlador = new AerolineaController();
        this.scanner = scanner;
        this.submenuAeronave= new SubMenuAeronave(scanner);
    }

    public SubMenuAerolinea(AerolineaController controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
        this.submenuAeronave= new SubMenuAeronave(scanner);
    }

    public void verSubMenuAerolinea() {
        int opcion = 1;

        while (opcion != 0) {

            System.out.println("======== Gestión de Aerolíneas ========");
            System.out.println("1. Añadir Aerolínea");
            System.out.println("2. Modificar Aerolínea");
            System.out.println("3. Eliminar Aerolínea");
            System.out.println("4. Ver todas las Aerolíneas");
            System.out.println("5. Buscar Aerolínea");
            System.out.println("--------- Opciones Extra ---------");
            System.out.println("6. Ver Aeronaves de una Aerolínea");
            System.out.println("7. Asignar Aeronave a Aerolínea");
            System.out.println("8. Gestionar Aeronaves");            
            System.out.println("=======Presione 0 para Salir========");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0: break;

                case 1: añadirAerolinea(); break;
                case 2: modificarAerolinea(); break;
                case 3: eliminarAerolinea(); break;
                case 4: verTodasAerolineas(); break;
                case 5: buscarAerolinea(); break;

                case 6: verAeronavesDeAerolinea(); break;
                case 7: asignarAeronaveAAerolinea(); break;
                case 8: submenuAeronave.verSubMenuAeronave(); break;
                default:
                    System.out.println("===== Opción inválida =====");
            }
        }
    }

    // --------------------- CRUD -------------------------

    public void añadirAerolinea() {
        System.out.println("Ingrese el nombre de la Aerolínea:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el correo de la Aerolínea:");
        String correo = scanner.nextLine();

        if (controlador.añadirAerolinea(nombre, correo)) {
            System.out.println("===== Aerolínea registrada con éxito =====");
        } else {
            System.out.println("===== No se pudo registrar la Aerolínea =====");
        }
    }

    public void modificarAerolinea() {
        System.out.println("Ingrese el ID de la Aerolínea a modificar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aerolinea aerolinea = controlador.getGeneralById(id);

        if (aerolinea == null) {
            System.out.println("===== ID no encontrado =====");
            return;
        }

        System.out.println("Datos actuales:");
        System.out.println(aerolinea);

        System.out.println("Nuevo nombre (Enter para no cambiar):");
        String nombre = scanner.nextLine();

        System.out.println("Nuevo correo (Enter para no cambiar):");
        String correo = scanner.nextLine();

        if (nombre.trim().isEmpty()) nombre = null;
        if (correo.trim().isEmpty()) correo = null;

        if (controlador.actualizarAerolinea(id, nombre, correo)) {
            System.out.println("===== Aerolínea modificada =====");
        } else {
            System.out.println("===== No se pudo modificar =====");
        }
    }

    public void eliminarAerolinea() {
        System.out.println("Ingrese el ID de la Aerolínea a eliminar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aerolinea aerolinea = controlador.getGeneralById(id);

        if (aerolinea == null) {
            System.out.println("===== ID no encontrado =====");
            return;
        }

        System.out.println("Aerolínea encontrada:");
        System.out.println(aerolinea);

        System.out.println("¿Confirmar eliminación? (1=Sí / 2=No)");
        int confirm = scanner.nextInt();

        if (confirm == 1) {
            if (controlador.eliminarObjeto(id)) {
                System.out.println("===== Aerolínea eliminada =====");
            } else {
                System.out.println("===== No se puede eliminar: tiene Aeronaves asociadas =====");
            }
        } else {
            System.out.println("===== Cancelado =====");
        }
    }

    public void verTodasAerolineas() {
        List<Aerolinea> lista = controlador.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("===== No hay Aerolíneas registradas =====");
        } else {
            for (Aerolinea aero : lista) {
                System.out.println(aero);
            }
        }
    }

    public void buscarAerolinea() {
        System.out.println("Ingrese el ID de la Aerolínea:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aerolinea aerolinea = controlador.getGeneralById(id);

        if (aerolinea == null) {
            System.out.println("===== Aerolínea no encontrada =====");
        } else {
            System.out.println(aerolinea);
        }
    }

    // ------------------------ EXTRAS -----------------------

    public void verAeronavesDeAerolinea() {
        System.out.println("Ingrese el ID de la Aerolínea:");
        int id = scanner.nextInt();
        scanner.nextLine();

        List<Aeronave> aeronaves = controlador.getAeronavesDeAerolinea(id);

        if (aeronaves.isEmpty()) {
            System.out.println("===== No tiene Aeronaves asignadas =====");
        } else {
            for (Aeronave a : aeronaves) {
                System.out.println(a);
            }
        }
    }

    public void asignarAeronaveAAerolinea() {
        System.out.println("ID de la Aerolínea:");
        int idAero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("ID de la Aeronave:");
        int idNave = scanner.nextInt();
        scanner.nextLine();

        if (controlador.assignAeronaveToAerolinea(idAero, idNave)) {
            System.out.println("===== Aeronave asignada =====");
        } else {
            System.out.println("===== No se pudo asignar =====");
        }
    }
}
