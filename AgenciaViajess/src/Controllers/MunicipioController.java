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
    }
    public MunicipioController(MunicipioRepository classData) {
        this.classData= new MunicipioRepository();
        this.hotelData= new HotelRepository();
        this.actividadTuristicaData= new ActividadTuristicaRepository();
        this.trayectoData= new TrayectoRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<Hotel> hotelesMunicipio = hotelData.findHotelByMunicipioId(id);
        List<ActividadTuristica> acitivdadesTuristicaMunicipio = actividadTuristicaData.findActividadesTuristicasByMunicipioId(id);        
        List<Trayecto> trayectosMunicipioDestino= trayectoData.findTrayectosByMunicipioDestinoId(id);  
        List<Trayecto> trayectosMunicipioInicio= trayectoData.findTrayectosByMunicipioInicioId(id); 
        
        if (!hotelesMunicipio.isEmpty()) {
            return false; 
        }
        if (!acitivdadesTuristicaMunicipio.isEmpty()) {
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
}
