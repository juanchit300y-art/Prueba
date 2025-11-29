/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
/**
 *
 * @author DELL
 */
import java.util.Scanner;
public class SubMenuVehiculo {
    private Scanner scanner;

    public SubMenuVehiculo(Scanner scanner) {
        this.scanner= scanner;
    }
    public void mostrar(){
        int opcion;
        System.out.println("============= SubMenu Vehiculo ========================");
        System.out.println("1. Gestionar Carros");
        System.out.println("2. Gestionar Aeronaves ");
        System.out.println("======= Presione 0 para Salir =======");
        System.out.println("Seleccione una opcion:");
        opcion= scanner.nextInt();
        scanner.nextLine();
        switch(opcion){
            case 1:
                new SubMenuCarro(scanner).iniciarMenu();
                break;
            case 2:
                new SubMenuAeronave(scanner).verSubMenuAeronave();
                break;
            default:
                System.out.println("========Opicon Invalida========");
        }
    }
    
}
