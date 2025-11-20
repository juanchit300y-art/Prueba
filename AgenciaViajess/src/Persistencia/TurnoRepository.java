/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Turno;
import java.util.ArrayList;
import java.util.List;

public class TurnoRepository extends GeneralRepository<Turno>{
    
    
    public TurnoRepository() {
        this.dataAccess = new JsonRepository<>("Turnos.json", Turno.class);
    }
    public TurnoRepository(IDataAccess<Turno> dataAccess) {
        this.dataAccess = dataAccess;
    }
    
    public List<Turno> findTurnosByGuiaId(Integer guiaId) {
        List<Turno> turnos = getAllT();
        List<Turno> result = new ArrayList<>();
        for (Turno turno : turnos) {
            if (turno.getIdGuia() != null && turno.getIdGuia().equals(guiaId)) {
                result.add(turno);
            }
        }
        return result;
    }
    
    public List<Turno> findTurnosByActividadTuristicaId(Integer actividadTuristicaId) {
        List<Turno> turnos = getAllT();
        List<Turno> result = new ArrayList<>();
        for (Turno turno : turnos) {
            if (turno.getIdActividadTuristica() != null && turno.getIdActividadTuristica().equals(actividadTuristicaId)) {
                result.add(turno);
            }
        }
        return result;
    }
    
}