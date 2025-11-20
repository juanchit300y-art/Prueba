/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.ArrayList;
import java.util.List;
import Modelos.Trayecto;

public class TrayectoRepository extends GeneralRepository<Trayecto>{
    
    
    public TrayectoRepository() {
        this.dataAccess = new JsonRepository<>("Trayectos.json", Trayecto.class);
    }
    public TrayectoRepository(IDataAccess<Trayecto> dataAccess) {
        this.dataAccess = dataAccess;
    }
    public List<Trayecto> findTrayectosByMunicipioId(Integer municipioId) {
        List<Trayecto> trayectos = getAllT();
        List<Trayecto> result = new ArrayList<>();
        for (Trayecto trayecto : trayectos) {
            if (trayecto.getIdMunicipio() != null && trayecto.getIdMunicipio().equals(municipioId)) {
                result.add(trayecto);
            }
        }
        return result;
    }
}