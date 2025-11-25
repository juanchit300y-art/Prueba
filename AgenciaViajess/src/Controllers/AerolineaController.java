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
public class AerolineaController extends GeneralController<Aerolinea> {
    AeronaveController aeronaveData;
 
    public AerolineaController() {
        this.classData= new AerolineaRepository();
        this.aeronaveData= new AeronaveController();
    }
    public AerolineaController(AerolineaRepository classData) {
        this.classData= classData;
        this.aeronaveData= new AeronaveController();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<Aeronave> aeronavesAerolinea= aeronaveData.getAeronavesByAerolinea(id);        
        if (!aeronavesAerolinea.isEmpty()) {
            return false; 
        }
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarAerolinea(Integer id, String nombre, String correo) {
        Aerolinea aerolinea = classData.findATById(id);
        if (aerolinea == null) {
            return false;
        }
        if (nombre != null && !nombre.trim().isEmpty()) {
            aerolinea.setNombre(nombre.trim());
        }
        if (correo != null && !correo.trim().isEmpty()) {
            aerolinea.setCorreo(correo.trim());
        }
        classData.saveT(aerolinea);
        return true;
    }

    public boolean añadirAerolinea(String nombre, String correo) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        if (correo == null || correo.trim().isEmpty()) {
            return false;
        }        
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setNombre(nombre.trim());
        aerolinea.setCorreo(correo);
        
        classData.saveT(aerolinea);
        return true;
    }
    // Aeronave Relacionm (caso profesor)
    public List<Aeronave> getAeronavesDeAerolinea(Integer aerolineaId){ 
        return aeronaveData.getAeronavesByAerolinea(aerolineaId);
    }
    public boolean assignAeronaveToAerolinea(Integer aerolineaId, Integer aeronaveId) {
        Aerolinea aerolinea = classData.findATById(aerolineaId);
        Aeronave aeronave = aeronaveData.getGeneralById(aeronaveId);
        
        if (aerolinea == null || aeronave == null) {
            return false;
        }
        
        aeronave.setAerolineaId(aerolineaId);
        aeronaveData.guardarT(aeronave);
        return true;
    }
}
