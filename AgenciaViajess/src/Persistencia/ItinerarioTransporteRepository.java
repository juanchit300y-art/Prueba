/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.ItinerarioTransporte;

public class ItinerarioTransporteRepository extends GeneralRepository<ItinerarioTransporte>{
    
    
    public ItinerarioTransporteRepository() {
        this.dataAccess = new JsonRepository<>("ItinerariosDeTransporte.json", ItinerarioTransporte.class);
    }
    public ItinerarioTransporteRepository(IDataAccess<ItinerarioTransporte> dataAccess) {
        this.dataAccess = dataAccess;
    }
}