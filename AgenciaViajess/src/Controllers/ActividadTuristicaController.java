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
public class ActividadTuristicaController extends GeneralController<ActividadTuristica> {
    MunicipioRepository municipioData;
    TurnoRepository turnoData;
    ElementoPlanRepository elementoPlanData;
    
    public ActividadTuristicaController() {
    }
    public ActividadTuristicaController(ActividadTuristicaRepository classData) {
        this.classData= new ActividadTuristicaRepository();
        this.municipioData= new MunicipioRepository();
        this.turnoData= new TurnoRepository();
        this.elementoPlanData= new ElementoPlanRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<ElementoPlan> elementosPlanActividadTuristica= elementoPlanData.findElementosPLanByActividadTuristicaId(id);
        List<Turno> turnosActividadTuristica= turnoData.findTurnosByActividadTuristicaId(id);        
        if (!elementosPlanActividadTuristica.isEmpty()) {
            return false; 
        }
        if (!turnosActividadTuristica.isEmpty()) {
            return false; 
        }
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarActividadTuristica(Integer id, String nombre, Integer municipioId) {
        ActividadTuristica actividadTuristica = classData.findATById(id);
        if (actividadTuristica == null) {
            return false;
        }
        if (nombre != null && !nombre.trim().isEmpty()) {
            actividadTuristica.setNombre(nombre.trim());
        }
        if (municipioId != null) {
            
            Municipio municipio = municipioData.findATById(municipioId);
            if (municipio == null) {
                return false;
            }
            actividadTuristica.setMunicipioId(municipioId);
        }
        
        classData.saveT(actividadTuristica);
        return true;
    }

    public boolean añadirActividadTuristica(String nombre, Integer municipioId) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        
        Municipio municipio = municipioData.findATById(municipioId);
        if (municipio == null) {
            return false;
        }
        
        ActividadTuristica actividadTuristica = new ActividadTuristica();
        actividadTuristica.setNombre(nombre.trim());
        actividadTuristica.setMunicipioId(municipioId);
        
        classData.saveT(actividadTuristica);
        return true;
    }
}
