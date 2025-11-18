/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciaviajess;

import Presentacion.*;
import java.util.Scanner;

/**
 *
 * @author Juan Guerrero
 */
public class main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        MenuPrincipal menuPrincipal= new MenuPrincipal(1, scanner);
        menuPrincipal.verMenu();
    }
    
}
