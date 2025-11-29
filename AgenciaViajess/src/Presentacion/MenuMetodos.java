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
public class MenuMetodos {
    Scanner scanner;

    public MenuMetodos() {
    }

    public MenuMetodos(Scanner scanner) {
        this.scanner = scanner;
    }
    public void verMenu(){
        int opcion= 1;
        while (opcion !=0 ){
            System.out.println("======== Bienvenido al menu de Metodos ========");
            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. ");
            System.out.println("6. ");
            System.out.println("7. ");
            System.out.println("8. ");
            System.out.println("9. ");
            System.out.println("10. ");
            System.out.println("11. ");
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
