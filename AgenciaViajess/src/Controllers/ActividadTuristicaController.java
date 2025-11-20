/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Persistencia.*;
import Modelos.*;


/**
 *
 * @author DELL
 */
public class ActividadTuristicaController extends GeneralController<ActividadTuristica> {
    MunicipioRepository municipioData;
    
    public ActividadTuristicaController() {
    }
    public ActividadTuristicaController(ActividadTuristicaRepository classData) {
        this.classData= new ActividadTuristicaRepository();
        this.municipioData= new MunicipioRepository();
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

    @Override
    public boolean eliminarObjeto() {
        
        List<Course> professorCourses = courseRepository.findCoursesByProfessorId(id);
        if (!professorCourses.isEmpty()) {
            return false; // Cannot delete professor with assigned courses
        }
        
        professorRepository.deleteProfessor(id);
        return true;
    }
    }
    
    
}
