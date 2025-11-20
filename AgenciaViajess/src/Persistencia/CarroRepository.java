/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Carro;
import java.util.List;
import java.util.ArrayList;

public class CarroRepository {
    private IDataAccess<Carro> dataAccess;
    
    public CarroRepository() {
        this.dataAccess = new JsonRepository<>("carroa.json", Carro.class);
    }
    
    // Constructor for dependency injection
    public CarroRepository(IDataAccess<Carro> dataAccess) {
        this.dataAccess = dataAccess;
    }
    
    public List<Carro> getAllCarros() {
        return dataAccess.findAll();
    }
    
    public Carro findCarroById(Integer id) {
        return dataAccess.findById(id);
    }
    
    public void saveCarro(Carro carro) {
        dataAccess.save(carro);
    }
    
    public void deleteCarro(Integer id) {
        dataAccess.delete(id);
    }
}