/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Viaje;

public class ViajeRepository extends GeneralRepository<Viaje>{
    
    
    public ViajeRepository() {
        this.dataAccess = new JsonRepository<>("Viajes.json", Viaje.class);
    }
    public ViajeRepository(IDataAccess<Viaje> dataAccess) {
        this.dataAccess = dataAccess;
    }
}