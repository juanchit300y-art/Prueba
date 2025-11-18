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
public class MenuPrincipal {
    int id;

    public MenuPrincipal() {
    }

    public MenuPrincipal(int id) {
        this.id = id;
    }
    public void verMenu(){
        
        int inicio=0;
        while(inicio != 3 ){
            System.out.println("========Bienvenido al menu de ViajaSeguro, la mejor agencia de viajes========");
            System.out.println("Seleccione como quiere ingresar: ");
            System.out.println("1. Administrador ");
            System.out.println("2. Usuario");
            System.out.println("3. Salir");
            inicio=  scanner.nextInt();
            switch(inicio){
                case 1:
                    System.out.println("Aqui va linea de Codigo");
                    break;
                case 2:    
                    System.out.println("Aqui va linea de Codigo");
                    break;
                case 3:    
                    System.out.println("=======Gracias por visitar nuestro Sistema======= ");
                    break;
                default:
                    System.out.println("Numero invalido, Ingrese la opcion correspondiente");
            }
        
        }
    }
    
}
