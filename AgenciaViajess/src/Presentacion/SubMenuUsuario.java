/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class SubMenuUsuario {
    private Scanner scanner;
    private SubMenuGuia submenuGuia;
    private SubMenuCliente submenuCliente;
    
    public SubMenuUsuario(Scanner scanner) {
        this.scanner= scanner;
        this.submenuCliente= new SubMenuCliente(scanner);
        this.submenuGuia= new SubMenuGuia(scanner);
    }
    public void mostrar(){
        int opcion;
        System.out.println("============= SubMenu Usuarios ========================");
        System.out.println("1. Gestionar Guias");
        System.out.println("2. Gestionar Clientes");
        System.out.println("======= Presione 0 para Salir =======");
        System.out.println("Seleccione una opcion:");
        opcion= scanner.nextInt();
        scanner.nextLine();
        switch(opcion){
            case 1:
                submenuGuia.mostrarMenu();
                break;
            case 2:
                submenuCliente.mostrarMenu();
                break;
            default:
                System.out.println("========Opicon Invalida========");
        }
    }    
    //Controlador de trayecto
}


