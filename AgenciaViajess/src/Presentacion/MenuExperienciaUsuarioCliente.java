/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Controllers.*;
import java.util.Scanner;
import Modelos.*;
import java.util.List;

/**
 *
 * @author Juanes
 */
public class MenuExperienciaUsuarioCliente {
    Scanner scanner;
    ClienteController controladorCliente;
    FacturaController facturaController;

    public MenuExperienciaUsuarioCliente(Scanner scanner) {
        this.scanner = scanner;
        this.controladorCliente= new ClienteController();
        this.facturaController= new FacturaController();
        
    }
  
    public void verMenuExperienciaUsuario(Integer idUsuario ){
        Cliente cliente= controladorCliente.getGeneralById(idUsuario);
        String nombre= cliente.getNombre();
        int inicio= 1;
        while(inicio!=0 ){
            System.out.println("======== Bienvenid@ " + nombre + " a nuestro sistema ========");
            System.out.println("Seleeciona lo que deseas Gestionar:  ");
            System.out.println(" 1. Gestionar Facturas  ");
            System.out.println(" 2. Gestionar Viajes ");
            System.out.println("========  Presiona 0 para salir ========");
            inicio= scanner.nextInt();
            scanner.nextLine();
            switch(inicio){
                case 0:
                    break;
                case 1:
                    mostrarMenuFactura(idUsuario);
                    break;
                case 2:
                    //verMenuViajeExperiencia(); QUITAR LA COMENTACION
                    break;
                default:
                    System.out.println("Dato invalido");
            }
        } 
    }
    //facturaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaas
     public void mostrarMenuFactura(Integer idCliente) {
        Integer opcion = -1;
        while (opcion != 0) {
            System.out.println("====== Mis Facturas======");
            System.out.println("1. Añadir Factura");
            System.out.println("2. Actualizar Factura");
            System.out.println("3. Eliminar Factura");
            System.out.println("4. Ver Factura por ID");
            System.out.println("5. Ver Todas mis Facturas");
            System.out.println("6. Ver Viaje asociado a una Factura");
            System.out.println("====== Presione 0 para Salir ======");
            System.out.print("Digite una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    añadirFactura(idCliente); //Hecho
                    break;
                case 2:
                    actualizarFactura(idCliente);  //Hecho
                    break;
                case 3:
                    eliminarFactura(idCliente); //Hecho 
                    break;
                case 4:
                    verFacturaPorId(idCliente); //Hecho
                    break;
                case 5:
                    verFacturasPorCliente(idCliente); //Hecho
                    break;
                case 6:
                    verViajeDeFactura(idCliente);//Hecho
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        }
    }

    private void añadirFactura(Integer idCliente) {
        System.out.println("=== Añadir Factura ===");
        System.out.print("Costo: ");
        Integer costo = scanner.nextInt();
        System.out.print("ID Viaje: ");
        Integer viajeId = scanner.nextInt();
        Integer clienteId = idCliente;

        boolean resultado = facturaController.añadirFactura(costo, viajeId, clienteId);

        if (resultado) System.out.println("Factura añadida correctamente.");
        else System.out.println("No se pudo añadir la factura (verifique ID de Viaje).");
    }

    private void actualizarFactura(Integer idCliente) {
        System.out.println("=== Actualizar Factura ===");
        System.out.print("ID de la factura: (Deja el espacio vacio si no va  haber cambios)");
        Integer id = scanner.nextInt();

        System.out.print("Nuevo costo:  (Deja el espacio vacio si no va  haber cambios)");
        Integer costo = scanner.nextInt();

        System.out.print("Nuevo ID Viaje:      (Deja el espacio vacio si no va  haber cambios)");
        Integer viajeId = scanner.nextInt();

        Integer clienteId = idCliente;

        boolean resultado = facturaController.actualizarFactura(id, costo, viajeId, clienteId);

        if (resultado) System.out.println("Factura actualizada con exito.");
        else System.out.println("No se pudo actualizar la factura (verifique IDs).");
    }

    private void eliminarFactura(Integer idCliente) {
        System.out.println("=== Eliminar Factura ===");
        System.out.print("ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Cliente actual= facturaController.getClienteDeFactura(id);
        Integer idActual= actual.getId();
        boolean resultado= false;
        if(idActual.equals(idCliente)){
            resultado= facturaController.eliminarObjeto(id);
        }
        

        if (resultado) System.out.println("Factura eliminada.");
        else System.out.println("No se pudo eliminar la factura, revise su id");
    }

    private void verFacturaPorId(Integer idCliente) {
        System.out.println("=== Ver Factura por ID ===");
        System.out.print("ID: ");
        Integer id = scanner.nextInt();
        Cliente actual= facturaController.getClienteDeFactura(id);
        Integer idActual= actual.getId();
        if(idActual.equals(idCliente)){
            Factura factura = facturaController.getGeneralById(id);
            if (factura != null) {
                System.out.println(factura);
            } else {
                System.out.println("Factura no encontrada.");
            }
        }
        else{
            System.out.println("Factura no encontrada.");
        }

    }


    private void verFacturasPorCliente(Integer idCliente) {
        System.out.println("=== Tus Facturas ===");

        List<Factura> lista = facturaController.getFacturasByCliente(idCliente);

        if (lista.isEmpty()) System.out.println("No tienes facturas asociadas a este cliente.");
        else lista.forEach(f -> System.out.println(f));
    }


    private void verViajeDeFactura(Integer idCliente) {
        System.out.println("=== Viaje de Factura ===");
        System.out.print("ID Factura: ");
        Integer id = scanner.nextInt();
        Cliente actual= facturaController.getClienteDeFactura(id);
        Integer idActual= actual.getId();
        if(idActual.equals(idCliente)){
            Viaje viaje = facturaController.getViajeDeFactura(id);

            if (viaje == null) System.out.println("No se encontró viaje relacionado.");
            else System.out.println(viaje);
        }
        else{
            System.out.println("No se encontro dentro de tus facturas");
        }
    }
}//quitar esto
    //------------------ viajeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
    /*public void verMenuViajeExperiencia() {
        int opcion = 1;
        while (opcion != 0) {

            System.out.println("======== Gestión de mis Viajes ========");
            System.out.println("1. Añadir Viaje");
            System.out.println("2. Modificar Viaje");
            System.out.println("3. Eliminar Viaje");
            System.out.println("4. Ver todas los Viajes");
            System.out.println("5. Buscar Viaje");
            System.out.println("--------- Opciones Extra ---------");
            System.out.println("6. Ver Entretenimientos de un Viaje");
            System.out.println("7. Asignar Entretenimiento a un Viaje");
            System.out.println("8. Ver Facturas de un Viaje");
            System.out.println("9. Asignar Factura a un Viaje");
            System.out.println("10. Ver Cuotas de un Viaje");
            System.out.println("11. Asignar Cuota a un Viaje");
            System.out.println("12. Ver Itinerarios de un Viaje");
            System.out.println("13. Asignar Itinerario a un Viaje");
            System.out.println("Gestionar: ");
            System.out.println("14. Gestionar Cuotas");
            System.out.println("15. Gestionar Facturas");
            System.out.println("16. Gestionar Itinerarios de Transporte");
            System.out.println("17. Gestionar Entretenimientos ");
            System.out.println("====== Presione 0 para Salir =======");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0: break;

                case 1: añadirViaje(); break;
                case 2: modificarViaje(); break;
                case 3: eliminarViaje(); break;
                case 4: verTodosViajes(); break;
                case 5: buscarViaje(); break;

                case 6: verEntretenimientos(); break;
                case 7: asignarEntretenimiento(); break;
                case 8: verFacturas(); break;
                case 9: asignarFactura(); break;
                case 10: verCuotas(); break;
                case 11: asignarCuota(); break;
                case 12: verItinerarios(); break;
                case 13: asignarItinerario(); break;
                case 14: submenuCuota.mostrarMenu(); break;
                case 15: submenuFactura.mostrarMenu();break;
                case 16: submenuItinerarioTransporte.mostrarMenu();break;
                case 17: submenuEntretenimiento.mostrarMenu();break;

                default:
                    System.out.println("===== Opción inválida =====");
            }
        }
    }

    // --------------------- CRUD -------------------------

    public void añadirViaje() {
        if (controlador.añadirViaje()) {
            System.out.println("===== Viaje registrado con éxito =====");
        } else {
            System.out.println("===== No se pudo registrar el Viaje =====");
        }
    }

    public void modificarViaje() {
        System.out.println("Ingrese el ID del Viaje a modificar:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        // en el controlador actualizarViaje solo recibe id (no hay campos editables)
        if (controlador.actualizarViaje(id)) {
            System.out.println("===== Viaje modificado =====");
        } else {
            System.out.println("===== No se pudo modificar (ID inválido) =====");
        }
    }

    public void eliminarViaje() {
        System.out.println("Ingrese el ID del Viaje a eliminar:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Viaje viaje = controlador.getGeneralById(id);

        if (viaje == null) {
            System.out.println("===== ID no encontrado =====");
            return;
        }

        System.out.println("Viaje encontrado:");
        System.out.println(viaje);
        System.out.println("¿Confirmar eliminación? (1=Sí / 2=No)");
        int confirm = scanner.nextInt();
        scanner.nextLine();

        if (confirm == 1) {
            if (controlador.eliminarObjeto(id)) {
                System.out.println("===== Viaje eliminado =====");
            } else {
                System.out.println("===== No se puede eliminar: tiene relaciones activas =====");
            }
        } else {
            System.out.println("===== Cancelado =====");
        }
    }

    public void verTodosViajes() {
        List<Viaje> lista = controlador.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("===== No hay Viajes registrados =====");
        } else {
            for (Viaje v : lista) {
                System.out.println(v);
            }
        }
    }

    public void buscarViaje() {
        System.out.println("Ingrese el ID del Viaje:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Viaje viaje = controlador.getGeneralById(id);

        if (viaje == null) {
            System.out.println("===== Viaje no encontrado =====");
        } else {
            System.out.println(viaje);
        }
    }

    // ------------------------ EXTRAS -----------------------

    public void verEntretenimientos() {
        System.out.println("Ingrese el ID del Viaje:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        List<Entretenimiento> lista = controlador.getEntretenimientosDeViaje(id);

        if (lista.isEmpty()) {
            System.out.println("===== No tiene Entretenimientos asignados =====");
        } else {
            for (Entretenimiento e : lista) {
                System.out.println(e);
            }
        }
    }

    public void asignarEntretenimiento() {
        System.out.println("ID del Viaje:");
        Integer viajeId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("ID del Entretenimiento:");
        Integer entretenimientoId = scanner.nextInt();
        scanner.nextLine();

        if (controlador.assignEntretenimientoToViaje(viajeId, entretenimientoId)) {
            System.out.println("===== Entretenimiento asignado =====");
        } else {
            System.out.println("===== No se pudo asignar =====");
        }
    }

    public void verFacturas() {
        System.out.println("Ingrese el ID del Viaje:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        List<Factura> lista = controlador.getFacturasDeViaje(id);

        if (lista.isEmpty()) {
            System.out.println("===== No tiene Facturas asignadas =====");
        } else {
            for (Factura f : lista) {
                System.out.println(f);
            }
        }
    }

    public void asignarFactura() {
        System.out.println("ID del Viaje:");
        Integer viajeId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("ID de la Factura:");
        Integer facturaId = scanner.nextInt();
        scanner.nextLine();

        if (controlador.assignFacturatoToViaje(viajeId, facturaId)) {
            System.out.println("===== Factura asignada =====");
        } else {
            System.out.println("===== No se pudo asignar =====");
        }
    }

    public void verCuotas() {
        System.out.println("Ingrese el ID del Viaje:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        List<Cuota> lista = controlador.getCuotasDeViaje(id);

        if (lista.isEmpty()) {
            System.out.println("===== No tiene Cuotas asignadas =====");
        } else {
            for (Cuota c : lista) {
                System.out.println(c);
            }
        }
    }

    public void asignarCuota() {
        System.out.println("ID del Viaje:");
        Integer viajeId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("ID de la Cuota:");
        Integer cuotaId = scanner.nextInt();
        scanner.nextLine();

        if (controlador.assignCuotaToViaje(viajeId, cuotaId)) {
            System.out.println("===== Cuota asignada =====");
        } else {
            System.out.println("===== No se pudo asignar =====");
        }
    }

    public void verItinerarios() {
        System.out.println("Ingrese el ID del Viaje:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        List<ItinerarioTransporte> lista = controlador.getItinerariosTransporteDeViaje(id);

        if (lista.isEmpty()) {
            System.out.println("===== No tiene Itinerarios asignados =====");
        } else {
            for (ItinerarioTransporte it : lista) {
                System.out.println(it);
            }
        }
    }

    public void asignarItinerario() {
        System.out.println("ID del Viaje:");
        Integer viajeId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("ID del Itinerario:");
        Integer itinerarioId = scanner.nextInt();
        scanner.nextLine();

        if (controlador.assignItinerarioTransporteToViaje(viajeId, itinerarioId)) {
            System.out.println("===== Itinerario asignado =====");
        } else {
            System.out.println("===== No se pudo asignar =====");
        }
    }
}

  
}*/ 