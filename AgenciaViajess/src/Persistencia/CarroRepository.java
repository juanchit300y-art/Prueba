/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Carro;

public class CarroRepository extends GeneralRepository <Carro>{    
    public CarroRepository() {
        this.dataAccess = new JsonRepository<>("carros.json", Carro.class);
    }
    public CarroRepository(IDataAccess<Carro> dataAccess) {
        this.dataAccess = dataAccess;
    }
}