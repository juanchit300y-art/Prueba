package Presentacion;

import Controllers.AeronaveController;
import Modelos.Aeronave;
import Modelos.Aerolinea;
import Modelos.ServicioTransporte;
import java.util.List;
import java.util.Scanner;
import Presentacion.SubMenuServicioTransporte;
public class SubMenuAeronave {

    private AeronaveController controlador;
    private Scanner scanner;

    public SubMenuAeronave(Scanner scanner) {
        this.controlador = new AeronaveController();
        this.scanner = scanner;
    }

    public SubMenuAeronave(AeronaveController controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }

    public void verSubMenuAeronave() {
        int opcion = 1;

        while (opcion != 0) {

            System.out.println("======== Gestión de Aeronaves ========");
            System.out.println("1. Añadir Aeronave");
            System.out.println("2. Modificar Aeronave");
            System.out.println("3. Eliminar Aeronave");
            System.out.println("4. Ver todas las Aeronaves");
            System.out.println("5. Buscar Aeronave");
            System.out.println("--------- Opciones Extra ---------");
            System.out.println("6. Ver Aerolínea de una Aeronave");
            System.out.println("7. Ver Servicios de Transporte de una Aeronave");
            System.out.println("8. Asignar Servicio de Transporte a Aeronave");
            System.out.println("9. Gestionar Servicios de Transporte ");
            System.out.println("=======Presione 0 para Salir========");
            System.out.println("0. Volver");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0: break;
                case 1: añadirAeronave(); break;
                case 2: modificarAeronave(); break;
                case 3: eliminarAeronave(); break;
                case 4: verTodasAeronaves(); break;
                case 5: buscarAeronave(); break;

                case 6: verAerolineaDeAeronave(); break;
                case 7: verServiciosTransporte(); break;
                case 8: asignarServicioTransporte(); break;
                case 9: new SubMenuServicioTransporte(scanner).mostrarMenu(); break;

                default:
                    System.out.println("===== Opción inválida =====");
            }
        }
    }

    // ----------------------------- CRUD -----------------------------

    public void añadirAeronave() {
        System.out.println("Ingrese la marca de la Aeronave:");
        String marca = scanner.nextLine();

        System.out.println("Ingrese el ID de la Aerolínea:");
        Integer aerolineaId = scanner.nextInt();
        scanner.nextLine();

        if (controlador.añadirAeronave(marca, aerolineaId)) {
            System.out.println("===== Aeronave registrada con éxito =====");
        } else {
            System.out.println("===== No se pudo registrar la Aeronave =====");
        }
    }

    public void modificarAeronave() {
        System.out.println("Ingrese el ID de la Aeronave a modificar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aeronave aeronave = controlador.getGeneralById(id);

        if (aeronave == null) {
            System.out.println("===== ID no encontrado =====");
            return;
        }

        System.out.println("Datos actuales:");
        System.out.println(aeronave);

        System.out.println("Nueva marca (Enter para no cambiar):");
        String marca = scanner.nextLine();

        System.out.println("Nuevo ID de Aerolínea (Enter para no cambiar):");
        String input = scanner.nextLine();
        Integer aerolineaId = null;

        if (!input.trim().isEmpty()) {
            aerolineaId = Integer.parseInt(input);
        }

        if (marca.trim().isEmpty()) marca = null;

        if (controlador.actualizarAeronave(id, marca, aerolineaId)) {
            System.out.println("===== Aeronave modificada =====");
        } else {
            System.out.println("===== No se pudo modificar =====");
        }
    }

    public void eliminarAeronave() {
        System.out.println("Ingrese el ID de la Aeronave a eliminar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aeronave aeronave = controlador.getGeneralById(id);

        if (aeronave == null) {
            System.out.println("===== ID no encontrado =====");
            return;
        }

        System.out.println("Aeronave encontrada:");
        System.out.println(aeronave);

        System.out.println("¿Confirmar eliminación? (1=Sí / 2=No)");
        int confirm = scanner.nextInt();

        if (confirm == 1) {
            if (controlador.eliminarObjeto(id)) {
                System.out.println("===== Aeronave eliminada =====");
            } else {
                System.out.println("===== No se puede eliminar: tiene Servicios de Transporte asociados =====");
            }
        } else {
            System.out.println("===== Cancelado =====");
        }
    }

    public void verTodasAeronaves() {
        List<Aeronave> lista = controlador.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("===== No hay Aeronaves registradas =====");
        } else {
            for (Aeronave a : lista) {
                System.out.println(a);
            }
        }
    }

    public void buscarAeronave() {
        System.out.println("Ingrese el ID de la Aeronave:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aeronave aeronave = controlador.getGeneralById(id);

        if (aeronave == null) {
            System.out.println("===== Aeronave no encontrada =====");
        } else {
            System.out.println(aeronave);
        }
    }

    // --------------------------- EXTRA ------------------------------

    public void verAerolineaDeAeronave() {
        System.out.println("Ingrese el ID de la Aeronave:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aerolinea aerolinea = controlador.getAerolineaDeAeronave(id);

        if (aerolinea == null) {
            System.out.println("===== La aeronave no existe o no tiene Aerolínea asignada =====");
        } else {
            System.out.println(aerolinea);
        }
    }

    public void verServiciosTransporte() {
        System.out.println("Ingrese el ID de la Aeronave:");
        int id = scanner.nextInt();
        scanner.nextLine();

        List<ServicioTransporte> lista = controlador.getServiciosTrasportesDeAeronave(id);

        if (lista.isEmpty()) {
            System.out.println("===== La aeronave no tiene servicios asignados =====");
        } else {
            for (ServicioTransporte s : lista) {
                System.out.println(s);
            }
        }
    }

    public void asignarServicioTransporte() {
        System.out.println("Ingrese el ID de la Aeronave:");
        int aeronaveId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el ID del Servicio de Transporte:");
        int servicioId = scanner.nextInt();
        scanner.nextLine();

        if (controlador.assignServicioTransporteToAeronave(aeronaveId, servicioId)) {
            System.out.println("===== Servicio de Transporte asignado =====");
        } else {
            System.out.println("===== No se pudo asignar =====");
        }
    }
}
