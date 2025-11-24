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
public class GuiaController extends GeneralController<Guia> {
    TurnoRepository turnoData;
    
    public GuiaController() {
        this.classData= new GuiaRepository();
        this.turnoData= new TurnoRepository();
    }
    public GuiaController(GuiaRepository classData) {
        this.classData= classData;
        this.turnoData= new TurnoRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<Turno> turnosGuia= turnoData.findTurnosByGuiaId(id);
        if (!turnosGuia.isEmpty()) {
            return false; 
        }
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarGuia(Integer id, String nombre, String contraseña,String correo,  Integer añosExperiencia) {
        Guia guia = classData.findATById(id);
        if (guia == null) {
            return false;
        }
        if (nombre != null && !nombre.trim().isEmpty()) {
            guia.setNombre(nombre.trim());
        }
        if (contraseña != null && !contraseña.trim().isEmpty()) {
            guia.setContraseña(contraseña.trim());
        }
        if (correo != null && !correo.trim().isEmpty()) {
            guia.setCorreo(correo.trim());
        }
        if (añosExperiencia != null && añosExperiencia > -1) {
            guia.setAñosExperiencia(añosExperiencia);
        }      

        classData.saveT(guia);
        return true;
    }

    public boolean añadirGuia(String nombre, String contraseña,String correo,  Integer añosExperiencia) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        if (contraseña == null ||  contraseña.trim().isEmpty()) {
            return false;
        }
        if (correo == null  || correo.trim().isEmpty()) {
            return false;
        }
        if (añosExperiencia == null  || añosExperiencia<0) {
            return false;
        }  
        Guia guia = new Guia();
        guia.setNombre(nombre.trim());
        guia.setContraseña(contraseña);
        guia.setCorreo(correo);
        guia.setAñosExperiencia(añosExperiencia);
        
        classData.saveT(guia);
        return true;
    }
    //Turno Relacion (caso Profesor)
    public List<Turno> getTurnosDeGuia(Integer guiaId){ 
        return turnoData.findTurnosByGuiaId(guiaId);
    }
    public boolean assignTurnoToGuia(Integer guiaId, Integer turnoId) {
        Guia guia = classData.findATById(guiaId);
        Turno turno = turnoData.findATById(turnoId);
        
        if (guia == null || turno == null) {
            return false;
        }
        
        turno.setGuiaId(guiaId);
        turnoData.saveT(turno);
        return true;
    }
}