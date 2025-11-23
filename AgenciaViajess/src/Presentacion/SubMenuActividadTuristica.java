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
        System.out.println();
    }
    
}
