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
public class SubMenu {
    Scanner scanner;
    GeneralController controlador;
    public SubMenu() {
    }

    public SubMenu(Scanner scanner, GeneralController controlador) {
        this.scanner = scanner;
        this.controlador = controlador;
    }

    
}
