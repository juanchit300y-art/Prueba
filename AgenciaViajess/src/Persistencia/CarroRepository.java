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
    
}