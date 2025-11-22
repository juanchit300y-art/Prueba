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
public class PlanController extends GeneralController<Plan> {
    ElementoPlanRepository elementoPlanData;
    EntretenimientoRepository entretenimientoData;
    
    public PlanController() {
    }
    public PlanController(PlanRepository classData) {
        this.classData= new PlanRepository();
        this.elementoPlanData= new ElementoPlanRepository();
        this.entretenimientoData= new EntretenimientoRepository();
    }
    
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<ElementoPlan> elementosPlanPlan = elementoPlanData.findElementosPLanByPlanId(id);
        List<Entretenimiento> entretenimientosPlan = entretenimientoData.findEntretenimientosByPlanId(id);
        
        if (!elementosPlanPlan.isEmpty()) {
            return false; 
        }
        if (!entretenimientosPlan.isEmpty()) {
            return false; 
        }
        
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarPlan(Integer id, String nombre) {
        Plan plan = classData.findATById(id);
        
        if (plan == null) {
            return false;
        }
        if (nombre != null && !nombre.trim().isEmpty()) {
            plan.setNombre(nombre.trim());
        }
        
        classData.saveT(plan);
        return true;
    }

    public boolean añadirPlan(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        
        Plan plan = new Plan();
        plan.setNombre(nombre.trim());
        
        classData.saveT(plan);
        return true;
    }
}
