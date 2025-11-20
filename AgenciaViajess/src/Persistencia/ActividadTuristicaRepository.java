/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.ActividadTuristica;
import java.util.List;
import java.util.ArrayList;

public class ActividadTuristicaRepository extends GeneralRepository<ActividadTuristica>{
    
    
    public ActividadTuristicaRepository() {
        this.dataAccess = new JsonRepository<>("actividadesTuristicas.json", ActividadTuristica.class);
    }
    public ActividadTuristicaRepository(IDataAccess<ActividadTuristica> dataAccess) {
        this.dataAccess = dataAccess;
    }
}