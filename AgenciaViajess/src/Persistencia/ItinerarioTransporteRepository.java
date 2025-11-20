/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.ItinerarioTransporte;
import java.util.List;
import java.util.ArrayList;

public class ItinerarioTransporteRepository {
    private IDataAccess<ItinerarioTransporte> dataAccess;
    
    public ItinerarioTransporteRepository() {
        this.dataAccess = new JsonRepository<>("ItinerariosDeTransporte.json", ItinerarioTransporte.class);
    }
    
    // Constructor for dependency injection
    public ItinerarioTransporteRepository(IDataAccess<ItinerarioTransporte> dataAccess) {
        this.dataAccess = dataAccess;
    }
    
    public List<ItinerarioTransporte> getAllItinerariosDeTransporte() {
        return dataAccess.findAll();
    }
    
    public ItinerarioTransporte findItinerarioTransporteById(Integer id) {
        return dataAccess.findById(id);
    }
    
    public void saveItinerarioTransporte(ItinerarioTransporte course) {
        dataAccess.save(course);
    }
    
    public void deleteItinerarioTransporte(Integer id) {
        dataAccess.delete(id);
    }
}