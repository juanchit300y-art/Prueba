/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Controllers.ClienteController;
import Controllers.GuiaController;
import java.util.Scanner;
import Modelos.Cliente;
import Modelos.Guia;
/**
 *
 * @author Juan Guerrero
 */
public class SubMenuSesionUsuario {
    private SubMenuCliente submenuCliente;
    private SubMenuGuia submenuGuia;
    private ClienteController clienteController;
    private GuiaController guiaController;
    private MenuExperienciaUsuarioCliente menuExperienciaUsuario;
    Scanner scanner;
            
    public SubMenuSesionUsuario() {
    }

    public SubMenuSesionUsuario(Scanner scanner) {
        this.submenuCliente = new SubMenuCliente(scanner);
        this.submenuGuia = new SubMenuGuia(scanner);
        this.scanner = scanner;
        this.clienteController = new ClienteController();
        this.guiaController = new GuiaController();
        this.menuExperienciaUsuario= new MenuExperienciaUsuarioCliente(scanner);
    }

    
    public void verMenu(){
        int inicio = 1;
        while (inicio!=0){
            System.out.println("========Bienvenido al menu de Usuario========");
            System.out.println("Ingrese la opcion que desee:");
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Registrarse");
            System.out.println("===Presione 0 para Salir====");
            inicio=scanner.nextInt();
            scanner.nextLine(); 
            
            switch(inicio){
                case 1:
                    IniciarSesion();
                    break;
                case 2:
                    Registrarse();
                    break;
            }
        }
    }
    
    public void Registrarse(){
        int inicio=1;
        while(inicio!=0){
            System.out.println("======== REGISTRARSE ========");
            System.out.println("Ingrese la opcion que desee:");
            System.out.println("1. Usuario");
            System.out.println("2. Guia");
            System.out.println("===Presione 0 para Salir====");
            inicio=scanner.nextInt();
            scanner.nextLine();
            
            switch(inicio){
                case 1:
                    submenuCliente.registrarCliente();
                case 2:
                    submenuGuia.crear();
            }
        }
        
    }
    
    public void IniciarSesion(){
        int inicio = 1;
        while(inicio!=0){
            System.out.println("======== INISIAR SESION ========");
            System.out.println("Ingrese la opcion que desee:");
            System.out.println("1. Cliente");
            System.out.println("2. Guia");
            System.out.println("===Presione 0 para Salir====");
            inicio=scanner.nextInt();
            scanner.nextLine();
            
            switch(inicio){
                case 1:
                    iniciarSesionCliente();
                    break;
                case 2:
                    iniciarSesionGuia();
                    break;
                
            }
        }
        
    }
    
    public void iniciarSesionCliente(){
        int inicio = 1;
        while(inicio!=0){
            System.out.println("======== Cliente ========");
            System.out.println("Ingrese su ID:");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Cliente cliente = clienteController.getGeneralById(id);

            if (cliente == null) {
                System.out.println("===== ID no encontrado =====");
                return;
            }
            
            System.out.println("Ingrese su Contraseña:");
            String contraseña = scanner.nextLine();
            
            if(cliente.getContraseña().equals(contraseña)){
                System.out.println("===== INICIO DE SESION EXITOSO =====");
                menuExperienciaUsuario.mostrarMenuCliente(id);
                inicio=0;
            }else{
                System.out.println("Contraseña incorrecta, presione 0 para volver");
                inicio= scanner.nextInt();
                scanner.nextLine();
            }

        }
    }
    
    public void iniciarSesionGuia(){
        int inicio = 1;
        while(inicio!=0){
            System.out.println("======== Guia ========");
            System.out.println("Ingrese su ID:");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Guia guia = guiaController.getGeneralById(id);

            if (guia == null) {
                System.out.println("===== ID no encontrado =====");
                return;
            }
            
            System.out.println("Ingrese su Contraseña:");
            String contraseña = scanner.nextLine();
            
            if(guia.getContraseña().equals(contraseña)){
                System.out.println("===== INICIO DE SESION EXITOSO =====");
                System.out.println("--------------------INTERFAZ INICIO DE SESION--------------------");;
                inicio=0;
            }else{
                System.out.println("Contraseña incorrecta, presione 0 para volver");
                inicio= scanner.nextInt();
                scanner.nextLine();
            }

        }
    }
    
    
    
    
}
