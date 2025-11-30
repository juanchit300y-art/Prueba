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
        System.out.println("");
    }
    public void MetodoD(){
        System.out.println("======== Metodo D======== ");
    
    }
    public void MetodoE(){
        System.out.println("======== Metodo E======== ");
        System.out.println("");
    }
    public void MetodoF(){
        System.out.println("======== Metodo F======== ");
        System.out.println("");
    }
    public void MetodoG(){
        System.out.println("======== Metodo G======== ");
        System.out.println("");
    
    }
    public void MetodoH(){
        System.out.println("======== Metodo H======== ");
        System.out.println("");
    
    }
    public void MetodoI(){
        System.out.println("======== Metodo I======== ");
        System.out.println("");
    }
    public void MetodoJ(){
        System.out.println("======== Metodo J======== ");
        System.out.println("");
    
    }
    public void MetodoK(){
        System.out.println("======== Metodo K======== ");
        System.out.println("");
    
    }
    
}
