/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.ItinerarioTransporte;
import java.util.ArrayList;
import java.util.List;

public class ItinerarioTransporteRepository extends GeneralRepository<ItinerarioTransporte>{
    
    
    public ItinerarioTransporteRepository() {
        this.dataAccess = new JsonRepository<>("ItinerariosDeTransporte.json", ItinerarioTransporte.class);
    }
    public ItinerarioTransporteRepository(IDataAccess<ItinerarioTransporte> dataAccess) {
        this.dataAccess = dataAccess;
    }
    
    public List<ItinerarioTransporte> findItinerarioTransportByViajeId(Integer viajeId) {
        List<ItinerarioTransporte> itinerariosDeTransporte = getAllT();
        List<ItinerarioTransporte> result = new ArrayList<>();
        for (ItinerarioTransporte itinerarioDeTransporte : itinerariosDeTransporte) {
            if (itinerarioDeTransporte.getViajeId() != null && itinerarioDeTransporte.getViajeId().equals(viajeId)) {
                result.add(itinerarioDeTransporte);
            }
        }
        return result;
    }
    
    public List<ItinerarioTransporte> findItinerarioTransportByTrayectoId(Integer trayectoId) {
        List<ItinerarioTransporte> itinerariosDeTransporte = getAllT();
        List<ItinerarioTransporte> result = new ArrayList<>();
        for (ItinerarioTransporte itinerarioDeTransporte : itinerariosDeTransporte) {
            if (itinerarioDeTransporte.getTrayectoId() != null && itinerarioDeTransporte.getTrayectoId().equals(trayectoId)) {
                result.add(itinerarioDeTransporte);
            }
        }
        return result;
    }
}