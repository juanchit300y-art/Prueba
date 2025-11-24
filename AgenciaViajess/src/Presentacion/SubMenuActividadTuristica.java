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
    public SubMenuActividadTuristica(Scanner scanner) {
        this.controlador= new ActividadTuristicaController();
        this.scanner= scanner;
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
        System.out.println("1. Añadir Actividad Turistica  ");
        System.out.println("2. Modificar Actividad Turistica  ");
        System.out.println("3. Elimar Actividad Turistica ");
        System.out.println("4. Ver todas las actividades Tursiticas ");
        System.out.println("5. Buscar Actividad Turistica");
        System.out.println("6. Gestionar Elemento Plan");
        System.out.println("Presione 0 para volver  ");
        inicio= scanner.nextInt();
        scanner.nextLine();
                    switch(inicio){
                case 0:
                    break;
                case 1:
                    añadirActividadTuristica();
                    break;
                case 2:    
                    // linea
                case 3:    
                    // linea    
                case 4:    
                    // linea
                case 5:    
                    // linea
                case 6:    
                    // linea
                default:
                    System.out.println("Numero invalido, incgrese una de las opciones correspondientes");
            }
        }
    }
    public void añadirActividadTuristica(){
        String nombre= null;
        System.out.println("Ingrese el nombre de la actividad Turistica");
        nombre= scanner.nextLine();
        Integer idMunicipio;
        int numeroEntrada;
        System.out.println("Ingrese el Municipio al que corresponde");
        numeroEntrada= scanner.nextInt();
        scanner.nextLine();
        idMunicipio=numeroEntrada;
        if(controlador.añadirActividadTuristica(nombre, idMunicipio)){
            
        }
        else{
            System.out.println("La creacion de la Actividad Turistica fallo, revise los datos ingresados");
        }
    }    
    
}
