/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public abstract class GeneralRepository<T> {
    
    protected IDataAccess<T> dataAccess;

    public GeneralRepository() {
    }
   
    public List<T> getAllT() {
        return dataAccess.findAll();
    }
    
    public T findATById(Integer id) {
        return dataAccess.findById(id);
    }
    
    public void saveT(T objeto) {
        dataAccess.save(objeto);
    }
    
    public void deleteT(Integer id) {
        dataAccess.delete(id);
    }
}

