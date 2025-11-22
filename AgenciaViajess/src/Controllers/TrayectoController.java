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
public class TrayectoController extends GeneralController<Trayecto> {
    MunicipioRepository municipioInicioData;
    MunicipioRepository municipioDestinoData;
    ItinerarioTransporteRepository itinerarioTransporteData;
    ServicioTransporteRepository servicioTransporteData;
    TrayectoRepository trayectoData;
    public TrayectoController() {
    }
    public TrayectoController(TrayectoRepository classData) {
        this.classData= new TrayectoRepository();
        this.municipioInicioData= new MunicipioRepository();
        this.municipioDestinoData= new MunicipioRepository();
        this.itinerarioTransporteData= new ItinerarioTransporteRepository();
        this.servicioTransporteData= new ServicioTransporteRepository();
        this.trayectoData = new TrayectoRepository();
    }
    
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<ItinerarioTransporte> itinerariosTransporteTrayecto = itinerarioTransporteData.findItinerarioTransportByTrayectoId(id);
        List<ServicioTransporte> servicioTransporteTrayecto = servicioTransporteData.findServicioTransporteByTrayectoId(id);
        
        if (!itinerariosTransporteTrayecto.isEmpty()) {
            return false; 
        }
        if (!servicioTransporteTrayecto.isEmpty()) {
            return false; 
        }
        
        classData.deleteT(id);
        return true;
    }      
    
    public boolean actualizarTrayecto(Integer id, Integer municipioInicioId, Integer municipioDestinoId) {
        Trayecto trayecto = classData.findATById(id);
        if (trayecto == null) {
            return false;
        }
        
        if (municipioInicioId != null) {
            Municipio municipio = municipioInicioData.findATById(municipioInicioId);
            if (municipio == null) {
                return false;
            }
            trayecto.setMunicipioInicioId(municipioInicioId);
        }
        
        if (municipioDestinoId != null) {
            Municipio municipio = municipioDestinoData.findATById(municipioDestinoId);
            if (municipio == null) {
                return false;
            }
            trayecto.setMunicipioDestinoId(municipioDestinoId);
        }
        classData.saveT(trayecto);
        return true;
    }

    public boolean añadirTrayecto(Integer municipioInicioId, Integer municipioDestinoId) {
        
        Municipio municipioInicio = municipioInicioData.findATById(municipioInicioId);
        if (municipioInicio == null) {
            return false;
        }
        
        Municipio municipioDestino = municipioDestinoData.findATById(municipioDestinoId);
        if(municipioDestino == null){
            return false;
        }
        
        
        Trayecto trayecto = new Trayecto();
        trayecto.setMunicipioInicioId(municipioInicioId);
        trayecto.setMunicipioDestinoId(municipioDestinoId);
        
        classData.saveT(trayecto);
        return true;
    }
    //Relacion a MunicipioInicio (caso curso)
    public List<Trayecto> getTrayectosByMunicipioInicio(Integer municipioInicioId) {
        return trayectoData.findTrayectosByMunicipioInicioId(municipioInicioId);
    }
    public Trayecto getMunicipioInicioDeTrayecto(Integer trayectoId) {
        Trayecto trayecto = classData.findATById(trayectoId);
        if (trayecto == null) {
            return null;
        }
        return trayectoData.findATById(trayecto.getMunicipioInicioId());
    }

    //Relacion a MunicipioDestino (caso curso)
    public List<Trayecto> getTrayectosByMunicipioDestino(Integer municipioDestinoId) {
        return trayectoData.findTrayectosByMunicipioDestinoId(municipioDestinoId);
    }
    public Trayecto getMunicipioDestinoDeTrayecto(Integer trayectoId) {
        Trayecto trayecto = classData.findATById(trayectoId);
        if (trayecto == null) {
            return null;
        }
        return trayectoData.findATById(trayecto.getMunicipioDestinoId());
    }
    
    //Relacion lista ItinerarioTransporte (caso profesor)
    public List<ItinerarioTransporte> getItinerariosTransporteDeTrayecto(Integer trayectoId){ 
        return itinerarioTransporteData.findItinerarioTransportByTrayectoId(trayectoId);
    }
    public boolean assignItinerarioTransporteToTrayecto(Integer trayectoId, Integer itinerarioTransporteId) {
        Trayecto trayecto = classData.findATById(trayectoId);
        ItinerarioTransporte itinerarioTransporte = itinerarioTransporteData.findATById(itinerarioTransporteId);
        
        if (trayecto == null || itinerarioTransporte == null) {
            return false;
        }
        
        itinerarioTransporte.setTrayectoId(trayectoId);
        itinerarioTransporteData.saveT(itinerarioTransporte);
        return true;
    }
    
    //Relacion lista ServicioTransporte (caso profesor)
    public List<ServicioTransporte> getServiciosTransporteDeTrayecto(Integer trayectoId){ 
        return servicioTransporteData.findServicioTransporteByTrayectoId(trayectoId);
    }
    public boolean assignServicioTransporteToTrayecto(Integer trayectoId, Integer servicioTransporteId) {
        Trayecto trayecto = classData.findATById(trayectoId);
        ServicioTransporte servicioTransporte = servicioTransporteData.findATById(servicioTransporteId);
        
        if (trayecto == null || servicioTransporte == null) {
            return false;
        }
        
        servicioTransporte.setTrayectoId(trayectoId);
        servicioTransporteData.saveT(servicioTransporte);
        return true;
    }
}
