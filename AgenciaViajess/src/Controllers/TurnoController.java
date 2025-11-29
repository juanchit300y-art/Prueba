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
public class TurnoController extends GeneralController<Turno> {
    private ActividadTuristicaRepository actividadTuristicaData;
    private GuiaRepository guiaData;
    private TurnoRepository turnoData;
    public TurnoController() {
        this.classData= new TurnoRepository();
        this.actividadTuristicaData= new ActividadTuristicaRepository();
        this.guiaData= new GuiaRepository();
        this.turnoData= new TurnoRepository();
    }
    public TurnoController(TurnoRepository classData) {
        this.classData= classData;
        this.actividadTuristicaData= new ActividadTuristicaRepository();
        this.guiaData= new GuiaRepository();
        this.turnoData= new TurnoRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarTurno(Integer id, Integer actividadTuristicaId, Integer guiaId) {
        Turno turno = classData.findATById(id);
        if (turno == null) {
            return false;
        }
        
        if (actividadTuristicaId != null) {
            ActividadTuristica actividadTuristica = actividadTuristicaData.findATById(actividadTuristicaId);
            if (actividadTuristica == null) {
                return false;
            }
            turno.setActividadTuristicaId(actividadTuristicaId);
        }
        if(guiaId!= null){
            Guia guia= guiaData.findATById(guiaId);
            if(guia== null){
                return false;
            }
            turno.setGuiaId(guiaId);
        }        
        classData.saveT(turno);
        return true;
    }

    public boolean añadirTurno(Integer actividadTuristicaId, Integer guiaId) {
        ActividadTuristica actividadTuristica = actividadTuristicaData.findATById(actividadTuristicaId);
        if (actividadTuristica == null) {
            return false;
        }
        Guia guia = guiaData.findATById(guiaId);
        if (guia == null) {
            return false;
        }
        Turno turno = new Turno();
        turno.setActividadTuristicaId(actividadTuristicaId);
        turno.setGuiaId(guiaId);
        
        classData.saveT(turno);
        return true;
    }
    //Cliente relacion (caso curso) - relacion a guia
    public List<Turno> getTurnosByGuia(Integer guiaId) {
        return turnoData.findTurnosByGuiaId(guiaId);
    }
    public Guia getGuiaDeTurno(Integer turnoId) {
        Turno turno = classData.findATById(turnoId);
        if (turno == null) {
            return null;
        }
        return guiaData.findATById(turno.getGuiaId());
    }
    //Viaje relacion (caso curso) -  relacion a Actividad Turistica
    public List<Turno> getTurnosByActividadTuristica(Integer actividadTuristicaId) {
        return turnoData.findTurnosByActividadTuristicaId(actividadTuristicaId);
    }
    public ActividadTuristica getActividadTuristicaDeTurno(Integer turnoId) {
        Turno turno = classData.findATById(turnoId);
        if (turno == null) {
            return null;
        }
        return actividadTuristicaData.findATById(turno.getActividadTuristicaId());
    }
}