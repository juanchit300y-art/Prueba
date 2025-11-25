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
    MunicipioController municipioData;
    TurnoController turnoData;
    ElementoPlanController elementoPlanData;
    ActividadTuristicaRepository actividadTuristicaData;
    
    public ActividadTuristicaController() {
        this.classData= new ActividadTuristicaRepository();
        this.municipioData= new MunicipioController();
        this.turnoData= new TurnoController();
        this.elementoPlanData= new ElementoPlanController();
        this.actividadTuristicaData= new ActividadTuristicaRepository();
    }
    public ActividadTuristicaController(ActividadTuristicaRepository classData) {
        this.classData= classData;
        this.municipioData= new MunicipioController();
        this.turnoData= new TurnoController();
        this.elementoPlanData= new ElementoPlanController();
        this.actividadTuristicaData= new ActividadTuristicaRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<ElementoPlan> elementosPlanActividadTuristica= elementoPlanData.getElementosPlanByActividadTuristica(id);
        List<Turno> turnosActividadTuristica= turnoData.getTurnosByActividadTuristica(id);        
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
            
            Municipio municipio = municipioData.getGeneralById(municipioId);  
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
        
        Municipio municipio = municipioData.getGeneralById(municipioId);
        if (municipio == null) {
            return false;
        }
        
        ActividadTuristica actividadTuristica = new ActividadTuristica();
        actividadTuristica.setNombre(nombre.trim());
        actividadTuristica.setMunicipioId(municipioId);
        
        classData.saveT(actividadTuristica);
        return true;
    }
    //Elemento Plan Relacion
    //En caso de Profesor
    public List<ElementoPlan> getElementosPlanActividadTuristica(Integer actividadTuristicaId){ 
        return elementoPlanData.getElementosPlanByActividadTuristica(actividadTuristicaId);
    }
    public boolean assignElementoPlanToActividadTuristica(Integer actividadTuristicaId, Integer elementoPlanId) {
        ActividadTuristica actividadTuristica = classData.findATById(actividadTuristicaId);
        ElementoPlan elementoPlan = elementoPlanData.getGeneralById(elementoPlanId);
        
        if (actividadTuristica == null || elementoPlan == null) {
            return false;
        }
        
        elementoPlan.setActividadTuristicaId(actividadTuristicaId);
        elementoPlanData.elementoPlanData.saveT(elementoPlan);//----------------------------------------------------------
        return true;
    }
    //Turno Relacion
    //En caso Profesor (La clase tiene un listado de objetos
    public List<Turno> getTurnosDeActividadTuristica(Integer actividadTuristicaId){ 
        return turnoData.getTurnosByActividadTuristica(actividadTuristicaId);
    }
    public boolean assignTurnoToActividadTuristica(Integer actividadTuristicaId, Integer turnoId) {
        ActividadTuristica actividadTuristica = classData.findATById(actividadTuristicaId);
        Turno turno = turnoData.getGeneralById(turnoId);
        
        if (actividadTuristica == null || turno == null) {
            return false;
        }
        
        turno.setActividadTuristicaId(actividadTuristicaId);
        turnoData.saveT(turno);// este es el error que se soluciona con otro data arriba uwu
        return true;
    }
    // Municipio Relacion
    // En caso curso (Un objeto de clase clase hace parte de la lista de otro)
    //Toca inicializar un nuevo Repository de la misma clase (diferente al classData por conlficto)
    public List<ActividadTuristica> getActividadesTuristicasByMunicipio(Integer municipioId) {
        return actividadTuristicaData.findActividadesTuristicasByMunicipioId(municipioId);
    }
    public Municipio getMunicipioDeActividadTuristica(Integer actividadTuristicaId) {
        ActividadTuristica actividadTuristica = classData.findATById(actividadTuristicaId);
        if (actividadTuristica == null) {
            return null;
        }
        return municipioData.getGeneralById(actividadTuristica.getMunicipioId());
    }

}
