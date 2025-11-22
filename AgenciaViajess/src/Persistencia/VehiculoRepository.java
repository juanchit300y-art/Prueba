/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Vehiculo;

public class VehiculoRepository extends GeneralRepository<Vehiculo>{
    
    
    public VehiculoRepository() {
        this.dataAccess = new JsonRepository<>("Vehiculos.json", Vehiculo.class);
    }
    public VehiculoRepository(IDataAccess<Vehiculo> dataAccess) {
        this.dataAccess = dataAccess;
    }
}