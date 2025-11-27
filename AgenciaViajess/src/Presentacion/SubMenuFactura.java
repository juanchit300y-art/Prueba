package Presentacion;

import Controllers.FacturaController;
import Modelos.Factura;
import Modelos.Cliente;
import Modelos.Viaje;

import java.util.List;
import java.util.Scanner;

public class SubMenuFactura {

    private Scanner scanner;
    private FacturaController facturaController;

    public SubMenuFactura(Scanner scanner) {
        this.scanner = scanner;
        this.facturaController = new FacturaController();
    }

    public void mostrarMenu() {
        Integer opcion = -1;
        while (opcion != 0) {
            System.out.println("====== SubMenu Factura======");
            System.out.println("1. Añadir Factura");
            System.out.println("2. Actualizar Factura");
            System.out.println("3. Eliminar Factura");
            System.out.println("4. Ver Factura por ID");
            System.out.println("5. Ver Todas las Facturas");

            System.out.println("------ Opciones Extras ------");
            System.out.println("6. Ver Facturas por ID de Cliente");
            System.out.println("7. Ver Facturas por ID de Viaje");
            System.out.println("8. Ver Cliente asociado a una Factura");
            System.out.println("9. Ver Viaje asociado a una Factura");

            System.out.println("====== Presione 0 para Salir ======");
            System.out.print("Digite una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    añadirFactura();
                    break;
                case 2:
                    actualizarFactura();
                    break;
                case 3:
                    eliminarFactura();
                    break;
                case 4:
                    verFacturaPorId();
                    break;
                case 5:
                    verTodasLasFacturas();
                    break;
                case 6:
                    verFacturasPorCliente();
                    break;
                case 7:
                    verFacturasPorViaje();
                    break;
                case 8:
                    verClienteDeFactura();
                    break;
                case 9:
                    verViajeDeFactura();
                    break;
                case 0:
                    System.out.println("Saliendo del Menu Factura...");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        }
    }

    private void añadirFactura() {
        System.out.println("=== Añadir Factura ===");
        System.out.print("Costo: ");
        Integer costo = scanner.nextInt();

        System.out.print("ID Viaje: ");
        Integer viajeId = scanner.nextInt();

        System.out.print("ID Cliente: ");
        Integer clienteId = scanner.nextInt();

        boolean resultado = facturaController.añadirFactura(costo, viajeId, clienteId);

        if (resultado) System.out.println("Factura añadida correctamente.");
        else System.out.println("No se pudo añadir la factura (verifique IDs).");
    }

    private void actualizarFactura() {
        System.out.println("=== Actualizar Factura ===");
        System.out.print("ID de la factura: ");
        Integer id = scanner.nextInt();

        System.out.print("Nuevo costo: ");
        Integer costo = scanner.nextInt();

        System.out.print("Nuevo ID Viaje: ");
        Integer viajeId = scanner.nextInt();

        System.out.print("Nuevo ID Cliente: ");
        Integer clienteId = scanner.nextInt();

        boolean resultado = facturaController.actualizarFactura(id, costo, viajeId, clienteId);

        if (resultado) System.out.println("Factura actualizada con exito.");
        else System.out.println("No se pudo actualizar la factura (verifique IDs).");
    }

    private void eliminarFactura() {
        System.out.println("=== Eliminar Factura ===");
        System.out.print("ID: ");
        Integer id = scanner.nextInt();

        boolean resultado = facturaController.eliminarObjeto(id);

        if (resultado) System.out.println("Factura eliminada.");
        else System.out.println("No se pudo eliminar la factura.");
    }

    private void verFacturaPorId() {
        System.out.println("=== Ver Factura por ID ===");
        System.out.print("ID: ");
        Integer id = scanner.nextInt();

        Factura factura = facturaController.getGeneralById(id);

        if (factura != null) {
            System.out.println(factura);
        } else {
            System.out.println("Factura no encontrada.");
        }
    }

    private void verTodasLasFacturas() {
        System.out.println("=== Lista de Facturas ===");
        List<Factura> lista = facturaController.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("No hay facturas registradas.");
        } else {
            for (Factura f : lista) {
                System.out.println(f);
            }
        }
    }

    private void verFacturasPorCliente() {
        System.out.println("=== Facturas por Cliente ===");
        System.out.print("ID Cliente: ");
        Integer id = scanner.nextInt();

        List<Factura> lista = facturaController.getFacturasByCliente(id);

        if (lista.isEmpty()) System.out.println("No hay facturas asociadas a este cliente.");
        else lista.forEach(f -> System.out.println(f));
    }

    private void verFacturasPorViaje() {
        System.out.println("=== Facturas por Viaje ===");
        System.out.print("ID Viaje: ");
        Integer id = scanner.nextInt();

        List<Factura> lista = facturaController.getFacturasByViaje(id);

        if (lista.isEmpty()) System.out.println("No hay facturas asociadas a este viaje.");
        else lista.forEach(f -> System.out.println(f));
    }

    private void verClienteDeFactura() {
        System.out.println("=== Cliente de Factura ===");
        System.out.print("ID Factura: ");
        Integer id = scanner.nextInt();

        Cliente cliente = facturaController.getClienteDeFactura(id);

        if (cliente == null) System.out.println("No se encontró cliente relacionado.");
        else System.out.println(cliente);
    }

    private void verViajeDeFactura() {
        System.out.println("=== Viaje de Factura ===");
        System.out.print("ID Factura: ");
        Integer id = scanner.nextInt();

        Viaje viaje = facturaController.getViajeDeFactura(id);

        if (viaje == null) System.out.println("No se encontró viaje relacionado.");
        else System.out.println(viaje);
    }
}
