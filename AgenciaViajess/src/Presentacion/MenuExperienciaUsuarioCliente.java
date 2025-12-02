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
                    //
                    break;
                default:
                    System.out.println("Dato invalido");
            }
        } 
    }
    //fackturaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaas
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
    
          
}