/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Controllers.AerolineaController;
import Modelos.Aerolinea;
import Modelos.Aeronave;
import java.util.List;
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
        System.out.println("========Bienvenido al menu de Gestion de Aerolinea========");
        System.out.println("Seleccion la opcion deseada: ");
        System.out.println("1. Añadir Aerolinea");
        System.out.println("2. Modificar Aerolinea");
        System.out.println("3. Elimar Aerolinea");
        System.out.println("4. Ver todas las aerolineas");
        System.out.println("5. Buscar Aerolinea");
        System.out.println("6. Gestionar Aeronaves");
        System.out.println("======== Presione 0 para volver ========  ");
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
                    verTodasAerolineas();
                    break;
                case 5:    
                    buscarAerolinea();
                    break;
                case 6:    
                    eleccionEspecificoOGeneral();
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
        if(aerolinea== null){
            System.out.println("========El id ingresado no existe, por favor reviselo========");
        }
        else {
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
    }
    public void eliminarAerolinea(){
        int aerolineaAEliminarId;
        System.out.println("Para eliminar una Aerolinea: ");
        System.out.println("Ingrese el id de la Aerolinea que desea eliminar: ");
        aerolineaAEliminarId= scanner.nextInt();
        scanner.nextLine();
        Aerolinea aerolineaAEliminar= controlador.getGeneralById(aerolineaAEliminarId);
        if (aerolineaAEliminar== null){
            System.out.println("Aerolinea inexistente, no se encontro Aerolinea con ese Id");
        }
        else{
            System.out.println("La aerolinea que fue ingresada es: ");
            System.out.println(aerolineaAEliminar);
            System.out.println("¿Esta seguro que desea eliminarla?");
            int eleccion;
            System.out.println("Presione 1 para confirmar y 2 para cancelar");
            eleccion= scanner.nextInt();
            switch(eleccion){
                case 1:
                    if(controlador.eliminarObjeto(aerolineaAEliminarId)){
                        System.out.println("======== La aerolinea fue eliminada correctamente ======== ");
                    }
                    else{
                        System.out.println("======== No fue posible eliminar la aerolinea, asegurese de que no la aerolinea no posea aeronaves======== ");
                        System.out.println("======== De ser asi, no es posible realizar su eliminacion ========  ");
                    }
                    break;
                case 2:
                    System.out.println("========La Aerolinea no fue eliminada, muchas gracias ========  ");
                    break;
                default:
                    System.out.println("======== Opcion invalida, por favor ingrese un numero valido ======== ");
            }
        }
    }
    public void verTodasAerolineas(){
        System.out.println("======== Todas las aerolineas de nuestra agencia de viajes======== ");
        List<Aerolinea> aerolineas= controlador.getAllGeneral();
        if(aerolineas.isEmpty()){
            System.out.println("========No se encuentran Aerolineas registradas en el sistema========");
        }
        else{
            for(Aerolinea actual: aerolineas){
                System.out.println(actual);
            }
        }
    }
    public void buscarAerolinea(){
        System.out.println("Para buscar una Aerolinea: ");
        int idAerolineaBuscada;
        System.out.println("Ingrese el Id de la Aerolinea que desea buscar:  ");
        idAerolineaBuscada= scanner.nextInt();
        scanner.nextLine();
        Aerolinea aerolinea= controlador.getGeneralById(idAerolineaBuscada);
        if (aerolinea== null){
            System.out.println("======== Aerolinea inexistente o Id no encontrado ========");
        }
        else{
            System.out.println(aerolinea);
        }
    }
    public void eleccionEspecificoOGeneral(){
        int opcion;
        System.out.println("Escoja la opcion que desee: ");
        System.out.println("1. Si desea Gestionar las aeronaves de una Aerolinea en especifico");
        System.out.println("2. Si desea Gestionar las aeronaves de toda la Agencia");
        System.out.println("======== Presione 0 para volver ========");
        opcion= scanner.nextInt();
        scanner.nextLine();
        switch(opcion){
            case 0:
                break;
            case 1:
                int idAeronavesAerolinea;
                System.out.println("Ingrese el Id de la Aerolinea de la cual desea gestionar sus Aeronaves: ");
                idAeronavesAerolinea= scanner.nextInt();
                scanner.nextLine();
                System.out.println("Codigo en proceso, estamos trabajando en eso :p (Aqui va linea de codigo) "); //Linea de Codigoooooooooo
                break;
            case 2:
                System.out.println("Codigo en proceso, estamos trabajando en eso :p"); //Linea de codigooooooooooooooooo
                break;
            default:
                System.out.println("======== Opcion invalidad, ingrese el dato correspondiente ======== ");
        }
    }

}
