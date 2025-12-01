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
    private TrayectoRepository trayectoData;
    private ViajeRepository viajeData;
    private ReservaRepository reservaData;
    private ItinerarioTransporteRepository itinerarioTransporteData;
    private ServicioTransporteController controladorServicioTransporte;
    
    public ItinerarioTransporteController() {
        this.classData= new ItinerarioTransporteRepository();
        this.trayectoData= new TrayectoRepository();
        this.viajeData= new ViajeRepository();
        this.reservaData= new ReservaRepository();
        this.itinerarioTransporteData= new ItinerarioTransporteRepository();
        this.controladorServicioTransporte= new ServicioTransporteController();
    }
    public ItinerarioTransporteController(ItinerarioTransporteRepository classData) {
        this.classData= classData;
        this.trayectoData= new TrayectoRepository();
        this.viajeData= new ViajeRepository();
        this.reservaData= new ReservaRepository();
        this.itinerarioTransporteData= new ItinerarioTransporteRepository();
        this.controladorServicioTransporte= new ServicioTransporteController();
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
    
    public boolean actualizarItinerarioTransporte(Integer id, Integer orden, Integer trayectoId, Integer viajeId) {
        ItinerarioTransporte itinerarioTransporte = classData.findATById(id);
        if (itinerarioTransporte == null) {
            return false;
        }
        if (orden != null && orden > 0) {
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

    public boolean añadirItinerarioTransporte(Integer orden, Integer trayectoId, Integer viajeId) {
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

    //Relacion a Trayecto (caso curso)
    public List<ItinerarioTransporte> getItinerariosTransporteByTrayecto(Integer trayectoId) {
        return itinerarioTransporteData.findItinerarioTransportByTrayectoId(trayectoId);
    }
    public Trayecto getTrayectoDeItinerarioTransporte(Integer itinerarioTransporteId) {
        ItinerarioTransporte itinerarioTransporte = classData.findATById(itinerarioTransporteId);
        if (itinerarioTransporte == null) {
            return null;
        }
        return trayectoData.findATById(itinerarioTransporte.getTrayectoId());
    }
    
    //Relacion a Viaje (caso curso)
    public List<ItinerarioTransporte> getItinerariosTransporteByViaje(Integer viajeId) {
        return itinerarioTransporteData.findItinerarioTransportByViajeId(viajeId);
    }
    public Viaje getViajeDeItinerarioTransporte(Integer itinerarioTransporteId) {
        ItinerarioTransporte itinerarioTransporte = classData.findATById(itinerarioTransporteId);
        if (itinerarioTransporte == null) {
            return null;
        }
        return viajeData.findATById(itinerarioTransporte.getViajeId());
    }
    
    //Relacion lista reservas (caso profesor)
    public List<Reserva> getReservasDeItinerarioTransporte(Integer itinerarioTransporteId){ 
        return reservaData.findReservaByItinerarioTransporteId(itinerarioTransporteId);
    }
    public boolean assignReservaToItinerarioTransporte(Integer itinerarioTransporteId, Integer reservaId) {
        ItinerarioTransporte itinerarioTransporte = classData.findATById(itinerarioTransporteId);
        Reserva reserva = reservaData.findATById(reservaId);
        
        if (itinerarioTransporte == null || reserva == null) {
            return false;
        }
        
        reserva.setItinerarioTransporteId(itinerarioTransporteId);
        reservaData.saveT(reserva);
        return true;
    }
    //Metodo trayecto segun viaje id
    public Double costoTrayectoXViaje(Integer viajeId){
        Double respuesta=0.0;
        List<ItinerarioTransporte> itinerariosXViaje= getItinerariosTransporteByViaje(viajeId);
        for(ItinerarioTransporte actual : itinerariosXViaje){
            Integer idTrayecto= actual.getTrayectoId();
            Double aSumar= controladorServicioTransporte.costoXTrayectoAereo(idTrayecto);
            respuesta= aSumar + respuesta;
        }
        return respuesta;
    }
    public Double MetodoI(Integer viajeId){
        Double respuesta=0.0;
        List<ItinerarioTransporte> itinerariosXViaje= getItinerariosTransporteByViaje(viajeId);
        for(ItinerarioTransporte actual : itinerariosXViaje){
            Integer idTrayecto= actual.getTrayectoId();
            Double aSumar= controladorServicioTransporte.costoXTrayecto(idTrayecto);
            respuesta= aSumar + respuesta;
        }
        return respuesta;
    }
}
