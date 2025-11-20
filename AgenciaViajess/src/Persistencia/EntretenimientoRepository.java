
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Entretenimiento;
import java.util.ArrayList;
import java.util.List;

public class EntretenimientoRepository extends GeneralRepository<Entretenimiento> {
    
    public EntretenimientoRepository() {
        this.dataAccess = new JsonRepository<>("entretenimientos.json", Entretenimiento.class);
    }
    public EntretenimientoRepository(IDataAccess<Entretenimiento> dataAccess) {
        this.dataAccess = dataAccess;
    }
   
    public List<Entretenimiento> findEntretenimientosByPlanId(Integer planId) {
        List<Entretenimiento> entretenimientos = getAllT();
        List<Entretenimiento> result = new ArrayList<>();
        for (Entretenimiento entretenimiento : entretenimientos) {
            if (entretenimiento.getPlanId() != null && entretenimiento.getPlanId().equals(planId)) {
                result.add(entretenimiento);
            }
        }
        return result;
    }
    
    public List<Entretenimiento> findEntretenimientosByViajeId(Integer viajeId) {
        List<Entretenimiento> entretenimientos = getAllT();
        List<Entretenimiento> result = new ArrayList<>();
        for (Entretenimiento entretenimiento : entretenimientos) {
            if (entretenimiento.getViajeId() != null && entretenimiento.getViajeId().equals(viajeId)) {
                result.add(entretenimiento);
            }
        }
        return result;
    }
    
    
}