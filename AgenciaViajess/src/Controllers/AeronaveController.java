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
    
    public AeronaveController() {
    }
    public AeronaveController(AeronaveRepository classData) {
        this.classData= new AeronaveRepository();
        this.aerolineaData= new AerolineaRepository();
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
}
