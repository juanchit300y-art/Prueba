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
        while(inicio !=  0){    
            System.out.println("========Bienvenido al menu de Administrador========");
            System.out.println("Ingrese la opcion que desee:");
            System.out.println("1.Gestionar Actividades Turisticas");
            System.out.println("2. Gestionar Aerolineas");
            System.out.println("3. Gestionar Aeronaves");
            System.out.println("4. Gestionar Carros");
            System.out.println("5. Gestionar Clientes");
            System.out.println("6. Gestionar Cuotas");
            System.out.println("7. Gestionar Elementos Planes");
            System.out.println("8. Gestionar Entretenimiento ");
            System.out.println("9. Gestionar Facturas");
            System.out.println("10. Gestionar Guias");
            System.out.println("11. Gestionar Habitaciones");
            System.out.println("12. Gestionar Hoteles");
            System.out.println("13. Gestionar Itinerario Transporte");
            System.out.println("14. Gestionar Municipios");
            System.out.println("15. Gestionar Planes");
            System.out.println("16. Gestionar Reservas");
            System.out.println("17. Gestionar Servicios de Transporte");
            System.out.println("18. Gestionar Trayectos");
            System.out.println("19. Gestionar Turnos");
            System.out.println("20. Gestionar Viajes");
            System.out.println("===Presione 0 para Salir====");
            inicio= scanner.nextInt();
            scanner.nextLine();
            switch(inicio){
                case 0:
                    break;
                case 1:
                    
            }
        }
    }
    
}
