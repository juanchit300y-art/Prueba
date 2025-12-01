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
    private FacturaController facturaController;
    private ItinerarioTransporteController itinerarioTransporteController;

    public MenuMetodos(Scanner scanner) {
        this.scanner = scanner;
        this.viajeController= new ViajeController();
        this.aerolineaController= new AerolineaController();
        this.facturaController= new FacturaController();
        this.itinerarioTransporteController= new ItinerarioTransporteController();
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
                    MetodoA();//1.0
                    break;
                case 2:
                    MetodoB();//id 1 = 88878.0
                    break;
                case 3:
                    MetodoC();//da 1
                    break;
                case 4:
                    MetodoD();//cliente 2 da 382273
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
                    MetodoI();//viaje 1 da 667878
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
        Integer clienteId;
        System.out.println("Ingrse el id del cliente del cual lo quiere ver: ");
        clienteId= scanner.nextInt();
        scanner.nextLine();
        Double resultado= facturaController.metodoD(clienteId);
        System.out.println("Costo de todos sus trayectos aereos: " + resultado);
    
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
        Integer idAerolinea;
        System.out.println("Ingrese el id de la Aerolinea");
        idAerolinea= scanner.nextInt();
        scanner.nextLine();
        Integer idMunicipio;
        System.out.println("Ingrese el id del Municipio: ");
        idMunicipio= scanner.nextInt();
        scanner.nextLine();
        int respuesta= facturaController.metodoH(idAerolinea, idMunicipio);
        System.out.println("Total de clientes : " + respuesta);
    }
    public void MetodoI(){
        System.out.println("======== Metodo I======== ");
        System.out.println("Suma total de costos de todos los servicios de transporte (trayectos) para un viaje específico. ");
        Integer idViaje;
        System.out.println("Ingrese el id del viaje: ");
        idViaje= scanner.nextInt();
        scanner.nextLine();
        Double respuesta= itinerarioTransporteController.MetodoI(idViaje);
        System.out.println("El costo total de los trayectos es " + respuesta );
        
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
