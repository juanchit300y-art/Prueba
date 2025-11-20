/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Factura;

public class FacturaRepository extends GeneralRepository<Factura>{
    
    
    public HotelRepository() {
        this.dataAccess = new JsonRepository<>("Hoteles.json", Hotel.class);
    }
    public HotelRepository(IDataAccess<Hotel> dataAccess) {
        this.dataAccess = dataAccess;
    }
}