package Presentacion;

import Controllers.ServicioTransporteController;
import Modelos.ServicioTransporte;
import Modelos.Trayecto;
import Modelos.Vehiculo;
import java.util.List;
import java.util.Scanner;

public class SubMenuServicioTransporte {

    private Scanner scanner;
    private ServicioTransporteController controller ;
    private SubMenuVehiculo submenuVehiculo;
    public SubMenuServicioTransporte(Scanner scanner) {
        this.controller = new ServicioTransporteController();
        this.scanner = scanner;
        this.submenuVehiculo= new SubMenuVehiculo(scanner);
    }
    public void mostrarMenu() {
        int opcion = 1;

        while (opcion != 0) {
            System.out.println("============= SUBMENU SERVICIO TRANSPORTE =======================");
            System.out.println("1. Crear Servicio Transporte");
            System.out.println("2. Actualizar Servicio Transporte");
            System.out.println("3. Eliminar Servicio Transporte");
            System.out.println("4. Ver Servicio Transporte por ID");
            System.out.println("5. Ver todos los Servicios Transporte");

            System.out.println("------ Opciones extras ------");
            System.out.println("6. Ver Servicios por ID de Trayecto");
            System.out.println("7. Ver Trayecto asociado a un Servicio Transporte");
            System.out.println("8. Ver Servicios por ID de Vehículo");
            System.out.println("9. Ver Vehículo asociado a un Servicio Transporte");
            System.out.println("10.Gestionar Vehiculos");

            System.out.println("======= Presione 0 para Salir =======");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

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
                    verServiciosPorTrayecto();
                    break;
                case 7:
                    verTrayectoDeServicio();
                    break;
                case 8:
                    verServiciosPorVehiculo();
                    break;
                case 9:
                    verVehiculoDeServicio();
                    break;
                case 10:
                    submenuVehiculo.mostrar();
                    break;
                case 0:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    // ======================================================
    // CRUD
    // ======================================================

    private void crear() {
        System.out.println("=== Crear Servicio Transporte ===");

        System.out.print("Ingrese fecha inicio: ");
        String fechaInicio = scanner.nextLine();

        System.out.print("Ingrese fecha fin: ");
        String fechaFin = scanner.nextLine();

        System.out.println("Seleccione tipo de vehículo:");
        System.out.println("1. Aeronave");
        System.out.println("2. Carro");
        System.out.print("Opción: ");
        Integer opcionVehiculo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese ID del Vehículo: ");
        Integer vehiculoId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese ID del Trayecto: ");
        Integer trayectoId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.añadirReserva(null, fechaInicio, fechaFin, opcionVehiculo, vehiculoId, trayectoId);

        if (resultado) {
            System.out.println("Servicio Transporte creado correctamente.");
        } else {
            System.out.println("No se pudo crear el servicio. Verifique los datos.");
        }
    }

    private void actualizar() {
        System.out.println("=== Actualizar Servicio Transporte ===");

        System.out.print("Ingrese ID del Servicio Transporte: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nueva fecha inicio (vacío para no cambiar): ");
        String fechaInicio = scanner.nextLine();
        if (fechaInicio.trim().isEmpty()) fechaInicio = null;

        System.out.print("Nueva fecha fin (vacío para no cambiar): ");
        String fechaFin = scanner.nextLine();
        if (fechaFin.trim().isEmpty()) fechaFin = null;

        System.out.println("Modificar vehículo:");
        System.out.println("1. Aeronave");
        System.out.println("2. Carro");
        System.out.println("0. No cambiar vehículo");
        System.out.print("Opción: ");
        Integer opcionVehiculo = scanner.nextInt();
        scanner.nextLine();
        if (opcionVehiculo == 0) opcionVehiculo = null;

        System.out.print("Nuevo ID del Vehículo (0 para no cambiar): ");
        Integer vehiculoId = scanner.nextInt();
        scanner.nextLine();
        if (vehiculoId == 0) vehiculoId = null;

        System.out.print("Nuevo ID de Trayecto (0 para no cambiar): ");
        Integer trayectoId = scanner.nextInt();
        scanner.nextLine();
        if (trayectoId == 0) trayectoId = null;

        boolean resultado = controller.actualizarServicioTransporte(id, fechaInicio, fechaFin, opcionVehiculo, vehiculoId, trayectoId);

        if (resultado) {
            System.out.println("Servicio Transporte actualizado con éxito.");
        } else {
            System.out.println("No se pudo actualizar el servicio.");
        }
    }

    private void eliminar() {
        System.out.println("=== Eliminar Servicio Transporte ===");

        System.out.print("Ingrese ID del Servicio Transporte: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.eliminarObjeto(id);

        if (resultado) {
            System.out.println("Servicio Transporte eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }

    private void verPorId() {
        System.out.println("=== Ver Servicio Transporte por ID ===");

        System.out.print("Ingrese ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        ServicioTransporte st = controller.getGeneralById(id);

        if (st != null) {
            System.out.println(st);
        } else {
            System.out.println("No se encontró el servicio.");
        }
    }

    private void verTodos() {
        System.out.println("=== Lista de Servicios Transporte ===");

        List<ServicioTransporte> lista = controller.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("No hay registros.");
        } else {
            for (ServicioTransporte st : lista) {
                System.out.println(st);
            }
        }
    }

    // ======================================================
    // EXTRAS
    // ======================================================

    private void verServiciosPorTrayecto() {
        System.out.println("=== Ver Servicios por ID de Trayecto ===");

        System.out.print("Ingrese ID del Trayecto: ");
        Integer trayectoId = scanner.nextInt();
        scanner.nextLine();

        List<ServicioTransporte> lista = controller.getServiciosTransporteByTrayecto(trayectoId);

        if (lista.isEmpty()) {
            System.out.println("No hay servicios asociados a este trayecto.");
        } else {
            for (ServicioTransporte st : lista) {
                System.out.println(st);
            }
        }
    }

    private void verTrayectoDeServicio() {
        System.out.println("=== Ver Trayecto de un Servicio Transporte ===");

        System.out.print("Ingrese ID del Servicio Transporte: ");
        Integer servicioId = scanner.nextInt();
        scanner.nextLine();

        Trayecto t = controller.getTrayectoDeServicioTransporte(servicioId);

        if (t != null) {
            System.out.println(t);
        } else {
            System.out.println("No se encontró un trayecto asociado.");
        }
    }

    private void verServiciosPorVehiculo() {
        System.out.println("=== Ver Servicios por ID de Vehículo ===");

        System.out.print("Ingrese ID del Vehículo: ");
        Integer vehiculoId = scanner.nextInt();
        scanner.nextLine();

        List<ServicioTransporte> lista = controller.getServiciosTransporteByVehiculo(vehiculoId);

        if (lista.isEmpty()) {
            System.out.println("No hay servicios asociados a este vehículo.");
        } else {
            for (ServicioTransporte st : lista) {
                System.out.println(st);
            }
        }
    }

    private void verVehiculoDeServicio() {
        System.out.println("=== Ver Vehículo de un Servicio Transporte ===");

        System.out.print("Ingrese ID del Servicio: ");
        Integer servicioId = scanner.nextInt();
        scanner.nextLine();

        Vehiculo v = controller.getVehiculoDeServicioTransporte(servicioId);

        if (v != null) {
            System.out.println(v);
        } else {
            System.out.println("No se encontró vehículo asociado.");
        }
    }
}
