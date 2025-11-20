/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.ActividadTuristica;
import java.util.ArrayList;
import java.util.List;

public class ActividadTuristicaRepository extends GeneralRepository<ActividadTuristica>{
    
    
    public ActividadTuristicaRepository() {
        this.dataAccess = new JsonRepository<>("actividadesTuristicas.json", ActividadTuristica.class);
    }
    public ActividadTuristicaRepository(IDataAccess<ActividadTuristica> dataAccess) {
        this.dataAccess = dataAccess;
    }
    public List<ActividadTuristica> findActividadesTuristicasByMunicipioId(Integer municipioId) {
        List<ActividadTuristica> actividadesTuristicas = getAllT();
        List<ActividadTuristica> result = new ArrayList<>();
        for (ActividadTuristica actividadTuristica : actividadesTuristicas) {
            if (actividadTuristica.getIdMunicipio() != null && actividadTuristica.getIdMunicipio().equals(municipioId)) {
                result.add(actividadTuristica);
            }
        }
        return result;
    }
}