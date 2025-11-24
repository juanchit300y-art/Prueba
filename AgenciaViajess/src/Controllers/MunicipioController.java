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
public class MunicipioController extends GeneralController<Municipio> {
    HotelRepository hotelData;
    ActividadTuristicaRepository actividadTuristicaData;
    TrayectoRepository trayectoData;
    
    public MunicipioController() {
        this.classData= new MunicipioRepository();
        this.hotelData= new HotelRepository();
        this.actividadTuristicaData= new ActividadTuristicaRepository();
        this.trayectoData= new TrayectoRepository();
    }
    public MunicipioController(MunicipioRepository classData) {
        this.classData= classData;
        this.hotelData= new HotelRepository();
        this.actividadTuristicaData= new ActividadTuristicaRepository();
        this.trayectoData= new TrayectoRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<Hotel> hotelesMunicipio = hotelData.findHotelByMunicipioId(id);
        List<ActividadTuristica> acitividadesTuristicaMunicipio = actividadTuristicaData.findActividadesTuristicasByMunicipioId(id);        
        List<Trayecto> trayectosMunicipioDestino= trayectoData.findTrayectosByMunicipioDestinoId(id);  
        List<Trayecto> trayectosMunicipioInicio= trayectoData.findTrayectosByMunicipioInicioId(id); 
        
        if (!hotelesMunicipio.isEmpty()) {
            return false; 
        }
        if (!acitividadesTuristicaMunicipio.isEmpty()) {
            return false; 
        }
        if (!trayectosMunicipioDestino.isEmpty()) {
            return false; 
        }
        if (!trayectosMunicipioInicio.isEmpty()) {
            return false; 
        }
        
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarMunicipio(Integer id, String nombre) {
        Municipio municipio = classData.findATById(id);
        
        if (municipio == null) {
            return false;
        }
        if (nombre != null && !nombre.trim().isEmpty()) {
            municipio.setNombre(nombre.trim());
        }
        
        classData.saveT(municipio);
        return true;
    }

    public boolean añadirMunicipio(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        
        Municipio municipio = new Municipio();
        municipio.setNombre(nombre.trim());
        
        classData.saveT(municipio);
        return true;
    }
    
    //Relacion lista Hoteles (caso profesor)
    public List<Hotel> getHotelesDeMunicipio(Integer municipioId){ 
        return hotelData.findHotelByMunicipioId(municipioId);
    }
    public boolean assignHotelToMunicipio(Integer municipioId, Integer hotelId) {
        Municipio municipio = classData.findATById(municipioId);
        Hotel hotel = hotelData.findATById(hotelId);
        
        if (municipio == null || hotel == null) {
            return false;
        }
        
        hotel.setMunicipioId(municipioId);
        hotelData.saveT(hotel);
        return true;
    }
    
    //Relacion lista ActividadesTuristicas (caso profesor)
    public List<ActividadTuristica> getActividadesTuristicasDeMunicipio(Integer municipioId){ 
        return actividadTuristicaData.findActividadesTuristicasByMunicipioId(municipioId);
    }
    public boolean assignActividadTuristicaToMunicipio(Integer municipioId, Integer actividadTuristicaId) {
        Municipio municipio = classData.findATById(municipioId);
        ActividadTuristica actividadTuristica = actividadTuristicaData.findATById(actividadTuristicaId);
        
        if (municipio == null || actividadTuristica == null) {
            return false;
        }
        
        actividadTuristica.setMunicipioId(municipioId);
        actividadTuristicaData.saveT(actividadTuristica);
        return true;
    }
    
    //Relacion lista TrayectosMunicipioInicio (caso profesor)
    public List<Trayecto> getTrayectosInicioDeMunicipio(Integer municipioId){ 
        return trayectoData.findTrayectosByMunicipioInicioId(municipioId);
    }
    public boolean assignTrayectoMunicipioInicioToMunicipio(Integer municipioId, Integer trayectoId) {
        Municipio municipio = classData.findATById(municipioId);
        Trayecto trayecto = trayectoData.findATById(trayectoId);
        
        if (municipio == null || trayecto == null) {
            return false;
        }
        
        trayecto.setMunicipioInicioId(municipioId);
        trayectoData.saveT(trayecto);
        return true;
    }
    
    //Relacion lista TrayectosMunicipioDestino (caso profesor)
    public List<Trayecto> getTrayectosDestinoDeMunicipio(Integer municipioId){ 
        return trayectoData.findTrayectosByMunicipioDestinoId(municipioId);
    }
    public boolean assignTrayectoMunicipioDestinoToMunicipio(Integer municipioId, Integer trayectoId) {
        Municipio municipio = classData.findATById(municipioId);
        Trayecto trayecto = trayectoData.findATById(trayectoId);
        
        if (municipio == null || trayecto == null) {
            return false;
        }
        
        trayecto.setMunicipioDestinoId(municipioId);
        trayectoData.saveT(trayecto);
        return true;
    }
}
