/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import java.util.List;
import Persistencia.GeneralRepository;

/**
 *
 * @author Juanes
 */
public abstract class GeneralController <T> {   
    protected GeneralRepository<T> classData;
    //Constructor
    public GeneralController() {
    }

    public GeneralController(GeneralRepository classData) {
        this.classData = classData;
    }
    //Metodos    
    public List<T> getAllGeneral() {
        return classData.getAllT();
    } 
    public T getGeneralById(Integer idBuscado) {
        return classData.findATById(idBuscado);
    }
    public abstract boolean eliminarObjeto();
    
}
