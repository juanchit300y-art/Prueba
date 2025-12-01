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
public class ElementoPlanController extends GeneralController<ElementoPlan> {
    private ActividadTuristicaRepository actividadTuristicaData;
    private PlanRepository planData;
    private ElementoPlanRepository elementoPlanData;
    public ElementoPlanController() {
        this.classData= new ElementoPlanRepository();
        this.actividadTuristicaData= new ActividadTuristicaRepository();
        this.planData= new PlanRepository();
        this.elementoPlanData= new ElementoPlanRepository();
    }
    public ElementoPlanController(ElementoPlanRepository classData) {
        this.classData= classData;
        this.actividadTuristicaData= new ActividadTuristicaRepository();
        this.planData= new PlanRepository();
        this.elementoPlanData= new ElementoPlanRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarElementoPlan(Integer id, Integer actividadTuristicaId, Integer planId) {
        ElementoPlan elementoPlan = classData.findATById(id);
        if (elementoPlan == null) {
            return false;
        }
        if (actividadTuristicaId != null) {
            ActividadTuristica actividadTuristica = actividadTuristicaData.findATById(actividadTuristicaId);
            if (actividadTuristica == null) {
                return false;
            }
            elementoPlan.setActividadTuristicaId(actividadTuristicaId);
        }
        if(planId!= null){
            Plan plan= planData.findATById(planId);
            if(plan== null){
                return false;
            }
            elementoPlan.setPlanId(planId);
        }        
        classData.saveT(elementoPlan);
        return true;
    }

    public boolean añadirElementoPlan(Integer actividadTuristicaId, Integer planId) {
        ActividadTuristica actividadTuristica = actividadTuristicaData.findATById(actividadTuristicaId);
        if (actividadTuristica == null) {
            return false;
        }
        Plan plan = planData.findATById(planId);
        if (plan == null) {
            return false;
        }
        ElementoPlan elementoPlan = new ElementoPlan();
        elementoPlan.setActividadTuristicaId(actividadTuristicaId);
        elementoPlan.setPlanId(planId);
        
        classData.saveT(elementoPlan);
        return true;
    }
    //Relacion Plan (caso curso)
    public List<ElementoPlan> getElementosPlanByPlan(Integer planId) {
        return elementoPlanData.findElementosPLanByPlanId(planId);
    }
    public Plan getPlanDeElementoPlan(Integer elementoPlanId) {
        ElementoPlan elementoPlan = classData.findATById(elementoPlanId);
        if (elementoPlan == null) {
            return null;
        }
        return planData.findATById(elementoPlan.getPlanId());
    }
    //Relacion ActividadTuristica (caso curso)
    public List<ElementoPlan> getElementosPlanByActividadTuristica(Integer actividadTuristicaId) {
        return elementoPlanData.findElementosPLanByActividadTuristicaId(actividadTuristicaId);
    }
    public ActividadTuristica getActividadTuristicaDeElementoPlan(Integer elementoPlanId) {
        ElementoPlan elementoPlan = classData.findATById(elementoPlanId);
        if (elementoPlan == null) {
            return null;
        }
        return actividadTuristicaData.findATById(elementoPlan.getActividadTuristicaId());
    }
    //Verificacion MunicipioId
    public boolean verificacionActividadMunicipioH(){
        
        
        
        
        
        
        
    }
}