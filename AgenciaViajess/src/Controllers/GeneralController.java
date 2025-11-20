/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Persistencia.GeneralRepository;

/**
 *
 * @author Juanes
 */
public abstract class GeneralController {
    protected GeneralRepository classData;

    public GeneralController() {
    }

    public GeneralController(GeneralRepository classData) {
        this.classData = classData;
    }
    
    
    
}
