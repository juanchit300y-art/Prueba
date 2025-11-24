/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Controllers.AerolineaController;
import Modelos.Aerolinea;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class SubMenuAerolinea {
    private AerolineaController controlador;
    Scanner scanner;
    public SubMenuAerolinea(Scanner scanner) {
        this.controlador= new AerolineaController();
        this.scanner= scanner;
    }

    public SubMenuAerolinea(AerolineaController controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }
    
    /**
     * @return the controlador
     */
    public AerolineaController getControlador() {
        return controlador;
    }

    /**
     * @param controlador the controlador to set
     */
    public void setControlador(AerolineaController controlador) {
        this.controlador = controlador;
    }
    public void verSubMenuAerolinea(){
        int inicio=1;
        while(inicio !=0 ){
        System.out.println("========Bienvenido al menu de Gestion deAerolinea========");
        System.out.println("Seleccion la opcion deseada: ");
        System.out.println("1. Añadir Aerolinea");
        System.out.println("2. Modificar Aerolinea");
        System.out.println("3. Elimar Aerolinea");
        System.out.println("4. Ver todas las aerolineas");
        System.out.println("5. Buscar Aerolinea");
        System.out.println("6. Gestionar Aeronaves");
        System.out.println("Presione 0 para volver  ");
        inicio= scanner.nextInt();
        scanner.nextLine();
                    switch(inicio){
                case 0:
                    break;
                case 1:
                    añadirAerolinea();
                    break;
                case 2:    
                    modificarAerolinea();
                    break;
                case 3:    
                    eliminarAerolinea();   
                    break;
                case 4:    
                    // linea
                    break;
                case 5:    
                    // linea
                    break;
                case 6:    
                    // linea
                    break;
                default:
                    System.out.println("======== Numero invalido, incgrese una de las opciones correspondientes======== ");
            }
        }
    }
    public void añadirAerolinea(){
        String nombre= null;
        System.out.println("Para añadir la nueva aerolinea:   ");
        System.out.println("Ingrese el nombre de la aerolinea");
        nombre= scanner.nextLine();
        String correo;
        System.out.println("Ingrese el correo de la aerolinea:");
        correo= scanner.nextLine();
        if(controlador.añadirAerolinea(nombre, correo)){
            System.out.println("======== La aerolinea se guardo correctamente========");
        }
        else{
            System.out.println("======== La creacion de la Arolinea fallo, revise los datos ingresados======== ");
        }
    }    
    public void modificarAerolinea(){
        int idAModificar;
        System.out.println("Para modificar una Aerolinea:   ");
        System.out.println("Ingrese el id de la Aerolinea a modificar: ");
        idAModificar= scanner.nextInt();
        scanner.nextLine();
        Aerolinea aerolinea= controlador.getGeneralById(idAModificar);
        System.out.println("Estos son los datos actuales de esa Aerolinea:  ");
        System.out.println(aerolinea);
        String nombre;
        System.out.println("Ingrese el nuevo nombre de la Aerolinea:      (Si no desea cambiarlo presione Enter y deje el espacio vacio)");
        nombre= scanner.nextLine();
        String correo;
        System.out.println("Ingrese el nuevo correo de la Aerolinea:      (Si no desea cambiarlo presione Enter y deje el espacio vacio)");
        correo= scanner.nextLine();
        System.out.println("Ingrese el nuevo nombre de la Aerolinea:      (Si no desea cambiarlo presione Enter y deje el espacio vacio)");
        if(controlador.actualizarAerolinea(idAModificar, nombre, correo)){
            System.out.println("======== La modificacion se guardo correctamente ========");
        }
        else{
            System.out.println("======== La modificacion no se guardo correctamente, vuelva a intentarlo ======== ");
        }   
    }
    public void eliminarAerolinea(){
        int aerolineaAEliminarId;
        System.out.println("Para eliminar una Aerolinea: ");
        System.out.println("Ingrese el id de la Aerolinea que desea eliminar: ");
        aerolineaAEliminarId= scanner.nextInt();
        scanner.nextLine();
        Aerolinea aerolineaAEliminar= controlador.getGeneralById(aerolineaAEliminarId);
        System.out.println("");
    }
    1.	Mercado:  
a.	Personas mayores con acceso a celulares
b.	Se estima 2,7 millones de posibles clientes
2.	Problema:
a.	La vulnerabilidad digital a la que están sujetos las personas mayores, enfocándonos en las ciberestafas a las que están expuestos
3.	Dolor:
a.	Desconfianza, impotencia por el desconocimiento, perdida de dinero y tiempo, estrés, incertidumbre
4.	La competencia:
a.	Truora, que se enfoca en la ciberciguridad antifraudes pero a diferencia de ellos nosotros trabajamos enfocándonos en adultos mayores, expandiéndonos por mas ramas que ellos no abarcan y tenemos asistencia humana, y nuestro precio accesible.
5.	La solución
a.	 Una aplicación que se basa en el uso de IA y acompañamiento humano personalizado que reconoce, interpreta, alerta y protege de distintos tipos de estafa en contextos, de tecnologia móvil con énfasis en llamadas y mensajes de tipo sms.
6.	Las características:
a.	Confiable, seguro, fácil de usar, accesible .
7.	Los beneficios
a.	
8.	Los Modelos de Ingresos
a.	
9.	El equipo de trabajo/Talentos
a.	Guerrero:
b.	Jacobo:
c.	Miguel:
d.	Juanes:
10.	El objetivo/propósito
a.	
11.	La tecnología
a.	
12.	El negocio/trato

}
