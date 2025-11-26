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
    private String contraseña;
    private SubMenuActividadTuristica submenuActividadTuristica;
    private SubMenuAerolinea submenuAerolinea;
    Scanner scanner;

    public MenuAdministrador() {
    }

    public MenuAdministrador(Integer id, String contraseña, Scanner scanner) {
        this.id = id;
        this.contraseña = contraseña;
        this.scanner = scanner;
        this.submenuActividadTuristica= new SubMenuActividadTuristica(scanner);
        this.submenuAerolinea= new SubMenuAerolinea(scanner);
    }

    /**
     * @return the id
     */
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
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    public void ingresoContraseña(){
        int volver=1;
        while(volver !=0){
            String contraseña;
            System.out.println("Ingrese la contraseña de Administrador para ingresar al sistema");
            contraseña= scanner.nextLine();
            if(contraseña.equals (this.contraseña)){
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
        while(inicio !=  0){    
            System.out.println("========Bienvenido al menu de Administrador========");
            System.out.println("Ingrese la opcion que desee:");
            System.out.println("1.Gestionar Actividades Turisticas");
            System.out.println("2. Gestionar Aerolineas"); 
            System.out.println("3. Gestionar Hoteles");
            System.out.println("4. Gestionar Municipios");
            System.out.println("5. Gestionar Planes");
            System.out.println("6. Gestionar Servicios de Transporte");
            System.out.println("7. Gestionar Trayectos");
            System.out.println("8. Gestionar Usuario");
            System.out.println("9. Gestionar Viajes");
            System.out.println("10. Restablecer contraseña de Administradores");
            System.out.println("===Presione 0 para Salir====");
            inicio= scanner.nextInt();
            scanner.nextLine();
            switch(inicio){
                case 0:
                    break;
                case 1:
                    submenuActividadTuristica.verSubMenuActividadTuristica();
                    break;
                case 2:    
                    submenuAerolinea.verSubMenuAerolinea();
                    break;
                case 3:    
                    // linea    
                case 4:    
                    // linea
                case 5:    
                    // linea
                case 6:    
                    // linea
                case 7:    
                    // linea
                case 8:    
                    // linea
                case 9:    
                    // linea
                case 10:
                    
                default:
                    System.out.println("Dato ingresado invalido, ingrese una opcion valida");
            }
        }
    }
    
}
