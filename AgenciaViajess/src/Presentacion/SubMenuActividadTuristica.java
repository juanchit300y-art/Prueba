/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Controllers.ActividadTuristicaController;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class SubMenuActividadTuristica {
    private ActividadTuristicaController controlador;
    Scanner scanner;

    public SubMenuActividadTuristica() {
    }

    public SubMenuActividadTuristica(ActividadTuristicaController controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }
    
    /**
     * @return the controlador
     */
    public ActividadTuristicaController getControlador() {
        return controlador;
    }

    /**
     * @param controlador the controlador to set
     */
    public void setControlador(ActividadTuristicaController controlador) {
        this.controlador = controlador;
    }
    public void verSubMenuActividadTuristica(){
        int inicio=1;
        while(inicio !=0 ){
        System.out.println("========Bienvenido al menu de Gestion de Actividades Turisticas========");
        System.out.println("Seleccion la opcion deseada: ");
        System.out.println("1.  ");
        System.out.println("2.  ");
        System.out.println("3.  ");
        System.out.println("4.  ");
        System.out.println("Presione 0 para volver  ");
        inicio= scanner.nextInt();
        scanner.nextLine();
        
        }
    }
        
    
}
