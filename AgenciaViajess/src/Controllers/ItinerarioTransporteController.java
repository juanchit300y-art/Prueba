/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Persistencia.*;
import Modelos.*;
import java.util.List;


/**
 *
 * @author DELL
 */
public class ItinerarioTransporteController extends GeneralController<ItinerarioTransporte> {
    TrayectoRepository trayectoData;
    ViajeRepository viajeData;
    ReservaRepository reservaData;
    
    public ItinerarioTransporteController() {
    }
    public ItinerarioTransporteController(ItinerarioTransporteRepository classData) {
        this.classData= new ItinerarioTransporteRepository();
        this.trayectoData= new TrayectoRepository();
        this.viajeData= new ViajeRepository();
        this.reservaData= new ReservaRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<Reserva> reservasItinerarioTransporte= reservaData.findReservaByItinerarioTransporteId(id);       
        if (!reservasItinerarioTransporte.isEmpty()) {
            return false; 
        }
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarItinerarioTransporte(Integer id, int orden, Integer trayectoId, Integer viajeId) {
        ItinerarioTransporte itinerarioTransporte = classData.findATById(id);
        if (itinerarioTransporte == null) {
            return false;
        }
        if (orden>0) {
            itinerarioTransporte.setOrden(orden);
        }
        
        if (trayectoId != null) {
            Trayecto trayecto = trayectoData.findATById(trayectoId);
            if (trayecto == null) {
                return false;
            }
            itinerarioTransporte.setTrayectoId(trayectoId); 
        }
        
        if (viajeId != null) {
            Viaje viaje = viajeData.findATById(viajeId);
            if (viaje == null) {
                return false;
            }
            itinerarioTransporte.setViajeId(viajeId); 
        }
        classData.saveT(itinerarioTransporte);
        return true;
    }

    public boolean añadirItinerarioTransporte(int orden, Integer trayectoId, Integer viajeId) {
        if (orden < 0) {
            return false;
        }
        
        Trayecto trayecto = trayectoData.findATById(trayectoId);
        if (trayecto == null) {
            return false;
        }
        
        Viaje viaje = viajeData.findATById(viajeId);
        if (viaje == null) {
            return false;
        }
        
        ItinerarioTransporte itinerarioTransporte = new ItinerarioTransporte();
        itinerarioTransporte.setOrden(orden);
        itinerarioTransporte.setTrayectoId(trayectoId);
        itinerarioTransporte.setViajeId(viajeId);
        
        classData.saveT(itinerarioTransporte);
        return true;
    }
}
