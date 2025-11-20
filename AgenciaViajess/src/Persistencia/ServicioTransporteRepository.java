/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.ServicioTransporte;

public class ServicioTransporteRepository extends GeneralRepository<ServicioTransporte>{
    
    
    public ServicioTransporteRepository() {
        this.dataAccess = new JsonRepository<>("ServiciosDeTransporte.json", ServicioTransporte.class);
    }
    public ServicioTransporteRepository(IDataAccess<ServicioTransporte> dataAccess) {
        this.dataAccess = dataAccess;
    }
}