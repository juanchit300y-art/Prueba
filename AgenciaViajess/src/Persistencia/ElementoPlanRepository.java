
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.ElementoPlan;
import java.util.ArrayList;
import java.util.List;

public class ElementoPlanRepository extends GeneralRepository<ElementoPlan> {
    
    public ElementoPlanRepository() {
        this.dataAccess = new JsonRepository<>("elementosDePlan.json", ElementoPlan.class);
    }
    public ElementoPlanRepository(IDataAccess<ElementoPlan> dataAccess) {
        this.dataAccess = dataAccess;
    }
    
    public List<ElementoPlan> findElementoPLanByActividadTuristiaId(Integer actividadTuristicaId) {
        List<ElementoPlan> elementosDelPlan = getAllT();
        List<ElementoPlan> result = new ArrayList<>();
        for (ElementoPlan elementoPlan : elementosDelPlan) {
            if (elementoPlan.getActividadTuristicaId() != null && elementoPlan.getActividadTuristicaId().equals(actividadTuristicaId)) {
                result.add(elementoPlan);
            }
        }
        return result;
    }
   
    public List<ElementoPlan> findElementoPLanByPlanId(Integer planId) {
        List<ElementoPlan> elementosDelPlan = getAllT();
        List<ElementoPlan> result = new ArrayList<>();
        for (ElementoPlan elementoPlan : elementosDelPlan) {
            if (elementoPlan.getPlanId() != null && elementoPlan.getPlanId().equals(planId)) {
                result.add(elementoPlan);
            }
        }
        return result;
    }
   
}