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
    private SubMenuHotel submenuHotel;
    private SubMenuMunicipio submenuMunicipio;
    private SubMenuPlan submenuPlan;
    private SubMenuServicioTransporte submenuServicioTransporte;
    private SubMenuTrayecto submenuTrayecto;
    private SubMenuUsuario submenuUsuario;
    private SubMenuViaje submenuViaje;
    Scanner scanner;

    public MenuAdministrador() {
    }

    public MenuAdministrador(Integer id, String contraseña, Scanner scanner) {
        this.id = id;
        this.contraseña = contraseña;
        this.scanner = scanner;
        this.submenuActividadTuristica= new SubMenuActividadTuristica(scanner);
        this.submenuAerolinea= new SubMenuAerolinea(scanner);
        this.submenuHotel= new SubMenuHotel(scanner);
        this.submenuMunicipio= new SubMenuMunicipio(scanner);
        this.submenuPlan= new SubMenuPlan(scanner);
        this.submenuServicioTransporte= new SubMenuServicioTransporte(scanner);
        this.submenuTrayecto= new SubMenuTrayecto (scanner);
        this.submenuUsuario= new SubMenuUsuario(scanner);
        this.submenuViaje= new SubMenuViaje(scanner);
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
                    submenuHotel.mostrarMenu();
                    break;
                case 4:    
                    submenuMunicipio.mostrarMenu();
                    break;
                case 5:    
                    submenuPlan.iniciar();
                    break;
                case 6:    
                    submenuServicioTransporte.mostrarMenu();
                    break;
                case 7:    
                    submenuTrayecto.verSubMenuTrayecto();
                    break;
                case 8:    
                    submenuUsuario.mostrar();
                    break;
                case 9:    
                    submenuViaje.verSubMenuViaje();
                    break;
                case 10:
                    restablecerContraseña();
                    break;
                default:
                    System.out.println("Dato ingresado invalido, ingrese una opcion valida");
            }
        }
    }
    public void restablecerContraseña(){
        String contraseña;
        System.out.println("Ingrese una nueva contraseña");
        contraseña= scanner.nextLine();
        int opcion;
        System.out.println("Se restablecerea la contraseña, esta seguto de hacerlo? (1.Si/2.No)");
        opcion= scanner.nextInt();
        scanner.nextLine();
        switch(opcion){
            case 1:
                setContraseña(contraseña);
                System.out.println("Se ha restablecido la contraseña exisitosamente");
                break;
            case 2:
                System.out.println("Proceso cancelado, muchas gracias ");
                break;
            default:
                System.out.println("Opcion invalida");
        }
    }
    
}
