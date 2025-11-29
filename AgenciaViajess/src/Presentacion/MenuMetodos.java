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
    public MenuMetodos() {
    }

    public MenuMetodos(Scanner scanner) {
        this.scanner = scanner;
        this.viajeController= new ViajeController();
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
            }
        }
    }
    public void MetodoA(){
        double Resultado= this.viajeController.metodoA();
        System.out.println(Resultado);
    }
    public void MetodoB(){
    
    }
    public void MetodoC(){
    
    }
    public void MetodoD(){
    
    }
    public void MetodoE(){
    
    }
    public void MetodoF(){
    
    }
    public void MetodoG(){
    
    }
    public void MetodoH(){
    
    }
    public void MetodoI(){
    
    }
    public void MetodoJ(){
    
    }
    public void MetodoK(){
    
    }
    
}
