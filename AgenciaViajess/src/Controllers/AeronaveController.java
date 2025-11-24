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
public class AeronaveController extends GeneralController<Aeronave> {
    AerolineaRepository aerolineaData;
    ServicioTransporteRepository servicioTransporteData;
    AeronaveRepository aeronaveData;
    
    public AeronaveController() {
        this.classData= new AeronaveRepository();
        this.aerolineaData= new AerolineaRepository();
        this.aeronaveData= new AeronaveRepository();
    }
    public AeronaveController(AeronaveRepository classData) {
        this.classData= classData;
        this.aerolineaData= new AerolineaRepository();
        this.aeronaveData= new AeronaveRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<ServicioTransporte> servicioTransporteAeronave= servicioTransporteData.findServicioTransporteByVehiculoId(id);
        if (!servicioTransporteAeronave.isEmpty()) {
            return false; 
        }
        classData.deleteT(id);
        return true;
    }     
    
    public boolean actualizarAeronave(Integer id, String marca, Integer aerolineaId) {
        Aeronave aeronave = classData.findATById(id);
        if (aeronave == null) {
            return false;
        }
        if (marca != null && !marca.trim().isEmpty()) {
            aeronave.setMarca(marca.trim());
        }
        if (aerolineaId != null) {
            Aerolinea aerolinea = aerolineaData.findATById(aerolineaId);
            if (aerolinea == null) {
                return false;
            }
            aeronave.setAerolineaId(aerolineaId);
        }
        classData.saveT(aeronave);
        return true;
    }

    public boolean añadirAeronave(String marca, Integer aerolineaId) {
        if (marca == null || marca.trim().isEmpty()) {
            return false;
        }
        Aerolinea aerolinea = aerolineaData.findATById(aerolineaId);
        if (aerolinea == null) {
            return false;
        }
        Aeronave aeronave = new Aeronave();
        aeronave.setMarca(marca.trim());
        aeronave.setAerolineaId(aerolineaId);
        
        classData.saveT(aeronave);
        return true;
    }
    //Aerolinea Relacion (caso curso)
    public List<Aeronave> getAeronavesByAerolinea(Integer aerolineaId) {
        return aeronaveData.findAAeronavesByAerolineaId(aerolineaId);
    }
    public Aerolinea getAerolineaDeAeronave(Integer aeronaveId) {
        Aeronave aeronave = classData.findATById(aeronaveId);
        if (aeronave == null) {
            return null;
        }
        return aerolineaData.findATById(aeronave.getAerolineaId());
    }
    //ServicioTransporte Relacion (caso profesor)
    public List<ServicioTransporte> getServiciosTrasportesDeAeronave(Integer aeronaveId){ 
        return servicioTransporteData.findServicioTransporteByVehiculoId(aeronaveId);
    }
    public boolean assignServicioTransporteToAeronave(Integer aeronaveId, Integer servicioTransporteId) {
        Aeronave aeronave = classData.findATById(aeronaveId);
        ServicioTransporte servicioTransporte = servicioTransporteData.findATById(servicioTransporteId);
        
        if (aeronave == null || servicioTransporte == null) {
            return false;
        }
        
        servicioTransporte.setVehiculoId(aeronaveId);
        servicioTransporteData.saveT(servicioTransporte);
        return true;
    }
}
