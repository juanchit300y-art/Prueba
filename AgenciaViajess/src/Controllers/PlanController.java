/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Persistencia.*;
import Modelos.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DELL
 */
public class PlanController extends GeneralController<Plan> {
    private ElementoPlanRepository elementoPlanData;
    private EntretenimientoRepository entretenimientoData;
    
    public PlanController() {
        this.classData= new PlanRepository();
        this.elementoPlanData= new ElementoPlanRepository();
        this.entretenimientoData= new EntretenimientoRepository();
    }
    public PlanController(PlanRepository classData) {
        this.classData= classData;
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
    
    //Relacion lista ElementosPlan (caso profesor)
    public List<ElementoPlan> getElementosPlanDePlan(Integer planId){ 
        return elementoPlanData.findElementosPLanByPlanId(planId);
    }
    public boolean assignElementosPlanToPlan(Integer planId, Integer elementoPlanId) {
        Plan plan = classData.findATById(planId);
        ElementoPlan elementoPlan = elementoPlanData.findATById(elementoPlanId);
        
        if (plan == null || elementoPlan == null) {
            return false;
        }
        
        elementoPlan.setPlanId(planId);
        elementoPlanData.saveT(elementoPlan);
        return true;
    }
    
    //Relacion lista Entretenimiento (caso profesor)
    public List<Entretenimiento> getEntretenimientosDePlan(Integer planId){ 
        return entretenimientoData.findEntretenimientosByPlanId(planId);
    }
    public boolean assignEntretenimientoToPlan(Integer planId, Integer entretenimientoId) {
        Plan plan = classData.findATById(planId);
        Entretenimiento entretenimiento = entretenimientoData.findATById(entretenimientoId);
        
        if (plan == null || entretenimiento == null) {
            return false;
        }
        
        entretenimiento.setPlanId(planId);
        entretenimientoData.saveT(entretenimiento);
        return true;
    }
    //Tamaño actividades
        public double numActividadesXPlan(Integer idPlan){
        double numActividades;
        List<ElementoPlan> elementosDelPlan= getElementosPlanDePlan(idPlan);
        numActividades= elementosDelPlan.size();
        return numActividades;
    }
    // ActividadXId
    public boolean tieneActividad(Integer idActividad, Integer idPlan){
        Plan plan= getGeneralById(idPlan);
        List<ElementoPlan> elementosPlan= getElementosPlanDePlan(idPlan);
        for(ElementoPlan actual: elementosPlan){
            Integer idActividadElemento= actual.getActividadTuristicaId();
            if(idActividadElemento.equals(idActividad)){
                return true;    
            }
        }
        return false;
    }
        
    public List<Plan> planesMin3ActividadesE(){
        List<Plan> respuesta = new ArrayList<>();
        List<Plan> planes = classData.getAllT();
        for(Plan actual:planes){
            if(getElementosPlanDePlan(actual.getId()).size()>=3){
                respuesta.add(actual);
            }
        }
        return respuesta;
    }
}
