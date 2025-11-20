/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Hotel;

public class FacturaRepository extends GeneralRepository<Hotel>{
    
    
    public FacturaRepository() {
        this.dataAccess = new JsonRepository<>("Hoteles.json", Hotel.class);
    }
    public FacturaRepository(IDataAccess<Hotel> dataAccess) {
        this.dataAccess = dataAccess;
    }
}