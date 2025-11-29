package Presentacion;

import Controllers.ClienteController;
import Controllers.FacturaController;
import Modelos.Cliente;
import Modelos.Factura;
import java.util.List;
import java.util.Scanner;

public class SubMenuCliente {

    private Scanner scanner;
    private ClienteController clienteController;
    private SubMenuFactura submenuFactura;

    public SubMenuCliente(Scanner scanner) {
        this.scanner = scanner;
        this.clienteController = new ClienteController();
        this.submenuFactura = new SubMenuFactura(scanner);
    }

    public void mostrarMenu() {
        int opcion=1;

        while (opcion != 0){
            System.out.println("====== SUBMENÚ CLIENTE ======");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver lista de clientes");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("----- OPCIONES EXTRA -----");
            System.out.println("5. Ver facturas de un cliente");
            System.out.println("6. Asignar factura a cliente");
            System.out.println("7. Gestionar Facturas ");
            System.out.println("=======Presione 0 para Salir========");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    mostrarClientes();
                    break;
                case 3:
                    actualizarCliente();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 5:
                    verFacturasCliente();
                    break;
                case 6:
                    asignarFacturaCliente();
                    break;
                case 7:
                    submenuFactura.mostrarMenu();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        }
    }

    public void registrarCliente() {
        System.out.println("====== REGISTRAR CLIENTE ======");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        System.out.print("Medio de pago: ");
        String medioPago = scanner.nextLine();

        boolean exito = clienteController.añadirCliente(nombre, contrasena, correo, medioPago);

        if (exito) {
            System.out.println("Cliente registrado exitosamente.");
        } else {
            System.out.println("No se pudo registrar el cliente. Verifique los campos.");
        }
    }

    private void mostrarClientes() {
        System.out.println("====== LISTA DE CLIENTES ======");

        List<Cliente> clientes = clienteController.getAllGeneral();

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Cliente c : clientes) {
            System.out.println(c.toString());
        }
    }

    private void actualizarCliente() {
        System.out.println("====== ACTUALIZAR CLIENTE ======");

        System.out.print("ID del cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo nombre (enter para dejar igual): ");
        String nombre = scanner.nextLine();

        System.out.print("Nueva contraseña (enter para dejar igual): ");
        String contrasena = scanner.nextLine();

        System.out.print("Nuevo correo (enter para dejar igual): ");
        String correo = scanner.nextLine();

        System.out.print("Nuevo medio de pago (enter para dejar igual): ");
        String medioPago = scanner.nextLine();

        boolean exito = clienteController.actualizarCliente(id, nombre, contrasena, correo, medioPago);

        if (exito) {
            System.out.println("Cliente actualizado correctamente.");
        } else {
            System.out.println("No se encontró el cliente o hubo un error.");
        }
    }

    private void eliminarCliente() {
        System.out.println("====== ELIMINAR CLIENTE ======");

        System.out.print("ID del cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean exito = clienteController.eliminarObjeto(id);

        if (exito) {
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("No se puede eliminar: El cliente tiene facturas asociadas.");
        }
    }

    private void verFacturasCliente() {
        System.out.println("====== FACTURAS DEL CLIENTE ======");

        System.out.print("ID del cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        List<Factura> facturas = clienteController.getFacturasDeCliente(idCliente);

        if (facturas.isEmpty()) {
            System.out.println("El cliente no tiene facturas.");
            return;
        }

        System.out.println("--- Facturas asociadas ---");
        for (Factura f : facturas) {
            System.out.println(f.toString());
        }
    }

    private void asignarFacturaCliente() {
        System.out.println("====== ASIGNAR FACTURA A CLIENTE ======");

        System.out.print("ID del cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID de la factura: ");
        int idFactura = scanner.nextInt();
        scanner.nextLine();

        boolean exito = clienteController.assignFacturaToCliente(idCliente, idFactura);

        if (exito) {
            System.out.println("Factura asignada correctamente.");
        } else {
            System.out.println("No se pudo asignar la factura. Verifique los IDs.");
        }
    }
}
