/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Scanner;

/**
 *
 * @author Juanes
 */
public class MenuAdministrador {
    private Integer id;
    Scanner scanner;

    public MenuAdministrador() {
    }

    public MenuAdministrador(Integer id, Scanner scanner) {
        this.id = id;
        this.scanner = scanner;
    }
    public void ingresoContraseña(){
        int volver=1;
        while(volver !=0){
            int contraseña;
            System.out.println("Ingrese la contraseña de Administrador para ingresar al sistema");
            contraseña= scanner.nextInt();
            scanner.nextLine();
            if(contraseña== 12345){
                verMenu();
                volver=0;
            }
            else{
                System.out.println("Contraseña Incorrecta, presione 0 para volver");
                volver= scanner.nextInt();
                scanner.nextLine();
            }
        }
    }
    
    
    public void verMenu(){
        int inicio=1;
        while(inicio !=  9){}    
            System.out.println("========Bienvenido al menu de Administrador========");
            System.out.println("9. Salir");
            inicio= scanner.nextInt();
            scanner.nextLine();
        }
    
}
