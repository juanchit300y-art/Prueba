/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Controllers.*;
import java.util.Scanner;

/**
 *
 * @author Juanes
 */
public class MenuMetodos {
    Scanner scanner;
    private ViajeController viajeController;
    private AerolineaController aerolineaController;
    public MenuMetodos() {
    }

    public MenuMetodos(Scanner scanner) {
        this.scanner = scanner;
        this.viajeController= new ViajeController();
        this.aerolineaController= new AerolineaController();
    }
    public void verMenu(){
        int opcion= 1;
        while (opcion !=0 ){
            System.out.println("======== Bienvenido al menu de Metodos ========");
            System.out.println("1. Metodo A");
            System.out.println("2. Metodo B");
            System.out.println("3. Metodo C");
            System.out.println("4. Metodo D");
            System.out.println("5. Metodo E");
            System.out.println("6. Metodo F");
            System.out.println("7. Metodo G");
            System.out.println("8. Metodo H");
            System.out.println("9. Metodo I");
            System.out.println("10. Metodo J");
            System.out.println("11. Metodo K");
            System.out.println("Seleccione el metodo que desea ejecutar:  ");
            System.out.println("======== Presione 0 para volver========");
            opcion= scanner.nextInt();
            scanner.nextLine();
            switch( opcion){
                case 0:
                    break;
                case 1:
                    MetodoA();
                    break;
                case 2:
                    MetodoB();
                    break;
                case 3:
                    MetodoC();
                    break;
                case 4:
                    MetodoD();
                    break;
                case 5:
                    MetodoE();
                    break;
                case 6:
                    MetodoF();
                    break;
                case 7:
                    MetodoG();
                    break;
                case 8:
                    MetodoH();
                    break;
                case 9:
                    MetodoI();
                    break;
                case 10:
                    MetodoJ();
                    break;
                case 11:
                    MetodoK();
                    break;
                default:
                    System.out.println("======== Opcion invalida======== ");
            }
        }
    }
    public void MetodoA(){
        System.out.println("======== Metodo A======== ");
        System.out.println("Promedio de actividades por plan para viajes que incluyen al menos un trayecto aéreo y uno terrestre: ");
        double Resultado= this.viajeController.metodoA();
        System.out.println(Resultado);
    }
    public void MetodoB(){
        System.out.println("======== Metodo B======== ");
        System.out.println("Mínimo costo de un trayecto aéreo para una aerolínea específica.");
        Integer idAerolinea;
        System.out.println("Ingrese el Id de la Aerolinea: ");
        idAerolinea= scanner.nextInt();
        scanner.nextLine();
        Double respuesta= aerolineaController.MetodoB(idAerolinea);
        System.out.println("La aerolinea Seleccionada fue :");
        System.out.print(this.aerolineaController.getGeneralById(idAerolinea));
        System.out.println("El costo minimo de la aerolinea es: " + respuesta);
    }
    public void MetodoC(){
        System.out.println("======== Metodo C======== ");
        System.out.println("Cantidad de viajes que incluyen al menos un plan con una actividad específica dada por parámetro mediante el nombre) y que hayan utilizado un vehículo del hotel con menos habitaciones");
        String nombreActividad;
        System.out.println("Ingrese el nombre de la actividad especifica : ");
        nombreActividad= scanner.nextLine();
        int resultado= viajeController.metodoC(nombreActividad);
        System.out.println(resultado);
                
    }
    public void MetodoD(){
        System.out.println("======== Metodo D======== ");
        System.out.println("Suma total de costos de todos los trayectos de tipo vuelo para un cliente específico. ");
    
    }
    public void MetodoE(){
        System.out.println("======== Metodo E======== ");
        System.out.println("Retornar en una lista de todos los hoteles que tienen habitaciones reservadas en viajes que incluyen un plan con al menos 3 actividades. ");
    }
    public void MetodoF(){
        System.out.println("======== Metodo F======== ");
        System.out.println("Promedio de trayectos por viaje para clientes que han realizado más de un viaje. ");
    }
    public void MetodoG(){
        System.out.println("======== Metodo G======== ");
        System.out.println("Máximo número de actividades en un plan para viajes que tienen al menos un trayecto terrestre.");
    
    }
    public void MetodoH(){
        System.out.println("======== Metodo H======== ");
        System.out.println("Conteo de clientes que han utilizado una aerolínea específica y han realizado al menos una actividad en un municipio específico. ");
    
    }
    public void MetodoI(){
        System.out.println("======== Metodo I======== ");
        System.out.println("Suma total de costos de todos los servicios de transporte (trayectos) para un viaje específico. ");
    }
    public void MetodoJ(){
        System.out.println("======== Metodo J======== ");
        System.out.println("Retornar en una nueva lista todos los planes que incluyen una actividad con nombre específico y que han sido contratados por clientes con más de un viaje.");
    
    }
    public void MetodoK(){
        System.out.println("======== Metodo K======== ");
        System.out.println("Promedio de habitaciones reservadas por hotel en viajes que incluyen al menos un trayecto aéreo y un trayecto terrestre.");
    
    }
    
}
