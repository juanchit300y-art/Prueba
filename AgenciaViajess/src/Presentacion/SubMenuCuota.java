package Presentacion;

import Controllers.CuotaController;
import Controllers.ViajeController;
import Modelos.Cuota;
import Modelos.Viaje;
import java.util.List;
import java.util.Scanner;

public class SubMenuCuota {

    private Scanner scanner;
    private CuotaController cuotaController;

    public SubMenuCuota(Scanner scanner) {
        this.scanner=scanner;
        this.cuotaController = new CuotaController();
    }

    public void mostrarMenu() {
        int opcion=1;

        while (opcion != 0) {
            System.out.println("====== SUBMENÚ CUOTA ======");
            System.out.println("1. Registrar cuota");
            System.out.println("2. Ver lista de cuotas");
            System.out.println("3. Actualizar cuota");
            System.out.println("4. Eliminar cuota");
            System.out.println("----- OPCIONES EXTRA -----");
            System.out.println("5. Ver cuotas de un viaje");
            System.out.println("6. Ver viaje asociado a una cuota");
            System.out.println("=======Presione 0 para Salir========");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarCuota();
                    break;
                case 2:
                    mostrarCuotas();
                    break;
                case 3:
                    actualizarCuota();
                    break;
                case 4:
                    eliminarCuota();
                    break;
                case 5:
                    verCuotasPorViaje();
                    break;
                case 6:
                    verViajeDeCuota();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        }
    }

    private void registrarCuota() {
        System.out.println("====== REGISTRAR CUOTA ======");

        System.out.print("Monto: ");
        Integer monto = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID del viaje: ");
        Integer viajeId = scanner.nextInt();
        scanner.nextLine();

        boolean exito = cuotaController.añadirCuota(monto, viajeId);

        if (exito) {
            System.out.println("Cuota registrada exitosamente.");
        } else {
            System.out.println("No se pudo registrar la cuota. Verifique los datos.");
        }
    }

    private void mostrarCuotas() {
        System.out.println("====== LISTA DE CUOTAS ======");

        List<Cuota> cuotas = cuotaController.getAllGeneral();

        if (cuotas.isEmpty()) {
            System.out.println("No hay cuotas registradas.");
            return;
        }

        for (Cuota c : cuotas) {
            System.out.println(c.toString());
        }
    }

    private void actualizarCuota() {
        System.out.println("====== ACTUALIZAR CUOTA ======");

        System.out.print("ID de la cuota: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo monto (0 para dejar igual): ");
        Integer monto = scanner.nextInt();
        scanner.nextLine();
        if (monto == 0) monto = null;

        System.out.print("Nuevo ID de viaje (0 para dejar igual): ");
        Integer viajeId = scanner.nextInt();
        scanner.nextLine();
        if (viajeId == 0) viajeId = null;

        boolean exito = cuotaController.actualizarCuota(id, monto, viajeId);

        if (exito) {
            System.out.println("Cuota actualizada correctamente.");
        } else {
            System.out.println("No se encontró la cuota o hubo un error.");
        }
    }

    private void eliminarCuota() {
        System.out.println("====== ELIMINAR CUOTA ======");

        System.out.print("ID de la cuota: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean exito = cuotaController.eliminarObjeto(id);

        if (exito) {
            System.out.println("Cuota eliminada exitosamente.");
        } else {
            System.out.println("No se pudo eliminar la cuota.");
        }
    }

    private void verCuotasPorViaje() {
        System.out.println("====== CUOTAS DEL VIAJE ======");

        System.out.print("ID del viaje: ");
        int viajeId = scanner.nextInt();
        scanner.nextLine();

        List<Cuota> cuotas = cuotaController.getCuotasByViaje(viajeId);

        if (cuotas.isEmpty()) {
            System.out.println("Este viaje no tiene cuotas registradas.");
            return;
        }

        System.out.println("--- Cuotas asociadas ---");
        for (Cuota c : cuotas) {
            System.out.println(c.toString());
        }
    }

    private void verViajeDeCuota() {
        System.out.println("====== VIAJE DE LA CUOTA ======");

        System.out.print("ID de la cuota: ");
        int cuotaId = scanner.nextInt();
        scanner.nextLine();

        Viaje viaje = cuotaController.getViajeDeCuota(cuotaId);

        if (viaje == null) {
            System.out.println("No se encontró un viaje asociado a esta cuota.");
            return;
        }

        System.out.println("--- Viaje asociado ---");
        System.out.println(viaje.toString());
    }
}
