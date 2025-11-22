/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Scanner;
import Presentacion.*;
/**
 *
 * @author DELL
 */
public class MenuPrincipal {
    //Atributos
    private Integer id;
    Scanner scanner;
    private MenuAdministrador menuAdministrador;
    //Constructores
    public MenuPrincipal() {
    }

    public MenuPrincipal(Integer id, Scanner scanner) {
        this.id = id;
        this.scanner=scanner;
        this.menuAdministrador= new MenuAdministrador(1, scanner);
    }
    //Getters y Setters
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the menuAdministrador
     */
    public MenuAdministrador getMenuAdministrador() {
        return menuAdministrador;
    }

    /**
     * @param menuAdministrador the menuAdministrador to set
     */
    public void setMenuAdministrador(MenuAdministrador menuAdministrador) {
        this.menuAdministrador = menuAdministrador;
    }
    
    //Metodos
    public void verMenu(){
        
        int inicio=0;
        while(inicio != 3 ){
            System.out.println("========Bienvenido al menu de ViajaSeguro, la mejor agencia de viajes========");
            System.out.println("Seleccione como quiere ingresar: ");
            System.out.println("1. Administrador ");
            System.out.println("2. Usuario");
            System.out.println("3. Salir");
            inicio=  scanner.nextInt();
            scanner.nextLine();
            switch(inicio){
                case 1:
                    menuAdministrador.ingresoContraseña();
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
